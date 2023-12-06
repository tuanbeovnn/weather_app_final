package fi.tuni.prog3.weatherapp.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode implements CommonErrorCode {

    // Enum constants
    ID_NOT_FOUND(HttpStatus.NOT_FOUND, "404", "Id could not be found"),
    LOCATION_NOT_FOUND(HttpStatus.NOT_FOUND, "404", "Location could not be found");

    // Fields
    private final HttpStatus status;
    private final String code;
    private final String message;

    // Constructor
    ErrorCode(final HttpStatus status, final String code, final String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    // Implemented methods from CommonErrorCode interface

    public String code() {
        return this.code;
    }

    public HttpStatus status() {
        return this.status;
    }

    public String message() {
        return this.message;
    }
}
