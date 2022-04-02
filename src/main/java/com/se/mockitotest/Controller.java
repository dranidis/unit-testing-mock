package com.se.mockitotest;

public class Controller {
    private Sensor sensor = new Sensor();
    private boolean isOn;

    public Controller(Sensor sensor) {
        this.sensor = sensor;
    }

    public void turnOn() {
        isOn = true;
    }

    public void shutdown() {
        isOn = false;
    }

    public boolean getStatus() {
        return isOn;
    }

    public void check() {
        if (sensor.getTemperature() > 100) {
            isOn = false;
        } else {
            isOn = true;
        }
    }
}
