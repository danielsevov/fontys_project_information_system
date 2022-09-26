package fontys.frontend.controllers;

import businessentitiesapi.Flight;
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
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Controller for KPI Dashboard: Flights JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class FlightDashboardController extends ControllerBase implements Initializable {
    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public FlightDashboardController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    Label idField, departureField, arrivalField, totalFlights, totalFlightHours, completedFlights, completedHours,
            activeFlights, upcomingFlights, upcomingHours, averageDuration, averagePrice, averageOccupancy, priceField,
            planeField, ticketsField, optionsField, durationField, occupancyField, firstClass, businessClass, economyClass;
    @FXML
    ComboBox<String> flightField;
    @FXML
    GridPane singleGrid, multiGrid, thirdGrid;

    private List<Flight> flights = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    /**
     * Changes scene to managerHub.fxml.
     */
    @FXML
    public void backToHub() {
        resetFlight();
        sceneManager.get().changeScene("managerHub");
    }

    /**
     * Action function for picking airplane.
     */
    @FXML
    public void pickFlight() {
        var value = flightField.getValue();
        if(flights.stream().anyMatch(s -> s.toString().equals(value))){
            singleGrid.setVisible(true);
            StringBuilder id = new StringBuilder();
            boolean x = false;
            for(char a: value.toCharArray()){
                if(x && a!=' '){
                    id.append(a);
                }
                if(x && a==' '){
                    break;
                }
                if(!x && a==' '){
                    x = true;
                }
            }
            int i = Integer.parseInt(id.toString());
            var flight = getFlightManager().get(i).get();
            idField.setText(String.valueOf(flight.getId()));
            departureField.setText(flight.getDepartureAirport() + "\n" + flight.getDepartureDatetime());
            arrivalField.setText(flight.getArrivalAirport() + "\n" + flight.getArrivalDatetime());
            priceField.setText(flight.getPrice() + "€");
            planeField.setText(flight.getPlane().getRegistrationNumber());
            multiGrid.setVisible(true);
            var curTickets = tickets.stream().filter(s->s.getFlight().getId()==flight.getId()).collect(Collectors.toList());
            ticketsField.setText(String.valueOf(curTickets.size()));
            durationField.setText(ControllerUtils.durationToString(flight.getDuration()));
            int options = 0, f = 0, b = 0, e = 0;
            for(Ticket t : curTickets){
                options += getBookedOptionManager().getByColumnValues("ticket", t.getId()).size();
                var mul = t.getTicketType().getName();
                switch (mul){
                    case "First Class" : f++;break;
                    case "Business Class" : b++;break;
                    case "Economy Class" : e++;break;
                }
            }
            optionsField.setText(String.valueOf(options));
            double occupancy = (curTickets.size()*100.0)/flight.getPlane().getMaxCapacity();
            occupancyField.setText(ControllerUtils.round(occupancy, 2) + "%");
            thirdGrid.setVisible(true);
            firstClass.setText(String.valueOf(f));
            businessClass.setText(String.valueOf(b));
            economyClass.setText(String.valueOf(e));
        }
        else{
            resetFlight();
        }
    }

    public void resetFlight(){
        singleGrid.setVisible(false);
        departureField.setText("");
        arrivalField.setText("");
        idField.setText("");
        priceField.setText("");
        planeField.setText("");
        multiGrid.setVisible(false);
        flightField.setValue("");
        thirdGrid.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        flights = getFlightManager().getAll();
        tickets = getTicketManager().getAll();
        totalFlights.setText(String.valueOf(flights.size()));
        Duration hours = Duration.ZERO, cHours = Duration.ZERO, upHours = Duration.ZERO;
        int ac = 0, c = 0, u = 0;
        double price = 0, ocup = 0;
        for(Flight a : flights){
            hours = hours.plus(a.getDuration());
            price += a.getPrice();
            var curTickets = tickets.stream().filter(s->s.getFlight().getId()==a.getId()).count();
            ocup += (curTickets*100.0)/a.getPlane().getMaxCapacity();
            if(a.getArrivalDatetime().isBefore(LocalDateTime.now())) {
                c++;
                cHours = cHours.plus(a.getDuration());
            }
            if(a.getDepartureDatetime().isAfter(LocalDateTime.now())) {
                u++;
                upHours = upHours.plus(a.getDuration());
            }
            if(a.hasOverlapWith(LocalDateTime.now().minusMinutes(5), LocalDateTime.now().plusMinutes(5))){
                ac++;
            }
        }
        activeFlights.setText(String.valueOf(ac));
        completedFlights.setText(String.valueOf(c));
        upcomingFlights.setText(String.valueOf(u));
        completedHours.setText(ControllerUtils.durationToString(cHours));
        upcomingHours.setText(ControllerUtils.durationToString(upHours));
        totalFlightHours.setText(ControllerUtils.durationToString(hours));
        var dur = (hours.toHours()*1.0)/flights.size();
        averageDuration.setText(ControllerUtils.round(dur, 1) + " hours");
        price /= flights.size();
        averagePrice.setText(ControllerUtils.round(price, 2) + "€");
        ocup /= flights.size();
        averageOccupancy.setText(ControllerUtils.round(ocup, 2) + "%");
        resetFlight();
        flightField.setItems(ControllerUtils.entitiesToObservableList(flights.stream(), Flight::toString));
    }
}
