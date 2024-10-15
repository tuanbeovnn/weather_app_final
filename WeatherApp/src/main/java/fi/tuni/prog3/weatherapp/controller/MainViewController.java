package fi.tuni.prog3.weatherapp.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/MainView.fxml")
@Slf4j
public class MainViewController implements Initializable {

    @FXML
    @Getter
    private AnchorPane content;

    @FXML
    private Button btnForecast, btnData, btnHome, btnSetting;

    @Autowired
    private FxWeaver fxWeaver;

    private final DataTransferController dataTransferController = DataTransferController.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataTransferController.initialize(fxWeaver, content, btnHome, btnData, btnForecast, btnSetting);

        Platform.runLater(this::initMainView);
    }

    private void initMainView() {
        dataTransferController.loadLayout(HomeController.class);
    }

    @FXML
    void loadHomeLayout(ActionEvent event) {
        dataTransferController.loadLayout(HomeController.class);
    }

    @FXML
    void loadDataLayout(ActionEvent event) {
        dataTransferController.loadLayout(DataController.class);
    }

    @FXML
    void loadForecastLayout(ActionEvent event) {
        dataTransferController.loadLayout(ForecastController.class);
    }

    @FXML
    void loadSettingLayout(ActionEvent event) {
        dataTransferController.loadLayout(SettingController.class);
    }
}