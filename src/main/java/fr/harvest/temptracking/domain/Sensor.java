package fr.harvest.temptracking.domain;


public class Sensor {

    private SensorState state;

    public Sensor(double hotThreshold, double coldThreshold) {
        this.state = new SensorState(hotThreshold, coldThreshold);
    }

    public String determineState(double temperature) {
        return state.determineState(temperature);
    }

    public void updateStateThresholds(double hot, double cold) {
        state.updateThresholds(hot, cold);
    }
}