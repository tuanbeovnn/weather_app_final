package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.util.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
@FxmlView("/HomeLayout.fxml")
public class HomeController implements Initializable, BaseController {
    @FXML
    private Button btnSearch;

    @FXML
    private TextField inputSearch;

    @Setter
    private AnchorPane content;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void search(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.FORECAST_LAYOUT));
            Parent view = loader.load();

            ForecastController controller = loader.getController();
            controller.setSearchText(inputSearch.getText());

            content.getChildren().setAll(view);
        } catch (IOException e) {
            log.error("Failed to load view: {}", Constants.FORECAST_LAYOUT);
        }
    }



}
