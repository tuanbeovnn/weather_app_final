package fi.tuni.prog3.weatherapp.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class WeatherDto {
    private Long id;
    private String main;
    private String description;
    private String icon;

}
