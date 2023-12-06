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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherServiceImpl implements iAPI {
    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
    private static final String DEFAULT_LOCATION = "Vaasa";
    private final WeatherApi weatherApi;
    private final WeatherHistoryRepository weatherHistoryRepository;

    public WeatherServiceImpl(WeatherApi weatherApi, WeatherHistoryRepository weatherHistoryRepository) {
        this.weatherApi = weatherApi;
        this.weatherHistoryRepository = weatherHistoryRepository;
    }

    /**
     * This method using for looking a new location
     *
     * @param loc
     * @return
     */
    @Override
    public WeatherInfoDto lookUpLocation(String loc) {
        try {
            var weatherHistoryEntity = new WeatherHistoryEntity();
            var weatherInfoDto = weatherApi.weatherInfo(loc);
            if (weatherInfoDto != null) {
                weatherHistoryEntity.setLocation(weatherInfoDto.getName());
                weatherHistoryEntity.setDetails(GsonUtils.objectToString(weatherInfoDto));
                weatherHistoryEntity.setWeatherIdLocation(weatherInfoDto.getId());
                weatherHistoryEntity.setFavorite(false);
                weatherHistoryEntity = weatherHistoryRepository.save(weatherHistoryEntity);
                weatherInfoDto.setCurrentId(weatherHistoryEntity.getId());
            }
            return weatherInfoDto;
        } catch (WebClientResponseException.NotFound notFoundException) {
            logger.error("Weather Location not found: {}", loc);
            return null;
        }
    }

    /**
     * This method using for getting a current location, by default is Vaasa location
     *
     * @param location
     * @return
     */
    @Override
    public WeatherInfoDto getCurrentWeather(String location) {
        if (location == null || location.equals("")) {
            return weatherApi.weatherInfo(DEFAULT_LOCATION);
        }
        return weatherApi.weatherInfo(location);
    }

    /**
     * This method is using for get the fore cast
     *
     * @param location
     * @return
     */
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

    /**
     * This method is using for get the list history search
     *
     * @return
     */
    @Override
    public List<WeatherInfoDto> getListHistory() {
        var weatherHistoryEntityList = weatherHistoryRepository.findAllByCreatedDate();

        if (weatherHistoryEntityList == null) {
            logger.error("Get list history unsuccessfully {}", weatherHistoryEntityList);
            return Collections.emptyList();
        }
        logger.info("Get list history successfully {}", weatherHistoryEntityList.size());

        return weatherHistoryEntityList.stream()
                .map(weatherHistoryEntity -> {
                    WeatherInfoDto weatherInfoDto = GsonUtils.stringToObject(weatherHistoryEntity.getDetails(), WeatherInfoDto.class);
                    weatherInfoDto.setCurrentId(weatherHistoryEntity.getId());
                    return weatherInfoDto;
                })
                .collect(Collectors.toList());
    }

    /**
     * This method is using for get list favorite when client want to see their favorite
     *
     * @return
     */
    @Override
    public List<WeatherInfoDto> getListFavorite() {
        var weatherFavoriteList = weatherHistoryRepository.findAllByFavoriteCreatedDate();

        if (weatherFavoriteList == null) {
            logger.error("Get list favorite unsuccessfully {}", weatherFavoriteList);
            return Collections.emptyList();
        }
        logger.info("Get list favorite successfully {}", weatherFavoriteList.size());

        return weatherFavoriteList.stream()
                .map(weatherHistoryEntity -> {
                    WeatherInfoDto weatherInfoDto = GsonUtils.stringToObject(weatherHistoryEntity.getDetails(), WeatherInfoDto.class);
                    weatherInfoDto.setCurrentId(weatherHistoryEntity.getId());
                    return weatherInfoDto;
                })
                .collect(Collectors.toList());
    }

    /**
     * This method is using for update status of favorite
     *
     * @param id
     * @param isFavorite
     */

    @Override
    public void updateFavoriteStatus(Long id, boolean isFavorite) {
        var weatherHistoryEntity = weatherHistoryRepository.findById(id)
                .orElseThrow(() -> new WeatherException(ErrorCode.ID_NOT_FOUND));

        weatherHistoryEntity.setFavorite(isFavorite);
        logger.info("Update status successfully with id {}", id);
        weatherHistoryRepository.save(weatherHistoryEntity);
    }

    /**
     * This method is using for findById of the weather.
     *
     * @param id
     * @return
     */
    @Override
    public WeatherInfoDto findById(Long id) {
        var weatherHistoryEntity = weatherHistoryRepository.findById(id)
                .orElseThrow(() -> new WeatherException(ErrorCode.ID_NOT_FOUND));
        WeatherInfoDto weatherInfoDto = GsonUtils.stringToObject(weatherHistoryEntity.getDetails(), WeatherInfoDto.class);
        weatherInfoDto.setFavorite(weatherHistoryEntity.getFavorite());
        weatherInfoDto.setCurrentId(id);
        logger.info("Find by id successfully {}", id);
        return weatherInfoDto;
    }


}
