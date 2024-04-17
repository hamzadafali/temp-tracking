package fr.harvest.temptracking.infrastrecture.controller;

import fr.harvest.temptracking.application.usecase.HistoricalUseCase;
import fr.harvest.temptracking.application.usecase.TemperatureMeasurementUseCase;
import fr.harvest.temptracking.domain.TemperatureHistory;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sensor")
public class SensorController {
    private final TemperatureMeasurementUseCase service;
    private final HistoricalUseCase historicalUseCase;



    @GetMapping("/state")
    public String getSensorState() {
        return service.execute();
    }

    @GetMapping("/history")
    //ResponseEntity
    public List<TemperatureHistory> getTemperatureHistory() {
        return historicalUseCase.getTemperatureHistory();
    }

    @PostMapping("/thresholds")
    public void setThresholds(@RequestParam double hot, @RequestParam double cold) {
        service.setThresholds(hot, cold);
    }
}