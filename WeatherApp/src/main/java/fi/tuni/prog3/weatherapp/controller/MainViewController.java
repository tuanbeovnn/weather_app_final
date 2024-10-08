package fi.tuni.prog3.weatherapp.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/mainView.fxml")
@Slf4j
public class MainViewController implements Initializable {
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
        Platform.runLater(this::loadHomeLayout);
    }

    private void loadHomeLayout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomeLayout.fxml"));
            Parent homeView = loader.load();
            contentId.getChildren().setAll(homeView);
        } catch (IOException e) {
            log.error("Failed to load HomeLayout.fxml", e);
        }
    }

    @FXML
    void loadDataLayout(ActionEvent event) {
        log.info("Go Data");
    }

    @FXML
    void loadForecastLayout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ForecastLayout.fxml"));
        Parent forecastView = loader.load();
        contentId.getChildren().clear();
        contentId.getChildren().setAll(forecastView);

    }

    @FXML
    void loadHomeLayout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomeLayout.fxml"));
        Parent homeView = loader.load();
        contentId.getChildren().clear();
        contentId.getChildren().setAll(homeView);

    }

    @FXML
    void loadSettingLayout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SettingLayout.fxml"));
        Parent settingView = loader.load();
        contentId.getChildren().clear();
        contentId.getChildren().setAll(settingView);

    }

}
