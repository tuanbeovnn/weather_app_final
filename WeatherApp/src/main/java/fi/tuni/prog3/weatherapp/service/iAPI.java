/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fi.tuni.prog3.weatherapp.service;

import fi.tuni.prog3.weatherapp.dto.ForeCastInfoDto;
import fi.tuni.prog3.weatherapp.dto.WeatherInfoDto;

import java.util.List;

/**
 * Interface for extracting data from the OpenWeatherMap API.
 */
public interface iAPI {
    WeatherInfoDto lookUpLocation(String loc);

    WeatherInfoDto getCurrentWeather(String location);

    ForeCastInfoDto getForecast(String location);

    List<WeatherInfoDto> getListHistory();

    List<WeatherInfoDto> getListFavorite();

    void updateFavoriteStatus(Long id, boolean isFavorite);

    void isNotFavorite(Long id);

    WeatherInfoDto findById(Long id);

}
