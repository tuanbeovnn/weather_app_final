package fi.tuni.prog3.weatherapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class WeatherException extends RuntimeException {
    private String code;
    private String message;
    private HttpStatus status;

    public WeatherException() {
    }

    public WeatherException(final CommonErrorCode code) {
        this.code = code.code();
        this.message = code.message();
        this.status = code.status();
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setStatus(final HttpStatus status) {
        this.status = status;
    }
}