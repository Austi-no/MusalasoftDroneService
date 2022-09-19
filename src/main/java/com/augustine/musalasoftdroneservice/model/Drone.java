package com.augustine.musalasoftdroneservice.model;

import com.augustine.musalasoftdroneservice.enums.*;
import org.hibernate.validator.constraints.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.*;
import java.io.*;
import java.util.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 7:08 PM
 * @project MusalaSoftDroneService
 */
@Entity
@Table(name = "drone")
public class Drone implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "SERIAL NUMBER should not be blank")
    @Size(min = 3, message = "SERIAL NUMBER should be at least 3 chars")
    @Column(name = "serial_number")
    private String serialNumber;

    @NotBlank(message = "WEIGHT LIMIT should not be blank")
    @Column(name = "weight_limit")
    @Range(min = 1, max = 100, message = "WEIGHT LIMIT should be between 0 and 100")
    private Integer weightLimit;

    @NotBlank(message = "Battery Percentage should not be blank")
    @Range(min = 1, max = 100, message = "BATTERY PERCENTAGE should be between 0 and 100")
    @Column(name = "battery_percentage")
    private Double batteryPercentage;

    @NotBlank(message = "MODEL should not be blank")
    @Column(name = "model")
    @Enumerated(EnumType.STRING)
    private Model model;

    @NotBlank(message = "STATE should not be blank")
    @Column(name = "STATE")
    @Enumerated(EnumType.STRING)
    private State state;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "drone_id")
    private List<Medication> medications;

    public Drone() {
    }

    public Drone(String serialNumber, Integer weightLimit, Double batteryPercentage, Model model, State state) {
        this.serialNumber = serialNumber;
        this.weightLimit = weightLimit;
        this.batteryPercentage = batteryPercentage;
        this.model = model;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(Integer weightLimit) {
        this.weightLimit = weightLimit;
    }

    public Double getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(Double batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", weightLimit=" + weightLimit +
                ", batteryPercentage=" + batteryPercentage +
                ", model=" + model +
                ", state=" + state +
                ", medications=" + medications +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drone)) return false;
        Drone drone = (Drone) o;
        return Objects.equals(id, drone.id) && Objects.equals(serialNumber, drone.serialNumber) && Objects.equals(weightLimit, drone.weightLimit) && Objects.equals(batteryPercentage, drone.batteryPercentage) && model == drone.model && state == drone.state && Objects.equals(medications, drone.medications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, weightLimit, batteryPercentage, model, state, medications);
    }
}
