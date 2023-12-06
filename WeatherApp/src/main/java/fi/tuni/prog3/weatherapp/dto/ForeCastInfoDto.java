package fi.tuni.prog3.weatherapp.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents forecast information received from the OpenWeatherMap API.
 */
public class ForeCastInfoDto {

    private List<ForeCastDto> list = new ArrayList<>(); // List of forecast data

    private String cod; // Internal parameter

    private int message; // Internal parameter

    private int cnt; // Number of forecasts returned

    /**
     * Gets the list of forecast data.
     *
     * @return The list of ForeCastDto objects.
     */
    public List<ForeCastDto> getList() {
        return list;
    }

    /**
     * Sets the list of forecast data.
     *
     * @param list The list of ForeCastDto objects to set.
     */
    public void setList(List<ForeCastDto> list) {
        this.list = list;
    }

    /**
     * Gets the internal parameter 'cod'.
     *
     * @return The internal parameter 'cod' as a String.
     */
    public String getCod() {
        return cod;
    }

    /**
     * Sets the internal parameter 'cod'.
     *
     * @param cod The internal parameter 'cod' to set.
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * Gets the internal parameter 'message'.
     *
     * @return The internal parameter 'message' as an int.
     */
    public int getMessage() {
        return message;
    }

    /**
     * Sets the internal parameter 'message'.
     *
     * @param message The internal parameter 'message' to set.
     */
    public void setMessage(int message) {
        this.message = message;
    }

    /**
     * Gets the number of forecasts returned.
     *
     * @return The number of forecasts returned as an int.
     */
    public int getCnt() {
        return cnt;
    }

    /**
     * Sets the number of forecasts returned.
     *
     * @param cnt The number of forecasts returned to set.
     */
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
