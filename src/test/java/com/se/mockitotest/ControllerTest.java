package com.se.mockitotest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit test
 */
public class ControllerTest {

    @Test
    public void offAtBeginning() {
        Controller s = new Controller(new Sensor());
        assertFalse(s.getStatus());
    }

    @Test
    public void onAfterTurnOn() {
        Controller s = new Controller(new Sensor());
        s.turnOn();
        assertTrue(s.getStatus());
    }

    @Test
    public void offAfterShutDown() {
        Controller s = new Controller(new Sensor());
        s.turnOn();
        s.shutdown();
        assertFalse(s.getStatus());
    }

    @Test
    public void turnsOffWhenSensorValueHigh() {
        Sensor mockSensor = Mockito.mock(Sensor.class);

        Mockito.when(mockSensor.getTemperature()).thenReturn(101);

        Controller s = new Controller(mockSensor);

        s.check();
        Mockito.verify(mockSensor).getTemperature();

        assertFalse(s.getStatus());
    }

    @Test
    public void staysOnWhenSensorValueLow() {
        Sensor mockSensor = Mockito.mock(Sensor.class);
        Mockito.when(mockSensor.getTemperature()).thenReturn(100);

        Controller s = new Controller(mockSensor);
        s.check();

        assertTrue(s.getStatus());
    }
}
