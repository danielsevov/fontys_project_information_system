package fontys.frontend;

import businesslogic.BusinessLogicAPI;
import fontys.frontend.controllers.ControllerBase;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIFlightApp extends Application {
    private final Logger logger = Logger.getLogger(getClass().getName());
    private BusinessLogicAPI businessLogicAPI;
    private SceneManager sceneManager;
    private static final String INITIAL_VIEW = "officerHub";

    private final Callback<Class<?>, Object> controllerFactory = (Class<?> clazz) -> {
        Object controller;
        try {
            if (ControllerBase.class.isAssignableFrom(clazz)) {
                var constructor = clazz.getConstructor(Supplier.class, BusinessLogicAPI.class);
                controller = constructor.newInstance((Supplier<?>) this::getSceneManager, businessLogicAPI);
            } else {
                logger.log(Level.SEVERE, () -> "Constructing controller from no-arg constructor!");
                controller = clazz.getConstructor().newInstance();
            }
        } catch (ReflectiveOperationException ex) {
            throw new RuntimeException(ex);
        }
        return controller;
    };

    public GUIFlightApp(BusinessLogicAPI businessLogicAPI) {
        this.businessLogicAPI = businessLogicAPI;
    }

    public GUIFlightApp show() {
        return init(true);
    }

    GUIFlightApp init(boolean startJavaFXToolkit) {

        if (startJavaFXToolkit) {
            Platform.startup(() -> {
            });

            initializeSceneManager();

            Platform.runLater(() -> {
                Stage stage = new Stage();
                try {
                    start(stage);
                } catch (IOException ex) {
                    throw new IllegalStateException(ex);
                }
            });

        } else {
            initializeSceneManager();
        }

        return this;
    }

    /**
     * Initializes sceneManager.
     */
    private void initializeSceneManager() {
        sceneManager = new SceneManager(controllerFactory, INITIAL_VIEW);
    }

    /**
     * Action function for starting the GUI application.
     */
    @Override
    public void start(Stage stage) throws IOException {
        sceneManager.displayOn(stage, 840, 640, "FlightApp");
    }

    /**
     * Returns sceneManager.
     */
    public SceneManager getSceneManager() {
        return sceneManager;
    }
}
