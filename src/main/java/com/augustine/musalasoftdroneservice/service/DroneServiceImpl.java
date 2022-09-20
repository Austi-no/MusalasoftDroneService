package com.augustine.musalasoftdroneservice.service;

import com.augustine.musalasoftdroneservice.enums.*;
import com.augustine.musalasoftdroneservice.exceptions.*;
import com.augustine.musalasoftdroneservice.mapper.*;
import com.augustine.musalasoftdroneservice.model.*;
import com.augustine.musalasoftdroneservice.repository.*;
import com.augustine.musalasoftdroneservice.util.*;
import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 8:17 PM
 * @project MusalaSoftDroneService
 */
@Service
@Transactional

public class DroneServiceImpl implements DroneService {

    private static final Logger logger = LoggerFactory.getLogger(DroneServiceImpl.class);
    private final DroneRepository droneRepository;
    private MedicationMapper medicationMapper;
    private final MedicationRepository medicationRepository;

    public DroneServiceImpl(DroneRepository droneRepository, MedicationRepository medicationRepository) {
        this.droneRepository = droneRepository;
        this.medicationRepository = medicationRepository;
    }

    //    ADD A NEW DRONE
    @Override
    public ResponseEntity registerDrone(Drone drone) {
        Drone existingDrone = droneRepository.findDroneBySerialNumber(drone.getSerialNumber());
        if (existingDrone != null) {
            return new ResponseEntity<>(new ErrorResponse("Drone already exists", Collections.singletonList("Drone already exists")), HttpStatus.BAD_REQUEST);
        }
        Drone newDrone = new Drone();
        newDrone.setState(State.IDLE);
        newDrone.setSerialNumber(drone.getSerialNumber());
        newDrone.setBatteryPercentage(drone.getBatteryPercentage());
        newDrone.setMedications(drone.getMedications());
        newDrone.setModel(drone.getModel());
        newDrone.setWeightLimit(drone.getWeightLimit());

        Drone savedDrone = droneRepository.save(newDrone);
        if (savedDrone != null) {
            return ResponseEntity.ok(new ApiResponse<>("Drone registered successfully", savedDrone));
        } else {
            return ResponseEntity.ok(new ApiResponse<>("Drone registration failed", null));
        }
    }

    //       GET ALL DRONES
    @Override
    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    private void validateWeight(Drone drone, List<Medication> medications) throws DroneMaximumWeightExceededException {
        double currentLoadWeight = loadWeight(drone.getMedications());
        double newLoadWeight = loadWeight(medications);
        double totalWeight = currentLoadWeight + newLoadWeight;
        if (totalWeight > drone.getWeightLimit()) {
            throw new DroneMaximumWeightExceededException("Drone maximum weight exceeded");
        }
    }

    private void validateBattery(Drone drone) throws DroneBatteryLowException {
        if (drone.getBatteryPercentage() < 20) {
            throw new DroneBatteryLowException("Drone battery is low @ 25%");
        }
    }

    private void validateDroneState(Drone drone) throws IllegalDroneLoadingException {
        if (drone.getState() == State.LOADING) {
            throw new IllegalDroneLoadingException("Drone is already loading");
        }
    }

    private void validateDrone(Drone drone, List<Medication> medications) throws DroneMaximumWeightExceededException, DroneBatteryLowException, IllegalDroneLoadingException {
        validateWeight(drone, medications);
        validateBattery(drone);
        validateDroneState(drone);
    }


    @Override
    public List<MedicationDTO> addMedication(String droneSerialNumber, List<MedicationDTO> medicationDTO) throws DroneNotFoundException, DroneMaximumWeightExceededException, DroneBatteryLowException, IllegalDroneLoadingException {
        Drone drone = droneRepository.findDroneBySerialNumber(droneSerialNumber);
        List<Medication> medications = medicationMapper.mapListIn(medicationDTO);

        if (drone == null) {
            throw new DroneNotFoundException("Drone not found");
        }
        validateDrone(drone, medications);

        drone.getMedications().addAll(medications);

        drone.setState(State.LOADED);
        drone = droneRepository.saveAndFlush(drone);
        return medicationMapper.mapListOut(drone.getMedications());


    }

    @Override
    public ResponseEntity getDroneBatteryStatus(String droneSerialNumber) {
        Drone drone = droneRepository.findDroneBySerialNumber(droneSerialNumber);
        if (drone == null) {
            return new ResponseEntity<>(new ErrorResponse("Drone not found",
                    Collections.singletonList("Drone not found")), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(new ApiResponse<>("Drone battery status",
                drone.getBatteryPercentage()));
    }


    //    RETRIEVE MEDICATIONS FROM DRONE
    @Override
    public List<Medication> getMedicationsByDroneID(Long droneID) {
        return medicationRepository.findMedicationByDrone_Id(droneID);
    }

    private double loadWeight(List<Medication> medications) {
        double totalWeight = 0;
        if (medications != null) {
            for (Medication medication : medications) {
                totalWeight += medication.getWeight();
            }
        }
        return totalWeight;
    }

}
