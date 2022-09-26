package fontys.frontend.controllers;

import businessentitiesapi.BookedOption;
import businessentitiesapi.Booking;
import businessentitiesapi.Ticket;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import fontys.frontend.observables.ObservableTicket;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static helpers.ControllerUtils.entitiesToObservableList;

/**
 * Controller for Booking view JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class SingleBookingController extends ControllerBase implements Viewable {

    /**
     * Initialize all FX fields.
     */
    @FXML
    TableView<ObservableTicket> table;
    @FXML
    Label holderLabel, titleText;

    private Stage stage;
    private Booking book;
    private Integer bookingId;
    private List<Ticket> tickets = new ArrayList<>();

    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public SingleBookingController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    public void close() {
        stage.close();
    }

    /**
     * Changes scene to employeeHub.fxml.
     */
    @FXML
    public void backToHub() {
        if (book != null) {
            deleteBooking();
        }
        table.getItems().clear();
        sceneManager.get().changeScene("employeeHub");
    }

    public void deleteBooking() {
        for (Ticket a : tickets) {
            var options = getBookedOptionManager().getAll().stream()
                    .filter(o -> o.getTicket().getId() == a.getId()).collect(Collectors.toList());
            for (BookedOption o : options) {
                getBookedOptionManager().deleteById(o.getId());
            }
            getTicketManager().deleteById(a.getId());
        }
        getBookingManager().deleteById(bookingId);
        close();
    }

    @Override
    public void setFocusForId(int id, Stage stage) {
        setBooking(id, stage);
    }

    public void setBooking(Integer bookingId, Stage stage) {
        this.stage = stage;
        this.bookingId = bookingId;
        book = getBookingManager().get(bookingId).get();
        holderLabel.setText(book.getBuyer().getName());
        titleText.setText("Booking number " + bookingId);

        table.setPlaceholder(new Label("No tickets assigned to this booking."));
        table.getColumns()
                .addAll(makeColumn("id", "ID", 50),
                        makeColumn("flight", "Flight", 440),
                        makeColumn("customer", "Customer", 80),
                        makeColumn("seat_number", "Seat", 60),
                        makeColumn("ticket_type", "Class", 80),
                        makeColumn("price", "Price", 70));
        resetTickets();
    }

    public void resetTickets() {
        tickets = getTicketManager().getByColumnValues("booking", bookingId);
        table.setItems(entitiesToObservableList(tickets.stream(), ObservableTicket::fromTicket));
    }
}
