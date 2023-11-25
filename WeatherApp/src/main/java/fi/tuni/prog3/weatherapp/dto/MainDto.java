package fi.tuni.prog3.weatherapp.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainDto {
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private double pressure;
    private double humidity;
    private double sea_level;
    private double grnd_level;

}
