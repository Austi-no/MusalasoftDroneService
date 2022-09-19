package com.augustine.musalasoftdroneservice.exceptions;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 1:37 PM
 * @project MusalaSoftDroneService
 */
public class DroneNotFoundException extends RuntimeException {

    public DroneNotFoundException(String message) {
        super(message);
    }

}
