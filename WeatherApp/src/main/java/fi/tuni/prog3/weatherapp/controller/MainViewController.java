package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.common.Constants;
import fi.tuni.prog3.weatherapp.model.MainUIModel;
import fi.tuni.prog3.weatherapp.model.MenuUIModel;
import fi.tuni.prog3.weatherapp.service.HomeService;
import fi.tuni.prog3.weatherapp.service.LayoutService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
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
    private Button btnForecast, btnData, btnHome, btnSetting;

    @FXML
    private Label inputSearch;

    @Autowired
    private LayoutService layoutService;

    @Getter
    private MenuUIModel menuUIModel;

    @Getter
    private MainUIModel mainUIModel;

    private boolean isHomeLayoutLoaded = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(this::initMainView);

        menuUIModel = MenuUIModel.builder()
                .btnData(btnData)
                .btnHome(btnHome)
                .btnSetting(btnSetting)
                .btnForecast(btnForecast)
                .build();
        mainUIModel = MainUIModel.builder()
                .content(contentId)
                .build();

        layoutService.resetButtonStyles(menuUIModel);
    }

    private void initMainView() {
        if (!isHomeLayoutLoaded) {
            layoutService.loadLayout(contentId, Constants.HOME_LAYOUT, btnHome, menuUIModel);
            isHomeLayoutLoaded = true;
        }
    }

    @FXML
    void loadHomeLayout(ActionEvent event) {
        layoutService.loadLayout(contentId, Constants.HOME_LAYOUT, btnHome,menuUIModel);
    }

    @FXML
    void loadDataLayout(ActionEvent event) {
        layoutService.loadLayout(contentId, Constants.DATA_LAYOUT, btnData, menuUIModel);
    }

    @FXML
    void loadForecastLayout(ActionEvent event) {
        layoutService.loadLayout(contentId, Constants.FORECAST_LAYOUT, btnForecast, menuUIModel);
    }

    @FXML
    void loadSettingLayout(ActionEvent event) throws IOException {
        layoutService.loadLayout(contentId, Constants.SETTING_LAYOUT, btnSetting, menuUIModel);

    }
}
