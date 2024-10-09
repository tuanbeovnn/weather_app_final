package fi.tuni.prog3.weatherapp.model;

import javafx.scene.control.Button;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class MenuUIModel {
    private Button btnForecast;
    private Button btnData;
    private Button btnHome;
    private Button btnSetting;
}
