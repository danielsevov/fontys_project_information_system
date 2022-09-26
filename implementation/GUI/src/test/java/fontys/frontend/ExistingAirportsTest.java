package fontys.frontend;

import fontys.frontend.observables.ObservableAirport;
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
import static utils.TestData.airports;

@MockitoSettings(strictness = Strictness.LENIENT)
public class ExistingAirportsTest extends GUITestBase {
    protected ExistingAirportsTest() {
        super("existingPorts");
    }

    @Override
    void setupScene() {
        mockedGetAll();
        when(airportManager.search(eq("Airport"))).thenReturn(airports);
        when(airportManager.search(eq("d"))).thenReturn(List.of(airports.get(2), airports.get(3), airports.get(5)));
        when(airportManager.search(or(eq("Hamburg"), eq("Hamburg Airport")))).thenReturn(List.of(airports.get(0)));
        when(airportManager.search(or(eq("Venlo"), eq("Venlo Airport")))).thenReturn(List.of(airports.get(1)));
        when(airportManager.search(or(eq("Eindhoven Airport"), eq("Eindhoven")))).thenReturn(List.of(airports.get(2)));
        when(airportManager.search(or(eq("Amsterdam Airport"), eq("Amsterdam")))).thenReturn(List.of(airports.get(3)));
        when(airportManager.get(eq(1))).thenReturn(java.util.Optional.of(airports.get(0)));
        when(airportManager.get(eq(2))).thenReturn(java.util.Optional.of(airports.get(1)));
        when(airportManager.get(eq(3))).thenReturn(java.util.Optional.of(airports.get(2)));
        when(airportManager.get(eq(4))).thenReturn(java.util.Optional.of(airports.get(3)));
        when(airportManager.get(eq(5))).thenReturn(java.util.Optional.of(airports.get(4)));
        when(airportManager.get(eq(6))).thenReturn(java.util.Optional.of(airports.get(5)));
    }

    private void clickOnTableRowText(String controlId, String textToSelect, FxRobot robot) {
        TableView<?> box = lookupControl(controlId, robot);
        var a = box.getItems();
        int c = 0, iid = -1, id = 0;
        for (Object b : a) {
            ObservableAirport fl = (ObservableAirport) b;
            if (fl.getName().contains(textToSelect)) {
                iid = c;
                id = 1;
            }
            if (fl.getLocation().contains(textToSelect)) {
                iid = c;
                id = 2;
            }
            c++;
        }
        if (iid != -1) {
            var idk = box.getColumns().get(id);
            var st = (String) idk.getCellObservableValue(iid).getValue();
            robot.doubleClickOn(st);
        }
    }

    @ParameterizedTest
    @CsvSource({
            "'Hamburg', 'Hamburg Airport', '#currentName', true",
            "'Hamburg', 'Hamburg', '#currentLocation', true",
            "'Hamburg', 'Hamburg Airport', '#currentLocation', false",
            "'Hamburg', 'Hamburg', '#currentName', false",

            "'Venlo', 'Venlo Airport', '#currentName', true",
            "'Venlo', 'Venlo', '#currentLocation', true",
            "'Venlo', 'Venlo Airport', '#currentLocation', false",
            "'Venlo', 'Venlo', '#currentName', false",

            "'Eindhoven', 'Eindhoven Airport', '#currentName', true",
            "'Eindhoven', 'Eindhoven', '#currentLocation', true",
            "'Eindhoven', 'Eindhoven Airport', '#currentLocation', false",
            "'Eindhoven', 'Eindhoven', '#currentName', false",

    })
    void testDetailView(String reg, String expected, String label, boolean bool, FxRobot robot) {
        assertThatCode(() -> clickOnTableRowText("#table", reg, robot)).doesNotThrowAnyException();
        Assertions.assertThat(robot.lookup(label).queryAs(Label.class).getText().equals(expected)).isEqualTo(bool);
    }

    @ParameterizedTest
    @CsvSource({
            "'Hamburg', '1'",
            "'Venlo', '1'",
            "'Eindhoven', '1'",
            "'Hamburg Airport', '1'",
            "'Venlo Airport', '1'",
            "'Eindhoven Airport', '1'",
            "'d', 3",
            "'Airport', 6",
            "'New York', '0'",
            "'Istanbul', '0'",
    })
    void testSearch(String expected, int nm, FxRobot robot) {
        clickWritePress("#searchTerm", expected, robot);
        var a = robot.lookup("#table").queryTableView().getItems().size();
        assertThat(a).isEqualTo(nm);
    }
}
