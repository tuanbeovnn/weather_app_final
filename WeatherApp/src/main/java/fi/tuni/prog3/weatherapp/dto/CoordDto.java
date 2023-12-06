package fi.tuni.prog3.weatherapp.dto;

/**
 * Represents geographical coordinates received from the OpenWeatherMap API.
 */
public class CoordDto {

    private float lon; // Longitude

    private float lat; // Latitude

    /**
     * Gets the longitude coordinate.
     *
     * @return The longitude coordinate as a float.
     */
    public float getLon() {
        return lon;
    }

    /**
     * Sets the longitude coordinate.
     *
     * @param lon The longitude coordinate to set.
     */
    public void setLon(float lon) {
        this.lon = lon;
    }

    /**
     * Gets the latitude coordinate.
     *
     * @return The latitude coordinate as a float.
     */
    public float getLat() {
        return lat;
    }

    /**
     * Sets the latitude coordinate.
     *
     * @param lat The latitude coordinate to set.
     */
    public void setLat(float lat) {
        this.lat = lat;
    }
}
