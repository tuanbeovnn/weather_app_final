package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.dto.WeatherInfoDto;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class WeatherRenderer {
    public static final String OPEN_WEATHER_URL_IMG = "https://openweathermap.org/img/wn/";

    public void renderHistory(List<WeatherInfoDto> weatherInfoDtoList, Text[] city_history, ImageView[] icon_history,
                              Text[] temp_history, Text[] desc_history, Label[] currentIds) {
        IntStream.range(0, Math.min(weatherInfoDtoList.size(), city_history.length))
                .forEach(i -> renderCity(weatherInfoDtoList.get(i), city_history[i], icon_history[i], temp_history[i], desc_history[i], currentIds[i]));
    }

    public void renderFavorite(List<WeatherInfoDto> weatherInfoDtoList, Text[] city_favou, ImageView[] icon_favou,
                               Text[] temp_favou, Text[] desc_favou, Label[] currentIds) {
        IntStream.range(0, Math.min(weatherInfoDtoList.size(), city_favou.length))
                .forEach(i -> renderCity(weatherInfoDtoList.get(i), city_favou[i], icon_favou[i], temp_favou[i], desc_favou[i], currentIds[i]));
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
