package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.model.HomeUIModel;
import fi.tuni.prog3.weatherapp.service.HomeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
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
    private HomeService homeService;

    @Autowired
    private MainViewController mainViewController;

    private HomeUIModel homeUIModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeUIModel = HomeUIModel.builder()
                .btnSearch(btnSearch)
                .inputSearch(inputSearch)
                .build();
    }

    @FXML
    void search(ActionEvent event){
        homeService.search(
                mainViewController.getMainUIModel().getContent(),
                inputSearch.getText(),
                mainViewController.getMenuUIModel().getBtnForecast()
        );
    }

}
