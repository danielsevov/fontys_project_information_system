package fontys.frontend;

import fontys.frontend.observables.ObservableFlight;
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
import static utils.TestData.flights;

@MockitoSettings(strictness = Strictness.LENIENT)
public class ExistingFlightsTest extends GUITestBase {
    protected ExistingFlightsTest() {
        super("existingFlights");
    }

    @Override
    void setupScene() {
        mockedGetAll();
        when(flightManager.search(or(eq("Ham"), eq("Venlo")))).thenReturn(List.of(flights.get(0)));
        when(flightManager.search(eq("XB"))).thenReturn(List.of(flights.get(0)));
        when(flightManager.search(eq("Eindhoven"))).thenReturn(List.of(flights.get(1)));
        when(flightManager.search(eq("Frank"))).thenReturn(List.of(flights.get(2)));
        when(flightManager.get(eq(1))).thenReturn(java.util.Optional.of(flights.get(0)));
        when(flightManager.get(eq(2))).thenReturn(java.util.Optional.of(flights.get(1)));
        when(flightManager.get(eq(3))).thenReturn(java.util.Optional.of(flights.get(2)));
    }

    private void clickOnTableRowText(String controlId, String textToSelect, FxRobot robot) {
        TableView<?> box = lookupControl(controlId, robot);
        var a = box.getItems();
        int c = 0, iid = -1, id = 0;
        for (Object b : a) {
            ObservableFlight fl = (ObservableFlight) b;
            if (fl.getDeparturePort().contains(textToSelect)) {
                iid = c;
                id = 2;
            }
            if (fl.getArrivalPort().contains(textToSelect)) {
                iid = c;
                id = 3;
            }
            if (fl.getPlane().contains(textToSelect)) {
                iid = c;
                id = 1;
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
            "'Hamburg', '#currentDepPort', true",
            "'Eindhoven', '#currentDepPort', true",
            "'Frankfurt', '#currentDepPort', true",
            "'Venlo', '#currentArrPort', true",
            "'XB-HCW', '#currentPlane', true",
            "'Hamburg', '#currentArrPort', false",
            "'Venlo', '#currentDepPort', false",
            "'Frankfurt', '#currentArrPort', false",
            "'XB', '#currentArrPort', false",
            "'XB', '#currentPlane', true",
    })
    void testDetailView(String expected, String label, boolean bool, FxRobot robot) {
        assertThatCode(() -> clickOnTableRowText("#table", expected, robot)).doesNotThrowAnyException();
        Assertions.assertThat(robot.lookup(label).queryAs(Label.class).getText().contains(expected)).isEqualTo(bool);
    }

    @ParameterizedTest
    @CsvSource({
            "'Ham', '1'",
            "'Eindhoven', '1'",
            "'Venlo', '1'",
            "'Frank', '1'",
            "'XB', '1'",
            "'NYC', '0'",
            "'XBOX', '0'",
    })
    void testSearch(String expected, int nm, FxRobot robot) {
        clickWritePress("#searchTerm", expected, robot);
        var a = robot.lookup("#table").queryTableView().getItems().size();
        assertThat(a).isEqualTo(nm);
    }
}
