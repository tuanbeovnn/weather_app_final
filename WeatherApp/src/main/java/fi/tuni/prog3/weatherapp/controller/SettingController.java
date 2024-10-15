package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.service.IDataService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@Slf4j
@Component
@FxmlView ("/SettingLayout.fxml")
public class SettingController implements Initializable {
    @FXML
    private ComboBox<String> activitiesComboBox;

    @FXML
    private Button btnSave;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    private CheckBox checkBoxPrecipitation;

    @FXML
    private CheckBox checkBoxTemperature;

    @FXML
    private CheckBox checkBoxWindspeed;

    @Autowired
    private FxWeaver fxWeaver;

    @Autowired
    IDataService dataService;

    @Autowired
    private MainViewController mainViewController;

    private Map<Integer, String> activitiesMap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Hard code
        activitiesMap = new HashMap<>();
        activitiesMap.put(1, "Running");
        activitiesMap.put(2, "Swimming");
        activitiesMap.put(3, "Cycling");

        activitiesMap.values().forEach(activitiesComboBox.getItems()::add);

        checkBoxPrecipitation.setSelected(true);
        checkBoxTemperature.setSelected(false);
        checkBoxWindspeed.setSelected(true);
    }

    @FXML
    void save(ActionEvent event) {
        LocalDate fromDate = fromDatePicker.getValue();
        LocalDate toDate = toDatePicker.getValue();
        var selectedActivity = activitiesComboBox.getItems();

//        if (checkBoxPrecipitation.isSelected()) {
//
//        }
//
//        if (checkBoxTemperature.isSelected()) {
//
//        }
//
//        if (checkBoxWindspeed.isSelected()) {
//
//        }

        log.info("From date: " + fromDate);
        log.info("To date: " + toDate);
        log.info("Activities: " + selectedActivity);

        Parent root = fxWeaver.loadView(HomeController.class);
        mainViewController.getContentId().getChildren().clear();
        mainViewController.getContentId().getChildren().setAll(root);
    }
}
