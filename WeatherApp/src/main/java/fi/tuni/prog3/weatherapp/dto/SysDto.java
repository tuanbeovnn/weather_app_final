package fi.tuni.prog3.weatherapp.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysDto {
    private int type;
    private Long id;
    private String country;
    private Long sunrise;
    private Long sunset;

}
