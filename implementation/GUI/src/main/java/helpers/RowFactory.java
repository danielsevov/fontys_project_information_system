package helpers;

import fontys.frontend.GUIFlightApp;
import fontys.frontend.controllers.Viewable;
import fontys.frontend.observables.ObservableEntity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableRow;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

/**
 * Factory class for {@link TableRow} objects.
 */
public class RowFactory {
    private RowFactory() {
    }

    /**
     * Create a new table row, which is capable of listening for double clicks.
     * This spawns a new controller window.
     *
     * @param stageName         the stage name of the controller window
     * @param controllerFactory the controller factory to use while spawning
     * @param title             the title of the new stage
     * @param entityReset       the entity reset hook
     * @param <T>               the type of the resulting table row
     * @return the created table row
     */
    public static <T extends ObservableEntity> TableRow<T> create(
            String stageName, Callback<Class<?>,
            Object> controllerFactory,
            String title,
            Runnable entityReset
    ) {
        TableRow<T> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && (!row.isEmpty())) {
                T rowData = row.getItem();
                var windowTitle = title != null ? title : rowData.toString();

                FXMLLoader loader = new FXMLLoader(GUIFlightApp.class.getResource(stageName));
                loader.setControllerFactory(controllerFactory);

                Parent root;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException("Could not load scene for stage " + stageName);
                }

                Viewable controller = loader.getController();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                // Bring selected element into focus.
                controller.setFocusForId(rowData.getId(), stage);
                stage.setTitle(windowTitle);
                stage.showAndWait();
                entityReset.run();
            }
        });
        return row;
    }
}
