package com.augustine.musalasoftdroneservice.service;

import com.augustine.musalasoftdroneservice.enums.*;
import com.augustine.musalasoftdroneservice.exceptions.*;
import com.augustine.musalasoftdroneservice.model.*;
import com.augustine.musalasoftdroneservice.repository.*;
import com.augustine.musalasoftdroneservice.util.*;
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

    private final DroneRepository droneRepository;

    public DroneServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

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

}
