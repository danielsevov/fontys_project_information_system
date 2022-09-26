package fontys.frontend.controllers;

import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Controller for Central Sales Officer Hub creation JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class OfficerHubController extends ControllerBase implements Initializable {

    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public OfficerHubController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    ComboBox<String> userField;

    /**
     * Changes hubs.
     */
    @FXML
    public void pickUser() {
        if (userField.getValue().equals("Employee")) {
            userField.setValue("Officer");
            sceneManager.get().changeScene("employeeHub");
        }
        if (userField.getValue().equals("Manager")) {
            userField.setValue("Officer");
            sceneManager.get().changeScene("managerHub");
        }
    }

    /**
     * Changes scene to existingFlights.fxml.
     */
    @FXML
    public void viewFlights() {
        sceneManager.get().changeScene("existingFlights");
    }

    /**
     * Changes scene to existingPorts.fxml.
     */
    @FXML
    public void viewPorts() {
        sceneManager.get().changeScene("existingPorts");
    }

    /**
     * Changes scene to existingPlanes.fxml.
     */
    @FXML
    public void viewPlanes() {
        sceneManager.get().changeScene("existingPlanes");
    }

    /**
     * Changes scene to existingDailyDiscounts.fxml.
     */
    @FXML
    public void viewDiscounts() {
        sceneManager.get().changeScene("existingDailyDiscounts");
    }

    /**
     * Changes scene to flightReg.fxml.
     */
    @FXML
    public void createFlight() {
        sceneManager.get().changeScene("flightReg");
    }

    /**
     * Changes scene to airportReg.fxml.
     */
    @FXML
    public void createPort() {
        sceneManager.get().changeScene("airportReg");
    }

    /**
     * Changes scene to airplaneReg.fxml.
     */
    @FXML
    public void createPlane() {
        sceneManager.get().changeScene("airplaneReg");
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
        userField.setValue("Officer");
    }
}
