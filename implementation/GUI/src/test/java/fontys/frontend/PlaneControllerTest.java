package fontys.frontend;

import javafx.scene.control.Label;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.testfx.api.FxRobot;

import static org.assertj.core.api.Assertions.assertThat;


public class PlaneControllerTest extends GUITestBase {
    protected PlaneControllerTest() {
        super("airplaneReg");
    }

    @ParameterizedTest
    @CsvSource({
            // regId, maxCapacity
            "'K05NE', '120', true",
            "'K06NE', '0', false",
            "'', '120', false",
    })
    void testAddPlane(String regId, String maxCapacity, boolean expected, FxRobot robot) {
        clickWritePress("#regNumberField", regId, robot);
        clickWritePress("#maxCapacityField", maxCapacity, robot);
        robot.clickOn("#createPlane");
        String endMessage = robot.lookup("#endLabel").queryAs(Label.class).getText();

        if (expected) {
            assertThat(endMessage).contains("Created airplane " + regId + " m.c.  " + maxCapacity);
        } else {
            assertThat(endMessage).contains("Could not create airplane!");
        }
    }
}
