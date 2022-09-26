package fontys.frontend.controllers;

import businessentitiesapi.Flight;
import businessentitiesapi.Manager;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import fontys.frontend.observables.ObservableFlight;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Controller for Existing Flight List JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the input
 * from the app user.
 */
public class ExistingFlightsController extends SearchableController<Flight, ObservableFlight> {
    /**
     * Super constructor.
     */
    public ExistingFlightsController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @Override
    public Function<? super Flight, ? extends ObservableFlight> entityCreator() {
        return ObservableFlight::fromFlight;
    }

    @Override
    Manager<Flight, Integer> getManager() {
        return getFlightManager();
    }

    /**
     * /**
     * Initializes the columns of the table and populates it with flights.
     */
    @SuppressWarnings("unchecked")
    @Override
    void additionalSetup() {
        table.setPlaceholder(new Label("No registered flights in the system."));
        table.setRowFactory(createRowFactory("singleFlight.fxml"));

        table.getColumns()
                .addAll(makeColumn("id", "ID", 40),
                        makeColumn("plane", "Airplane RN", 80),
                        makeColumn("departurePort", "Departure Airport", 140),
                        makeColumn("arrivalPort", "Arrival Airport", 140),
                        makeColumn("departureTime", "Departure DateTime", 140),
                        makeColumn("arrivalTime", "Arrival DateTime", 140),
                        makeColumn("price", "Price", 40));
    }

    /**
     * FX action function for switching to flightReg.fxml scene.
     */
    @FXML
    private void addFlight() {
        sceneManager.get().changeScene("flightReg");
    }

    /**
     * FX action function for switching to officerHub.fxml scene.
     */
    @FXML
    private void backToHub() {
        sceneManager.get().changeScene("officerHub");
    }
}
