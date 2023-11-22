package fi.tuni.prog3.weatherapp;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/mainView.fxml")
public class PrimaryController implements Initializable {
    private static final String DEFAULT_LOCATION = "Vaasa";

    @FXML
    public ImageView btn_add_favorite;
    @FXML
    private ImageView backImg;

    @FXML
    private MenuButton btn_favorite;

    @FXML
    private MenuButton btn_history;

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
    private Label dwp;

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
    private TextField inpLocation;

    @FXML
    private ImageView loader;

    @FXML
    private Label current_location;

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

    @FXML
    void loadNewLocationData(ActionEvent event) {

    }

    @FXML
    void showFavorite(ActionEvent event) {

    }

    @FXML
    void showHistory(ActionEvent event) {

    }

    @FXML
    public void addFavorite(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        loadInitialData();
    }
//
//    private void loadInitialData() {
//        WeatherInfoDto weatherInfoDto = syncWeather("");
//        renderDataFromWeatherApi(weatherInfoDto);
//    }
//
//    public WeatherInfoDto syncWeather(String query) {
//        if (query == null || query.isEmpty()) {
//            return getCurrentWeatherFromAPI(DEFAULT_LOCATION);
//        } else {
//            return getCurrentWeatherFromAPI(query);
//        }
//    }
//
//    private WeatherInfoDto getCurrentWeatherFromAPI(String location) {
//        return weatherApi.weatherInfo(location);
//    }
//
//    private void renderDataFromWeatherApi(WeatherInfoDto weatherInfoDto) {
//        current_location.setText(weatherInfoDto.getName());
//        time.setText(DateTimeUtil.convertToTimeString(weatherInfoDto.getDt()));
//        headerTemp.setText(Math.round(weatherInfoDto.getMain().getTemp()) + "°C");
//        headerStat.setText(weatherInfoDto.getWeather().get(0).getMain());
//        headerStatDesc.setText(weatherInfoDto.getWeather().get(0).getDescription());
//
//        String temperatureRange = String.format("%d°C/%d°C",
//                Math.round(weatherInfoDto.getMain().getTemp_max()), Math.round(weatherInfoDto.getMain().getTemp_min()));
//        highLow.setText(temperatureRange);
//        wind.setText(weatherInfoDto.getWind().getSpeed() + " m/s");
//        humidity.setText(weatherInfoDto.getMain().getHumidity() + "%");
//
//        pressure.setText(weatherInfoDto.getMain().getPressure() + " mb");
//        uv.setText(DateTimeUtil.convertToTimeString(weatherInfoDto.getSys().getSunrise()));
//        visibility.setText(weatherInfoDto.getVisibility() / 1000f + " km");
//        moonP.setText(DateTimeUtil.convertToTimeString(weatherInfoDto.getSys().getSunset()));
//    }

}
