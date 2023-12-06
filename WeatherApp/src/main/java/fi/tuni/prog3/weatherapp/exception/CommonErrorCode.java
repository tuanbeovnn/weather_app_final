package fi.tuni.prog3.weatherapp.exception;

import org.springframework.http.HttpStatus;

public interface CommonErrorCode {

    // Method to get the error code
    String code();

    // Method to get the HTTP status associated with the error
    HttpStatus status();

    // Method to get the error message
    String message();
}