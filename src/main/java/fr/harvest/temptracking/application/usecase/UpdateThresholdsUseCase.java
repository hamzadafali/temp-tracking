package fr.harvest.temptracking.application.usecase;

import fr.harvest.temptracking.domain.Sensor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UpdateThresholdsUseCase {
    private Sensor sensor;

    public void updateThresholds(double hotThreshold, double coldThreshold) {
        sensor.updateStateThresholds(hotThreshold, coldThreshold);
    }
}
