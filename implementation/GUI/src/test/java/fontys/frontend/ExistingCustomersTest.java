package fontys.frontend;

import fontys.frontend.observables.ObservableCustomer;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.testfx.api.FxRobot;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.AdditionalMatchers.or;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static utils.TestData.customers;

@MockitoSettings(strictness = Strictness.LENIENT)
public class ExistingCustomersTest extends GUITestBase {
    protected ExistingCustomersTest() {
        super("existingCustomers");
    }

    @Override
    void setupScene() {
        mockedGetAll();
        when(customerManager.search(or(eq("Ivan"), eq("")))).thenReturn(List.of(customers.get(0)));
        when(customerManager.search(eq("John"))).thenReturn(List.of(customers.get(1), customers.get(4)));
        when(customerManager.search(eq("mark@spencer.com"))).thenReturn(List.of(customers.get(2)));
        when(customerManager.search(eq("1959"))).thenReturn(List.of(customers.get(4)));
        when(customerManager.get(eq(0))).thenReturn(java.util.Optional.of(customers.get(0)));
        when(customerManager.get(eq(1))).thenReturn(java.util.Optional.of(customers.get(1)));
        when(customerManager.get(eq(2))).thenReturn(java.util.Optional.of(customers.get(2)));
        when(customerManager.get(eq(3))).thenReturn(java.util.Optional.of(customers.get(3)));
        when(customerManager.get(eq(4))).thenReturn(java.util.Optional.of(customers.get(4)));
        when(customerManager.get(eq(5))).thenReturn(java.util.Optional.of(customers.get(5)));
    }

    private boolean findRow(String controlId, String textToSelect, FxRobot robot) {
        TableView<?> box = lookupControl(controlId, robot);
        for (Object b : box.getItems()) {
            ObservableCustomer cm = (ObservableCustomer) b;
            if (cm.getName().contains(textToSelect) || cm.getEmail().contains(textToSelect) || cm.getBirthdate().contains(textToSelect)) {
                return true;
            }
        }
        return false;
        }

    @ParameterizedTest
    @CsvSource({
            "'Ivan Ivanov', true",
            "'Azis', false",
            "'Mark', true",
            "'Megan', true",
            "'Johnny', true",
            "'ivan@ivanov', true",
            "'com.com', false",
            "'megan@thompson', true",
            "'1959', true",
            "'2012', false",
    })
    void testDetailView(String expected, boolean result, FxRobot robot) {
        assertThat(findRow("#table", expected, robot)).isEqualTo(result);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "'Ivan', '1'",
            "'John', '2'",
            "'mark@spencer.com', '1'",
            "'1959', '1'",
            "'2012', '0'",
            "'Jared', '0'",
    })
    void testSearch(String expected, int nm, FxRobot robot) {
        clickWritePress("#searchTerm", expected, robot);
        var a = robot.lookup("#table").queryTableView().getItems().size();
        assertThat(a).isEqualTo(nm);
    }
}
