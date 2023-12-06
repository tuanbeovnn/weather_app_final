package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.dto.WeatherInfoDto;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Component responsible for rendering weather information in the application.
 */
@Component
public class WeatherRenderer {

    /**
     * The base URL for OpenWeatherMap icons.
     */
    public static final String OPEN_WEATHER_URL_IMG = "https://openweathermap.org/img/wn/";

    /**
     * Renders historical weather information.
     *
     * @param weatherInfoDtoList The list of WeatherInfoDto objects containing historical weather data.
     * @param city_history       An array of Text elements for displaying city names.
     * @param icon_history       An array of ImageView elements for displaying weather icons.
     * @param temp_history       An array of Text elements for displaying temperatures.
     * @param desc_history       An array of Text elements for displaying weather descriptions.
     * @param currentIds         An array of Label elements for storing current IDs associated with each weather item.
     */
    public void renderHistory(List<WeatherInfoDto> weatherInfoDtoList, Text[] city_history, ImageView[] icon_history,
                              Text[] temp_history, Text[] desc_history, Label[] currentIds) {
        IntStream.range(0, Math.min(weatherInfoDtoList.size(), city_history.length))
                .forEach(i -> renderCity(weatherInfoDtoList.get(i), city_history[i], icon_history[i], temp_history[i], desc_history[i], currentIds[i]));
    }

    /**
     * Renders favorite weather information.
     *
     * @param weatherInfoDtoList The list of WeatherInfoDto objects containing favorite weather data.
     * @param city_favou          An array of Text elements for displaying city names.
     * @param icon_favou          An array of ImageView elements for displaying weather icons.
     * @param temp_favou          An array of Text elements for displaying temperatures.
     * @param desc_favou          An array of Text elements for displaying weather descriptions.
     * @param currentIds          An array of Label elements for storing current IDs associated with each weather item.
     */
    public void renderFavorite(List<WeatherInfoDto> weatherInfoDtoList, Text[] city_favou, ImageView[] icon_favou,
                               Text[] temp_favou, Text[] desc_favou, Label[] currentIds) {
        IntStream.range(0, Math.min(weatherInfoDtoList.size(), city_favou.length))
                .forEach(i -> renderCity(weatherInfoDtoList.get(i), city_favou[i], icon_favou[i], temp_favou[i], desc_favou[i], currentIds[i]));
    }

    /**
     * Renders weather information for a specific city.
     *
     * @param weatherInfoDto The WeatherInfoDto containing weather data for a specific city.
     * @param cityText       The Text element for displaying the city name.
     * @param iconImage      The ImageView element for displaying the weather icon.
     * @param tempText       The Text element for displaying the temperature.
     * @param descText       The Text element for displaying the weather description.
     * @param currentId      The Label element for storing the current ID associated with the weather item.
     */
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

    /**
     * Gets the URL for the weather icon based on the icon code.
     *
     * @param iconCode The code representing the weather icon.
     * @return The URL for the weather icon.
     */
    private String getIconUrl(String iconCode) {
        return OPEN_WEATHER_URL_IMG + iconCode + "@2x.png";
    }
}
