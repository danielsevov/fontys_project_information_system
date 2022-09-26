package fontys.frontend.controllers;

import businessentitiesapi.*;
import businesslogic.BusinessLogicAPI;
import businesslogic.bulkvalidator.BulkException;
import businesslogic.validation.TicketRegistrationHandler;
import fontys.frontend.SceneManager;
import helpers.ControllerUtils;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.homberghp.fxuiscraper.FXUIScraper;

import java.net.URL;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static helpers.ControllerUtils.entitiesToObservableList;
import static javafx.collections.FXCollections.observableArrayList;

/**
 * Controller for Ticket Creation JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the input
 * from the app user.
 */
public class TicketController extends ControllerBase implements Initializable {

    /**
     * Super constructor.
     */
    public TicketController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    private Stage stage;
    private Flight flight;
    private Booking booking;
    private TicketType type;
    private double extras = 0;
    private String seatNumber;
    private List<Ticket> tickets = new ArrayList<>();
    private List<TicketOption> ticketOptions = new ArrayList<>();
    private final List<TicketOption> bookedOptions = new ArrayList<>();
    Map<Character, Double> multipliers = new HashMap<>();

    @FXML
    VBox root;
    @FXML
    Label endLabel, titleText, flightLabel, customerLabel, classLabel;
    @FXML
    ComboBox<Flight> flightField;
    @FXML
    ComboBox<Customer> customerField;
    @FXML
    ComboBox<String> classField, optionField;

    private final TicketRegistrationHandler handler = new TicketRegistrationHandler();
    private final FXUIScraper scraper = () -> root;
    private List<Node> allNodes = List.of();


    /**
     * Initializes scene for port.
     */
    public void setBooking(Integer id, Stage stage) {
        booking = getBookingManager().get(id).get();
        titleText.setText("Ticket for booking " + id);
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        classField.disableProperty().bind(flightField.valueProperty().isNull());

        var list = entitiesToObservableList(getFlightManager().getAll().stream(), f -> f);
        list.add(null);
        flightField.setItems(list);

        var list2 = entitiesToObservableList(getCustomerManager().getAll().stream(), f -> f);
        list2.add(null);
        customerField.setItems(list2);

        ticketOptions = getTicketOptionManager().getAll();
        var list3 = entitiesToObservableList(ticketOptions.stream(), TicketOption::getName);
        list3.add("");
        optionField.setItems(list3);

        multipliers.put('F', 0.1);
        multipliers.put('B', 0.3);
        multipliers.put('E', 0.6);
    }

    private Ticket createTicket() {
        // At this point, input is already validated.
        return getTicketManager()
                .createTicket(
                        flightField.getValue(),
                        customerField.getValue(),
                        seatNumber,
                        booking,
                        type,
                        calculatePrice()
                );
    }

    private Map<String, String> scrapeFields() {
        return allNodes.stream().collect(Collectors.toMap(Node::getId, FXUIScraper::toString));
    }

    @FXML
    public void storeTicket() {
        allNodes = scraper.inputControlStream(x -> true, Set.of()).collect(Collectors.toList());
        var keyValues = scrapeFields();
        try {
            handler.validateTicketInfo(keyValues);
            getTicketManager().save(createTicket());
            var ticket = getTicketManager().get(getTicketManager().lastId()).get();
            for (TicketOption option : bookedOptions) {
                var o = getBookedOptionManager().createBookedOption(ticket, option);
                getBookedOptionManager().save(o);
            }
            endLabel.setText("Ticket created successfully!");
            backToView();
        } catch (BulkException bex) {
            endLabel.setText("Could not create ticket!");
            displayErrors(bex, allNodes);
        }
    }

    @FXML
    public void pickFlight() {
        flight = flightField.getValue();
        flightLabel.setText(flight.toString());

        ObservableList<String> list = observableArrayList();

        tickets = getTicketManager().getByColumnValues("flight", flight.getId());
        var flightCap = flight.getPlane().getMaxCapacity();
        if (tickets.stream().filter(s -> s.getTicketType().getId() == 1).count() < flightCap * 0.1) {
            list.add("First Class");
        }
        if (tickets.stream().filter(s -> s.getTicketType().getId() == 2).count() < flightCap * 0.3) {
            list.add("Business Class");
        }
        if (tickets.stream().filter(s -> s.getTicketType().getId() == 3).count() < flightCap * 0.6) {
            list.add("Economy Class");
        }
        list.add("");
        classField.setItems(list);
    }

    @FXML
    public void pickClass() {
        var value = classField.getValue();
        if (value != null && !value.equals("")) {
            type = getTicketTypeManager().getByColumnValues("name", value).get(0);
            tickets = getTicketManager().getByColumnValues("flight", flight.getId());
            tickets = tickets.stream()
                    .filter(s -> s.getTicketType().getName()
                            .equals(type.getName())).collect(Collectors.toList());

            double currentMultiplier = multipliers.get(type.getName().charAt(0));

            List<Integer> seats = new ArrayList<>();
            int maxSeatNumber = 1, countOfSeatsSold = 0, firstFreeSeatNumber = 1;
            for (Ticket a : tickets) {
                var currentSeatNumber = a.getSeatNumber();
                int currentSeatNumberInteger = 1;

                if (ControllerUtils.isInteger(currentSeatNumber.substring(1))) {
                    currentSeatNumberInteger = Integer.parseInt(currentSeatNumber.substring(1));
                }

                if (maxSeatNumber < currentSeatNumberInteger) maxSeatNumber = currentSeatNumberInteger;

                seats.add(currentSeatNumberInteger);
                countOfSeatsSold++;
            }
            for (int i = 1; i <= maxSeatNumber + 1; i++) {
                if (!seats.contains(i)) {
                    firstFreeSeatNumber = i;
                    break;
                }
            }

            if (countOfSeatsSold < flight.getPlane().getMaxCapacity() * currentMultiplier) {
                seatNumber = type.getName().charAt(0) + String.valueOf(firstFreeSeatNumber);
            }
        } else {
            classLabel.setText("");
            seatNumber = null;
        }
    }

    @FXML
    public void pickExtra() {
        var value = optionField.getValue();
        if (value != null && !value.equals("")) {
            for (TicketOption option : ticketOptions) {
                if (option.getName().equals(optionField.getValue())) {
                    //add new booked option to list
                    bookedOptions.add(option);
                    endLabel.setText(option.getName() + " option added successfully!");
                    //add value of new option to ticket price
                    var selectedOption = (TicketOption) ticketOptions.stream().filter(op -> op.getName().equals(option.getName())).collect(Collectors.toList()).get(0);
                    extras += selectedOption.getPrice();
                    //remove added option from list of available options
                    ticketOptions = ticketOptions.stream().filter(op -> !op.getName().equals(option.getName())).collect(Collectors.toList());
                    var list = entitiesToObservableList(ticketOptions.stream(), TicketOption::getName);
                    list.add("");
                    optionField.setItems(list);
                    optionField.setValue("");
                    break;
                }
            }
        }
        //disable fields when no more options are available
        if (optionField.getItems().size() == 1) {
            optionField.setDisable(true);
        }
    }

    public double calculatePrice() {
        var day = flight.getDepartureDatetime().getDayOfWeek().getValue();
        var dailyDiscount = getDailyDiscountManager().get(day).get().getMultiplier();
        return flight.getPrice() * type.getMultiplier() * dailyDiscount + extras;
    }

    @FXML
    public void backToView() {
        stage.close();
    }
}
