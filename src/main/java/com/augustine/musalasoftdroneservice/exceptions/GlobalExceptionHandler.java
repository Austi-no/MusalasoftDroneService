package com.augustine.musalasoftdroneservice.exceptions;

import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.*;
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
@SuppressWarnings({"unchecked", "rawtypes"})
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Server Error", details);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //    DRONE NOT FOUND EXCEPTION_HANDLER
    @ExceptionHandler(DroneNotFoundException.class)
    public ResponseEntity<Object> handleDroneNotFoundException(DroneNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        details.add(LocalDateTime.now().toString());
        ErrorResponse error = new ErrorResponse("Drone Not Found", details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //      DRONE BATTERY LOW EXCEPTION_HANDLER
    @ExceptionHandler(DroneBatteryLowException.class)
    public ResponseEntity<Object> handleDroneBatteryLowException(DroneBatteryLowException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        details.add(LocalDateTime.now().toString());
        ErrorResponse error = new ErrorResponse("Drone Low Battery", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    //    DRONE MAXIMUM WEIGHT EXCEEDED EXCEPTION_HANDLER
    @ExceptionHandler(DroneMaximumWeightExceededException.class)
    public ResponseEntity<Object> handleDroneMaximumWeightExceededException(DroneMaximumWeightExceededException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        details.add(LocalDateTime.now().toString());
        ErrorResponse error = new ErrorResponse("Drone Maximum Weight Exceeded", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    //    ILLEGAL DRONE LOADING EXCEPTION_HANDLER
    @ExceptionHandler(IllegalDroneLoadingException.class)
    public ResponseEntity<Object> handleDroneIllegalLoadingException(IllegalDroneLoadingException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        details.add(LocalDateTime.now().toString());
        ErrorResponse error = new ErrorResponse("Illegal Drone Loading", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    //     METHOD NOT ALLOWED EXCEPTION_HANDLER
    @ExceptionHandler(HttpClientErrorException.MethodNotAllowed.class)
    public ResponseEntity<Object> handleMethodNotAllowedException(MethodNotAllowedException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        details.add(LocalDateTime.now().toString());
        ErrorResponse error = new ErrorResponse("Method Not Allowed", details);
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}
