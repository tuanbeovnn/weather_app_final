package fi.tuni.prog3.weatherapp;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherSystemApplication {
    public static void main(String[] args) {
        Application.launch(WeatherApp.class, args);
    }
}
