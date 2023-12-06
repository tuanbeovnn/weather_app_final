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

/**
 * Controller class for the main view of the WeatherApp.
 * This class implements the Initializable interface.
 */
@Component
@FxmlView("/mainView.fxml")
public class MainViewController implements Initializable {
    private static final Logger logger = LoggerFactory.getLogger(MainViewController.class);
    static final String IMAGE_URL_ADDED_FAVOURITE = "/icon-weather-detail/added-to-favorites.png";
    static final String IMAGE_URL_ADD_TO_FAVOURITE = "/icon-weather-detail/add-to-favorites.png";
    public static final String OPEN_WEATHER_URL_IMG = "https://openweathermap.org/img/wn/";
    private final iAPI iAPI;

    private final WeatherRenderer weatherRenderer;

    /**
     * Constructor for MainViewController.
     *
     * @param iAPI            The service for accessing weather information APIs.
     * @param weatherRenderer The renderer for weather information.
     */
    public MainViewController(iAPI iAPI, WeatherRenderer weatherRenderer) {
        this.iAPI = iAPI;
        this.weatherRenderer = weatherRenderer;
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

    /**
     * Initializes the main view when it is loaded.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setVisible(true);
        btn_add_favorite.setVisible(false);
        var weatherInfoDto = iAPI.getCurrentWeather("");
        var foreCastInfoDto = iAPI.getForecast("");
        renderDataFromWeatherApi(weatherInfoDto);
        renderDataFromForeCastApi(foreCastInfoDto);
    }

    /**
     * Handles the "Show Favorite" button click event.
     *
     * @param event The action event triggered by the button click.
     */
    @FXML
    void showFavorite(ActionEvent event) {
        title.setVisible(false);
        historyPane.setVisible(false);
        favouritePane.setVisible(true);
        renderFavorite();
    }

    /**
     * Handles the "Show History" button click event.
     *
     * @param event The action event triggered by the button click.
     */
    @FXML
    void showHistory(ActionEvent event) {
        title.setVisible(false);
        historyPane.setVisible(true);
        favouritePane.setVisible(false);
        renderHistory();
    }

    /**
     * Handles the "Add Favorite" button click event.
     *
     * @param mouseEvent The mouse event triggered by the button click.
     */
    @FXML
    public void addFavorite(MouseEvent mouseEvent) {
        var id = Long.parseLong(current_id.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        if (weatherInfoDto.getFavorite()) {
            iAPI.updateFavoriteStatus(id, false);
            setFavoriteImage(false);
        } else {
            iAPI.updateFavoriteStatus(id, true);
            setFavoriteImage(true);
        }
    }

    /**
     * Sets the image for the "Add to Favorite" button based on the favorite status.
     *
     * @param isFavorite True if the location is a favorite, false otherwise.
     */
    private void setFavoriteImage(boolean isFavorite) {
        String imageUrl = isFavorite ? IMAGE_URL_ADDED_FAVOURITE : IMAGE_URL_ADD_TO_FAVOURITE;
        Image newImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imageUrl)));
        btn_add_favorite.setImage(newImage);
    }

    /**
     * Handles the "Load New Location Data" button click event.
     *
     * @param event The action event triggered by the button click.
     */
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
            Image newImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(IMAGE_URL_ADD_TO_FAVOURITE)));
            btn_add_favorite.setImage(newImage);
            title.setVisible(true);
        } else {
            locationErrorMessage.setText("Invalid location. Please try again.");
            locationErrorMessage.setTextFill(Color.RED);
        }
    }

    /**
     * Handles the "Show Current" button click event.
     *
     * @param actionEvent The action event triggered by the button click.
     */
    @FXML
    public void showCurrent(ActionEvent actionEvent) {
        title.setVisible(true);
        historyPane.setVisible(false);
        favouritePane.setVisible(false);
        btn_add_favorite.setVisible(false);
        var weatherInfoDto = iAPI.getCurrentWeather("");
        renderDataFromWeatherApi(weatherInfoDto);
    }

    /**
     * Handles the mouse click event on the favorite item at position 1.
     *
     * @param event The mouse event triggered by the click.
     */
    @FXML
    void get_favou1(MouseEvent event) {
        handleFavoriteClick(current_favorite_id1);
    }

    /**
     * Handles the mouse click event on the favorite item at position 2.
     *
     * @param event The mouse event triggered by the click.
     */
    @FXML
    void get_favou2(MouseEvent event) {
        handleFavoriteClick(current_favorite_id2);
    }

    /**
     * Handles the mouse click event on the favorite item at position 3.
     *
     * @param event The mouse event triggered by the click.
     */
    @FXML
    void get_favou3(MouseEvent event) {
        handleFavoriteClick(current_favorite_id3);
    }

    /**
     * Handles the mouse click event on the favorite item at position 4.
     *
     * @param event The mouse event triggered by the click.
     */
    @FXML
    void get_favou4(MouseEvent event) {
        handleFavoriteClick(current_favorite_id4);
    }

    /**
     * Handles the mouse click event on the favorite item at position 5.
     *
     * @param event The mouse event triggered by the click.
     */
    @FXML
    void get_favou5(MouseEvent event) {
        handleFavoriteClick(current_favorite_id5);
    }

    /**
     * Handles the mouse click event on the favorite item at position 6.
     *
     * @param event The mouse event triggered by the click.
     */
    @FXML
    void get_favou6(MouseEvent event) {
        handleFavoriteClick(current_favorite_id6);
    }

    /**
     * Handles the mouse click event on the history item at position 1.
     *
     * @param event The mouse event triggered by the click.
     */
    @FXML
    void get_his1(MouseEvent event) {
        handleHistoryClick(current_history_id1);
    }

    /**
     * Handles the mouse click event on the history item at position 2.
     *
     * @param event The mouse event triggered by the click.
     */
    @FXML
    void get_his2(MouseEvent event) {
        handleHistoryClick(current_history_id2);
    }

    /**
     * Handles the mouse click event on the history item at position 3.
     *
     * @param event The mouse event triggered by the click.
     */
    @FXML
    void get_his3(MouseEvent event) {
        handleHistoryClick(current_history_id3);
    }

    /**
     * Handles the mouse click event on the history item at position 4.
     *
     * @param event The mouse event triggered by the click.
     */
    @FXML
    void get_his4(MouseEvent event) {
        handleHistoryClick(current_history_id4);
    }

    /**
     * Handles the mouse click event on the history item at position 5.
     *
     * @param event The mouse event triggered by the click.
     */
    @FXML
    void get_his5(MouseEvent event) {
        handleHistoryClick(current_history_id5);
    }

    /**
     * Handles the mouse click event on the history item at position 6.
     *
     * @param event The mouse event triggered by the click.
     */
    @FXML
    void get_his6(MouseEvent event) {
        handleHistoryClick(current_history_id6);
    }


    /**
     * Renders weather information from the open API for the current weather data.
     *
     * @param weatherInfoDto The WeatherInfoDto containing the current weather data.
     */
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

    /**
     * Renders historical weather information.
     */
    private void renderHistory() {
        var weatherInfoDtoList = iAPI.getListHistory();
        Text[] weatherHistoryCities = {city_history1, city_history2, city_history3, city_history4, city_history5, city_history6};
        ImageView[] iconHistoryCities = {icon_history1, icon_history2, icon_history3, icon_history4, icon_history5, icon_history6};
        Text[] tempHistoryCities = {temp_history1, temp_history2, temp_history3, temp_history4, temp_history5, temp_history6};
        Text[] descHistoryCities = {desc_history1, desc_history2, desc_history3, desc_history4, desc_history5, desc_history6};
        Label[] currentIds = {current_history_id1, current_history_id2, current_history_id3, current_history_id4, current_history_id5, current_history_id6};

        weatherRenderer.renderHistory(weatherInfoDtoList, weatherHistoryCities, iconHistoryCities, tempHistoryCities, descHistoryCities, currentIds);
    }

    /**
     * This method is helping for render list favorite
     */
    private void renderFavorite() {
        var weatherInfoDtoList = iAPI.getListFavorite();
        Text[] weatherFavoriteCities = {city_favou1, city_favou2, city_favou3, city_favou4, city_favou5, city_favou6};
        ImageView[] iconFavoriteCities = {icon_favou1, icon_favou2, icon_favou3, icon_favou4, icon_favou5, icon_favou6};
        Text[] tempFavoriteCities = {temp_favou1, temp_favou2, temp_favou3, temp_favou4, temp_favou5, temp_favou6};
        Text[] descFavoriteCities = {desc_favou1, desc_favou2, desc_favou3, desc_favou4, desc_favou5, desc_favou6};
        Label[] currentIds = {current_favorite_id1, current_favorite_id2, current_favorite_id3, current_favorite_id4, current_favorite_id5, current_favorite_id6};

        weatherRenderer.renderFavorite(weatherInfoDtoList, weatherFavoriteCities, iconFavoriteCities, tempFavoriteCities, descFavoriteCities, currentIds);
    }

    /**
     * Renders weather information for a specific forecast item.
     *
     * @param foreCastDto The ForeCastDto containing forecast data for a specific time.
     * @param index       The index indicating the position of the forecast item.
     */
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

    /**
     * Renders weather information from the open API for the forecast data.
     *
     * @param foreCastInfoDtos The ForeCastInfoDto containing forecast data.
     */
    private void renderDataFromForeCastApi(ForeCastInfoDto foreCastInfoDtos) {
        for (int i = 0; i < 5; i++) {
            renderDataItem(foreCastInfoDtos.getList().get(7 + i * 8), i + 1);
        }
    }

    /**
     * Handles a click on a favorite item by updating the displayed weather information.
     *
     * @param currentFavoriteId The label containing the ID of the clicked favorite item.
     */
    private void handleFavoriteClick(Label currentFavoriteId) {
        var id = Long.parseLong(currentFavoriteId.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
        btn_add_favorite.setVisible(true);
        Image newImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(IMAGE_URL_ADDED_FAVOURITE)));
        btn_add_favorite.setImage(newImage);
    }


    /**
     * Handles a click on a history item by updating the displayed weather information.
     *
     * @param currentHistoryId The label containing the ID of the clicked history item.
     */
    private void handleHistoryClick(Label currentFavoriteId) {
        var id = Long.parseLong(current_history_id1.getText());
        WeatherInfoDto weatherInfoDto = iAPI.findById(id);
        renderDataFromWeatherApi(weatherInfoDto);
        title.setVisible(true);
        btn_add_favorite.setVisible(false);
    }
}
