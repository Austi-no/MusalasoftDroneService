package com.augustine.musalasoftdroneservice.controller;

import com.augustine.musalasoftdroneservice.model.*;
import com.augustine.musalasoftdroneservice.service.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;

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


    @PostMapping("/register")
    public ResponseEntity registerDrone(@RequestBody @Valid Drone drone) {
        return droneService.registerDrone(drone);
    }

}
