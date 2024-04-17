package fr.harvest.temptracking.application.usecase;

import fr.harvest.temptracking.domain.TemperatureHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HistoricalUseCaseTest {

    private fr.harvest.temptracking.application.usecase.DatabaseAdapter dataBaseAdapter;
    private HistoricalUseCase  useCase;

    @BeforeEach
    void setUp() {
        // Mock the dependencies
        dataBaseAdapter = mock(fr.harvest.temptracking.application.usecase.DatabaseAdapter.class);
        // Initialize the use case with the mocked dependencies
        useCase = new HistoricalUseCase(dataBaseAdapter);
    }

    @Test
    void testGetTemperatureHistory() {
        // Setup expected results
        List<TemperatureHistory> expectedHistory = Arrays.asList(
                new TemperatureHistory(25.0, LocalDateTime.now()),
                new TemperatureHistory(26.0, LocalDateTime.now())
        );
        when(dataBaseAdapter.getTemperatureHistory()).thenReturn(expectedHistory);

        // Execute
        List<TemperatureHistory> history = useCase.getTemperatureHistory();

        // Verify
        assertEquals(expectedHistory, history);
        verify(dataBaseAdapter).getTemperatureHistory();
    }
}