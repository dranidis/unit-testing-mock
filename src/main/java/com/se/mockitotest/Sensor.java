package com.se.mockitotest;

public class Sensor {

    private final int initial = 95;
    private final int dt = 7;

    private int current;

    public int getTemperature() {
        int change = (int) (Math.random() * 2 * dt) - dt;
        current = initial + change;
        System.out.println("Temperature: " + current);
        return current ; // returns 0..199
    }

}
