package fontys.frontend.controllers;

import businessentitiesapi.Manager;
import businessentitiesapi.TicketOption;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import fontys.frontend.observables.ObservableTicketOption;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Controller for Existing Ticket Options List JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the input
 * from the app user.
 */
public class ExistingTicketOptionsController extends SearchableController<TicketOption, ObservableTicketOption> {

    /**
     * Super constructor.
     */
    public ExistingTicketOptionsController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @Override
    Function<? super TicketOption, ? extends ObservableTicketOption> entityCreator() {
        return ObservableTicketOption::fromOption;
    }

    @Override
    Manager<TicketOption, Integer> getManager() {
        return getTicketOptionManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    void additionalSetup() {
        table.setPlaceholder(new Label("No registered ticket options in the system."));
        table.setRowFactory(createRowFactory("singleOption.fxml"));

        table.getColumns()
                .addAll(makeColumn("id", "Ticket Option ID", 180),
                        makeColumn("name", "Ticket Option Name", 300),
                        makeColumn("price", "Ticket Option Price", 200));
    }

    /**
     * FX action function for switching to ticketOptionReg.fxml scene.
     */
    @FXML
    private void addTicketOption() {
        sceneManager.get().changeScene("ticketOptionReg");
    }

    /**
     * FX action function for switching to employeeHub.fxml scene.
     */
    @FXML
    private void backToHub() {
        sceneManager.get().changeScene("employeeHub");
    }

    /**
     * Updates booking values in table.
     */
    @FXML
    public void resetTicketOptions() {
        super.resetEntities();
    }
}
