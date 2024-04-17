package fr.harvest.temptracking.application.usecase;

import fr.harvest.temptracking.domain.TemperatureHistory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class HistoricalUseCase {
    private final fr.harvest.temptracking.application.usecase.DatabaseAdapter databaseAdapter;

    public List<TemperatureHistory> getTemperatureHistory() {
        return databaseAdapter.getTemperatureHistory();
    }
}
