package fontys.frontend.controllers;

import businessentitiesapi.DailyDiscount;
import businessentitiesapi.Manager;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import fontys.frontend.observables.ObservableDailyDiscount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static helpers.ControllerUtils.*;

/**
 * Controller for Existing Discounts List JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the input
 * from the app user.
 */
public class ExistingDailyDiscountsController extends SearchableController<DailyDiscount, ObservableDailyDiscount> implements Initializable {
    /**
     * Super constructor.
     */
    public ExistingDailyDiscountsController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    DayOfWeek day;
    double multiplier;
    @FXML
    ComboBox<String> dayField = new ComboBox<>();
    @FXML
    TextField multiplierField = new TextField();
    @FXML
    Label label = new Label();
    @FXML
    Button applyButton = new Button();

    @Override
    Function<? super DailyDiscount, ? extends ObservableDailyDiscount> entityCreator() {
        return ObservableDailyDiscount::fromDailyDiscount;
    }

    @Override
    Manager<DailyDiscount, Integer> getManager() {
        return getDailyDiscountManager();
    }


    @SuppressWarnings("unchecked")
    @Override
    void additionalSetup() {
        table.setPlaceholder(new Label("No registered airplanes in the system."));

        table.getColumns()
                .addAll(makeColumn("id", "Discount ID", 90),
                        makeColumn("day", "Day of the Week", 230),
                        makeColumn("multiplier", "Price Multiplier", 200));
    }

    /**
     * FX action function for switching to officerHub.fxml scene.
     */
    @FXML
    private void backToHub() {
        sceneManager.get().changeScene("officerHub");
    }

    /**
     * FX action function for entering new multiplier.
     */
    @FXML
    private void enterMultiplier() {
        var value = multiplierField.getText();
        var opt = tryParseDouble(value);
        if(opt.isPresent()){
            multiplier = opt.getAsDouble();
            if(multiplier<=0){
                multiplier = 0;
                multiplierField.setText("");
                applyButton.setVisible(false);
            }
            else{
                applyButton.setVisible(true);
            }
        }
        else{
            multiplierField.setText("");
            applyButton.setVisible(false);
        }
    }

    /**
     * FX action function for picking day of the week.
     */
    @FXML
    private void pickDay() {
        String value = dayField.getValue();
        if(!value.equals("")) day = DayOfWeek.valueOf(value);
        label.setVisible(true);
    }

    /**
     * FX action function for storing the changes.
     */
    @FXML
    private void applyChanges() {
        var a = getDailyDiscountManager().getAll();
        var d = getDailyDiscountManager().get(day.getValue()).get();
        getDailyDiscountManager().updateColumnFor(d, "multiplier", multiplier);
        multiplierField.setText("");
        dayField.setValue("");
        label.setVisible(false);
        applyButton.setVisible(false);
        resetEntities();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize();
        ObservableList<String> list = FXCollections.observableArrayList();
        var days = Arrays.stream(DayOfWeek.values()).map(Enum::name).collect(Collectors.toList());
        list.addAll(days);
        dayField.setItems(list);
        label.setVisible(false);
        applyButton.setVisible(false);
    }
}
