package fontys.frontend.controllers;

import businessentitiesapi.TicketOption;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class SingleOptionController extends ControllerBase implements Initializable, Viewable {

    /**
     * Super constructor.
     */
    public SingleOptionController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    /*Declaration of all necessary variables*/
    private Stage stage = null;
    private final Stage stag = new Stage();
    private Integer optionId = null;
    private Optional<TicketOption> option;

    @FXML
    private Label nameField, priceField, endLabel, titleText;

    /*Initializes Scene for Plane*/
    public void setOption(Integer id, Stage stage) {
        option = getTicketOptionManager().get(id);
        optionId = id;
        nameField.setText(option.get().getName());
        priceField.setText(String.valueOf(option.get().getPrice()));
        titleText.setText("Ticket Option ID : " + optionId + "         ");
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /*Closes the current stage*/
    @FXML
    private void backToView() {
        stage.close();
    }

    /*Creates a confirmation window for deletion*/
    @FXML
    private void deleteOption() {
        createConfirmationWindow();
    }

    /*Scene for the ConfirmationWindow*/
    public void createConfirmationWindow() {

        VBox mainPane = new VBox();
        Button deleteButton = new Button("Delete");
        Button cancelButton = new Button("Cancel");
        Label label = new Label(" Are you sure you want to delete this Option?");
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
            getTicketOptionManager().deleteById(optionId);
            this.stag.close();
            this.stage.close();
        });
        cancelButton.setOnAction(e -> this.stag.close());

        stag.setScene(new Scene(mainPane, 330, 110));
        stag.show();
    }

    @Override
    public void setFocusForId(int id, Stage stage) {
        setOption(id, stage);
    }
}
