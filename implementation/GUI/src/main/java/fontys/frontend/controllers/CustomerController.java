package fontys.frontend.controllers;

import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import helpers.DateConverter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Supplier;

/**
 * Controller for Customer registration JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class CustomerController extends ControllerBase implements Initializable {
    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public CustomerController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    TextField nameField;
    @FXML
    TextField emailField;
    @FXML
    DatePicker birthdateField;
    @FXML
    Label endLabel;

    private String name, email;
    private LocalDate birthdate;

    /**
     * Changes scene to existingCustomers.fxml.
     */
    @FXML
    public void viewCustomers() {
        sceneManager.get().changeScene("existingCustomers");
    }

    /**
     * Changes scene to officerHub.fxml.
     */
    @FXML
    public void backToHub() {
        sceneManager.get().changeScene("employeeHub");
    }

    /**
     * Stores plane to DB.
     */
    @FXML
    public void storeCustomer() {
        if (name != null && email != null && birthdate != null && !name.equals("") && !email.equals("") && !birthdate.equals("") && email.contains("@")) {
            System.out.println(name + ", " + email + ", born on " + birthdate);
            var manager = getCustomerManager();
            manager.save(manager.createCustomer(name, email, birthdate));
            endLabel.setText(String.format("Created %s, %s, born on %s", name, email, birthdate));
        } else {
            endLabel.setText("Could not register customer!");
        }
    }

    /**
     * FX action function for nameField input.
     */
    @FXML
    public void pickName() {
        this.name = nameField.getText();
    }

    /**
     * FX action function for emailField input.
     */
    @FXML
    public void pickEmail() {
        this.email = emailField.getText();
    }

    /**
     * FX action function for birthdateField input.
     */
    @FXML
    public void pickBirthdate() {
        this.birthdate = birthdateField.getValue();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getCustomerManager().getAll();
        birthdateField.setConverter(DateConverter.getInstance());
        birthdateField.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) > 0);
            }
        });
    }
}
