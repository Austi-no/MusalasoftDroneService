package com.augustine.musalasoftdroneservice.util;

import java.time.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 1:35 PM
 * @project MusalaSoftDroneService
 */
public class ErrorResponse {

    private LocalDateTime dateTime;
    private String message;

    public ErrorResponse(LocalDateTime dateTime, String message) {
        this.dateTime = dateTime;
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
