package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.model.MainUIModel;
import fi.tuni.prog3.weatherapp.model.MenuUIModel;
import fi.tuni.prog3.weatherapp.service.LayoutService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@Slf4j
public class MenuController implements Initializable {
    @FXML
    private Button btnForecast, btnData, btnHome, btnSetting;

    @FXML
    private Label inputSearch;

    @Autowired
    private LayoutService layoutService;

    @Getter
    private MenuUIModel menuUIModel;

    @Getter
    private MainUIModel mainUIModel;

    @FXML
    void loadHomeLayout(ActionEvent event) {
        log.info("Go Data");
    }

    @FXML
    void loadDataLayout(ActionEvent event) {
        log.info("Go Forecast");
    }

    @FXML
    void loadForecastLayout(ActionEvent event) {
        log.info("Go Home");
    }

    @FXML
    void loadSettingLayout(ActionEvent event) {
        log.info("Go Setting");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
