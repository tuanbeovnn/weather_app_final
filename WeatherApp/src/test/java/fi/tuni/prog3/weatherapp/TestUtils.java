package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.dto.*;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static WeatherInfoDto createMockWeatherInfoDto() {
        WeatherInfoDto weatherInfoDto = new WeatherInfoDto();

        // Set values for the WeatherInfoDto fields for testing
        weatherInfoDto.setCoord(createMockCoordDto());
        weatherInfoDto.setWeather(createMockWeatherDtoList());
        weatherInfoDto.setBase("TestBase");
        weatherInfoDto.setMain(createMockMainDto());
        weatherInfoDto.setVisibility(1000L);
        weatherInfoDto.setWind(createMockWindDto());
        weatherInfoDto.setClouds(createMockCloudsDto());
        weatherInfoDto.setDt(123456789L);
        weatherInfoDto.setSys(createMockSysDto());
        weatherInfoDto.setTimezone(7200L);
        weatherInfoDto.setId(123L);
        weatherInfoDto.setName("TestCity");
        weatherInfoDto.setCod(200L);
        weatherInfoDto.setFavorite(true);
        weatherInfoDto.setCurrentId(456L);

        return weatherInfoDto;
    }

    private static CoordDto createMockCoordDto() {
        CoordDto coordDto = new CoordDto();

        return coordDto;
    }

    private static List<WeatherDto> createMockWeatherDtoList() {
        List<WeatherDto> weatherDtoList = new ArrayList<>();
        WeatherDto weatherDto = new WeatherDto();
        // Set values for WeatherDto fields for testing
        weatherDto.setId(800L);
        weatherDto.setMain("Clear");
        weatherDto.setDescription("Clear sky");
        weatherDto.setIcon("01d");
        weatherDtoList.add(weatherDto);
        // Add more WeatherDto objects as needed
        return weatherDtoList;
    }

    private static MainDto createMockMainDto() {
        MainDto mainDto = new MainDto();
        // Set values for MainDto fields for testing
        mainDto.setTemp(25.5);
        mainDto.setPressure(1010L);
        mainDto.setHumidity(50L);
        return mainDto;
    }

    private static WindDto createMockWindDto() {
        WindDto windDto = new WindDto();
        // Set values for WindDto fields for testing
        windDto.setSpeed(5.0);
        windDto.setDeg(180L);
        return windDto;
    }

    private static CloudsDto createMockCloudsDto() {
        CloudsDto cloudsDto = new CloudsDto();
        // Set values for CloudsDto fields for testing
        cloudsDto.setAll(20L);
        return cloudsDto;
    }

    private static SysDto createMockSysDto() {
        SysDto sysDto = new SysDto();
        // Set values for SysDto fields for testing
        sysDto.setId(1234L);
        sysDto.setCountry("FI");
        sysDto.setSunrise(1234567890L);
        sysDto.setSunset(1234567899L);
        return sysDto;
    }
}
