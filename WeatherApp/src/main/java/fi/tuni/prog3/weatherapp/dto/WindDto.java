package fi.tuni.prog3.weatherapp.dto;

/**
 * A Data Transfer Object (DTO) representing wind information.
 */
public class WindDto {

    /**
     * The speed of the wind in meters per second.
     */
    private double speed;

    /**
     * The direction of the wind in degrees.
     */
    private double deg;

    /**
     * The gust speed of the wind in meters per second.
     */
    private double gust;

    /**
     * Gets the speed of the wind.
     *
     * @return The speed of the wind in meters per second.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the wind.
     *
     * @param speed The speed of the wind to set in meters per second.
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Gets the direction of the wind.
     *
     * @return The direction of the wind in degrees.
     */
    public double getDeg() {
        return deg;
    }

    /**
     * Sets the direction of the wind.
     *
     * @param deg The direction of the wind to set in degrees.
     */
    public void setDeg(double deg) {
        this.deg = deg;
    }

    /**
     * Gets the gust speed of the wind.
     *
     * @return The gust speed of the wind in meters per second.
     */
    public double getGust() {
        return gust;
    }

    /**
     * Sets the gust speed of the wind.
     *
     * @param gust The gust speed of the wind to set in meters per second.
     */
    public void setGust(double gust) {
        this.gust = gust;
    }
}
