package fi.tuni.prog3.weatherapp.util;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static String convertToTimeString(Long epochSeconds) {
        Instant instant = Instant.ofEpochSecond(epochSeconds);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return dateTime.format(formatter);
    }

    public static String formatLocalDateTime(String inputDateString) {
        LocalDateTime dateTime = LocalDateTime.parse(inputDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return dateTime.format(DateTimeFormatter.ofPattern("E, MMM d"));
    }

    public static String formatDateTime(String inputDateString) {
        LocalDateTime dateTime = LocalDateTime.parse(inputDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return dateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }


}
