package fi.tuni.prog3.weatherapp.service;

import fi.tuni.prog3.weatherapp.model.MenuUIModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class LayoutService {
    @Autowired
    private ApplicationContext applicationContext;

    @Getter
    private Label inputSearch;

    @Getter
    private MenuUIModel menuUIModel;

    @Getter
    private Button selectedButton;

    public void loadLayout(AnchorPane contentId, String viewName, Button selectedButton, MenuUIModel menuUIModel){
        this.menuUIModel = menuUIModel;
        this.selectedButton = selectedButton;
        viewName = createFxmlPath(viewName);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewName));
            loader.setControllerFactory(applicationContext::getBean);
            Parent homeView = loader.load();
            contentId.getChildren().clear();
            contentId.getChildren().setAll(homeView);
        } catch (IOException e) {
            log.error("Failed to load view: {}", viewName);
        }
        selectButton(selectedButton, menuUIModel);
    }

    public void selectButton(Button selectedButton, MenuUIModel menuUIModel) {
        resetButtonStyles(menuUIModel);
        selectedButton.setStyle("-fx-background-color: #2b2b2b; -fx-text-fill: white;");

        // Box Shadow
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(-4); // Bóng đổ sang trái
        dropShadow.setOffsetY(4);   // Bóng đổ xuống dưới
        dropShadow.setColor(javafx.scene.paint.Color.GRAY);
        selectedButton.setEffect(dropShadow);
    }

    public void resetButtonStyles(MenuUIModel menuUIModel) {
        for (Button button : new Button[]{menuUIModel.getBtnHome(), menuUIModel.getBtnData(), menuUIModel.getBtnForecast(), menuUIModel.getBtnSetting()}) {
            button.setStyle("-fx-background-color: #6a6a6a; -fx-text-fill: white;");
            button.setEffect(null);
        }
    }

    public static String createFxmlPath(String viewName) {
        return "/" + viewName + ".fxml";
    }
}
