package com.augustine.musalasoftdroneservice.controller;

import com.augustine.musalasoftdroneservice.exceptions.*;
import com.augustine.musalasoftdroneservice.model.*;
import com.augustine.musalasoftdroneservice.service.*;
import com.augustine.musalasoftdroneservice.util.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 8:14 PM
 * @project MusalaSoftDroneService
 */

@RestController
@RequestMapping("/drone/api")
@Tag(name = "Drone Controller", description = "Drone Controller")
public class DroneController {

    private final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @Operation(summary = "Register Drone", description = "Register Drone", tags = {"Drone Controller"})
    @PostMapping("/register")
    public ResponseEntity registerDrone(@RequestBody @Valid Drone drone) {
        return droneService.registerDrone(drone);
    }

    @Operation(summary = "Get All Drones", description = "Get All Drones", tags = {"Drone Controller"})
    @GetMapping("/getAllDrones")
    public List<Drone> getAllDrones() {
        return droneService.getAllDrones();
    }

    @Operation(summary = "Add Medication", description = "Add Medication", tags = {"Drone Controller"})
    @PostMapping("/addMedication/{droneSerialNumber}")
    public List<MedicationDTO> addMedication(@PathVariable String droneSerialNumber,
                                             @RequestBody List<MedicationDTO> medicationDTO)
            throws DroneNotFoundException, DroneMaximumWeightExceededException,
            DroneBatteryLowException, IllegalDroneLoadingException {
        return droneService.addMedication(droneSerialNumber, medicationDTO);
    }

    @Operation(summary = "Get Medications By Drone ID", description = "Get Medications By Drone ID", tags = {"Drone Controller"})
    @GetMapping("/getMedicationsByDroneID/{droneID}")
    public List<Medication> getMedicationsByDroneID(@PathVariable Long droneID) {
        return droneService.getMedicationsByDroneID(droneID);
    }

    @Operation(summary = "Get Drone Battery Status", description = "Get Drone Battery Status", tags = {"Drone Controller"})
    @GetMapping("/getDroneBatteryStatus/{droneSerialNumber}")
    public ResponseEntity getDroneBatteryStatus(@PathVariable String droneSerialNumber) {
        return droneService.getDroneBatteryStatus(droneSerialNumber);
    }
}



