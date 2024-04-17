package fr.harvest.temptracking.application.usecase;

import fr.harvest.temptracking.domain.Sensor;
import fr.harvest.temptracking.domain.TemperatureHistory;
import fr.harvest.temptracking.domain.port.TemperatureCaptor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class TemperatureMeasurementUseCase {
    private final Sensor sensor;
    private final TemperatureCaptor temperatureCaptor;
    private final fr.harvest.temptracking.application.usecase.DatabaseAdapter databaseAdapter;

    public String execute() {

        String state = sensor.determineState(temperatureCaptor.getTemperature());
        databaseAdapter.saveTemperatureHistory(new TemperatureHistory(temperatureCaptor.getTemperature(), LocalDateTime.now()));
        return state;
    }

    public void setThresholds(double hot, double cold) {
        sensor.updateStateThresholds(hot, cold);
    }
}
