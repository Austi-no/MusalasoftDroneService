package com.augustine.musalasoftdroneservice.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 1:54 PM
 * @project MusalaSoftDroneService
 */
@Entity
@Table(name = "medication")
public class Medication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "([A-Za-z0-9\\-_]+)",
            message = "CODE should either be upper case, underscore and numbers")
    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private int weight;

    @Pattern(regexp = "(?=[A-Z0-9_]*[A-Z_])",
            message = "CODE should either be upper case, underscore and numbers")
    @Column(name = "code")
    private String code;


    @Column(name = "image_url")
    private String imageURL;

    @ManyToOne
    @JoinColumn(name="drone_id")
    @JsonBackReference
    private Drone drone;

    public Medication() {
    }

    public Medication(String name, int weight, String code, String imageURL, Drone drone) {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.imageURL = imageURL;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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

    public com.augustine.musalasoftdroneservice.model.Drone getDrone() {
        return drone;
    }

    public void setDrone(com.augustine.musalasoftdroneservice.model.Drone drone) {
        this.drone = drone;
    }
}
