package fi.tuni.prog3.weatherapp.dto;

import java.util.List;

/**
 * Represents forecast data received from the OpenWeatherMap API.
 */
public class ForeCastDto {

    private Long dt; // Time of data forecasted

    private MainDto main; // Main weather information

    private List<WeatherDto> weather; // Weather condition information

    private CloudsDto clouds; // Cloud information

    private WindDto wind; // Wind information

    private Long visibility; // Visibility in meters

    private double pop; // Probability of precipitation

    private SysDto sys; // Additional system information

    private String dt_txt; // Date and time in text format

    /**
     * Gets the time of the forecasted data.
     *
     * @return The time of the forecasted data as a Long.
     */
    public Long getDt() {
        return dt;
    }

    /**
     * Sets the time of the forecasted data.
     *
     * @param dt The time of the forecasted data to set.
     */
    public void setDt(Long dt) {
        this.dt = dt;
    }

    /**
     * Gets the main weather information.
     *
     * @return The MainDto containing main weather information.
     */
    public MainDto getMain() {
        return main;
    }

    /**
     * Sets the main weather information.
     *
     * @param main The MainDto containing main weather information to set.
     */
    public void setMain(MainDto main) {
        this.main = main;
    }

    /**
     * Gets the weather condition information.
     *
     * @return The list of WeatherDto objects containing weather condition information.
     */
    public List<WeatherDto> getWeather() {
        return weather;
    }

    /**
     * Sets the weather condition information.
     *
     * @param weather The list of WeatherDto objects containing weather condition information to set.
     */
    public void setWeather(List<WeatherDto> weather) {
        this.weather = weather;
    }

    /**
     * Gets the cloud information.
     *
     * @return The CloudsDto containing cloud information.
     */
    public CloudsDto getClouds() {
        return clouds;
    }

    /**
     * Sets the cloud information.
     *
     * @param clouds The CloudsDto containing cloud information to set.
     */
    public void setClouds(CloudsDto clouds) {
        this.clouds = clouds;
    }

    /**
     * Gets the wind information.
     *
     * @return The WindDto containing wind information.
     */
    public WindDto getWind() {
        return wind;
    }

    /**
     * Sets the wind information.
     *
     * @param wind The WindDto containing wind information to set.
     */
    public void setWind(WindDto wind) {
        this.wind = wind;
    }

    /**
     * Gets the visibility in meters.
     *
     * @return The visibility in meters as a Long.
     */
    public Long getVisibility() {
        return visibility;
    }

    /**
     * Sets the visibility in meters.
     *
     * @param visibility The visibility in meters to set.
     */
    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    /**
     * Gets the probability of precipitation.
     *
     * @return The probability of precipitation as a double.
     */
    public double getPop() {
        return pop;
    }

    /**
     * Sets the probability of precipitation.
     *
     * @param pop The probability of precipitation to set.
     */
    public void setPop(double pop) {
        this.pop = pop;
    }

    /**
     * Gets additional system information.
     *
     * @return The SysDto containing additional system information.
     */
    public SysDto getSys() {
        return sys;
    }

    /**
     * Sets additional system information.
     *
     * @param sys The SysDto containing additional system information to set.
     */
    public void setSys(SysDto sys) {
        this.sys = sys;
    }

    /**
     * Gets the date and time in text format.
     *
     * @return The date and time in text format as a String.
     */
    public String getDt_txt() {
        return dt_txt;
    }

    /**
     * Sets the date and time in text format.
     *
     * @param dt_txt The date and time in text format to set.
     */
    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
