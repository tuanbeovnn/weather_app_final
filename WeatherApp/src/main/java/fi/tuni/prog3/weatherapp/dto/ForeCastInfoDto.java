package fi.tuni.prog3.weatherapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ForeCastInfoDto {
    private List<ForeCastDto> list = new ArrayList<>();
    private String cod;
    private int message;
    private int cnt;

}
