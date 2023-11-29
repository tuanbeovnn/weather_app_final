package fi.tuni.prog3.weatherapp.service.impl;

import fi.tuni.prog3.weatherapp.dto.ForeCastInfoDto;
import fi.tuni.prog3.weatherapp.dto.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.entity.WeatherHistoryEntity;
import fi.tuni.prog3.weatherapp.exception.ErrorCode;
import fi.tuni.prog3.weatherapp.exception.WeatherException;
import fi.tuni.prog3.weatherapp.repository.WeatherHistoryRepository;
import fi.tuni.prog3.weatherapp.service.iAPI;
import fi.tuni.prog3.weatherapp.util.GsonUtils;
import fi.tuni.prog3.weatherapp.weatherapi.WeatherApi;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements iAPI {
    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
    private static final String DEFAULT_LOCATION = "Vaasa";
    private final WeatherApi weatherApi;
    private final WeatherHistoryRepository weatherHistoryRepository;

    @Override
    public WeatherInfoDto lookUpLocation(String loc) {
        try {
            WeatherHistoryEntity weatherHistoryEntity = new WeatherHistoryEntity();
            WeatherInfoDto weatherInfoDto = weatherApi.weatherInfo(loc);
            if (weatherInfoDto != null) {
                weatherHistoryEntity.setLocation(weatherInfoDto.getName());
                weatherHistoryEntity.setDetails(GsonUtils.objectToString(weatherInfoDto));
                weatherHistoryEntity.setWeatherIdLocation(weatherInfoDto.getId());
                weatherHistoryEntity.setIsFavorite(false);
                weatherHistoryEntity = weatherHistoryRepository.save(weatherHistoryEntity);
                weatherInfoDto.setCurrentId(weatherHistoryEntity.getId());
            }
            return weatherInfoDto;
        } catch (WebClientResponseException.NotFound notFoundException) {
            logger.error("Weather Location not found: {}", loc);
            return null;
        }
    }

    @Override
    public WeatherInfoDto getCurrentWeather(String location) {
        if (location == null || location.equals("")) {
            return weatherApi.weatherInfo(DEFAULT_LOCATION);
        }
        return weatherApi.weatherInfo(location);
    }

    @Override
    public ForeCastInfoDto getForecast(String location) {
        try {
            if (location == null || location.equals("")) {
                return weatherApi.foreCastInfo(DEFAULT_LOCATION);
            }
            return weatherApi.foreCastInfo(location);
        } catch (WebClientResponseException.NotFound notFoundException) {
            logger.error("Forecast Location not found: {}", location);
            return null;
        }
    }

    @Override
    public List<WeatherInfoDto> getListHistory() {
        List<WeatherHistoryEntity> weatherInfoDtoList = weatherHistoryRepository.findAllByCreatedDate();

        if (weatherInfoDtoList == null) {
            return Collections.emptyList();
        }

        return weatherInfoDtoList.stream()
                .map(weatherHistoryEntity -> GsonUtils.stringToObject(weatherHistoryEntity.getDetails(), WeatherInfoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<WeatherInfoDto> getListFavorite() {
        List<WeatherHistoryEntity> weatherInfoDtoList = weatherHistoryRepository.findAllByFavoriteCreatedDate();

        if (weatherInfoDtoList == null) {
            return Collections.emptyList();
        }

        return weatherInfoDtoList.stream()
                .map(weatherHistoryEntity -> GsonUtils.stringToObject(weatherHistoryEntity.getDetails(), WeatherInfoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateFavoriteStatus(Long id, boolean isFavorite) {
        WeatherHistoryEntity weatherHistoryEntity = weatherHistoryRepository.findById(id)
                .orElseThrow(() -> new WeatherException(ErrorCode.ID_NOT_FOUND));

        weatherHistoryEntity.setIsFavorite(isFavorite);
        weatherHistoryRepository.save(weatherHistoryEntity);
    }

    @Override
    public void isNotFavorite(Long id) {
        WeatherHistoryEntity weatherHistoryEntity = weatherHistoryRepository.findById(id)
                .orElseThrow(() -> new WeatherException(ErrorCode.ID_NOT_FOUND));
        weatherHistoryEntity.setIsFavorite(false);
        weatherHistoryRepository.save(weatherHistoryEntity);
    }
    @Override
    public WeatherInfoDto findById(Long id) {
        WeatherHistoryEntity weatherHistoryEntity = weatherHistoryRepository.findById(id)
                .orElseThrow(() -> new WeatherException(ErrorCode.ID_NOT_FOUND));
        WeatherInfoDto weatherInfoDto = GsonUtils.stringToObject(weatherHistoryEntity.getDetails(), WeatherInfoDto.class);
        weatherInfoDto.setIsFavorite(weatherHistoryEntity.getIsFavorite());
        return weatherInfoDto;
    }


}
