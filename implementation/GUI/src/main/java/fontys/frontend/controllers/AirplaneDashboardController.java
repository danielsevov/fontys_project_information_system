package fontys.frontend.controllers;

import businessentitiesapi.*;
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
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Controller for KPI Dashboard: Airplanes JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class AirplaneDashboardController extends ControllerBase implements Initializable {
    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public AirplaneDashboardController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    Label idField, nameField, capacityField, airplanesField, activeAirplanesField,
            previousFlightsField, upcomingFlightsField, locationField, averageField;
    @FXML
    ComboBox<String> airplaneField;
    @FXML
    GridPane singleGrid, multiGrid;

    private List<Airplane> airplanes = new ArrayList<>();
    private List<Flight> flights = new ArrayList<>();

    /**
     * Changes scene to managerHub.fxml.
     */
    @FXML
    public void backToHub() {
        resetAirplane();
        sceneManager.get().changeScene("managerHub");
    }

    /**
     * Action function for picking airplane.
     */
    @FXML
    public void pickAirplane() {
        var value = airplaneField.getValue();
        if(airplanes.stream().anyMatch(s -> s.getRegistrationNumber().equals(value))){
            singleGrid.setVisible(true);
            var airplane = getAirplaneManager().getByColumnValues("registration_number", value).get(0);
            idField.setText(String.valueOf(airplane.getId()));
            nameField.setText(String.valueOf(airplane.getRegistrationNumber()));
            capacityField.setText(String.valueOf(airplane.getMaxCapacity()));

            multiGrid.setVisible(true);
            var currentFlights = flights.stream().filter(s->s.getPlane().getRegistrationNumber()
                    .equals(airplane.getRegistrationNumber())).collect(Collectors.toList());
            var prev = currentFlights.stream().filter(s->s.getArrivalDatetime().isBefore(LocalDateTime.now())).collect(Collectors.toList());
            previousFlightsField.setText(String.valueOf(prev.size()));
            currentFlights.removeAll(prev);
            upcomingFlightsField.setText(String.valueOf(currentFlights.size()));
            double ocup = 0;
            LocalDateTime maxDate = LocalDateTime.MIN;
            String loc = "-";
            for(Flight a : prev){
                var tickets = getTicketManager().getByColumnValues("flight", a.getId()).size();
                ocup += (tickets*100.0)/airplane.getMaxCapacity();
                if(a.getArrivalDatetime().isAfter(maxDate)){
                    maxDate = a.getArrivalDatetime();
                    loc = a.getArrivalAirport().toString();
                }
            }
            locationField.setText(loc);
            ocup/=prev.size();
            averageField.setText(ControllerUtils.round(ocup, 2) +"%");
        }
        else{
            resetAirplane();
        }
    }

    public void resetAirplane(){
        singleGrid.setVisible(false);
        locationField.setText("");
        nameField.setText("");
        idField.setText("");
        capacityField.setText("");
        averageField.setText("");
        airplaneField.setValue("");
        previousFlightsField.setText("");
        upcomingFlightsField.setText("");
        multiGrid.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        airplanes = getAirplaneManager().getAll();
        airplanesField.setText(String.valueOf(airplanes.size()));
        flights = getFlightManager().getAll();
        var active = flights.stream().filter(s->s.hasOverlapWith(LocalDateTime.now().minusMinutes(5), LocalDateTime.now().plusMinutes(5))).count();
        activeAirplanesField.setText(String.valueOf(active));

        resetAirplane();
        airplaneField.setItems(ControllerUtils.entitiesToObservableList(airplanes.stream(), Airplane::getRegistrationNumber));
    }
}
