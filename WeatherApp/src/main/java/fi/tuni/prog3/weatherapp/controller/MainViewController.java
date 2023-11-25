package fi.tuni.prog3.weatherapp.controller;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/mainView.fxml")
public class MainViewController implements Initializable {
    private static final String DEFAULT_LOCATION = "Vaasa";
    @FXML
    private ImageView ar_favou1;

    @FXML
    private ImageView ar_favou2;

    @FXML
    private ImageView ar_favou3;

    @FXML
    private ImageView ar_favou4;

    @FXML
    private ImageView ar_favou5;

    @FXML
    private ImageView ar_favou6;

    @FXML
    private ImageView backImg;

    @FXML
    private ImageView btn_add_favorite;

    @FXML
    private Button btn_current;

    @FXML
    private Button btn_favorite;

    @FXML
    private Button btn_history;

    @FXML
    private Text city_favou1;

    @FXML
    private Text city_favou2;

    @FXML
    private Text city_favou3;

    @FXML
    private Text city_favou4;

    @FXML
    private Text city_favou5;

    @FXML
    private Text city_favou6;

    @FXML
    private Text city_history1;

    @FXML
    private Text city_history2;

    @FXML
    private Text city_history3;

    @FXML
    private Text city_history4;

    @FXML
    private Text city_history5;

    @FXML
    private Text city_history6;

    @FXML
    private Label current_location;

    @FXML
    private Label current_location1;

    @FXML
    private Label current_location2;

    @FXML
    private Text dateForecast1;

    @FXML
    private Text dateForecast2;

    @FXML
    private Text dateForecast3;

    @FXML
    private Text dateForecast4;

    @FXML
    private Text dateForecast5;

    @FXML
    private Text desc_favou1;

    @FXML
    private Text desc_favou2;

    @FXML
    private Text desc_favou3;

    @FXML
    private Text desc_favou4;

    @FXML
    private Text desc_favou5;

    @FXML
    private Text desc_favou6;

    @FXML
    private Text desc_history1;

    @FXML
    private Text desc_history2;

    @FXML
    private Text desc_history3;

    @FXML
    private Text desc_history4;

    @FXML
    private Text desc_history5;

    @FXML
    private Text desc_history6;

    @FXML
    private HBox favou_1;

    @FXML
    private HBox favou_2;

    @FXML
    private HBox favou_3;

    @FXML
    private HBox favou_4;

    @FXML
    private HBox favou_5;

    @FXML
    private HBox favou_6;

    @FXML
    private AnchorPane favouritePane;

    @FXML
    private Label headerStat;

    @FXML
    private Label headerStatDesc;

    @FXML
    private Label headerTemp;

    @FXML
    private Label highLow;

    @FXML
    private Label highLowForecast1;

    @FXML
    private Label highLowForecast2;

    @FXML
    private Label highLowForecast3;

    @FXML
    private Label highLowForecast4;

    @FXML
    private Label highLowForecast5;

    @FXML
    private AnchorPane historyPane;

    @FXML
    private HBox history_1;

    @FXML
    private HBox history_2;

    @FXML
    private HBox history_3;

    @FXML
    private HBox history_4;

    @FXML
    private HBox history_5;

    @FXML
    private HBox history_6;

    @FXML
    private Label humidity;

    @FXML
    private ImageView iconForecast1;

    @FXML
    private ImageView iconForecast2;

    @FXML
    private ImageView iconForecast3;

    @FXML
    private ImageView iconForecast4;

    @FXML
    private ImageView iconForecast5;

    @FXML
    private ImageView icon_favou1;

    @FXML
    private ImageView icon_favou2;

    @FXML
    private ImageView icon_favou3;

    @FXML
    private ImageView icon_favou4;

    @FXML
    private ImageView icon_favou5;

    @FXML
    private ImageView icon_favou6;

    @FXML
    private ImageView icon_history1;

    @FXML
    private ImageView icon_history2;

    @FXML
    private ImageView icon_history3;

    @FXML
    private ImageView icon_history4;

    @FXML
    private ImageView icon_history5;

    @FXML
    private ImageView icon_history6;

    @FXML
    private TextField inpLocation;

    @FXML
    private ImageView loader;

    @FXML
    private Label locationErrorMessage;

    @FXML
    private AnchorPane main;

    @FXML
    private Label moonP;

    @FXML
    private Label pressure;

    @FXML
    private AnchorPane root;

    @FXML
    private Label statForecast1;

    @FXML
    private Label statForecast2;

    @FXML
    private Label statForecast3;

    @FXML
    private Label statForecast4;

    @FXML
    private Label statForecast5;

    @FXML
    private Text temp_favou1;

    @FXML
    private Text temp_favou2;

    @FXML
    private Text temp_favou3;

    @FXML
    private Text temp_favou4;

    @FXML
    private Text temp_favou5;

    @FXML
    private Text temp_favou6;

    @FXML
    private Text temp_history1;

    @FXML
    private Text temp_history2;

    @FXML
    private Text temp_history3;

    @FXML
    private Text temp_history4;

    @FXML
    private Text temp_history5;

    @FXML
    private Text temp_history6;

    @FXML
    private Label time;

    @FXML
    private AnchorPane title;

    @FXML
    private ImageView titleBg;

    @FXML
    private Label uv;

    @FXML
    private Label visibility;

    @FXML
    private Label wind;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setVisible(true);
        historyPane.setVisible(false);
        favouritePane.setVisible(false);
        loadInitialData();
    }

    @FXML
    void showFavorite(ActionEvent event) {
        title.setVisible(false);
        historyPane.setVisible(false);
        favouritePane.setVisible(true);
    }

    @FXML
    void showHistory(ActionEvent event) {
        title.setVisible(false);
        historyPane.setVisible(true);
        favouritePane.setVisible(false);
    }

    @FXML
    public void addFavorite(MouseEvent mouseEvent) {

    }

    @FXML
    public void showCurrent(ActionEvent actionEvent) {
        title.setVisible(true);
        historyPane.setVisible(false);
        favouritePane.setVisible(false);
        loadInitialData();
    }

    @FXML
    void loadNewLocationData(ActionEvent event) {


    }

    private void loadInitialData() {

    }


    private void handleInvalidLocation() {
        showError();
    }

    private void showError() {
        Platform.runLater(() -> {
            locationErrorMessage.setText("Invalid location. Please try again.");
            locationErrorMessage.setTextFill(Color.RED);
        });
    }

    private void clearErrorMessage() {
        Platform.runLater(() -> {
            locationErrorMessage.setText("");
        });
    }


    @FXML
    void get_favou1(MouseEvent event) {
        System.out.println("get favourite 1");
    }

    @FXML
    void get_favou2(MouseEvent event) {
        System.out.println("get favourite 2");
    }

    @FXML
    void get_favou3(MouseEvent event) {
        System.out.println("get favourite 3");
    }

    @FXML
    void get_favou4(MouseEvent event) {
        System.out.println("get favourite 4");
    }

    @FXML
    void get_favou5(MouseEvent event) {
        System.out.println("get favourite 5");
    }

    @FXML
    void get_favou6(MouseEvent event) {
        System.out.println("get favourite 6");
    }

    @FXML
    void get_his1(MouseEvent event) {
        System.out.println("get history 1");
    }

    @FXML
    void get_his2(MouseEvent event) {
        System.out.println("get history 2");
    }

    @FXML
    void get_his3(MouseEvent event) {
        System.out.println("get history 3");
    }

    @FXML
    void get_his4(MouseEvent event) {
        System.out.println("get history 4");
    }

    @FXML
    void get_his5(MouseEvent event) {
        System.out.println("get history 5");
    }

    @FXML
    void get_his6(MouseEvent event) {
        System.out.println("get history 6");
    }
}
