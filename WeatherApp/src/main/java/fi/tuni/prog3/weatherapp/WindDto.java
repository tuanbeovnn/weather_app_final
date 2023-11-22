package fi.tuni.prog3.weatherapp;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WindDto {
    private double speed;
    private double deg;
    private double gust;
}
