package fi.tuni.prog3.weatherapp.model;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class HomeUIModel {
    private Button btnSearch;
    private TextField inputSearch;
}
