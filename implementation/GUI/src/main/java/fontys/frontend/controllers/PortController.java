package fontys.frontend.controllers;

import businessentitiesapi.Airport;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import static helpers.ControllerUtils.entitiesToObservableList;

/**
 * Controller for Airport creation JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class PortController extends ControllerBase implements Initializable {
    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public PortController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    ComboBox<String> nameField;
    @FXML
    ComboBox<String> locationField;
    @FXML
    Label endLabel;

    private String name, location;

    /**
     * Changes scene to existingPlanes.fxml.
     */
    @FXML
    public void viewPorts() {
        sceneManager.get().changeScene("existingPorts");
    }

    /**
     * Changes scene to officerHub.fxml.
     */
    @FXML
    public void backToHub() {
        sceneManager.get().changeScene("officerHub");
    }

    /**
     * Stores plane to DB.
     */
    @FXML
    public void storePort() {
        if (name != null && location !=null && !name.isBlank() && !location.isBlank()) {
            System.out.printf("%s, %s%n", name, location);
            var port = getAirportManager().createAirport(name, location);
            getAirportManager().save(port);
            endLabel.setText("Created " + name + ", " + location);
        } else {
            endLabel.setText("Could not create airport!");
        }
    }

    /**
     * FX action function for nameField input.
     */
    @FXML
    public void pickName() {
        name = nameField.getValue();
    }

    /**
     * FX action function for locationField input.
     */
    @FXML
    public void pickLocation() {
        location = locationField.getValue();
    }

    /**
     * Initializes Controller's ComboBox values.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var ports = getAirportManager().getAll();
        nameField.setItems(entitiesToObservableList(ports.stream(), Airport::getName));
        locationField.setItems(entitiesToObservableList(ports.stream(), Airport::getLocation));
    }
}
