package fr.harvest.temptracking.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorTest {
    private Sensor sensor;

    @BeforeEach
    void setUp() {
        sensor = new Sensor(40.0, 22.0);
    }

        @Test
        void testDetermineStateHot() {
            // given
            final double givenTemperature1 = 40.0;
            final double givenTemperature2 = 45.0;
            // when
            final String result1 = sensor.determineState(givenTemperature1);
            final String result2 = sensor.determineState(givenTemperature2);

            // then
            assertEquals("HOT", result1);
            assertEquals("HOT", result2);
        }

        @Test
        void testDetermineStateCold () {
            // given
            final double givenTemperature1 = 21.0;
            final double givenTemperature2 = 18.0;
            // when
            final String result1 = sensor.determineState(givenTemperature1);
            final String result2 = sensor.determineState(givenTemperature2);

            // then
            assertEquals("COLD", result1);
            assertEquals("COLD", result2);
        }

        @Test
        void testDetermineStateWarm () {
            // given
            final double givenTemperature1 = 30.0;
            final double givenTemperature2 = 39.0;
            // when
            final String result1 = sensor.determineState(givenTemperature1);
            final String result2 = sensor.determineState(givenTemperature2);
            // then
            assertEquals("WARM", result1);
            assertEquals("WARM", result2);
        }

        @Test
        void testUpdateStateThresholds () {
            // given
            final double givenTemperature1 = 50.0;
            final double givenTemperature2 = 20.0;
            // when
            sensor.updateStateThresholds(50.0, 20.0);
            // then
            assertEquals("HOT", sensor.determineState(51.0), "Sensor should be HOT at the new threshold of 50.0°C");
            assertEquals("COLD", sensor.determineState(19.0), "Sensor should be COLD at the new threshold of 20.0°C");
        }
    }