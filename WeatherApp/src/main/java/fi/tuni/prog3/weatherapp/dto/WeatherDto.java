package fi.tuni.prog3.weatherapp.dto;

/**
 * Represents weather information received from the OpenWeatherMap API.
 */
public class WeatherDto {

    private Long id; // Weather condition ID

    private String main; // Main weather condition (e.g., Clear, Clouds, Rain)

    private String description; // Weather condition description

    private String icon; // Weather icon identifier

    /**
     * Gets the weather condition ID.
     *
     * @return The weather condition ID as a Long.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the weather condition ID.
     *
     * @param id The weather condition ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the main weather condition.
     *
     * @return The main weather condition as a String.
     */
    public String getMain() {
        return main;
    }

    /**
     * Sets the main weather condition.
     *
     * @param main The main weather condition to set.
     */
    public void setMain(String main) {
        this.main = main;
    }

    /**
     * Gets the weather condition description.
     *
     * @return The weather condition description as a String.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the weather condition description.
     *
     * @param description The weather condition description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the weather icon identifier.
     *
     * @return The weather icon identifier as a String.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the weather icon identifier.
     *
     * @param icon The weather icon identifier to set.
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
