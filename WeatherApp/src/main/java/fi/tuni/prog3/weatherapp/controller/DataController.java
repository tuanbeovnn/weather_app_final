package fi.tuni.prog3.weatherapp.controller;

import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lombok.Setter;
import net.rgielen.fxweaver.core.FxmlView;

import java.net.URL;
import java.util.ResourceBundle;

@FxmlView ("/DataLayout.fxml")
public class DataController implements Initializable, BaseController {
    @Setter
    AnchorPane content;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
