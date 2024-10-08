package fi.tuni.prog3.weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/mainViewV2.fxml")
@Slf4j
public class MainViewV2Controller implements Initializable {
    @FXML
    private AnchorPane contentId;

    @FXML
    private Button Forecast;

    @FXML
    private Button btnData;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnSetting;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/component/HomeLayout.fxml"));
//            Parent homeView = loader.load();
//            contentId.getChildren().clear();
//            contentId.getChildren().setAll(homeView);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    void goData(ActionEvent event) {
        log.info("Go Data");
    }

    @FXML
    void goForecast(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/component/ForecastLayout.fxml"));
            Parent forecastView = loader.load();
            contentId.getChildren().clear();
            contentId.getChildren().setAll(forecastView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goHome(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/component/HomeLayout.fxml"));
            Parent homeView = loader.load();
            contentId.getChildren().clear();
            contentId.getChildren().setAll(homeView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goSetting(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/component/SettingLayout.fxml"));
            Parent settingView = loader.load();
            contentId.getChildren().clear();
            contentId.getChildren().setAll(settingView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
