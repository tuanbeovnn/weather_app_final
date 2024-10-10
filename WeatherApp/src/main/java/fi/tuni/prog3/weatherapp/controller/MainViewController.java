package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.util.Constants;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/MainView.fxml")
@Slf4j
public class MainViewController implements Initializable {
    @Getter
    private static MainViewController instance;

    @FXML
    @Getter
    private AnchorPane contentId;

    @FXML
    @Getter
    private Button btnForecast, btnData, btnHome, btnSetting;

    @FXML
    private VBox menuLayout;

    @FXML
    private GridPane menuGrid;

    private boolean isMenuVisible = true;

    private boolean isHomeLayoutLoaded = false;

    public MainViewController() {
        instance = this;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(this::initMainView);
        resetButtonStyles();
    }

    private void initMainView() {
        if (!isHomeLayoutLoaded) {
            loadLayout(Constants.HOME_LAYOUT, btnHome);
            isHomeLayoutLoaded = true;
        }
    }

    @FXML
    private void toggleMenu() {
        Timeline timeline = new Timeline();
        if (isMenuVisible) {
            KeyValue kv1 = new KeyValue(menuLayout.prefWidthProperty(), 40);
            KeyValue kv2 = new KeyValue(menuGrid.opacityProperty(), 0);
            KeyFrame kf = new KeyFrame(Duration.millis(300), kv1, kv2);
            timeline.getKeyFrames().add(kf);
            timeline.setOnFinished(e -> {
                menuGrid.setVisible(false);
                btnHome.setText("🏠fsd");
                btnData.setText("📊");
                btnForecast.setText("🌤");
                btnSetting.setText("⚙");
                menuGrid.setOpacity(1);
            });
        } else {
            menuGrid.setVisible(true);
            btnHome.setText("🏠 Home");
            btnData.setText("📊 Data");
            btnForecast.setText("🌤 Forecast");
            btnSetting.setText("⚙ Setting");
            KeyValue kv1 = new KeyValue(menuLayout.prefWidthProperty(), 200);
            KeyValue kv2 = new KeyValue(menuGrid.opacityProperty(), 1);
            KeyFrame kf = new KeyFrame(Duration.millis(300), kv1, kv2);
            timeline.getKeyFrames().add(kf);
        }
        timeline.play();
        isMenuVisible = !isMenuVisible;
    }


    @FXML
    void loadHomeLayout(ActionEvent event) {
        loadLayout(Constants.HOME_LAYOUT, btnHome);
    }

    @FXML
    void loadDataLayout(ActionEvent event) {
        loadLayout(Constants.DATA_LAYOUT, btnData);
    }

    @FXML
    void loadForecastLayout(ActionEvent event) {
        loadLayout(Constants.FORECAST_LAYOUT, btnForecast);
    }

    @FXML
    void loadSettingLayout(ActionEvent event) {
        loadLayout(Constants.SETTING_LAYOUT, btnSetting);
    }

    private void loadLayout(String viewPath, Button selectedButton) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewPath));
            Parent view = loader.load();
            contentId.getChildren().clear();
            contentId.getChildren().setAll(view);
        } catch (IOException e) {
            log.error("Failed to load view: {}", viewPath);
        }
        this.selectButton(selectedButton);
    }

    public void selectButton(Button selectedButton) {
        resetButtonStyles();
        selectedButton.setStyle("-fx-background-color: #2b2b2b; -fx-text-fill: white;");

//         Box Shadow
//        DropShadow dropShadow = new DropShadow();
//        dropShadow.setOffsetX(-4); // Bóng đổ sang trái
//        dropShadow.setOffsetY(4);   // Bóng đổ xuống dưới
//        dropShadow.setColor(javafx.scene.paint.Color.GRAY);
//        selectedButton.setEffect(dropShadow);
    }

    public void resetButtonStyles() {
//        Set default color
        btnHome.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
        btnData.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
        btnForecast.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
        btnSetting.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");

//        Remove shadow effect
//        btnHome.setEffect(null);
//        btnData.setEffect(null);
//        btnForecast.setEffect(null);
//        btnSetting.setEffect(null);
    }

}
