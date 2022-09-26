package fontys.frontend;

import javafx.scene.control.Label;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.testfx.api.FxRobot;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketOptionControllerTest extends GUITestBase {
    protected TicketOptionControllerTest() {
        super("ticketOptionReg");
    }
    
    
    @ParameterizedTest
    @CsvSource({
            // name, price
            "'Extra Leg Space', '10', true",
            "'Extra Luggage', '15', true",
            "'Headphones', '', false",
            "'', '5', false"
    })
    void testAddOptionReg(String name, String price, boolean expected, FxRobot robot) {
        clickWritePress("#nameField", name, robot);
        clickWritePress("#priceField", price, robot);
        robot.clickOn("#createTicketOption");
        String endMessage = robot.lookup("#endLabel").queryAs(Label.class).getText();

        if (expected) {
            assertThat(endMessage).contains("Created ticket option " + name + " price: " + price + "€");
        } else {
            assertThat(endMessage).contains("Could not create ticket option!");
        }
    }   
    
}