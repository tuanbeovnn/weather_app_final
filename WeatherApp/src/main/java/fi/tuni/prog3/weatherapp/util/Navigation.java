package fi.tuni.prog3.weatherapp.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.stereotype.Component;

@Component
public class Navigation {
    private final FxWeaver fxWeaver;

    public Navigation(final FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    /**
     * Load the FXML file and set the next scene to be shown,
     * will replace current window.
     *
     * @param actionEvent required to get current scene
     * @param controller  the controller for the scene
     */
    public void loadNextScene(final ActionEvent actionEvent, Class<?> controller) {
        Parent parent = fxWeaver.loadView(controller);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

}
