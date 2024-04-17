package fr.harvest.temptracking.application.usecase;

import fr.harvest.temptracking.domain.TemperatureHistory;
import fr.harvest.temptracking.infrastrecture.entity.TemperatureHistoryEntity;
import fr.harvest.temptracking.infrastrecture.repository.TemperatureHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DatabaseAdapter {
    private final TemperatureHistoryRepository repository;

    public void saveTemperatureHistory(TemperatureHistory history) {
        TemperatureHistoryEntity entity = new TemperatureHistoryEntity(history.getTemperature(), history.getTimestamp());
        repository.save(entity);
    }

    public List<TemperatureHistory> getTemperatureHistory() {
        return repository.findTop15ByOrderByIdDesc();
    }
}
