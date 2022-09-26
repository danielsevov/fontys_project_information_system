package fontys.frontend;

import javafx.scene.control.Label;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.testfx.api.FxRobot;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerControllerTest extends GUITestBase {
    protected CustomerControllerTest() {
        super("customerReg");
    }

    @ParameterizedTest
    @CsvSource({
            // name,        email,             birthdate
            "'Ivan Ivanov', 'ivan@ivanov.com', '01/01/1980', true",
            "'John Jameson', 'john@jameson.com', '', false",
            "'Mark Spencer', '', '03/03/1990', false",
            "'', 'philip@ros.com', '04/04/1995', false",
            "'Johnny B Goode', 'johnnyATgoode.com', '04/04/1959', false",  //no @ symbol
    })
    void testAddOptionReg(String name, String email, String birthdate, boolean expected, FxRobot robot) {
        clickWritePress("#nameField", name, robot);
        clickWritePress("#emailField", email, robot);
        clickWritePress("#birthdateField", birthdate, robot);
        robot.clickOn("#createCustomer");
        String endMessage = robot.lookup("#endLabel").queryAs(Label.class).getText();

        if (expected) {
            assertThat(endMessage).contains("Created " + name + ", " + email);
        } else {
            assertThat(endMessage).contains("Could not register customer!");
        }
    }

}
