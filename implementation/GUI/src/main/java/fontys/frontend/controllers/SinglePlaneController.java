package fontys.frontend.controllers;

import businessentitiesapi.Airplane;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class SinglePlaneController extends ControllerBase implements Initializable, Viewable {

    /**
     * Super constructor.
     */
    public SinglePlaneController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    /*Declaration of all necessary variables*/
    private Stage stage;
    private final Stage stag = new Stage();
    private String registrationNumber;
    private Integer maximumCapacity;
    private Integer planeId;
    private Optional<Airplane> plane;

    @FXML
    private TextField newRegistrationNumber;
    @FXML
    private TextField newMaximumCapacity;
    @FXML
    private Label currentRegistrationNumber, currentMaximumCapacity, titleText, endLabel;

    /*Initializes Scene for Plane*/
    public void setPlane(Integer id, Stage stage) {
        plane = getAirplaneManager().get(id);
        planeId = id;
        currentRegistrationNumber.setText(plane.get().getRegistrationNumber());
        currentMaximumCapacity.setText(String.valueOf(plane.get().getMaxCapacity()));
        titleText.setText("Airplane ID : " + planeId + "         ");
        this.stage = stage;
    }

    public void resetPlane() {
        plane = getAirplaneManager().get(planeId);
        currentRegistrationNumber.setText(plane.get().getRegistrationNumber());
        currentMaximumCapacity.setText(String.valueOf(plane.get().getMaxCapacity()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /*Closes the current stage*/
    @FXML
    private void backToView() {
        stage.close();

    }

    @FXML
    private void pickRegNumber() {
        registrationNumber = newRegistrationNumber.getText();
        if (registrationNumber.length() < 3 || registrationNumber.length() > 7) {
            newRegistrationNumber.setText("");
            registrationNumber = null;
        }

    }

    @FXML
    private void pickMaxCap() {
        maximumCapacity = Integer.valueOf(newMaximumCapacity.getText());
        if (maximumCapacity <= 0 || maximumCapacity > 853) {
            newMaximumCapacity.setText("");
            maximumCapacity = null;
        }
    }

    /*Creates a confirmation window for deletion*/
    @FXML
    private void deletePlane() {
        createConfirmationWindow();
    }

    /*Update changes if any*/
    @FXML
    private void storeChanges() {
        if (registrationNumber == null && maximumCapacity == null) {
            endLabel.setText("Nothing new to store!");
        } else {
            //do something to update values
            var newPlane = getAirplaneManager()
                    .createAirplane(
                            planeId,
                            currentRegistrationNumber.getText(), Integer.parseInt(currentMaximumCapacity.getText()));
            if (registrationNumber != null)
                getAirplaneManager().updateColumnFor(newPlane, "registration_number", registrationNumber);
            if (maximumCapacity != null)
                getAirplaneManager().updateColumnFor(newPlane, "max_capacity", maximumCapacity);
            resetPlane();
            endLabel.setText("Changes stored!");
        }
    }

    /*Scene for the ConfirmationWindow*/
    public void createConfirmationWindow() {

        VBox mainPane = new VBox();
        Button deleteButton = new Button("Delete");
        Button cancelButton = new Button("Cancel");
        Label label = new Label(" Are you sure you want to delete this Airplane?");
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
            getAirplaneManager().deleteById(planeId);
            stag.close();
            stage.close();
        });
        cancelButton.setOnAction(e -> stag.close());

        stag.setScene(new Scene(mainPane, 330, 110));
        stag.show();
    }

    @Override
    public void setFocusForId(int id, Stage stage) {
        setPlane(id, stage);
    }
}
