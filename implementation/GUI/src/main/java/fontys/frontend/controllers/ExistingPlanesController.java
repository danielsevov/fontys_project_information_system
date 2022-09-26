package fontys.frontend.controllers;

import businessentitiesapi.Airplane;
import businessentitiesapi.Manager;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import fontys.frontend.observables.ObservableAirplane;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Controller for Existing Planes List JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the input
 * from the app user.
 */
public class ExistingPlanesController extends SearchableController<Airplane, ObservableAirplane> {
    /**
     * Super constructor.
     */
    public ExistingPlanesController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @Override
    Function<? super Airplane, ? extends ObservableAirplane> entityCreator() {
        return ObservableAirplane::fromPlane;
    }

    @Override
    Manager<Airplane, Integer> getManager() {
        return getAirplaneManager();
    }


    @SuppressWarnings("unchecked")
    @Override
    void additionalSetup() {
        table.setPlaceholder(new Label("No registered airplanes in the system."));
        table.setRowFactory(createRowFactory("singlePlane.fxml"));

        table.getColumns()
                .addAll(makeColumn("id", "Airplane ID", 200),
                        makeColumn("registration", "Registration Number", 260),
                        makeColumn("capacity", "Max Capacity", 260));
    }

    /**
     * FX action function for switching to officerHub.fxml scene.
     */
    @FXML
    private void backToHub() {
        sceneManager.get().changeScene("officerHub");
    }

    /**
     * FX action function for switching to airplaneReg.fxml scene.
     */
    @FXML
    private void addPlane() {
        sceneManager.get().changeScene("airplaneReg");
    }
}
