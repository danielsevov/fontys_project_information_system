package fontys.frontend;

import javafx.scene.control.Label;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import utils.TestData;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.LENIENT)
public class FlightControllerTest extends GUITestBase {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private final LocalDate now = LocalDate.now();

    protected FlightControllerTest() {
        super("flightReg");
    }

    @Override
    void setupScene() {
        mockedGetAll();
        when(flightManager.findQualifiedAirplanes(any(), any(), any())).thenReturn(TestData.planes);
    }

    @ParameterizedTest
    @CsvSource({
            // departTime,  arriveTime,  departLocation,  arriveLocation,  plane, price
            "'20:00',  '21:00',  'Venlo Airport',  'Hamburg Airport',  'XB-HCW', '10',  true",
            "'12:00',  '15:00',  'Frankfurt Airport',  'Amsterdam Airport',  'FF-NYC', '10', false",
    })
    void testAddFlight(LocalTime departTime, LocalTime arriveTime, String departLocation,
                       String arriveLocation, String plane, String price, boolean expected, FxRobot robot) {

        clickWritePress("#departDatetime", formatter.format(now.atTime(departTime)), robot);
        clickWritePress("#arrivalDatetime", formatter.format(now.atTime(arriveTime)), robot);
        // Drop down fields.
        clickOnDropdownText("#departField", departLocation, robot);
        clickOnDropdownText("#arriveField", arriveLocation, robot);
        clickWritePress("#priceField", price, robot);

        if (expected) {
            clickOnDropdownText("#planeField", plane, robot);
            robot.clickOn("#submit");
            Assertions.assertThat(robot.lookup("#endLabel").queryAs(Label.class).getText())
                    .contains("Flight planned successfully!");
        } else {
            robot.clickOn("#submit");
            Assertions.assertThat(robot.lookup("#endLabel").queryAs(Label.class).getText())
                    .contains("Could not create flight!");
        }
    }
}
