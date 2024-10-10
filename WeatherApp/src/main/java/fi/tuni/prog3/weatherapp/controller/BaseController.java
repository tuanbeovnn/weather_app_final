package fi.tuni.prog3.weatherapp.controller;

import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public interface BaseController {
    void setContent(AnchorPane contentId);
}
