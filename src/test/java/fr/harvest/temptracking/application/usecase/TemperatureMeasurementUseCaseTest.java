package fr.harvest.temptracking.application.usecase;

import fr.harvest.temptracking.domain.Sensor;
import fr.harvest.temptracking.domain.port.TemperatureCaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TemperatureMeasurementUseCaseTest {
    private Sensor sensor;
    private TemperatureCaptor temperatureCaptor;
    private TemperatureMeasurementUseCase useCase;
    private fr.harvest.temptracking.application.usecase.DatabaseAdapter dataBaseAdapter;

    @BeforeEach
    void setUp() {
        // Mock the dependencies
        sensor = mock(Sensor.class);
        dataBaseAdapter = mock(fr.harvest.temptracking.application.usecase.DatabaseAdapter.class);
        temperatureCaptor = mock(TemperatureCaptor.class);
        // Initialize the use case with the mocked dependencies
        useCase = new TemperatureMeasurementUseCase(sensor, temperatureCaptor);
    }

    @Test
    void testExecute() {
        // Setup
        double temperature = 25.0;
        when(temperatureCaptor.getTemperature()).thenReturn(temperature);
        when(sensor.determineState(temperature)).thenReturn("WARM");

        // Execute
        String state = useCase.execute();

        // Verify
        assertEquals("WARM", state);
        verify(sensor).determineState(temperature);
        verify(temperatureCaptor, times(1)).getTemperature();  // S'attend maintenant à deux appels
    }

    @Test
    void testSetThresholds() {
        // Setup thresholds
        double hot = 30.0;
        double cold = 10.0;

        // Execute
        useCase.setThresholds(hot, cold);

        // Verify
        verify(sensor).updateStateThresholds(hot, cold);
    }
}