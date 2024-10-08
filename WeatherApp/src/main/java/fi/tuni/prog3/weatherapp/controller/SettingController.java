package fi.tuni.prog3.weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/SettingLayout.fxml")
public class SettingController {
    @FXML
    private ComboBox<?> activitiesComboBox;

    @FXML
    private Button btnSave;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    void save(ActionEvent event) {

    }
}
