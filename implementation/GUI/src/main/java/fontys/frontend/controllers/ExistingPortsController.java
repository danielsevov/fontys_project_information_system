package fontys.frontend.controllers;

import businessentitiesapi.Airport;
import businessentitiesapi.Manager;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import fontys.frontend.observables.ObservableAirport;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Controller for Existing Airports List JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the input
 * from the app user.
 */
public class ExistingPortsController extends SearchableController<Airport, ObservableAirport> {

    /**
     * Super constructor.
     */
    public ExistingPortsController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @Override
    Function<? super Airport, ? extends ObservableAirport> entityCreator() {
        return ObservableAirport::fromPort;
    }

    @Override
    Manager<Airport, Integer> getManager() {
        return getAirportManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    void additionalSetup() {
        table.setPlaceholder(new Label("No registered airports in the system."));
        table.setRowFactory(createRowFactory("singlePort.fxml"));

        table.getColumns()
                .addAll(makeColumn("id", "Airport ID", 120),
                        makeColumn("name", "Airport Name", 300),
                        makeColumn("location", "Airport Location", 300));
    }

    /**
     * FX action function for switching to airportReg.fxml scene.
     */
    @FXML
    private void addPort() {
        sceneManager.get().changeScene("airportReg");
    }

    /**
     * FX action function for switching to officerHub.fxml scene.
     */
    @FXML
    private void backToHub() {
        sceneManager.get().changeScene("officerHub");
    }
}
