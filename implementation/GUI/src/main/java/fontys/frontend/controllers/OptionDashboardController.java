package fontys.frontend.controllers;

import businessentitiesapi.BookedOption;
import businessentitiesapi.TicketOption;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import helpers.ControllerUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Controller for KPI Dashboard: Ticket Options JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class OptionDashboardController extends ControllerBase implements Initializable {
    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public OptionDashboardController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    Label idField, nameField, priceField, optionsField, earningsField,
            pickedField, profitField, earningField, averageField, bookedField;
    @FXML
    ComboBox<String> optionField;
    @FXML
    GridPane singleGrid, multiGrid;

    private List<TicketOption> options = new ArrayList<>();
    private List<BookedOption> booked = new ArrayList<>();

    /**
     * Changes scene to managerHub.fxml.
     */
    @FXML
    public void backToHub() {
        resetOption();
        sceneManager.get().changeScene("managerHub");
    }

    /**
     * Action function for picking ticket option.
     */
    @FXML
    public void pickOption() {
        var value = optionField.getValue();
        if(options.stream().anyMatch(s -> s.getName().equals(value))){
            singleGrid.setVisible(true);
            var option = options.stream().filter(s->s.getName().equals(value)).collect(Collectors.toList()).get(0);
            idField.setText(String.valueOf(option.getId()));
            nameField.setText(option.getName());
            priceField.setText(String.valueOf(option.getPrice()));
            multiGrid.setVisible(true);
            var currentOptions = booked.stream().filter(s->s.getTicketOption().getName().equals(option.getName())).collect(Collectors.toList());
            var earn = currentOptions.stream().mapToDouble(s->s.getTicketOption().getPrice()).sum();
            var count = currentOptions.size();
            earningField.setText(earn + "€");
            bookedField.setText(String.valueOf(count));
            var flights = getFlightManager().size();
            var avg = earn/flights;
            averageField.setText(ControllerUtils.round(avg, 2) + "€");
        }
        else{
            resetOption();
        }
    }

    public void resetOption(){
        bookedField.setText("");
        averageField.setText("");
        earningField.setText("");
        singleGrid.setVisible(false);
        nameField.setText("");
        idField.setText("");
        priceField.setText("");
        multiGrid.setVisible(false);
        optionField.setValue("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        options = getTicketOptionManager().getAll();
        optionsField.setText(String.valueOf(options.size()));
        booked = getBookedOptionManager().getAll();
        var earn = booked.stream().mapToDouble(s->s.getTicketOption().getPrice()).sum();
        earningsField.setText(ControllerUtils.round(earn, 2) + "€");
        int max = 0, maxPr = 0;
        String opt = "-", optPr = "-";
        for(TicketOption o : options){
            var c = (int) booked.stream().filter(s->s.getTicketOption().getId()==o.getId()).count();
            if(c>max){
                max = c;
                opt = o.getName();
            }
            var curPr = c*o.getPrice();
            if(curPr>maxPr){
                maxPr = curPr;
                optPr = o.getName();
            }
        }
        pickedField.setText(opt);
        profitField.setText(optPr);
        resetOption();
        optionField.setItems(ControllerUtils.entitiesToObservableList(options.stream(), TicketOption::getName));
    }
}
