package com.augustine.musalasoftdroneservice.repository;

import com.augustine.musalasoftdroneservice.model.*;
import org.springframework.data.jpa.repository.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 6:33 PM
 * @project MusalaSoftDroneService
 */
public interface DroneRepository extends JpaRepository<Drone, Long> {
}