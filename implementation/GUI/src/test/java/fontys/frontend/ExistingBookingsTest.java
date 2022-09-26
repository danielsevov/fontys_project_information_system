package fontys.frontend;

import fontys.frontend.observables.ObservableBooking;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.mockito.AdditionalMatchers.or;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static utils.TestData.bookings;
import static utils.TestData.tickets;

@MockitoSettings(strictness = Strictness.LENIENT)
public class ExistingBookingsTest extends GUITestBase {
    protected ExistingBookingsTest() {
        super("existingBookings");
    }

    @Override
    void setupScene() {
        mockedGetAll();
        when(bookingManager.search(or(eq("1"), eq("Ivan Ivanov")))).thenReturn(List.of(bookings.get(0)));
        when(bookingManager.search(or(eq("2"), eq("John Jameson")))).thenReturn(List.of(bookings.get(1)));
        when(bookingManager.search(or(eq("3"), eq("Mark Spencer")))).thenReturn(List.of(bookings.get(2)));
        when(bookingManager.search(or(eq("4"), eq("Philip Ros")))).thenReturn(List.of(bookings.get(3)));
        when(bookingManager.search(or(eq("5"), eq("Johnny B Goode")))).thenReturn(List.of(bookings.get(4)));
        when(bookingManager.search(or(eq("6"), eq("Megan Thompson")))).thenReturn(List.of(bookings.get(5)));

        when(bookingManager.search(eq("John"))).thenReturn(List.of(bookings.get(1), bookings.get(4)));

        when(bookingManager.get(eq(1))).thenReturn(java.util.Optional.of(bookings.get(0)));
        when(bookingManager.get(eq(2))).thenReturn(java.util.Optional.of(bookings.get(1)));
        when(bookingManager.get(eq(3))).thenReturn(java.util.Optional.of(bookings.get(2)));
        when(bookingManager.get(eq(4))).thenReturn(java.util.Optional.of(bookings.get(3)));
        when(bookingManager.get(eq(5))).thenReturn(java.util.Optional.of(bookings.get(4)));
        when(bookingManager.get(eq(6))).thenReturn(java.util.Optional.of(bookings.get(5)));

        when(ticketManager.getByColumnValues("booking", 1)).thenReturn(List.of(tickets.get(0), tickets.get(1)));
        when(ticketManager.getByColumnValues("booking", 2)).thenReturn(List.of(tickets.get(2)));
        when(ticketManager.getByColumnValues("booking", 3)).thenReturn(List.of(tickets.get(3), tickets.get(4), tickets.get(5)));
        when(ticketManager.getByColumnValues("booking", 4)).thenReturn(List.of(tickets.get(6), tickets.get(7)));
        when(ticketManager.getByColumnValues("booking", 5)).thenReturn(List.of(tickets.get(8)));
        when(ticketManager.getByColumnValues("booking", 6)).thenReturn(List.of(tickets.get(9), tickets.get(10), tickets.get(11)));

    }

    public int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void clickOnTableRowText(String controlId, String textToSelect, FxRobot robot) {
        TableView<?> box = lookupControl(controlId, robot);
        var a = box.getItems();
        int c = 0, iid = -1, id = 0;
        for (Object b : a) {
            ObservableBooking fl = (ObservableBooking) b;
            if (fl.getCustomer().contains(textToSelect)) {
                iid = c;
                id = 1;
                break;
            }
            if (fl.getId() == tryParseInt(textToSelect)) {
                iid = c;
                id = 0;
                break;
            }
            c++;
        }
        if (iid != -1) {
            var idk = box.getColumns().get(id);
            var st = (String) idk.getCellObservableValue(iid).getValue().toString();
            robot.doubleClickOn(st);
        }
    }

    @ParameterizedTest
    @CsvSource({
            "'Ivan Ivanov', 'Ivan Ivanov', '#holderLabel', true",
            "'1', '1', '#titleText', true",
            "'John Jameson', 'John Jameson', '#holderLabel', true",
            "'2', '2', '#titleText', true",
            "'Mark Spencer', 'Mark Spencer', '#holderLabel', true",
            "'3', '3', '#titleText', true",
            "'Philip Ros', 'Philip Ros', '#holderLabel', true",
            "'4', '4', '#titleText', true",
            "'Johnny B Goode', 'Johnny B Goode', '#holderLabel', true",
            "'5', '5', '#titleText', true",
            "'Megan Thompson', 'Megan Thompson', '#holderLabel', true",
            "'6', '6', '#titleText', true",

            "'Ivan Ivanov', '1', '#titleText', true",
            "'1', 'Ivan Ivanov', '#holderLabel', true",
            "'John Jameson', '2', '#titleText', true",
            "'2', 'John Jameson', '#holderLabel', true",
            "'Mark Spencer', '3', '#titleText', true",
            "'3', 'Mark Spencer', '#holderLabel', true",
            "'Philip Ros', '4', '#titleText', true",
            "'4', 'Philip Ros', '#holderLabel', true",
            "'Johnny B Goode', '5', '#titleText', true",
            "'5', 'Johnny B Goode', '#holderLabel', true",
            "'Megan Thompson', '6', '#titleText', true",
            "'6', 'Megan Thompson', '#holderLabel', true",

            "'6', '6', '#holderLabel', false",
            "'1', '1', '#holderLabel', false",
            "'2', '2', '#holderLabel', false",
            "'3', '3', '#holderLabel', false",
            "'4', '4', '#holderLabel', false",
            "'5', '5', '#holderLabel', false",
            "'6', 'Jared', '#holderLabel', false",
            "'1', 'Dana', '#holderLabel', false",
            "'2', 'Emo', '#holderLabel', false",
            "'3', 'Vin', '#holderLabel', false",
            "'4', 'Dave', '#holderLabel', false",
            "'5', 'Gordon', '#holderLabel', false",

            "'Megan Thompson', '0', '#titleText', false",
            "'Ivan Ivanov', '0', '#titleText', false",
            "'John Jameson', '0', '#titleText', false",
            "'Mark Spencer', '0', '#titleText', false",
            "'Philip Ros', '0', '#titleText', false",
            "'Johnny B Goode', '0', '#titleText', false",
    })
    void testDetailView(String row, String expected, String label, boolean bool, FxRobot robot) {
        assertThatCode(() -> clickOnTableRowText("#table", row, robot)).doesNotThrowAnyException();
        Assertions.assertThat(robot.lookup(label).queryAs(Label.class).getText().contains(expected)).isEqualTo(bool);
    }

    @ParameterizedTest
    @CsvSource({
            "'1', '1'",
            "'2', '1'",
            "'3', '1'",
            "'4', '1'",
            "'5', '1'",
            "'6', '1'",
            "'Ivan Ivanov', '1'",
            "'John Jameson', '1'",
            "'Mark Spencer', '1'",
            "'Philip Ros', '1'",
            "'Johnny B Goode', '1'",
            "'Megan Thompson', '1'",
            "'John', '2'",
            "'Fred', '0'",
            "'Mary', '0'",
    })
    void testSearch(String expected, int nm, FxRobot robot) {
        clickWritePress("#searchTerm", expected, robot);
        var a = robot.lookup("#table").queryTableView().getItems().size();
        assertThat(a).isEqualTo(nm);
    }
}
