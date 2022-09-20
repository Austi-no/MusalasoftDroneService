package com.augustine.musalasoftdroneservice.repository;

import com.augustine.musalasoftdroneservice.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 6:35 PM
 * @project MusalaSoftDroneService
 */
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    List<Medication> findMedicationByDrone_Id(Long droneID);

}
