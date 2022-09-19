package com.augustine.musalasoftdroneservice.util;

import com.augustine.musalasoftdroneservice.model.*;
import com.fasterxml.jackson.annotation.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 9:25 PM
 * @project MusalaSoftDroneService
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "response", "message", "date"
})
public class ApiResponse<T> {
    @JsonProperty("data")
    private T data;

    @JsonProperty("status")
    private String response;

    @JsonProperty("message")
    private String message;

    public ApiResponse() {
    }

    public ApiResponse(T data, String response, String message) {
        this.data = data;
        this.response = response;
        this.message = message;
    }
    public ApiResponse(String response, T data) {
        this.response = response;
        this.data = data;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
