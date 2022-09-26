package fontys.frontend.controllers;

import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import helpers.ControllerUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.function.Supplier;

/**
 * Controller for Airplane creation JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class PlaneController extends ControllerBase {
    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public PlaneController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    TextField regNumberField, maxCapacityField;
    @FXML
    Label endLabel;

    private String regNum;
    private Integer maxCap;

    /**
     * Changes scene to existingPlanes.fxml.
     */
    @FXML
    public void viewPlanes() {
        sceneManager.get().changeScene("existingPlanes");
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
    public void storePlane() {
        if (maxCap != null && regNum != null) {
            System.out.println(regNum + " " + maxCap);
            var plane = getAirplaneManager().createAirplane(regNum, maxCap);
            getAirplaneManager().save(plane);
            endLabel.setText("Created airplane " + regNum + " m.c.  " + maxCap);
        } else {
            endLabel.setText("Could not create airplane!");
        }
    }

    /**
     * Action method for regNumberField
     */
    @FXML
    public void regNumber() {
        regNum = regNumberField.getText();
        if (regNum.length() < 3 || regNum.length() > 7) {
            regNumberField.setText("");
            regNum = null;
        }
    }

    /**
     * Action method for maxCapacityField
     */
    @FXML
    public void maxCapacity() {
        var value = maxCapacityField.getText();
        if (ControllerUtils.isInteger(value)) {
            maxCap = Integer.parseInt(value);
            if(maxCap <= 0 || maxCap > 853){
                maxCapacityField.setText("");
                maxCap = null;
            }
        }
        else{
            maxCapacityField.setText("");
            maxCap = null;
        }
    }

}
