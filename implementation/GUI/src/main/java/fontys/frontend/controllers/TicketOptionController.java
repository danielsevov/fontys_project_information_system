package fontys.frontend.controllers;

import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import helpers.ControllerUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.function.Supplier;

/**
 * Controller for TicketOption creation JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class TicketOptionController extends ControllerBase {
    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public TicketOptionController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    TextField nameField, priceField;
    @FXML
    Label endLabel;

    private String optionName;
    private Integer optionPrice;


    /**
     * Changes scene to existingPlanes.fxml.
     */
    @FXML
    public void viewOptions() {
        sceneManager.get().changeScene("existingTicketOptions");
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
    public void storeOption() {
        if (optionPrice != null && optionName != null && !optionPrice.equals("") && !optionName.equals("")) {
            var option = getTicketOptionManager().createTicketOption(optionName, optionPrice);
            getTicketOptionManager().save(option);
            endLabel.setText("Created ticket option " + optionName + " price: " + optionPrice + "€");
            nameField.setText("");
            priceField.setText("");
        } else {
            endLabel.setText("Could not create ticket option!");
        }
    }

    /**
     * Action method for nameField
     */
    @FXML
    public void pickName() {
        optionName = nameField.getText();
    }

    /**
     * Action method for priceField
     */
    @FXML
    public void pickPrice() {
        var value = priceField.getText();
        if (ControllerUtils.isInteger(value)) {
            optionPrice = Integer.parseInt(value);
            if (optionPrice <= 0 || optionPrice > 1000) {
                priceField.setText("");
                optionPrice = null;
            }
        } else {
            priceField.setText("");
            optionPrice = null;
        }
    }

}
