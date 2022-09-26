package fontys.frontend.controllers;

import businessentitiesapi.Airplane;
import businessentitiesapi.Airport;
import businessentitiesapi.Flight;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import helpers.DateConverter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import static helpers.ControllerUtils.entitiesToObservableListDistinct;

/**
 * Controller for Single Flight JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the input
 * from the app user.
 */
public class SingleFlightController extends ControllerBase implements Initializable, Viewable {

    /**
     * Super constructor.
     */
    public SingleFlightController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    private Stage stage;
    private final DateConverter converter = DateConverter.getInstance();
    private final Stage stag = new Stage();
    private Integer flightId;
    private Flight flight;
    private List<Airplane> planes;
    private List<Airport> ports;
    private List<Flight> flights;
    private String plane, depPort, arrPort, depart, arrive;

    @FXML
    Button backButton, storeButton, deleteButton;
    @FXML
    Label currentPlane, currentArrPort, currentDepPort, currentArr, currentDep, titleText, endLabel;
    @FXML
    ComboBox<String> newPlaneField, newDepPortField, newArrPortField;
    @FXML
    TextField newDep, newArr;

    /**
     * Initializes scene for selected flight.
     */
    public void setFlight(Integer id, Stage stage) {
        flightId = id;
        flight = getFlightManager().get(flightId).get();
        currentPlane.setText(flight.getPlane().getRegistrationNumber());
        currentArrPort.setText(flight.getArrivalAirport().getName());
        currentDepPort.setText(flight.getDepartureAirport().getName());
        currentArr.setText(flight.getArrivalDatetime().toString());
        currentDep.setText(flight.getDepartureDatetime().toString());
        titleText.setText("Flight ID : " + flightId + "         ");
        this.stage = stage;
        setFields();
    }

    /**
     * Resets all fields.
     */
    public void resetFlight() {
        flight = getFlightManager().get(flightId).get();
        currentPlane.setText(plane);
        currentArrPort.setText(arrPort);
        currentDepPort.setText(depPort);
        currentArr.setText(arrive);
        currentDep.setText(depart);
        titleText.setText("Flight ID : " + flightId + "         ");
        plane = null;
        arrPort = null;
        depPort = null;
        arrive = null;
        depart = null;
        newPlaneField.setValue(null);
        newDepPortField.setValue(null);
        newArrPortField.setValue(null);
        newDep.setText("");
        newArr.setText("");
    }

    /**
     * FX action function for closing current stage.
     */
    @FXML
    private void backToView() {
        stage.close();
    }

    /**
     * FX action function for storing the changes.
     */
    @FXML
    private void storeFlight() {
        if (plane != null && depPort != null && depart != null && arrPort != null && arrive != null) {
            System.out.println(plane + " " + depPort + "-" + arrPort + " " + depart + "-" + arrive);

            var a = converter.checkDateTime(arrive);
            var d = DateConverter.getInstance().checkDateTime(depart);
            var low = LocalDateTime.MIN;
            boolean c = true;
            Flight fl = null;
            Airport aa = null, da = null;
            Airplane pp = null;

            for (Flight f : flights) {
                if (f.getId() == flightId) {
                    fl = f;
                } else {
                    if (f.hasOverlapWith(d, a)) {
                        c = false;
                        break;
                    }
                    var t = f.getArrivalDatetime();
                    if (f.getPlane().getRegistrationNumber().equals(plane) &&
                            t.isBefore(d) && t.isAfter(low)) {
                        low = t;
                        aa = f.getArrivalAirport();
                    }
                }
            }

            if (c && fl != null && (aa == null || aa.getName().equals(depPort))) {
                for (Airport ap : ports) {
                    if (ap.getName().equals(depPort)) da = ap;
                    if (ap.getName().equals(arrPort)) aa = ap;
                    if (aa != null && da != null) break;
                }

                for (Airplane pl : planes) {
                    if (pl.getRegistrationNumber().equals(plane)) {
                        pp = pl;
                        break;
                    }
                }

                // FIXME: Extract to manager method.
                getFlightManager().updateColumnFor(fl, "plane", pp.getId());
                getFlightManager().updateColumnFor(fl, "departure_airport", da.getId());
                getFlightManager().updateColumnFor(fl, "arrival_airport", aa.getId());
                getFlightManager().updateColumnFor(fl, "departure_datetime", d);
                getFlightManager().updateColumnFor(fl, "arrival_datetime", a);
                endLabel.setText("Flight updated!");
                resetFlight();
            } else {
                endLabel.setText("Could not update flight due to overlap!");
            }
        } else {
            endLabel.setText("Could not update flight due to missing input!");
        }
    }

    /**
     * FX action function for deleting the flight.
     */
    @FXML
    private void deleteFlight() {
        createConfirmationWindow();
    }

    /**
     * FX action function for selecting arrival airport.
     */
    @FXML
    private void pickArrPort() {
        arrPort = newArrPortField.getValue();

        if (depPort != null && depPort.equals(arrPort)) {
            arrPort = null;
            newArrPortField.setValue(null);
        }
    }

    /**
     * FX action function for selecting departure airport.
     */
    @FXML
    private void pickDepPort() {
        depPort = newDepPortField.getValue();

        if (depPort != null && depPort.equals(arrPort)) {
            arrPort = null;
            newArrPortField.setValue("");
        }
    }

    /**
     * FX action function for selecting plane.
     */
    @FXML
    private void pickPlane() {
        plane = newPlaneField.getValue();
    }

    /**
     * FX action function for selecting arrival datetime.
     */
    @FXML
    private void pickArr() {
        arrive = newArr.getText();
        var date = converter.checkDateTime(arrive);
        var dep = converter.checkDateTime(depart);
        if (date == null || date.isBefore(dep)) {
            arrive = null;
            newArr.setText("");
        }
    }

    /**
     * FX action function for selecting departure datetime.
     */
    @FXML
    private void pickDep() {
        depart = newDep.getText();
        var date = converter.checkDateTime(depart);
        if (date == null) {
            depart = null;
            newDep.setText("");
            arrive = null;
            newArr.setText("");
        } else {
            newArr.setDisable(false);
        }
    }

    /**
     * Initializes controller.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setFields() {
        // FIXME: Remove eager fetching.
        ports = getAirportManager().getAll();
        planes = getAirplaneManager().getAll();
        flights = getFlightManager().getAll();

        var a = entitiesToObservableListDistinct(
                flights.stream(), f -> f.getPlane().getRegistrationNumber());
        a.add("");
        newPlaneField.setItems(a);
        var b = entitiesToObservableListDistinct(ports.stream(), Airport::getName);
        b.add("");
        newDepPortField.setItems(b);
        newArrPortField.setItems(b);

        newDep.setPromptText("yyyy-MM-dd HH:mm");
        newArr.setPromptText("yyyy-MM-dd HH:mm");
        newArr.setDisable(true);
    }

    /**
     * Create a pop-up confirmation window.
     */
    public void createConfirmationWindow() {

        VBox mainPane = new VBox();
        Button deleteButton = new Button("Delete");
        Button cancelButton = new Button("Cancel");
        Label label = new Label("   Are you sure you want to delete this flight?");
        label.setFont(new Font(16));
        Label whitespace1 = new Label("");
        Label whitespace2 = new Label("");
        Label whitespace3 = new Label("         ");
        deleteButton.setMinWidth(150);
        deleteButton.setMinHeight(36);
        cancelButton.setMinWidth(150);
        cancelButton.setMinHeight(36);
        HBox box = new HBox();
        box.getChildren().add(cancelButton);
        box.getChildren().add(whitespace3);
        box.getChildren().add(deleteButton);
        mainPane.getChildren().add(label);
        mainPane.getChildren().add(whitespace1);
        mainPane.getChildren().add(whitespace2);
        mainPane.getChildren().add(box);

        deleteButton.setOnAction(e -> {
            getFlightManager().deleteById(flightId);
            stag.close();
            stage.close();
        });
        cancelButton.setOnAction(e -> this.stag.close());

        stag.setScene(new Scene(mainPane, 330, 110));
        stag.show();
    }

    @Override
    public void setFocusForId(int id, Stage stage) {
        setFlight(id, stage);
    }
}
