package fontys.frontend;

import fontys.frontend.observables.ObservableAirplane;
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
import static utils.TestData.planes;

@MockitoSettings(strictness = Strictness.LENIENT)
public class ExistingPlanesTest extends GUITestBase {
    protected ExistingPlanesTest() {
        super("existingPlanes");
    }

    @Override
    void setupScene() {
        mockedGetAll();
        when(airplaneManager.search(eq("HCW"))).thenReturn(List.of(planes.get(0), planes.get(1)));
        when(airplaneManager.search(or(eq("XB-HCW"), eq("100")))).thenReturn(List.of(planes.get(0)));
        when(airplaneManager.search(or(eq("MX-HCW"), eq("20")))).thenReturn(List.of(planes.get(1)));
        when(airplaneManager.search(or(eq("FF-NYC"), eq("30")))).thenReturn(List.of(planes.get(2)));
        when(airplaneManager.search(or(eq("NS-K0R"), eq("40")))).thenReturn(List.of(planes.get(3)));
        when(airplaneManager.get(eq(1))).thenReturn(java.util.Optional.of(planes.get(0)));
        when(airplaneManager.get(eq(2))).thenReturn(java.util.Optional.of(planes.get(1)));
        when(airplaneManager.get(eq(3))).thenReturn(java.util.Optional.of(planes.get(2)));
        when(airplaneManager.get(eq(4))).thenReturn(java.util.Optional.of(planes.get(3)));
        when(airplaneManager.get(eq(5))).thenReturn(java.util.Optional.of(planes.get(4)));
        when(airplaneManager.get(eq(6))).thenReturn(java.util.Optional.of(planes.get(5)));
    }

    private void clickOnTableRowText(String controlId, String textToSelect, FxRobot robot) {
        TableView<?> box = lookupControl(controlId, robot);
        var a = box.getItems();
        int c = 0, iid = -1, id = 0;
        for (Object b : a) {
            ObservableAirplane fl = (ObservableAirplane) b;
            if (fl.getRegistration().contains(textToSelect)) {
                iid = c;
                id = 1;
            }
            if (fl.getCapacity().toString().contains(textToSelect)) {
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
            "'FF-NYC', 'FF-NYC', '#currentRegistrationNumber', true",
            "'XB-HCW', 'XB-HCW', '#currentRegistrationNumber', true",
            "'FF-NYC', '30', '#currentMaximumCapacity', true",
            "'XB-HCW', '100', '#currentMaximumCapacity', true",
            "'XB-HCW', '20', '#currentMaximumCapacity', false",

            "'NS-K0R', 'NS-K0R', '#currentRegistrationNumber', true",
            "'MX-HCW', 'MX-HCW', '#currentRegistrationNumber', true",
            "'NS-K0R', '40', '#currentMaximumCapacity', true",
            "'MX-HCW', '20', '#currentMaximumCapacity', true",
            "'MX-HCW', '30', '#currentMaximumCapacity', false",

            "'N711GZ', 'N711GZ', '#currentRegistrationNumber', true",
            "'D0KAR1', 'D0KAR1', '#currentRegistrationNumber', true",
            "'N711GZ', '50', '#currentMaximumCapacity', true",
            "'D0KAR1', '60', '#currentMaximumCapacity', true",
            "'D0KAR1', '20', '#currentMaximumCapacity', false",

    })
    void testDetailView(String reg, String expected, String label, boolean bool, FxRobot robot) {
        assertThatCode(() -> clickOnTableRowText("#table", reg, robot)).doesNotThrowAnyException();
        Assertions.assertThat(robot.lookup(label).queryAs(Label.class).getText().contains(expected)).isEqualTo(bool);
    }

    @ParameterizedTest
    @CsvSource({
            "'XB-HCW', '1'",
            "'MX-HCW', '1'",
            "'HCW', '2'",
            "'FF-NYC', '1'",
            "'NS-K0R', '1'",
            "'100', '1'",
            "'20', '1'",
            "'30', '1'",
            "'40', '1'",
            "'NYC', '0'",
            "'XBOX', '0'",
    })
    void testSearch(String expected, int nm, FxRobot robot) {
        clickWritePress("#searchTerm", expected, robot);
        var a = robot.lookup("#table").queryTableView().getItems().size();
        assertThat(a).isEqualTo(nm);
    }
}
