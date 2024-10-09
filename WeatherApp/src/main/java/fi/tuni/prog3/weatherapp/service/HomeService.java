package fi.tuni.prog3.weatherapp.service;

import fi.tuni.prog3.weatherapp.common.Constants;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    @Autowired LayoutService layoutService;

    public void search(AnchorPane contentId, String text, Button button) {
//        handle input search
        layoutService.loadLayout(contentId, Constants.FORECAST_LAYOUT, button, layoutService.getMenuUIModel());
    }
}