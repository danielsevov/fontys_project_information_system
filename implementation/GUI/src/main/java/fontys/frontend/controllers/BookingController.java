package fontys.frontend.controllers;

import businessentitiesapi.BookedOption;
import businessentitiesapi.Booking;
import businessentitiesapi.Customer;
import businessentitiesapi.Ticket;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.GUIFlightApp;
import fontys.frontend.SceneManager;
import fontys.frontend.observables.ObservableTicket;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static helpers.ControllerUtils.entitiesToObservableList;
import static helpers.ControllerUtils.entitiesToObservableListDistinct;

/**
 * Controller for Booking creation JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class BookingController extends ControllerBase implements Initializable {

    /**
     * Initialize all FX fields.
     */
    @FXML
    Label endLabel;
    @FXML
    ComboBox<String> buyerField;
    @FXML
    Button addTicketButton;
    @FXML
    TableView<ObservableTicket> ticketTable;

    private String customer;
    private List<Ticket> tickets;
    private List<Customer> customers = new ArrayList<>();
    private Booking book;
    private Integer bookingId;

    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public BookingController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    /**
     * Changes scene to existingBookings.fxml.
     */
    @FXML
    public void viewBookings() {
        if (book != null) {
            deleteBooking();
        }
        ticketTable.getItems().clear();
        addTicketButton.setDisable(true);
        sceneManager.get().changeScene("existingBookings");
    }

    @FXML
    public void resetValues() {
        customers = getCustomerManager().getAll();
        var list = entitiesToObservableListDistinct(customers.stream(), Customer::getName);
        list.add("");
        buyerField.setItems(list);
    }

    /**
     * Changes scene to ticketReg.fxml.
     */
    @FXML
    public void addTicket() {
        FXMLLoader loader = new FXMLLoader(GUIFlightApp.class.getResource("ticketReg.fxml"));
        loader.setControllerFactory(sceneManager.get().controllerFactory);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TicketController scene2Controller = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        bookingId = getBookingManager().lastId();
        scene2Controller.setBooking(bookingId, stage);

        stage.setTitle("Ticket for booking + " + bookingId);
        stage.showAndWait();
        resetRows();
        //sceneManager.get().changeScene("ticketReg");
    }

    /**
     * Stores booking to the DB.
     */
    @FXML
    public void storeBooking() {
        if (customer != null && ticketTable.getItems().size() > 0) {
            endLabel.setText("Successfully created booking!");
            ticketTable.getItems().clear();
            buyerField.setValue("");
            buyerField.setDisable(false);
            endLabel.setText("");
            customer = null;
            book = null;
            ticketTable.getItems().clear();
            addTicketButton.setDisable(true);
            sceneManager.get().changeScene("existingBookings");
        } else {
            endLabel.setText("Could not create booking!");
        }
    }

    /**
     * FX action function for picking customer.
     */
    @FXML
    public void pickCustomer() {
        var value = buyerField.getValue();
        if (value != null && !value.equals("")) {
            customer = value;
            buyerField.setDisable(true);
            addTicketButton.setDisable(false);
            var manager = getBookingManager();
            Customer cust = customers.stream().filter(c -> c.getName().equals(customer)).findFirst().orElseThrow();
            book = manager.createBooking(cust);
            manager.save(book);
        }
    }

    /**
     * Changes scene to employeeHub.fxml.
     */
    @FXML
    public void backToHub() {
        if (book != null) {
            deleteBooking();
        }
        ticketTable.getItems().clear();
        addTicketButton.setDisable(true);
        sceneManager.get().changeScene("employeeHub");
    }

    public void deleteBooking() {
        resetRows();
        buyerField.setDisable(false);
        if (tickets.size() > 0) {
            for (Ticket a : tickets) {
                var options = getBookedOptionManager().getByColumnValues("ticket", a.getId());
                for (BookedOption o : options) {
                    getBookedOptionManager().deleteById(o.getId());
                }
                getTicketManager().deleteById(a.getId());
            }
        }
        getBookingManager().deleteById(getBookingManager().lastId());
        buyerField.setValue("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getBookingManager().getAll();
        addTicketButton.setDisable(true);
        ticketTable.setPlaceholder(new Label("No tickets assigned to this booking."));
        ticketTable.getColumns()
                .addAll(makeColumn("id", "ID", 50),
                        makeColumn("flight", "Flight", 440),
                        makeColumn("customer", "Customer", 80),
                        makeColumn("seat_number", "Seat", 60),
                        makeColumn("ticket_type", "Class", 80),
                        makeColumn("price", "Price", 70));
        resetValues();
    }

    /**
     * Create a TableColumn.
     */
    public TableColumn<ObservableTicket, String> makeColumn(String name, String title, double width) {
        TableColumn<ObservableTicket, String> make = new TableColumn<>(title);
        make.setPrefWidth(width);
        make.setStyle("-fx-alignment: CENTER;");
        make.setCellValueFactory(new PropertyValueFactory<>(name));
        return make;
    }

    public void resetRows() {
        //tickets = getTicketManager().getByColumnValues("booking", bookingId);
        var list = getTicketManager().getAll();
        tickets = list.stream().filter(s -> s.getBooking().getId() == bookingId).collect(Collectors.toList());
        ticketTable.setItems(entitiesToObservableList(tickets.stream(), ObservableTicket::fromTicket));
    }
}
