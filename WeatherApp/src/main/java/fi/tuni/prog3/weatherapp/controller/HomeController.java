package fi.tuni.prog3.weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
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

    private final DataTransferController dataTransferController = DataTransferController.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (dataTransferController.getDataInput() != null) {
            log.info("data search found");
            inputSearch.setText(dataTransferController.getDataInput());
        } else {
            log.info("data search not found");
        }
    }

    @FXML
    void search(ActionEvent event){
        dataTransferController.setDataInput(inputSearch.getText());
        dataTransferController.loadLayout(ForecastController.class);
    }

}
