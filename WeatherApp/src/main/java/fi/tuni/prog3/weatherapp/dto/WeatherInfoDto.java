package fi.tuni.prog3.weatherapp.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class WeatherInfoDto {
    private CoordDto coord;
    private List<WeatherDto> weather;
    private String base;
    private MainDto main;
    private Long visibility;
    private WindDto wind;
    private CloudsDto clouds;
    private Long dt;
    private SysDto sys;
    private Long timezone;
    private Long id;
    private String name;
    private Long cod;

}
