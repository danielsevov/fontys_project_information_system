package fontys.frontend.controllers;

import businessentitiesapi.Customer;
import businessentitiesapi.Flight;
import businessentitiesapi.Ticket;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import helpers.ControllerUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Controller for Central Sales Manager Hub creation JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class ManagerHubController extends ControllerBase implements Initializable {

    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public ManagerHubController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    ComboBox<String> userField;
    @FXML
    Label revenueField, flightField, customerField, inFlightField, referralRateField, soldTicketField,
            locationField, airplaneField, activeFlightsField, upcomingFlightsField;

    /**
     * Changes hubs.
     */
    @FXML
    public void pickUser() {
        if (userField.getValue().equals("Employee")) {
            userField.setValue("Manager");
            sceneManager.get().changeScene("employeeHub");
        }
        if (userField.getValue().equals("Officer")) {
            userField.setValue("Manager");
            sceneManager.get().changeScene("officerHub");
        }
    }

    /**
     * Navigates to KPI Dashboard: Airplanes scene.
     */
    @FXML
    public void viewAirplanes() {
        sceneManager.get().changeScene("airplaneDashboard");
    }

    /**
     * Navigates to KPI Dashboard: Options scene.
     */
    @FXML
    public void viewOptions() {
        sceneManager.get().changeScene("optionDashboard");
    }

    /**
     * Navigates to KPI Dashboard: Customers scene.
     */
    @FXML
    public void viewCustomers() {
        sceneManager.get().changeScene("customerDashboard");
    }

    /**
     * Navigates to KPI Dashboard: Airports scene.
     */
    @FXML
    public void viewAirports() {
        sceneManager.get().changeScene("airportDashboard");
    }

    /**
     * Navigates to KPI Dashboard: Bookings scene.
     */
    @FXML
    public void viewBookings() {
        sceneManager.get().changeScene("bookingDashboard");
    }

    /**
     * Navigates to KPI Dashboard: Flights scene.
     */
    @FXML
    public void viewFlights() {
        sceneManager.get().changeScene("flightDashboard");
    }

    /**
     * Closes application.
     */
    @FXML
    public void close() {
        sceneManager.get().closeStage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userField.setItems(observableArrayList("Officer", "Employee", "Manager"));
        userField.setValue("Manager");

        var tickets = getTicketManager().getAll();
        double revenue = tickets.stream().map(Ticket::getPrice).mapToDouble(p -> p).sum();
        revenueField.setText(ControllerUtils.round(revenue, 2) + "€");
        int soldTickets = tickets.size();
        soldTicketField.setText(String.valueOf(soldTickets));
        int locations = getAirportManager().size();
        locationField.setText(String.valueOf(locations));
        int airplanes = getAirplaneManager().size();
        airplaneField.setText(String.valueOf(airplanes));
        var customers = getCustomerManager().getAll();
        customerField.setText(String.valueOf(customers.size()));
        var flights = getFlightManager().getAll();
        flightField.setText(String.valueOf(flights.size()));
        Duration flightHours = Duration.ZERO;
        int active = 0, upcoming = 0;
        for(Flight a : flights){
            if(a.getArrivalDatetime().isBefore(LocalDateTime.now())) {
                flightHours = flightHours.plus(a.getDuration());
            }
            if(a.getDepartureDatetime().isAfter(LocalDateTime.now())){
                upcoming++;
            }
            if(a.hasOverlapWith(LocalDateTime.now().minusMinutes(5), LocalDateTime.now().plusMinutes(5))){
                active++;
            }
        }
        inFlightField.setText(flightHours.toHours() + " hours");
        upcomingFlightsField.setText(String.valueOf(upcoming));
        activeFlightsField.setText(String.valueOf(active));
        int nonSingleTickets = 0;
        for(Customer a : customers){
            if(tickets.stream().filter(s -> s.getCustomer().getId() == a.getId()).count()>1){
                nonSingleTickets++;
            }
        }
        double rate = nonSingleTickets*100;
        rate /=tickets.size();
        referralRateField.setText(ControllerUtils.round(rate, 2) + "%");
    }
}
