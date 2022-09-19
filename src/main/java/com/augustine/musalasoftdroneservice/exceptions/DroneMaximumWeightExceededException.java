package com.augustine.musalasoftdroneservice.exceptions;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 1:45 PM
 * @project MusalaSoftDroneService
 */
public class DroneMaximumWeightExceededException extends RuntimeException {

    public DroneMaximumWeightExceededException(String message) {
        super(message);
    }

}
