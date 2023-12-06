package fi.tuni.prog3.weatherapp.config;

import fi.tuni.prog3.weatherapp.WeatherSystemApplication;
import fi.tuni.prog3.weatherapp.controller.MainViewController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * The main class for the WeatherApp JavaFX application.
 * This class extends the JavaFX {@link Application} class.
 */
public class WeatherApp extends Application {

    private ConfigurableApplicationContext applicationContext;

    /**
     * Sets the Spring application context for this JavaFX application.
     *
     * @param applicationContext The Spring application context.
     */
    public void setApplicationContext(ConfigurableApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * Initializes the application.
     * Retrieves command-line arguments and initializes the Spring application context.
     */
    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        this.applicationContext = new SpringApplicationBuilder()
                .sources(WeatherSystemApplication.class)
                .run(args);
    }

    /**
     * Starts the JavaFX application.
     * Loads the main view using the FxWeaver and displays it in a new stage.
     *
     * @param stage The primary stage for this application.
     */
    @Override
    public void start(Stage stage) {
        try {
            FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
            Parent root = fxWeaver.loadView(MainViewController.class);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Stops the application.
     * Closes the Spring application context and exits the JavaFX platform.
     */
    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }
}