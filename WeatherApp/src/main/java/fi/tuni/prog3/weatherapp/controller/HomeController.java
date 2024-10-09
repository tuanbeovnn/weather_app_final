package fi.tuni.prog3.weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
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
    private MainViewController mainViewController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void search(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ForecastLayout.fxml"));
            Parent view = loader.load();

            ForecastController controller = loader.getController();

            controller.setSearchText(inputSearch.getText());

            mainViewController.getContentId().getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML: /ForecastLayout.fxml");
        }
//        selectButton(selectedButton, menuUIModel);
    }



}
