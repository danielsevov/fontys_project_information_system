package fontys.frontend.controllers;

import businessentitiesapi.Booking;
import businessentitiesapi.Ticket;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import helpers.ControllerUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Controller for KPI Dashboard: Bookings JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class BookingDashboardController extends ControllerBase implements Initializable {
    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public BookingDashboardController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    Label idField, customerField,  ticketsField, customersField, flightsField, revenueTickets,
            totalTickets, totalBookings, averageTicket, averageBooking, revenue;
    @FXML
    ComboBox<String> bookingField;
    @FXML
    GridPane singleGrid, multiGrid;

    List<Booking> bookings = new ArrayList<>();
    List<Ticket> tickets = new ArrayList<>();

    /**
     * Changes scene to managerHub.fxml.
     */
    @FXML
    public void backToHub() {
        resetBooking();
        sceneManager.get().changeScene("managerHub");
    }

    /**
     * Action function for picking booking.
     */
    @FXML
    public void pickBooking() {
        var value = bookingField.getValue();
        if(ControllerUtils.isInteger(value) && bookings.stream().anyMatch(s -> s.getId() == Integer.parseInt(value))){
                int id = Integer.parseInt(value);
                singleGrid.setVisible(true);
                var booking = bookings.stream().filter(s -> s.getId() == id).collect(Collectors.toList()).get(0);
                idField.setText(String.valueOf(booking.getId()));
                customerField.setText(booking.getBuyer().getName());

                multiGrid.setVisible(true);
                var currentTickets = tickets.stream().filter(s -> s.getBooking().getId() == id).collect(Collectors.toList());
                ticketsField.setText(String.valueOf(currentTickets.size()));
                var flights = currentTickets.stream().map(s->s.getFlight().getId()).distinct().count();
                var customers = currentTickets.stream().map(s->s.getCustomer().getId()).distinct().count();
                flightsField.setText(String.valueOf(flights));
                customersField.setText(String.valueOf(customers));
            }
        else{
                resetBooking();
            }
    }

    public void resetBooking(){
        singleGrid.setVisible(false);
        customersField.setText("");
        customerField.setText("");
        ticketsField.setText("");
        idField.setText("");
        flightsField.setText("");
        bookingField.setValue("");
        multiGrid.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookings = getBookingManager().getAll();
        var books = bookings.size();
        totalBookings.setText(String.valueOf(books));
        tickets = getTicketManager().getAll();
        var ticks = tickets.size();
        totalTickets.setText(String.valueOf(ticks));
        double rev = 0, ticketRev = 0;
        for(Ticket t : tickets){
            rev += t.getPrice();
            var options = getBookedOptionManager().getByColumnValues("ticket", t.getId()).stream().mapToDouble(s->s.getTicketOption().getPrice()).sum();
            ticketRev += t.getPrice() + options;
        }
        revenue.setText(ControllerUtils.round(ticketRev, 2) + "€");
        revenueTickets.setText(ControllerUtils.round(rev, 2) + "€");
        averageBooking.setText(ControllerUtils.round(rev/books, 2) + "€");
        averageTicket.setText(ControllerUtils.round(rev/ticks, 2) + "€");
        resetBooking();
        bookingField.setItems(ControllerUtils.entitiesToObservableList(bookings.stream(), s->String.valueOf(s.getId())));
    }
}
