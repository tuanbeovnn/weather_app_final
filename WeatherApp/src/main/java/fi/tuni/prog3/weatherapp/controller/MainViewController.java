package fi.tuni.prog3.weatherapp.controller;


import fi.tuni.prog3.weatherapp.dto.ForeCastDto;
import fi.tuni.prog3.weatherapp.dto.ForeCastInfoDto;
import fi.tuni.prog3.weatherapp.dto.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.service.iAPI;
import fi.tuni.prog3.weatherapp.util.DateTimeUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import net.rgielen.fxweaver.core.FxmlView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static fi.tuni.prog3.weatherapp.util.DateTimeUtil.formatLocalDateTime;

@Component
@FxmlView("/mainView.fxml")
public class MainViewController implements Initializable {
    private static final Logger logger = LoggerFactory.getLogger(MainViewController.class);
    static final String IMAGE_URL_ADDED_FAVOURITE = "/icon-weather-detail/added-to-favorites.png";
    static final String IMAGE_URL_ADD_TO_FAVOURITE = "/icon-weather-detail/add-to-favorites.png";
    public static final String OPEN_WEATHER_URL_IMG = "https://openweathermap.org/img/wn/";
    private final iAPI iAPI;

    public MainViewController(iAPI iAPI) {
        this.iAPI = iAPI;
    }

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
    @FXML
    private Label current_id;
    @FXML
    private Text timeForecast1;
    @FXML
    private Text timeForecast2;
    @FXML
    private Text timeForecast3;
    @FXML
    private Text timeForecast4;
    @FXML
    private Text timeForecast5;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setVisible(true);
        btn_add_favorite.setVisible(false);
        var weatherInfoDto = iAPI.getCurrentWeather("");
        var foreCastInfoDto = iAPI.getForecast("");
        renderDataFromWeatherApi(weatherInfoDto);
        renderDataFromForeCastApi(foreCastInfoDto);
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
        var id = Long.parseLong(current_id.getText());
        var location = inpLocation.getText();
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        if (weatherInfoDto.getFavorite()) {
            iAPI.updateFavoriteStatus(id, false);
            setFavoriteImage(false);
        } else {
            iAPI.updateFavoriteStatus(id, true);
            setFavoriteImage(true);
        }
    }

    private void setFavoriteImage(boolean isFavorite) {
        String imageUrl = isFavorite ? IMAGE_URL_ADDED_FAVOURITE : IMAGE_URL_ADD_TO_FAVOURITE;
        Image newImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imageUrl)));
        btn_add_favorite.setImage(newImage);
    }

    @FXML
    void loadNewLocationData(ActionEvent event) {
        var location = inpLocation.getText();
        var weatherInfoDto = iAPI.lookUpLocation(location);
        ForeCastInfoDto foreCastInfoDto = iAPI.getForecast(location);
        if (weatherInfoDto != null && foreCastInfoDto != null) {
            logger.info("Location was found: {}", location);
            renderDataFromWeatherApi(weatherInfoDto);
            renderDataFromForeCastApi(foreCastInfoDto);
            locationErrorMessage.setText("");
            btn_add_favorite.setVisible(true);
        } else {
            locationErrorMessage.setText("Invalid location. Please try again.");
            locationErrorMessage.setTextFill(Color.RED);
        }
    }

    @FXML
    public void showCurrent(ActionEvent actionEvent) {
        title.setVisible(true);
        historyPane.setVisible(false);
        favouritePane.setVisible(false);
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

    private void renderDataFromWeatherApi(WeatherInfoDto weatherInfoDto) {
        current_location.setText(weatherInfoDto.getName());
        current_id.setText(weatherInfoDto.getCurrentId() == null ? "" : weatherInfoDto.getCurrentId().toString());
        time.setText(DateTimeUtil.convertToTimeString(weatherInfoDto.getDt()));
        headerTemp.setText(Math.round(weatherInfoDto.getMain().getTemp()) + "°C");
        headerStat.setText(weatherInfoDto.getWeather().get(0).getMain());
        headerStatDesc.setText(weatherInfoDto.getWeather().get(0).getDescription());

        var temperatureRange = String.format("%d°C/%d°C",
                Math.round(weatherInfoDto.getMain().getTemp_max()),
                Math.round(weatherInfoDto.getMain().getTemp_min()));
        highLow.setText(temperatureRange);
        wind.setText(weatherInfoDto.getWind().getSpeed() + " m/s");
        humidity.setText(weatherInfoDto.getMain().getHumidity() + "%");

        pressure.setText(weatherInfoDto.getMain().getPressure() + " mb");
        uv.setText(DateTimeUtil.convertToTimeString(weatherInfoDto.getSys().getSunrise()));
        visibility.setText(weatherInfoDto.getVisibility() / 1000f + " km");
        moonP.setText(DateTimeUtil.convertToTimeString(weatherInfoDto.getSys().getSunset()));
    }

    private void renderDataFromForeCastApi(ForeCastInfoDto foreCastInfoDtos) {
        for (int i = 0; i < 5; i++) {
            renderDataItem(foreCastInfoDtos.getList().get(7 + i * 8), i + 1);
        }
    }

    private void renderDataItem(ForeCastDto foreCastDto, int index) {
        Text[] dateForecasts = {dateForecast1, dateForecast2, dateForecast3, dateForecast4, dateForecast5};
        Text[] timeForecasts = {timeForecast1, timeForecast2, timeForecast3, timeForecast4, timeForecast5};
        Label[] statForecasts = {statForecast1, statForecast2, statForecast3, statForecast4, statForecast5};
        Label[] highLowForecasts = {highLowForecast1, highLowForecast2, highLowForecast3, highLowForecast4, highLowForecast5};
        ImageView[] iconForecasts = {iconForecast1, iconForecast2, iconForecast3, iconForecast4, iconForecast5};

        if (index >= 1 && index <= 5) {
            dateForecasts[index - 1].setText(formatLocalDateTime(foreCastDto.getDt_txt()));
            timeForecasts[index - 1].setText(DateTimeUtil.formatDateTime(foreCastDto.getDt_txt()));
            statForecasts[index - 1].setText(foreCastDto.getWeather().get(0).getMain());

            var temperatureRange = String.format("%d°C/%d°C",
                    Math.round(foreCastDto.getMain().getTemp_max()),
                    Math.round(foreCastDto.getMain().getTemp_min()));
            highLowForecasts[index - 1].setText(temperatureRange);

            iconForecasts[index - 1].setImage(new Image(OPEN_WEATHER_URL_IMG + foreCastDto.getWeather().get(0).getIcon() + "@2x.png"));
        }
    }

}
