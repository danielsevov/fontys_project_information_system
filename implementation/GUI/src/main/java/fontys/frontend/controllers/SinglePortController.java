package fontys.frontend.controllers;

import businessentitiesapi.Airport;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import static helpers.ControllerUtils.entitiesToObservableList;

/**
 * Controller for Single Airport JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the input
 * from the app user.
 */
public class SinglePortController extends ControllerBase implements Initializable, Viewable {

    /**
     * Super constructor.
     */
    public SinglePortController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    private Stage stage;
    private final Stage stag = new Stage();
    private Integer portId;
    private String name, location;
    private Optional<Airport> port;

    @FXML
    TextField newName;
    @FXML
    ComboBox<String> newLocation;
    @FXML
    Label currentName, currentLocation, titleText, endLabel;


    /**
     * Initializes scene for port.
     */
    public void setPort(Integer id, Stage stage) {
        port = getAirportManager().get(id);
        portId = id;
        currentName.setText(port.get().getName());
        currentLocation.setText(port.get().getLocation());
        titleText.setText("Airport ID : " + portId + "         ");
        this.stage = stage;
    }

    /**
     * Updates current name and location.
     */
    public void resetPort() {
        port = getAirportManager().get(portId);
        currentName.setText(port.get().getName());
        currentLocation.setText(port.get().getLocation());
    }

    /**
     * FX action function for closing current stage.
     */
    @FXML
    private void backToView() {
        stage.close();
    }

    /**
     * FX action function for deleting the airport.
     */
    @FXML
    private void deletePort() {
        createConfirmationWindow();
    }

    /**
     * FX action function for storing the changes to the DB.
     */
    @FXML
    private void storeChanges() {
        if (name == null && location == null) {
            endLabel.setText("Nothing new to store!");
        } else {
            //do something to update values
            var newPort = getAirportManager().createAirport(
                    portId,
                    currentName.getText(), currentLocation.getText());
            if (name != null) getAirportManager().updateColumnFor(newPort, "name", name);
            if (location != null) getAirportManager().updateColumnFor(newPort, "location", location);
            resetPort();
            endLabel.setText("Changes stored!");
        }
    }

    /**
     * FX action function for switching to existingFlights scene.
     */
    @FXML
    private void pickName() {
        name = newName.getText();
    }

    /**
     * FX action function for switching to existingFlights scene.
     */
    @FXML
    private void pickLocation() {
        location = newLocation.getValue();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var ports = getAirportManager().getAll().stream();
        newLocation.setItems(entitiesToObservableList(ports, Airport::getLocation));
    }

    public void createConfirmationWindow() {
        VBox mainPane = new VBox();
        Button deleteButton = new Button("Delete");
        Button cancelButton = new Button("Cancel");
        Label label = new Label("   Are you sure you want to delete this airport?");
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
            getAirportManager().deleteById(portId);
            stag.close();
            stage.close();
        });
        cancelButton.setOnAction(e -> stag.close());

        stag.setScene(new Scene(mainPane, 330, 110));
        stag.show();
    }

    @Override
    public void setFocusForId(int id, Stage stage) {
        setPort(id, stage);
    }
}
