package com.augustine.musalasoftdroneservice.util;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 20/Sep/2022 - 12:24 AM
 * @project MusalaSoftDroneService
 */
public class MedicationDTO {
    private String name;
    private Double weight;
    private String code;
    private String imageURL;

    public MedicationDTO() {
    }

    public MedicationDTO(String name, Double weight, String code, String imageURL) {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
