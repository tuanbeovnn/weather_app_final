package fi.tuni.prog3.weatherapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@FxmlView ("/DataLayout.fxml")
@Component
public class DataController implements Initializable {
    @FXML
    private LineChart<String, Number> lineChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Temperature");

        series.getData().add(new XYChart.Data<>("01.02", 15));
        series.getData().add(new XYChart.Data<>("02.02", 18));
        series.getData().add(new XYChart.Data<>("03.02", 20));
        series.getData().add(new XYChart.Data<>("04.02", 17));

        lineChart.getData().add(series);

        DataTransferController dataTransferController = DataTransferController.getInstance();
        dataTransferController.selectedBtnData();
    }

}
