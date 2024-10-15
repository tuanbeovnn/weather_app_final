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
    private AnchorPane contentId;

    @FXML
    private Button btnForecast, btnData, btnHome, btnSetting;

    @Autowired
    private FxWeaver fxWeaver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(this::initMainView);

//        Set button menu
        DataTransferController dataTransferController = DataTransferController.getInstance();
        dataTransferController.setBtnForecast(btnForecast);
        dataTransferController.setBtnData(btnData);
        dataTransferController.setBtnHome(btnHome);
        dataTransferController.setBtnSetting(btnSetting);
    }

    private void initMainView() {
        loadLayout(HomeController.class, btnHome);
    }

    @FXML
    void loadHomeLayout(ActionEvent event) {
        loadLayout(HomeController.class, btnHome);
    }

    @FXML
    void loadDataLayout(ActionEvent event) {
        loadLayout(DataController.class, btnData);
    }

    @FXML
    void loadForecastLayout(ActionEvent event) {
        loadLayout(ForecastController.class, btnForecast);
    }

    @FXML
    void loadSettingLayout(ActionEvent event) {
        loadLayout(SettingController.class, btnSetting);
    }

    private void loadLayout(Class<?> controllerClass, Button selectedButton) {
        Parent root = fxWeaver.loadView(controllerClass);
        if (root == null) {
            log.error("Failed to load view for {}", controllerClass.getSimpleName());
            return;
        }
        contentId.getChildren().clear();
        contentId.getChildren().setAll(root);
        selectButton(selectedButton);
    }

    private void selectButton(Button selectedButton) {
//        Reset style all menu button
        btnHome.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
        btnData.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
        btnForecast.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
        btnSetting.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
//        Set style for selected menu button
        selectedButton.setStyle("-fx-background-color: #2b2b2b; -fx-text-fill: white;");
    }

}