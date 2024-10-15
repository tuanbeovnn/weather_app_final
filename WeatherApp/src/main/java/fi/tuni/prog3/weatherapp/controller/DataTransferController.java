package fi.tuni.prog3.weatherapp.controller;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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

    private DataTransferController() {}

    public static synchronized DataTransferController getInstance() {
        if (instance == null) {
            instance = new DataTransferController();
        }
        return instance;
    }

    public void selectedBtnHome(){
        resetButtonFunction();
        btnHome.setStyle("-fx-background-color: #2b2b2b; -fx-text-fill: white;");
    }

    public void selectedBtnData(){
        resetButtonFunction();
        btnData.setStyle("-fx-background-color: #2b2b2b; -fx-text-fill: white;");
    }

    public void selectedBtnForecast(){
        resetButtonFunction();
        btnForecast.setStyle("-fx-background-color: #2b2b2b; -fx-text-fill: white;");
    }

    public void selectedBtnSetting(){
        resetButtonFunction();
        btnSetting.setStyle("-fx-background-color: #2b2b2b; -fx-text-fill: white;");
    }

    private void resetButtonFunction() {
        if (btnHome != null) btnHome.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
        if (btnData != null) btnData.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
        if (btnForecast != null) btnForecast.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
        if (btnSetting != null) btnSetting.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
    }
}
