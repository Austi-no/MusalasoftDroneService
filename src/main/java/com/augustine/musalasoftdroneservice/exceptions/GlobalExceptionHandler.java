package com.augustine.musalasoftdroneservice.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.mvc.method.annotation.*;

import java.time.*;
import java.util.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 1:29 PM
 * @project MusalaSoftDroneService
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //    DRONE NOT FOUND EXCEPTION_HANDLER
    @ExceptionHandler(DroneNotFoundException.class)
    public ResponseEntity<Object> handleDroneNotFoundException(DroneNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    //      DRONE BATTERY LOW EXCEPTION_HANDLER
    @ExceptionHandler(DroneBatteryLowException.class)
    public ResponseEntity<Object> handleDroneBatteryLowException(DroneBatteryLowException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    //    DRONE MAXIMUM WEIGHT EXCEEDED EXCEPTION_HANDLER
    @ExceptionHandler(DroneMaximumWeightExceededException.class)
    public ResponseEntity<Object> handleDroneMaximumWeightExceededException(DroneMaximumWeightExceededException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    //    ILLEGAL DRONE LOADING EXCEPTION_HANDLER
    @ExceptionHandler(IllegalDroneLoadingException.class)
    public ResponseEntity<Object> handleDroneIllegalLoadingException(IllegalDroneLoadingException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    //     METHOD NOT ALLOWED EXCEPTION_HANDLER
    @ExceptionHandler(HttpClientErrorException.MethodNotAllowed.class)
    public ResponseEntity<Object> handleMethodNotAllowedException(MethodNotAllowedException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.METHOD_NOT_ALLOWED);
    }


}
