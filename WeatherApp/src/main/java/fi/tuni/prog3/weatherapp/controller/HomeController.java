package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.service.IHomeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
@Component
@FxmlView("/HomeLayout.fxml")
public class HomeController implements Initializable {
    @FXML
    private Button btnSearch;

    @FXML
    private TextField inputSearch;

    @Autowired
    private FxWeaver fxWeaver;

    @Autowired
    private IHomeService homeService;

    @Autowired
    private MainViewController mainViewController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (homeService.getDataSearch() != null) {
            log.info("data search found");
            inputSearch.setText(homeService.getDataSearch());
        } else {
            log.info("data search not found");
        }
    }

    @FXML
    void search(ActionEvent event){
        homeService.setDataSearch(inputSearch.getText());

        Parent root = fxWeaver.loadView(ForecastController.class);
        mainViewController.getContentId().getChildren().clear();
        mainViewController.getContentId().getChildren().setAll(root);
    }

}
