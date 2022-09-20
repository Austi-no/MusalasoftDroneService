package com.augustine.musalasoftdroneservice.util;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 11:58 PM
 * @project MusalaSoftDroneService
 */
public class BatteryStatus {
    private String serialNumber;
    private int batteryPercentage;

    public BatteryStatus(String serialNumber, int batteryPercentage) {
        this.serialNumber = serialNumber;
        this.batteryPercentage = batteryPercentage;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }
}
