package fontys.frontend.controllers;

import businessentitiesapi.Airport;
import businessentitiesapi.Flight;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import helpers.ControllerUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Controller for KPI Dashboard: Airports JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class AirportDashboardController extends ControllerBase implements Initializable {
    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public AirportDashboardController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    Label idField, nameField, locationField, airportsField, locationsField, visitedLocationField, visitedAirportField,
            prevArrivals, prevDepartures, activeArrivals, activeDepartures, upArrivals, upDepartures, monthField, planesField;
    @FXML
    ComboBox<String> airportField;
    @FXML
    GridPane singleGrid, multiGrid;

    private List<Airport> airports = new ArrayList<>();
    private List<Flight> flights = new ArrayList<>();

    /**
     * Changes scene to managerHub.fxml.
     */
    @FXML
    public void backToHub() {
        resetAirport();
        sceneManager.get().changeScene("managerHub");
    }

    /**
     * Action function for picking airport.
     */
    @FXML
    public void pickAirport() {
        var value = airportField.getValue();
        if(airports.stream().anyMatch(s -> s.getName().equals(value))){
            singleGrid.setVisible(true);
            var airport = getAirportManager().getByColumnValues("name", value).get(0);
            idField.setText(String.valueOf(airport.getId()));
            nameField.setText(String.valueOf(airport.getName()));
            locationField.setText(String.valueOf(airport.getLocation()));

            multiGrid.setVisible(true);
            var arrivals = flights.stream().filter(s->s.getArrivalAirport().getName().equals(airport.getName())).collect(Collectors.toList());
            var departures = flights.stream().filter(s->s.getDepartureAirport().getName().equals(airport.getName())).collect(Collectors.toList());
            long prevAr, prevDep, actAr, actDep, upAr, upDep;
            LocalDateTime now = LocalDateTime.now();
            prevAr = arrivals.stream().filter(s->s.getArrivalDatetime().isBefore(now)).count();
            prevDep = departures.stream().filter(s->s.getDepartureDatetime().isBefore(now) && s.getArrivalDatetime().isBefore(now)).count();
            upAr = arrivals.stream().filter(s->s.getArrivalDatetime().isAfter(now) && s.getDepartureDatetime().isAfter(now)).count();
            upDep = departures.stream().filter(s->s.getDepartureDatetime().isAfter(now)).count();
            actAr = arrivals.stream().filter(s->s.getDepartureDatetime().isBefore(now) && s.getArrivalDatetime().isAfter(now)).count();
            actDep = departures.stream().filter(s->s.getDepartureDatetime().isBefore(now) && s.getArrivalDatetime().isAfter(now)).count();
            prevArrivals.setText(String.valueOf(prevAr));
            prevDepartures.setText(String.valueOf(prevDep));
            activeArrivals.setText(String.valueOf(actAr));
            activeDepartures.setText(String.valueOf(actDep));
            upArrivals.setText(String.valueOf(upAr));
            upDepartures.setText(String.valueOf(upDep));
            var months = arrivals.stream().map(s->s.getArrivalDatetime().getMonth()).collect(Collectors.toList());
            var month = ControllerUtils.mostCommon(months);
            if(month!=null) monthField.setText(month.name());
            else monthField.setText("-");
            planesField.setText(String.valueOf(prevAr-actDep));
        }
        else{
            resetAirport();
        }
    }

    public void resetAirport(){
        singleGrid.setVisible(false);
        nameField.setText("");
        idField.setText("");
        locationField.setText("");
        prevArrivals.setText("");
        prevDepartures.setText("");
        activeArrivals.setText("");
        activeDepartures.setText("");
        upArrivals.setText("");
        upDepartures.setText("");
        locationField.setText("");
        monthField.setText("");
        multiGrid.setVisible(false);
        airportField.setValue("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        airports = getAirportManager().getAll();
        airportsField.setText(String.valueOf(airports.size()));
        var locations = airports.stream().map(Airport::getLocation).distinct().count();
        locationsField.setText(String.valueOf(locations));
        flights = getFlightManager().getAll();
        var ar = flights.stream().map(s->s.getArrivalAirport().getName()).collect(Collectors.toList());
        var port = ControllerUtils.mostCommon(ar);
        visitedAirportField.setText(port);
        var arr = flights.stream().map(s->s.getArrivalAirport().getLocation()).collect(Collectors.toList());
        var loc = ControllerUtils.mostCommon(arr);
        visitedLocationField.setText(loc);
        resetAirport();
        airportField.setItems(ControllerUtils.entitiesToObservableList(airports.stream(), Airport::getName));
    }
}
