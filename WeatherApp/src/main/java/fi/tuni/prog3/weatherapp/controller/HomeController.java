package fi.tuni.prog3.weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Getter;
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
    @Getter
    private TextField inputSearch;

    @Autowired
    private FxWeaver fxWeaver;

    @Autowired
    private MainViewController mainViewController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DataTransferController dataTransferController = DataTransferController.getInstance();
        dataTransferController.selectedBtnHome();
        if (dataTransferController.getDataInput() != null) {
            log.info("data search found");
            inputSearch.setText(dataTransferController.getDataInput());
        } else {
            log.info("data search not found");
        }
    }

    @FXML
    void search(ActionEvent event){
        DataTransferController dataTransferController = DataTransferController.getInstance();
        dataTransferController.setDataInput(inputSearch.getText());

        Parent root = fxWeaver.loadView(ForecastController.class);
        mainViewController.getContentId().getChildren().clear();
        mainViewController.getContentId().getChildren().setAll(root);
    }

}
