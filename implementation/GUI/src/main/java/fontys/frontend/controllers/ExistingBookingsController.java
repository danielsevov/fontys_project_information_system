package fontys.frontend.controllers;

import businessentitiesapi.Booking;
import businessentitiesapi.Manager;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import fontys.frontend.observables.ObservableBooking;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Controller for Existing Bookings List JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the input
 * from the app user.
 */
public class ExistingBookingsController extends SearchableController<Booking, ObservableBooking> {

    /**
     * Super constructor.
     */
    public ExistingBookingsController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @Override
    Function<? super Booking, ? extends ObservableBooking> entityCreator() {
        return ObservableBooking::fromBooking;
    }

    @Override
    Manager<Booking, Integer> getManager() {
        return getBookingManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    void additionalSetup() {
        table.setPlaceholder(new Label("No registered bookings in the system."));
        table.setRowFactory(createRowFactory("singleBooking.fxml"));

        table.getColumns()
                .addAll(makeColumn("id", "Booking ID", 280),
                        makeColumn("customer", "Customer Name", 400));
    }

    /**
     * FX action function for switching to airportReg.fxml scene.
     */
    @FXML
    private void addBooking() {
        sceneManager.get().changeScene("bookingReg");
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
    public void resetBookings() {
        super.resetEntities();
    }
}
