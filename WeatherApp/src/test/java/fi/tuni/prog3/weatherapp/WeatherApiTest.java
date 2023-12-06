package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.config.WeatherApp;
import fi.tuni.prog3.weatherapp.dto.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.entity.WeatherHistoryEntity;
import fi.tuni.prog3.weatherapp.exception.WeatherException;
import fi.tuni.prog3.weatherapp.repository.WeatherHistoryRepository;
import fi.tuni.prog3.weatherapp.service.impl.WeatherServiceImpl;
import fi.tuni.prog3.weatherapp.weatherapi.WeatherApi;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static fi.tuni.prog3.weatherapp.TestUtils.createMockWeatherInfoDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = WeatherApp.class)
@AutoConfigureMockMvc
public class WeatherApiTest {
    @Mock
    private WeatherApi weatherApi;
    @Mock
    private WeatherHistoryRepository weatherHistoryRepository;
    @InjectMocks
    private WeatherServiceImpl weatherService;

    @Test
    public void testLookUpLocation_NotFound() {
        // Arrange
        String location = "UnknownLocation";
        when(weatherApi.weatherInfo(location)).thenThrow(WebClientResponseException.NotFound.class);
        // Act
        WeatherInfoDto result = weatherService.lookUpLocation(location);
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetCurrentWeather_DefaultLocation() {
        // Arrange
        WeatherInfoDto defaultWeatherInfoDto = new WeatherInfoDto();
        when(weatherApi.weatherInfo("Vaasa")).thenReturn(defaultWeatherInfoDto);
        // Act
        WeatherInfoDto result = weatherService.getCurrentWeather(null);
        // Assert
        assertNotNull(result);
        assertEquals(defaultWeatherInfoDto, result);
    }


    @Test
    public void lookUpLocation_Success() {
        // Arrange
        WeatherInfoDto mockWeatherInfoDto = new WeatherInfoDto();
        mockWeatherInfoDto.setName("TestLocation");

        when(weatherApi.weatherInfo(anyString())).thenReturn(mockWeatherInfoDto);

        WeatherHistoryEntity mockWeatherHistoryEntity = new WeatherHistoryEntity();
        mockWeatherHistoryEntity.setId(1L);

        when(weatherHistoryRepository.save(any())).thenReturn(mockWeatherHistoryEntity);
        // Act
        WeatherInfoDto result = weatherService.lookUpLocation("TestLocation");
        // Assert
        assertNotNull(result);
        assertEquals("TestLocation", result.getName());
        assertEquals(1L, result.getCurrentId());
        // Verify interactions with mocks
        verify(weatherApi, times(1)).weatherInfo("TestLocation");
        verify(weatherHistoryRepository, times(1)).save(any(WeatherHistoryEntity.class));
    }

    @Test
    public void lookUpLocation_LocationNotFound() {
        // Arrange
        when(weatherApi.weatherInfo(anyString())).thenThrow(WebClientResponseException.NotFound.class);
        // Act
        WeatherInfoDto result = weatherService.lookUpLocation("NonExistentLocation");
        // Assert
        assertNull(result);
        // Verify
        verify(weatherApi, times(1)).weatherInfo("NonExistentLocation");
        verify(weatherHistoryRepository, never()).save(any(WeatherHistoryEntity.class));
    }

    @Test
    public void getListHistory_NoHistory_ReturnsEmptyList() {
        // Arrange
        when(weatherHistoryRepository.findAllByCreatedDate()).thenReturn(Collections.emptyList());
        // Act
        List<WeatherInfoDto> result = weatherService.getListHistory();
        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        // Verify
        verify(weatherHistoryRepository, times(1)).findAllByCreatedDate();
        verifyNoInteractions(weatherApi);
    }

    @Test
    public void updateFavoriteStatus_IdNotFound_ShouldThrowWeatherException() {
        // Arrange
        long nonExistentId = 999L;
        boolean mockIsFavorite = true;
        when(weatherHistoryRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // Act & Assert
        WeatherException exception = assertThrows(WeatherException.class,
                () -> weatherService.updateFavoriteStatus(nonExistentId, mockIsFavorite));
        assertEquals("404", exception.getCode());
        // Verify
        verify(weatherHistoryRepository, times(1)).findById(nonExistentId);
        verifyNoMoreInteractions(weatherApi);
    }

    @Test
    public void updateFavoriteStatus_Success() {
        // Arrange
        long mockId = 1L;
        boolean mockIsFavorite = true;
        WeatherHistoryEntity mockWeatherHistoryEntity = createMockWeatherHistoryEntity(1L, "Location1", "Details1", 100L, false);
        when(weatherHistoryRepository.findById(mockId)).thenReturn(Optional.of(mockWeatherHistoryEntity));
        // Act
        assertDoesNotThrow(() -> weatherService.updateFavoriteStatus(mockId, mockIsFavorite));
        // Verify interactions with mocks
        verify(weatherHistoryRepository, times(1)).findById(mockId);
        verify(weatherHistoryRepository, times(1)).save(mockWeatherHistoryEntity);
        verifyNoMoreInteractions(weatherApi);
    }

    @Test
    public void getListFavorite_EmptyList_ReturnsEmptyList() {
        // Arrange
        when(weatherHistoryRepository.findAllByFavoriteCreatedDate()).thenReturn(Collections.emptyList());
        // Act
        List<WeatherInfoDto> result = weatherService.getListFavorite();
        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        // Verify interactions with mocks
        verify(weatherHistoryRepository, times(1)).findAllByFavoriteCreatedDate();
        verifyNoMoreInteractions(weatherApi);
    }

    @Test
    void lookUpLocation_SaveError() {
        // Arrange
        String location = "Helsinki";
        when(weatherApi.weatherInfo(location)).thenReturn(createMockWeatherInfoDto());
        when(weatherHistoryRepository.save(any())).thenThrow(RuntimeException.class);
        // Act & Assert
        assertThrows(RuntimeException.class, () -> weatherService.lookUpLocation(location));
        // Verify interactions with mocks
        verify(weatherApi, times(1)).weatherInfo(location);
        verify(weatherHistoryRepository, times(1)).save(any());
        verifyNoMoreInteractions(weatherApi, weatherHistoryRepository);
    }

    private WeatherHistoryEntity createMockWeatherHistoryEntity(Long id, String location, String details,
                                                                Long weatherIdLocation, boolean isFavorite) {
        WeatherHistoryEntity mockEntity = new WeatherHistoryEntity();
        mockEntity.setId(id);
        mockEntity.setLocation(location);
        mockEntity.setDetails(details);
        mockEntity.setWeatherIdLocation(weatherIdLocation);
        mockEntity.setFavorite(isFavorite);
        // Set other fields as needed
        return mockEntity;
    }

}