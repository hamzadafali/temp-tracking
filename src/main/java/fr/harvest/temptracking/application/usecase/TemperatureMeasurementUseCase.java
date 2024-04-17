package fr.harvest.temptracking.application.usecase;

import fr.harvest.temptracking.domain.Sensor;
import fr.harvest.temptracking.domain.TemperatureHistory;
import fr.harvest.temptracking.domain.port.TemperatureCaptor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class TemperatureMeasurementUseCase {
    private Sensor sensor;
    private TemperatureCaptor temperatureCaptor;

    public String execute() {
        return null;
    }

    public void setThresholds(double hot, double cold) {
    }
}
