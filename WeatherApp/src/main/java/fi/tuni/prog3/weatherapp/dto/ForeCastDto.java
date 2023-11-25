package fi.tuni.prog3.weatherapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ForeCastDto {
    private Long dt;
    private MainDto main;
    private List<WeatherDto> weather;
    private CloudsDto clouds;
    private WindDto wind;
    private Long visibility;
    private double pop;
    private SysDto sys;
    private String dt_txt;
}
