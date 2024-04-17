package fr.harvest.temptracking.infrastrecture.Adapter;

import fr.harvest.temptracking.domain.port.TemperatureCaptor;
import org.springframework.stereotype.Service;

@Service
public class TemperatureCaptorImpl implements TemperatureCaptor {
    @Override
    public double getTemperature() {
        return 43.0;
    }
}
