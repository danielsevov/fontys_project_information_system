package fontys.frontend.controllers;

import businessentitiesapi.*;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import helpers.ControllerUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Controller for KPI Dashboard: Customers JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the raw input
 * from the app user.
 */

public class CustomerDashboardController extends ControllerBase implements Initializable {
    /**
     * Constructor for passing sceneManager and businessLogicAPI to the controller.
     */
    public CustomerDashboardController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    @FXML
    Label customersField, activeCustomersField, averageAgeField, referralField, idField, nameField, emailField,
            birthdateField, ageField, bookingsField, ticketsField, averageOptionsField, ticketTypeField, ticketOptionField, inFlightField;
    @FXML
    ComboBox<String> customerField;
    @FXML
    GridPane singleGrid, multiGrid;

    private List<Customer> customers = new ArrayList<>();

    /**
     * Changes scene to managerHub.fxml.
     */
    @FXML
    public void backToHub() {
        resetCustomer();
        sceneManager.get().changeScene("managerHub");
    }

    /**
     * Action function for picking customer.
     */
    @FXML
    public void pickCustomer() {
        var value = customerField.getValue();
        if(customers.stream().anyMatch(s -> s.getName().equals(value))){
            singleGrid.setVisible(true);
            var customer = customers.stream().filter(s->s.getName().equals(value)).collect(Collectors.toList()).get(0);
            idField.setText(String.valueOf(customer.getId()));
            nameField.setText(String.valueOf(customer.getName()));
            emailField.setText(String.valueOf(customer.getEmail()));
            birthdateField.setText(String.valueOf(customer.getBirthDate()));
            var age = ChronoUnit.YEARS.between(customer.getBirthDate(), LocalDateTime.now());
            String additional = "";
            if(age==1) additional=" year old";
            if(age!=1) additional=" years old";
            ageField.setText(age + additional);

            multiGrid.setVisible(true);
            var bookingSize = getBookingManager().getByColumnValues("customer", customer.getId()).size();
            var currentTickets = getTicketManager().getByColumnValues("customer", customer.getId());
            var types = currentTickets.stream().map(Ticket::getTicketType).collect(Collectors.toList());
            List<TicketOption> options = new ArrayList<>();
            var sum = Duration.ZERO;
            for(Ticket a : currentTickets){
                options.addAll(getBookedOptionManager().getByColumnValues("ticket", a.getId())
                        .stream().map(BookedOption::getTicketOption).collect(Collectors.toList()));
                sum = sum.plus(a.getFlight().getDuration());
            }
            var cost = options.stream().mapToDouble(TicketOption::getPrice).sum();
            var avg = cost/currentTickets.size();
            inFlightField.setText(ControllerUtils.durationToString(sum));
            var commonOption = ControllerUtils.mostCommon(options);
            if(commonOption==null){
                ticketOptionField.setText("-");
            }
                else{
                    ticketOptionField.setText(commonOption.getName());
            }
            var commonType = ControllerUtils.mostCommon(types);
            if(commonOption==null){
                ticketTypeField.setText("-");
            }
            else{
                if (commonType != null) {
                    ticketTypeField.setText(commonType.getName());
                }
            }
            averageOptionsField.setText(ControllerUtils.round(avg, 2) + "€");
            ticketsField.setText(String.valueOf(currentTickets.size()));
            bookingsField.setText(String.valueOf(bookingSize));
        }
        else{
            resetCustomer();
        }
    }

    public void resetCustomer(){
        customerField.setValue("");
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        birthdateField.setText("");
        singleGrid.setVisible(false);
        inFlightField.setText("");
        ticketOptionField.setText("");
        ticketTypeField.setText("");
        averageOptionsField.setText("");
        ticketsField.setText("");
        bookingsField.setText("");
        multiGrid.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customers = getCustomerManager().getAll();
        customersField.setText(String.valueOf(customers.size()));
        List<Ticket> tickets = getTicketManager().getAll();
        long age = 0;
        int activeSize = 0, nonSingleTickets = 0;
        for(Customer a : customers){
            var size = tickets.stream().filter(s -> s.getCustomer().getId() == a.getId()).count();
            age += ChronoUnit.YEARS.between(a.getBirthDate(), LocalDateTime.now());
            if(size>1){
                nonSingleTickets++;
            }
            if(size>0){
                activeSize++;
            }
        }
        averageAgeField.setText(age / customers.size() + " years");
        activeCustomersField.setText(String.valueOf(activeSize));
        double rate = nonSingleTickets*100;
        rate /= tickets.size();
        referralField.setText(ControllerUtils.round(rate, 2) + "%");

        resetCustomer();
        customerField.setItems(ControllerUtils.entitiesToObservableList(customers.stream(), Customer::getName));
    }
}
