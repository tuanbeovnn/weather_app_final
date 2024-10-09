package fi.tuni.prog3.weatherapp.model;

import javafx.scene.layout.AnchorPane;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class MainUIModel {
    private AnchorPane content;
}
