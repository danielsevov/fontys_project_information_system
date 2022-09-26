package fontys.frontend;

import javafx.scene.control.Label;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.testfx.api.FxRobot;

import static org.assertj.core.api.Assertions.assertThat;

public class AirportRegTest extends GUITestBase {
    protected AirportRegTest() {
        super("airportReg");
    }

    @ParameterizedTest
    @CsvSource({
            // name, location
            "'Airport1', 'location1', true",
            "'Airport2', '', false",
            "'', 'location3', false",
    })
    void testAddPort(String name, String location, boolean expected, FxRobot robot) {
        clickWritePress("#nameField", name, robot);
        clickWritePress("#locationField", location, robot);
        robot.clickOn("#createPort");
        String endMessage = robot.lookup("#endLabel").queryAs(Label.class).getText();

        if (expected) {
            assertThat(endMessage).contains("Created " + name + ", " + location);
        } else {
            assertThat(endMessage).contains("Could not create airport!");
        }
    }
}
