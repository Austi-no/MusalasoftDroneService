package com.augustine.musalasoftdroneservice.service;

import com.augustine.musalasoftdroneservice.exceptions.*;
import com.augustine.musalasoftdroneservice.model.*;
import com.augustine.musalasoftdroneservice.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.http.*;

import javax.persistence.*;
import javax.transaction.*;
import java.util.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 8:15 PM
 * @project MusalaSoftDroneService
 */

public interface DroneService {
    ResponseEntity registerDrone(Drone drone);

    //       GET ALL DRONES
    List<Drone> getAllDrones();

    List<MedicationDTO> addMedication(String droneSerialNumber, List<MedicationDTO> medications) throws DroneNotFoundException, DroneMaximumWeightExceededException, DroneBatteryLowException, IllegalDroneLoadingException;


    ResponseEntity getDroneBatteryStatus(String droneSerialNumber);

    List<Medication> getMedicationsByDroneID(Long droneID);

}
