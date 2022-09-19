package com.augustine.musalasoftdroneservice.service;

import com.augustine.musalasoftdroneservice.exceptions.*;
import com.augustine.musalasoftdroneservice.model.*;
import org.springframework.http.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 8:15 PM
 * @project MusalaSoftDroneService
 */

public interface DroneService {
    ResponseEntity registerDrone(Drone drone);
}
