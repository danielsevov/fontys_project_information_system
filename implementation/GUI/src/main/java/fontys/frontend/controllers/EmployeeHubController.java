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
 * Controller for Central Sales Employee Hub creation JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class EmployeeHubController extends ControllerBase implements Initializable {

    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public EmployeeHubController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    ComboBox<String> userField;

    /**
     * Changes hubs.
     */
    @FXML
    public void pickUser() {
        if (userField.getValue().equals("Officer")) {
            userField.setValue("Employee");
            sceneManager.get().changeScene("officerHub");
        }
        if (userField.getValue().equals("Manager")) {
            userField.setValue("Employee");
            sceneManager.get().changeScene("managerHub");
        }
    }

    /**
     * Changes scene to existingBookings.fxml.
     */
    @FXML
    public void viewBookings() {
        sceneManager.get().changeScene("existingBookings");
    }

    /**
     * Changes scene to bookingReg.fxml.
     */
    @FXML
    public void createBooking() {
        sceneManager.get().changeScene("bookingReg");
    }

    /**
     * Changes scene to existingCustomers.fxml.
     */
    @FXML
    public void viewCustomers() {
        sceneManager.get().changeScene("existingCustomers");
    }

    /**
     * Changes scene to customerReg.fxml.
     */
    @FXML
    public void createCustomer() {
        sceneManager.get().changeScene("customerReg");
    }

    /**
     * Changes scene to existingCustomers.fxml.
     */
    @FXML
    public void viewOptions() {
        sceneManager.get().changeScene("existingTicketOptions");
    }

    /**
     * Changes scene to customerReg.fxml.
     */
    @FXML
    public void createOption() {
        sceneManager.get().changeScene("ticketOptionReg");
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
        userField.setValue("Employee");
    }
}
