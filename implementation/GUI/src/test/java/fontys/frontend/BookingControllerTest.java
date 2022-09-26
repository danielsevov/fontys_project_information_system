package fontys.frontend;

import businessentitiesapi.Booking;
import businessentitiesapi.Ticket;
import businesslogic.BookingImpl;
import fontys.frontend.observables.ObservableBooking;
import fontys.frontend.observables.ObservableTicket;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.testfx.api.FxRobot;
import utils.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static utils.TestData.*;

@MockitoSettings(strictness = Strictness.LENIENT)
public class BookingControllerTest extends GUITestBase {
    protected BookingControllerTest() {
        super("bookingReg");
    }

    private final List<Ticket> ticketList = new ArrayList<>(tickets);
    private final List<Booking> bookingsList = new ArrayList<>(bookings);
    private int id = 13;
    private final int bid = 7;

    @Override
    void setupScene() {
        mockedGetAll();
        when(dailyDiscountManager.get(1)).thenReturn(Optional.ofNullable(dailyDiscounts.get(0)));
        when(dailyDiscountManager.get(2)).thenReturn(Optional.ofNullable(dailyDiscounts.get(1)));
        when(dailyDiscountManager.get(3)).thenReturn(Optional.ofNullable(dailyDiscounts.get(2)));
        when(dailyDiscountManager.get(4)).thenReturn(Optional.ofNullable(dailyDiscounts.get(3)));
        when(dailyDiscountManager.get(5)).thenReturn(Optional.ofNullable(dailyDiscounts.get(4)));
        when(dailyDiscountManager.get(6)).thenReturn(Optional.ofNullable(dailyDiscounts.get(5)));
        when(dailyDiscountManager.get(7)).thenReturn(Optional.ofNullable(dailyDiscounts.get(6)));
        when(customerManager.getAll()).thenReturn(customers);
        when(customerManager.get(1)).thenReturn(Optional.of(customers.get(0)));
        when(customerManager.get(2)).thenReturn(Optional.of(customers.get(1)));
        when(customerManager.get(3)).thenReturn(Optional.of(customers.get(2)));
        when(customerManager.get(4)).thenReturn(Optional.of(customers.get(3)));

        when(flightManager.get(1)).thenReturn(Optional.of(flights.get(0)));
        when(flightManager.get(2)).thenReturn(Optional.of(flights.get(1)));

        when(bookingManager.getAll()).thenReturn(bookingsList);
        when(bookingManager.createBooking(customers.get(0))).thenReturn(new BookingImpl(bid, customers.get(0)));
        when(bookingManager.lastId()).thenReturn(bid);
        when(bookingManager.get(bid)).thenReturn(Optional.of(new BookingImpl(bid, customers.get(0))));
        when(bookingManager.save(any(Booking.class))).thenAnswer(invocation -> {
            Booking args = invocation.getArgument(0);
            bookingsList.add(args);
            return null;
        });

        when(ticketTypeManager.getByColumnValues("name", "First Class")).thenReturn((List.of(types.get(0))));
        when(ticketTypeManager.getByColumnValues("name", "Business Class")).thenReturn((List.of(types.get(1))));
        when(ticketTypeManager.getByColumnValues("name", "Economy Class")).thenReturn((List.of(types.get(2))));

        when(ticketOptionManager.getAll()).thenReturn(options);

        when(ticketManager.getAll()).thenReturn(ticketList);
        when(ticketManager.lastId()).thenReturn(id);
        when(ticketManager.get(id)).thenReturn(Optional.of(ticketList.get(ticketList.size() - 1)));

        when(ticketManager.getByColumnValues("flight", 1)).thenReturn(ticketList.stream().filter(s -> s.getFlight().getId()==1).collect(Collectors.toList()));
        when(ticketManager.getByColumnValues("flight", 1)).thenReturn(ticketList.stream().filter(s -> s.getFlight().getId()==2).collect(Collectors.toList()));
        when(ticketManager.getByColumnValues("flight", 1)).thenReturn(ticketList.stream().filter(s -> s.getFlight().getId()==3).collect(Collectors.toList()));
        when(ticketManager.getByColumnValues("booking", 7)).thenReturn(ticketList.stream().filter(s -> s.getBooking().getId()==7).collect(Collectors.toList()));

        when(ticketManager.save(any(Ticket.class))).thenAnswer(invocation -> {
            Ticket args = invocation.getArgument(0);
            ticketList.add(args);
            id++;
            return null;
        });

        when(ticketManager.createTicket(any(), any(), any(), any(), any(), anyDouble())).thenAnswer(invocation ->
                EntityUtils.createTicket(id, invocation.getArgument(0),
                        invocation.getArgument(1), invocation.getArgument(2),
                        invocation.getArgument(3), invocation.getArgument(4), invocation.getArgument(5))
        );

    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    void clickOnDropdown(String controlId, String textToSelect, FxRobot robot) {
        ComboBox<?> combo = robot.lookup(controlId).queryComboBox();
        final int index = combo.getItems().indexOf(textToSelect);
        final int indexSel = combo.getSelectionModel().getSelectedIndex();
        robot.clickOn(combo);

        if (index > indexSel) {
            for (int i = indexSel; i < index; i++) {
                robot.type(KeyCode.DOWN);
            }
        } else {
            for (int i = indexSel; i > index; i--) {
                robot.type(KeyCode.UP);
            }

        }

        if (!isInteger(textToSelect) && !textToSelect.equals("")) robot.type(KeyCode.UP);
        robot.type(KeyCode.ENTER);
    }

    @ParameterizedTest
    @CsvSource({
            // buyerName, flightId, customerId, seatClass, expectedBoolean
            "'Ivan Ivanov', '1', '1', 'Business Class', true",
            "'Mark Spencer', '2', '3', 'First Class', true",
            "'Philip Ros', '2', '4', 'Business Class', true",

            "'John Jameson', '1', '2', '', false",
            "'John Jameson', '', '', '', false"
    })
    void testAddTicketRestrictions(String buyer, String flightId, String customerId, String seatClass, boolean expected, FxRobot robot) {
        clickOnDropdownText("#buyerField", buyer, robot);
        robot.clickOn("#addTicketButton");
        if (!flightId.equals("")) clickOnDropdown("#flightField", flightId, robot);
        if (!customerId.equals("")) clickOnDropdown("#customerField", customerId, robot);
        if (!seatClass.equals("")) clickOnDropdown("#classField", seatClass, robot);
        robot.clickOn("#storeButton");
        if (!expected) {
            verify(ticketManager, times(0)).save(any());
            var backButton = robot.lookup("#backButton").queryButton();
            robot.clickOn(backButton);

        } else {
            verify(ticketManager, times(1)).save(any());
        }
    }

    @ParameterizedTest
    @CsvSource({
            // buyerName, flightId, customerId, seatClass, expectedBoolean
            "'John Jameson', false",
            "'', false"
    })
    void testCreateBookingRestrictions(String buyer, boolean expected, FxRobot robot) {
        clickOnDropdownText("#buyerField", buyer, robot);
        robot.clickOn("#createBooking");
        if (!expected) {
            String endMessage = robot.lookup("#endLabel").queryAs(Label.class).getText();
            assertThat(endMessage).contains("Could not create booking!");
        }
    }

    @ParameterizedTest
    @CsvSource({
            // buyerName, flightId, customerId, seatClass, expectedBoolean
            "'Ivan Ivanov', 'Extra leg room', 'More luggage', 'Dinner', 1",
            "'Ivan Ivanov', 'Extra leg room', 'More luggage', '', 2",
            "'Ivan Ivanov', 'Dinner', '', '', 3",
            "'Ivan Ivanov', '', '', '', 4"
    })
    void testAddExtra(String buyer, String firstOption, String secondOption, String thirdOption, int expected, FxRobot robot) {
        clickOnDropdownText("#buyerField", buyer, robot);
        robot.clickOn("#addTicketButton");
        if (!firstOption.equals("")) {
            clickOnDropdownText("#optionField", firstOption, robot);
        }
        if (!secondOption.equals("")) clickOnDropdownText("#optionField", secondOption, robot);
        if (!thirdOption.equals("")) clickOnDropdownText("#optionField", thirdOption, robot);

        var optionBox = robot.lookup("#optionField").queryComboBox();
        assertThat(optionBox.getItems().size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            // buyerName, flightId, customerId, seatClass, expectedBoolean
            "'Ivan Ivanov', '1', '1', 'Business Class', '200.0', true",
            "'Ivan Ivanov', '1', '1', 'First Class', '300.0', true",
            "'Ivan Ivanov', '1', '1', 'Economy Class', '100.0', true",
    })
    void testCreateBooking(String buyer, String flightId, String customerId, String seatClass, String price, boolean expected, FxRobot robot) {
        clickOnDropdownText("#buyerField", buyer, robot);
        robot.clickOn("#addTicketButton");
        clickOnDropdown("#flightField", flightId, robot);
        clickOnDropdown("#customerField", customerId, robot);
        clickOnDropdown("#classField", seatClass, robot);
        robot.clickOn("#storeButton");

        //check error message
        if (!expected) {
            robot.clickOn("#createBooking");
            String endMessage = robot.lookup("#endLabel").queryAs(Label.class).getText();
            assertThat(endMessage).contains("Could not create booking!");
        }
        //check new ticket in table
        else {
            var table = robot.lookup("#ticketTable").queryTableView();
            var ticket = (ObservableTicket) table.getItems().get(0);
            SoftAssertions soft = new SoftAssertions();
            soft.assertThat(ticket.getId()).isEqualTo(13);
            soft.assertThat(ticket.getFlight()).isEqualTo(flights.get(Integer.parseInt(flightId) - 1).toString());
            soft.assertThat(ticket.getCustomer()).isEqualTo(customers.get(Integer.parseInt(customerId) - 1).getName());
            soft.assertThat(ticket.getBooking()).isEqualTo("7");
            soft.assertThat(ticket.getPrice()).isEqualTo(price);
            soft.assertAll();
        }

        robot.clickOn("#createBooking");

        var bookTable = robot.lookup("#table").queryTableView();
        var booking = (ObservableBooking) bookTable.getItems().get(bid - 1);

        // check table for the new booking
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(booking.getId()).isEqualTo(bid);
        soft.assertThat(booking.getCustomer()).isEqualTo(buyer);
        soft.assertAll();
    }

    @ParameterizedTest
    @CsvSource({
            // buyerName, flightId, customerId, seatClass, expectedBoolean
            "'Ivan Ivanov', '1', '1', 'Business Class', 'Extra leg room', 'More luggage', '262.0', true",
            "'Ivan Ivanov', '1', '1', 'First Class', 'Dinner', 'More luggage', '337.0', true",
            "'Ivan Ivanov', '1', '1', 'Economy Class', 'Extra leg room', 'Dinner', '175.0', true",
    })
    void testCreateBookingWithExtras(String buyer, String flightId, String customerId, String seatClass, String firstOption, String secondOption, String price, boolean expected, FxRobot robot) {
        clickOnDropdownText("#buyerField", buyer, robot);
        robot.clickOn("#addTicketButton");
        clickOnDropdown("#flightField", flightId, robot);
        clickOnDropdown("#customerField", customerId, robot);
        clickOnDropdown("#classField", seatClass, robot);
        clickOnDropdownText("#optionField", firstOption, robot);
        clickOnDropdownText("#optionField", secondOption, robot);
        robot.clickOn("#storeButton");

        //check error message
        if (!expected) {
            robot.clickOn("#createBooking");
            String endMessage = robot.lookup("#endLabel").queryAs(Label.class).getText();
            assertThat(endMessage).contains("Could not create booking!");
        }
        //check new ticket in table
        else {
            var table = robot.lookup("#ticketTable").queryTableView();
            var ticket = (ObservableTicket) table.getItems().get(0);
            SoftAssertions soft = new SoftAssertions();
            soft.assertThat(ticket.getId()).isEqualTo(13);
            soft.assertThat(ticket.getFlight()).isEqualTo(flights.get(Integer.parseInt(flightId) - 1).toString());
            soft.assertThat(ticket.getCustomer()).isEqualTo(customers.get(Integer.parseInt(customerId) - 1).getName());
            soft.assertThat(ticket.getBooking()).isEqualTo("7");
            soft.assertThat(ticket.getPrice()).isEqualTo(price);
            soft.assertAll();
        }

        robot.clickOn("#createBooking");

        var bookTable = robot.lookup("#table").queryTableView();
        var booking = (ObservableBooking) bookTable.getItems().get(bid - 1);

        // check table for the new booking
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(booking.getId()).isEqualTo(bid);
        soft.assertThat(booking.getCustomer()).isEqualTo(buyer);
        soft.assertAll();
    }

    @ParameterizedTest
    @CsvSource({
            // buyerName, flightId, customerId, seatClass, expectedBoolean
//            "'Ivan Ivanov', '1', '1', '1', 'First Class', 'Economy Class', 'F1', 'E7'",
//            "'Ivan Ivanov', '1', '1', '1', 'Economy Class', 'Business Class', 'E7', 'B1'",
//            "'Ivan Ivanov', '1', '1', '1', 'Business Class', 'Business Class', 'B1', 'B1'",
//            "'Ivan Ivanov', '1', '1', '1', 'Economy Class', 'Economy Class', 'E7', 'E7'",
            "'Ivan Ivanov', '1', '1', '1', 'First Class', 'First Class', 'F1', 'F1'"


    })
    void testCreateBookingWithMoreTickets(String buyer, String flightId, String firstCustomerId, String secondCustomerId, String fseatClass, String sseatClass, String fValue, String sValue, FxRobot robot) {
        clickOnDropdownText("#buyerField", buyer, robot);

        robot.clickOn("#addTicketButton");
        clickOnDropdown("#flightField", flightId, robot);
        clickOnDropdown("#customerField", firstCustomerId, robot);
        clickOnDropdownText("#classField", fseatClass, robot);

        robot.clickOn("#storeButton");

        robot.clickOn("#addTicketButton");
        clickOnDropdown("#flightField", flightId, robot);
        clickOnDropdown("#customerField", secondCustomerId, robot);
        clickOnDropdown("#classField", sseatClass, robot);
        robot.clickOn("#storeButton");

        var table = robot.lookup("#ticketTable").queryTableView();
        var fticket = (ObservableTicket) table.getItems().get(0);
        SoftAssertions soft = new SoftAssertions();

        soft.assertThat(fticket.getId()).isEqualTo(13);
        soft.assertThat(fticket.getFlight()).isEqualTo(flights.get(0).toString());
        soft.assertThat(fticket.getCustomer()).isEqualTo(customers.get(0).getName());
        soft.assertThat(fticket.getBooking()).isEqualTo("7");
        soft.assertThat(fticket.getSeat_number()).isEqualTo(fValue);

        var sticket = (ObservableTicket) table.getItems().get(1);
        soft.assertThat(sticket.getId()).isEqualTo(14);
        soft.assertThat(sticket.getFlight()).isEqualTo(flights.get(0).toString());
        soft.assertThat(sticket.getCustomer()).isEqualTo(customers.get(0).getName());
        soft.assertThat(sticket.getBooking()).isEqualTo("7");
        soft.assertThat(sticket.getSeat_number()).isEqualTo(sValue);
        soft.assertAll();

        robot.clickOn("#createBooking");

        var bookTable = robot.lookup("#table").queryTableView();
        var booking = (ObservableBooking) bookTable.getItems().get(bid - 1);

        //check table for the new booking
        soft.assertThat(booking.getId()).isEqualTo(bid);
        soft.assertThat(booking.getCustomer()).isEqualTo(buyer);
        soft.assertAll();
    }
}
