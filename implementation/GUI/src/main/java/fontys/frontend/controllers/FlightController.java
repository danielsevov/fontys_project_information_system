package fontys.frontend.controllers;

import businessentitiesapi.Airplane;
import businessentitiesapi.Airport;
import businessentitiesapi.Flight;
import businesslogic.BusinessLogicAPI;
import businesslogic.bulkvalidator.BulkException;
import businesslogic.validation.FlightRegistrationValidator;
import fontys.frontend.SceneManager;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import nl.homberghp.fxuiscraper.FXUIScraper;
import tornadofx.control.DateTimePicker;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static helpers.ControllerUtils.entitiesToObservableList;
import static helpers.ControllerUtils.entitiesToObservableListDistinct;

/**
 * Controller for Flight creation JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */
public class FlightController extends ControllerBase {
    @FXML
    VBox root;
    @FXML
    DateTimePicker departDatetime, arrivalDatetime;
    @FXML
    ComboBox<Airplane> planeField;
    @FXML
    ComboBox<Airport> departField, arriveField;
    @FXML
    TextField priceField;
    @FXML
    Label endLabel;

    private final List<Airport> allPorts = getAirportManager().getAll();
    private final FlightRegistrationValidator validator = new FlightRegistrationValidator();
    private final FXUIScraper scraper = () -> root;
    private List<Node> allNodes = List.of();

    public FlightController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    void initialize() {
        configureDatetimeFields();
        // Initialise port fields with all available ports.
        var observablePorts = entitiesToObservableList(allPorts.stream(), x -> x);
        var binding = Bindings.or(
                departDatetime.dateTimeValueProperty().isNull(),
                arrivalDatetime.dateTimeValueProperty().isNull()
        );

        // Both fields remain disabled until a departure and arrival date was picked.
        departField.disableProperty().bind(binding);
        arriveField.disableProperty().bind(binding);

        departField.setItems(observablePorts);
        arriveField.setItems(observablePorts);
        planeField.setItems(entitiesToObservableList(getAirplaneManager().getAll().stream(), x -> x));
        // Set up listeners for our combo boxes.
        departField.valueProperty().addListener((o, ov, newValue) -> onAirportListingChanged(newValue, arriveField));
        arriveField.valueProperty().addListener((o, ov, newValue) -> onAirportListingChanged(newValue, departField));
    }

    private void configureDatetimeFields() {
        departDatetime.dateTimeValueProperty().addListener(o -> updateAvailableAirplanes());
        arrivalDatetime.dateTimeValueProperty().addListener(o -> {
            var departValue = departDatetime.getDateTimeValue();
            var arrivalValue = arrivalDatetime.getDateTimeValue();
            if (departValue != null && arrivalValue != null && arrivalValue.isBefore(departValue)) {
                // arrival time >= departure time
                arrivalDatetime.setDateTimeValue(null);
                return;
            }

            updateAvailableAirplanes();
        });
        // Normally, these fields are set to LocalDateTime.now(), which is not what we want.
        departDatetime.setDateTimeValue(null);
        arrivalDatetime.setDateTimeValue(null);
    }

    private void onAirportListingChanged(Airport selectedAirport, ComboBox<Airport> airportComboBox) {
        if (selectedAirport == null) {
            return;
        }
        // Remove the selected airport from the other combo box.
        // This prevents users from creating a flight from A to A instead of from A to B.
        var filteredPorts = allPorts.stream().filter(x -> x.getId() != selectedAirport.getId());
        airportComboBox.setItems(entitiesToObservableList(filteredPorts, x -> x));
        updateAvailableAirplanes();
    }

    private void updateAvailableAirplanes() {
        if (departField.getValue() == null) {
            return;
        }

        var departTime = departDatetime.getDateTimeValue();
        var arrivalTime = arrivalDatetime.getDateTimeValue();
        var departureAirport = departField.getValue();
        var found = getFlightManager().findQualifiedAirplanes(departTime, arrivalTime, departureAirport);
        planeField.setItems(entitiesToObservableListDistinct(found.stream(), x -> x));
    }

    private String nodeTransformer(Node node) {
        if (node instanceof DateTimePicker && ((DateTimePicker) node).getDateTimeValue() != null) {
            // DateTimePicker does not override its toString, use the internal one instead.
            return ((DateTimePicker) node).getDateTimeValue().toString();
        }
        return FXUIScraper.toString(node);
    }

    private Map<String, String> scrapeFields() {
        return allNodes.stream().collect(Collectors.toMap(Node::getId, this::nodeTransformer));
    }

    @FXML
    private void storeFlight() {
        // Initialise allNodes because the root scene is available at this point.
        allNodes = scraper.inputControlStream(x -> true, Set.of()).collect(Collectors.toList());
        var keyValues = scrapeFields();
        try {
            validator.validateFlightInfo(keyValues);
            getFlightManager().save(createFlight());
            endLabel.setText("Flight planned successfully!");
        } catch (BulkException bex) {
            endLabel.setText("Could not create flight!");
            displayErrors(bex, allNodes);
        }
    }

    private Flight createFlight() {
        // At this point, input is already validated.
        return getFlightManager()
                .createFlight(
                        planeField.getValue(),
                        departDatetime.getDateTimeValue(),
                        arrivalDatetime.getDateTimeValue(),
                        departField.getValue(),
                        arriveField.getValue(), Integer.parseInt(priceField.getText())
                );
    }

    /**
     * Changes scene to existingFlights.fxml.
     */
    @FXML
    public void viewFlights() {
        sceneManager.get().changeScene("existingFlights");
    }

    /**
     * Changes scene to existingFlights.fxml.
     */
    @FXML
    public void backToHub() {
        sceneManager.get().changeScene("officerHub");
    }
}
