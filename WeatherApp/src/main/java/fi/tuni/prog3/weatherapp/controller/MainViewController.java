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
import java.util.stream.IntStream;

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
    private ImageView ar_favou1, ar_favou2, ar_favou3, ar_favou4, ar_favou5, ar_favou6, backImg, btn_add_favorite,
            iconForecast1, iconForecast2, iconForecast3, iconForecast4, iconForecast5,
            icon_favou1, icon_favou2, icon_favou3, icon_favou4, icon_favou5, icon_favou6,
            icon_history1, icon_history2, icon_history3, icon_history4, icon_history5, icon_history6, loader, titleBg;

    @FXML
    private Button btn_current, btn_favorite, btn_history;

    @FXML
    private Text city_favou1, city_favou2, city_favou3, city_favou4, city_favou5, city_favou6,
            city_history1, city_history2, city_history3, city_history4, city_history5, city_history6,
            dateForecast1, dateForecast2, dateForecast3, dateForecast4, dateForecast5,
            desc_favou1, desc_favou2, desc_favou3, desc_favou4, desc_favou5, desc_favou6,
            desc_history1, desc_history2, desc_history3, desc_history4, desc_history5, desc_history6,
            temp_favou1, temp_favou2, temp_favou3, temp_favou4, temp_favou5, temp_favou6,
            temp_history1, temp_history2, temp_history3, temp_history4, temp_history5, temp_history6,
            timeForecast1, timeForecast2, timeForecast3, timeForecast4, timeForecast5;


    @FXML
    private Label current_location, current_location1, current_location2, moonP, pressure,
            statForecast1, statForecast2, statForecast3, statForecast4, statForecast5, time;

    @FXML
    private HBox favou_1, favou_2, favou_3, favou_4, favou_5, favou_6,
            history_1, history_2, history_3, history_4, history_5, history_6;

    @FXML
    private AnchorPane favouritePane, historyPane, main, root, title;

    @FXML
    private Label headerStat, headerStatDesc, headerTemp, highLow, highLowForecast1, highLowForecast2, highLowForecast3,
            highLowForecast4, highLowForecast5, humidity, locationErrorMessage, uv, visibility, wind, current_id,
            current_history_id1, current_history_id2, current_history_id3, current_history_id4, current_history_id5, current_history_id6,
            current_favorite_id1, current_favorite_id2, current_favorite_id3, current_favorite_id4, current_favorite_id5, current_favorite_id6;

    @FXML
    private TextField inpLocation;

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
        renderFavorite();
    }

    @FXML
    void showHistory(ActionEvent event) {
        title.setVisible(false);
        historyPane.setVisible(true);
        favouritePane.setVisible(false);
        renderHistory();
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
            title.setVisible(true);
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
        var id = Long.parseLong(current_favorite_id1.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
    }

    @FXML
    void get_favou2(MouseEvent event) {
        var id = Long.parseLong(current_favorite_id2.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
    }

    @FXML
    void get_favou3(MouseEvent event) {
        var id = Long.parseLong(current_favorite_id3.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
    }

    @FXML
    void get_favou4(MouseEvent event) {
        var id = Long.parseLong(current_favorite_id4.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
    }

    @FXML
    void get_favou5(MouseEvent event) {
        var id = Long.parseLong(current_favorite_id5.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
    }

    @FXML
    void get_favou6(MouseEvent event) {
        var id = Long.parseLong(current_favorite_id6.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
    }

    @FXML
    void get_his1(MouseEvent event) {
        var id = Long.parseLong(current_history_id1.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
    }

    @FXML
    void get_his2(MouseEvent event) {
        var id = Long.parseLong(current_history_id2.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
    }

    @FXML
    void get_his3(MouseEvent event) {
        var id = Long.parseLong(current_history_id3.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
    }

    @FXML
    void get_his4(MouseEvent event) {
        var id = Long.parseLong(current_history_id4.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
    }

    @FXML
    void get_his5(MouseEvent event) {
        var id = Long.parseLong(current_history_id5.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
    }

    @FXML
    void get_his6(MouseEvent event) {
        var id = Long.parseLong(current_history_id6.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
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


    private void renderHistory() {
        var weatherInfoDtoList = iAPI.getListHistory();
        Text[] weatherHistoryCities = {city_history1, city_history2, city_history3, city_history4, city_history5, city_history6};
        ImageView[] iconHistoryCities = {icon_history1, icon_history2, icon_history3, icon_history4, icon_history5, icon_history6};
        Text[] tempHistoryCities = {temp_history1, temp_history2, temp_history3, temp_history4, temp_history5, temp_history6};
        Text[] descHistoryCities = {desc_history1, desc_history2, desc_history3, desc_history4, desc_history5, desc_history6};
        Label[] currentIds = {current_history_id1, current_history_id2, current_history_id3, current_history_id4, current_history_id5, current_history_id6};


        IntStream.range(0, Math.min(weatherInfoDtoList.size(), weatherHistoryCities.length))
                .forEach(i -> renderCity(weatherInfoDtoList.get(i), weatherHistoryCities[i], iconHistoryCities[i], tempHistoryCities[i], descHistoryCities[i], currentIds[i]));
    }

    private void renderFavorite() {
        var weatherInfoDtoList = iAPI.getListFavorite();
        Text[] weatherFavoriteCities = {city_favou1, city_favou2, city_favou3, city_favou4, city_favou5, city_favou6};
        ImageView[] iconFavoriteCities = {icon_favou1, icon_favou2, icon_favou3, icon_favou4, icon_favou5, icon_favou6};
        Text[] tempFavoriteCities = {temp_favou1, temp_favou2, temp_favou3, temp_favou4, temp_favou5, temp_favou6};
        Text[] descFavoriteCities = {desc_favou1, desc_favou2, desc_favou3, desc_favou4, desc_favou5, desc_favou6};
        Label[] currentIds = {current_favorite_id1, current_favorite_id2, current_favorite_id3, current_favorite_id4, current_favorite_id5, current_favorite_id6};

        IntStream.range(0, Math.min(weatherInfoDtoList.size(), weatherFavoriteCities.length))
                .forEach(i -> renderCity(weatherInfoDtoList.get(i), weatherFavoriteCities[i], iconFavoriteCities[i], tempFavoriteCities[i], descFavoriteCities[i], currentIds[i]));
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

    private void renderDataFromForeCastApi(ForeCastInfoDto foreCastInfoDtos) {
        for (int i = 0; i < 5; i++) {
            renderDataItem(foreCastInfoDtos.getList().get(7 + i * 8), i + 1);
        }
    }

    private void renderCity(WeatherInfoDto weatherInfoDto, Text cityText, ImageView iconImage, Text tempText, Text descText, Label currentId) {
        if (weatherInfoDto != null) {
            cityText.setText(weatherInfoDto.getName());
            iconImage.setImage(new Image(getIconUrl(weatherInfoDto.getWeather().get(0).getIcon())));
            tempText.setText(Math.round(weatherInfoDto.getMain().getTemp()) + "°C");
            descText.setText(weatherInfoDto.getWeather().get(0).getDescription());
            currentId.setText(String.valueOf(weatherInfoDto.getCurrentId()));
        } else {
            cityText.setText("No data available");
        }
    }

    private String getIconUrl(String iconCode) {
        return OPEN_WEATHER_URL_IMG + iconCode + "@2x.png";
    }

}
