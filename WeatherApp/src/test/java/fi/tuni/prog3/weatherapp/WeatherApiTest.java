package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.config.WeatherApp;
import fi.tuni.prog3.weatherapp.dto.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.entity.WeatherHistoryEntity;
import fi.tuni.prog3.weatherapp.repository.WeatherHistoryRepository;
import fi.tuni.prog3.weatherapp.service.impl.WeatherServiceImpl;
import fi.tuni.prog3.weatherapp.weatherapi.WeatherApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
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
    public void lookUpLocation_Success() {
        WeatherInfoDto mockWeatherInfoDto = new WeatherInfoDto();
        mockWeatherInfoDto.setName("TestLocation");

        Mockito.when(weatherApi.weatherInfo(Mockito.anyString())).thenReturn(mockWeatherInfoDto);

        WeatherHistoryEntity mockWeatherHistoryEntity = new WeatherHistoryEntity();
        mockWeatherHistoryEntity.setId(1L);

        Mockito.when(weatherHistoryRepository.save(Mockito.any())).thenReturn(mockWeatherHistoryEntity);

        WeatherInfoDto result = weatherService.lookUpLocation("TestLocation");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("TestLocation", result.getName());
        Assertions.assertEquals(1L, result.getCurrentId());
    }

    @Test
    public void lookUpLocation_LocationNotFound() {
        Mockito.when(weatherApi.weatherInfo(Mockito.anyString())).thenThrow(WebClientResponseException.NotFound.class);

        WeatherInfoDto result = weatherService.lookUpLocation("NonExistentLocation");

        Assertions.assertNull(result);
    }


    @Test
    public void getListHistory_NoHistory_ReturnsEmptyList() {
        Mockito.when(weatherHistoryRepository.findAllByCreatedDate()).thenReturn(Collections.emptyList());
        List<WeatherInfoDto> result = weatherService.getListHistory();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }


}