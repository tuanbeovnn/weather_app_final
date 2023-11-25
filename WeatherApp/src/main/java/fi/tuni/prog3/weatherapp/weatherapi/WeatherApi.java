package fi.tuni.prog3.weatherapp.weatherapi;



import fi.tuni.prog3.weatherapp.dto.ForeCastInfoDto;
import fi.tuni.prog3.weatherapp.dto.WeatherInfoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class WeatherApi {
    private static final String WEATHER_ENDPOINT = "/weather";
    private static final String FORECAST_ENDPOINT = "/forecast";
    private static final String QUERY_PARAM_QUERY = "q";
    private static final String QUERY_PARAM_APP_ID = "appid";
    private static final String UNITS_METRIC = "metric";
    private static final String UNITS = "units";
    private final WebClient webClient;
    private final String weatherProjectUrl;
    private final String accessToken;

    public WeatherApi(final WebClient webClient,
                      @Value("${weather.projectUrl}") String weatherProjectUrl,
                      @Value("${weather.accessToken}") String accessToken) {
        this.webClient = webClient;
        this.weatherProjectUrl = weatherProjectUrl;
        this.accessToken = accessToken;
    }

    public WeatherInfoDto weatherInfo(final String query) {
        var uri = buildWeatherApiUri(query, WEATHER_ENDPOINT);

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(WeatherInfoDto.class)
                .block();
    }

    public ForeCastInfoDto foreCastInfo(final String query) {
        var uri = buildWeatherApiUri(query, FORECAST_ENDPOINT);

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(ForeCastInfoDto.class)
                .block();
    }

    private String buildWeatherApiUri(String query, String endpoint) {
        return UriComponentsBuilder.fromUriString(weatherProjectUrl)
                .path(endpoint)
                .queryParam(QUERY_PARAM_QUERY, query)
                .queryParam(QUERY_PARAM_APP_ID, accessToken)
                .queryParam(UNITS, UNITS_METRIC)
                .build()
                .toUriString();
    }
}
