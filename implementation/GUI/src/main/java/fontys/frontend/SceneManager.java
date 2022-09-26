package fontys.frontend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Scene manager for all controllers.
 */
public class SceneManager {

    private final Scene scene;
    private Stage stage = null;
    public final Callback<Class<?>, Object> controllerFactory;
    private final Map<String, Parent> views = new HashMap<>();

    public SceneManager(Callback<Class<?>, Object> controllerFactory, String initialView) {
        this.controllerFactory = controllerFactory;
        scene = new Scene(loadScene(initialView));
    }

    /**
     * Changes scenes by resetting the root of the current scene.
     */
    public final void changeScene(String view) {
        scene.setRoot(views.computeIfAbsent(view, this::loadScene));
    }

    /**
     * Loads a fxml scene.
     */
    private Parent loadScene(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(GUIFlightApp.class.getResource(fxml + ".fxml"));
        fxmlLoader.setControllerFactory(controllerFactory);
        try {
            return fxmlLoader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Displays scene on a stage.
     */
    void displayOn(Stage stage, int width, int height, String stageTitle) {
        this.stage = stage;
        stage.setScene(scene);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setTitle(stageTitle);
        stage.getIcons().add(new Image(getClass().getResource("icons/flight_icon.png").toExternalForm()));
        stage.show();
    }

    /**
     * Closes stage.
     */
    public void closeStage() {
        stage.close();
    }

}
