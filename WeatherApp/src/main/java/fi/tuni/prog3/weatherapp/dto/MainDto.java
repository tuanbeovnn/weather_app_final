package fi.tuni.prog3.weatherapp.dto;

/**
 * Represents main weather information received from the OpenWeatherMap API.
 */
public class MainDto {

    private double temp; // Temperature

    private double feels_like; // Human perception of weather

    private double temp_min; // Minimum temperature

    private double temp_max; // Maximum temperature

    private double pressure; // Atmospheric pressure

    private double humidity; // Humidity percentage

    private double sea_level; // Atmospheric pressure at sea level

    private double grnd_level; // Atmospheric pressure at ground level

    /**
     * Gets the temperature.
     *
     * @return The temperature as a double.
     */
    public double getTemp() {
        return temp;
    }

    /**
     * Sets the temperature.
     *
     * @param temp The temperature to set.
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * Gets the human perception of weather.
     *
     * @return The feels-like temperature as a double.
     */
    public double getFeels_like() {
        return feels_like;
    }

    /**
     * Sets the human perception of weather.
     *
     * @param feels_like The feels-like temperature to set.
     */
    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    /**
     * Gets the minimum temperature.
     *
     * @return The minimum temperature as a double.
     */
    public double getTemp_min() {
        return temp_min;
    }

    /**
     * Sets the minimum temperature.
     *
     * @param temp_min The minimum temperature to set.
     */
    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    /**
     * Gets the maximum temperature.
     *
     * @return The maximum temperature as a double.
     */
    public double getTemp_max() {
        return temp_max;
    }

    /**
     * Sets the maximum temperature.
     *
     * @param temp_max The maximum temperature to set.
     */
    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    /**
     * Gets the atmospheric pressure.
     *
     * @return The atmospheric pressure as a double.
     */
    public double getPressure() {
        return pressure;
    }

    /**
     * Sets the atmospheric pressure.
     *
     * @param pressure The atmospheric pressure to set.
     */
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    /**
     * Gets the humidity percentage.
     *
     * @return The humidity percentage as a double.
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * Sets the humidity percentage.
     *
     * @param humidity The humidity percentage to set.
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * Gets the atmospheric pressure at sea level.
     *
     * @return The atmospheric pressure at sea level as a double.
     */
    public double getSea_level() {
        return sea_level;
    }

    /**
     * Sets the atmospheric pressure at sea level.
     *
     * @param sea_level The atmospheric pressure at sea level to set.
     */
    public void setSea_level(double sea_level) {
        this.sea_level = sea_level;
    }

    /**
     * Gets the atmospheric pressure at ground level.
     *
     * @return The atmospheric pressure at ground level as a double.
     */
    public double getGrnd_level() {
        return grnd_level;
    }

    /**
     * Sets the atmospheric pressure at ground level.
     *
     * @param grnd_level The atmospheric pressure at ground level to set.
     */
    public void setGrnd_level(double grnd_level) {
        this.grnd_level = grnd_level;
    }
}
