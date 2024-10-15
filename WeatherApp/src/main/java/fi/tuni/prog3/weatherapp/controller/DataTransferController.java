package fi.tuni.prog3.weatherapp.controller;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@Slf4j
@Component
public class DataTransferController {
    private static DataTransferController instance;
    private String dataInput;
    private AnchorPane content;

    private Button btnForecast;
    private Button btnData;
    private Button btnHome;
    private Button btnSetting;

    private FxWeaver fxWeaver;

    private final Map<Class<?>, Button> controllerButtonMap = new HashMap<>();

    private DataTransferController() {}

    public static synchronized DataTransferController getInstance() {
        if (instance == null) {
            instance = new DataTransferController();
        }
        return instance;
    }

    public void initialize(FxWeaver fxWeaver,AnchorPane content, Button btnHome, Button btnData, Button btnForecast, Button btnSetting) {
        this.fxWeaver = fxWeaver;
        this.content = content;
        this.btnHome = btnHome;
        this.btnData = btnData;
        this.btnForecast = btnForecast;
        this.btnSetting = btnSetting;

//         Mapping controller match button
        controllerButtonMap.put(HomeController.class, btnHome);
        controllerButtonMap.put(DataController.class, btnData);
        controllerButtonMap.put(ForecastController.class, btnForecast);
        controllerButtonMap.put(SettingController.class, btnSetting);
    }

    public void loadLayout(Class<?> controllerClass) {
        if (fxWeaver == null) {
            log.error("FxWeaver is not initialized.");
            return;
        }
        Parent root = fxWeaver.loadView(controllerClass);
        if (root == null) {
            log.error("Failed to load view for {}", controllerClass.getSimpleName());
            return;
        }
        content.getChildren().clear();
        content.getChildren().setAll(root);

//      Set style selected button menu
        Button selectedButton = controllerButtonMap.get(controllerClass);
        resetButtonFunction();
        if (selectedButton != null) {
            selectedButton.setStyle("-fx-background-color: #2b2b2b; -fx-text-fill: white;");
        }
    }

    private void resetButtonFunction() {
        if (btnHome != null) btnHome.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
        if (btnData != null) btnData.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
        if (btnForecast != null) btnForecast.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
        if (btnSetting != null) btnSetting.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
    }
}
