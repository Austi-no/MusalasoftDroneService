package com.augustine.musalasoftdroneservice.mapper;

import com.augustine.musalasoftdroneservice.model.*;
import com.augustine.musalasoftdroneservice.util.*;
import org.mapstruct.*;
/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 20/Sep/2022 - 12:25 AM
 * @project MusalaSoftDroneService
 */
@Mapper(componentModel = "spring")
public interface MedicationMapper extends BasicMapper<MedicationDTO, Medication> {


}
