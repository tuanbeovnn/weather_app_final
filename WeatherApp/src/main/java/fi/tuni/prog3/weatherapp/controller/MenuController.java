package fi.tuni.prog3.weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MenuController {
    @FXML
    private Button Forecast;

    @FXML
    private Button btnData;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnSetting;

    @FXML
    void goData(ActionEvent event) {
        log.info("Go Data");
    }

    @FXML
    void goForecast(ActionEvent event) {
        log.info("Go Forecast");
    }

    @FXML
    void goHome(ActionEvent event) {
        log.info("Go Home");
    }

    @FXML
    void goSetting(ActionEvent event) {
        log.info("Go Setting");
    }


}
