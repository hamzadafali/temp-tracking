package fr.harvest.temptracking.domain;

public class SensorState {
    private double hotThreshold;
    private double coldThreshold;

    public SensorState(double hotThreshold, double coldThreshold) {
        this.hotThreshold = hotThreshold;
        this.coldThreshold = coldThreshold;
    }
}
