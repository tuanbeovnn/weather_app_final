package fi.tuni.prog3.weatherapp.dto;

/**
 * Represents cloud-related data received from the OpenWeatherMap API.
 */
public class CloudsDto {

    private double all;

    /**
     * Gets the cloudiness percentage.
     *
     * @return The cloudiness percentage as a double.
     */
    public double getAll() {
        return all;
    }

    /**
     * Sets the cloudiness percentage.
     *
     * @param all The cloudiness percentage to set.
     */
    public void setAll(double all) {
        this.all = all;
    }
}
