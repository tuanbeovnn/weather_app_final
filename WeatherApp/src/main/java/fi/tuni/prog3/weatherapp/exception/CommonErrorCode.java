package fi.tuni.prog3.weatherapp.exception;

import org.springframework.http.HttpStatus;

public interface CommonErrorCode {
    String code();

    HttpStatus status();

    String message();
}