package fontys.frontend;

import businessentitiesapi.*;
import businesslogic.BusinessLogicAPI;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.Start;
import utils.DelegatedApplicationExtension;
import utils.GuiTestCondition;
import utils.MockedBusiness;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static utils.TestData.*;

/**
 * Base class for all GUI related tests.
 */
@ExtendWith({MockitoExtension.class, DelegatedApplicationExtension.class, GuiTestCondition.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
abstract class GUITestBase {
    static {
        // Configure our runner to execute all tests in headless mode.
        if (Boolean.getBoolean("CI")) {
            System.setProperty("java.awt.headless", "true");
            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("prism.text", "t2k");
            System.setProperty("glass.platform", "Monocle");
            System.setProperty("monocle.platform", "Headless");
        }
    }

    private final String sceneName;

    @Mock
    AirportManager airportManager;
    @Mock
    AirplaneManager airplaneManager;
    @Mock
    BookingManager bookingManager;
    @Mock
    CustomerManager customerManager;
    @Mock
    FlightManager flightManager;
    @Mock
    TicketManager ticketManager;
    @Mock
    TicketOptionManager ticketOptionManager;
    @Mock
    TicketTypeManager ticketTypeManager;
    @Mock
    BookedOptionManager bookedOptionManager;
    @Mock
    DailyDiscountManager dailyDiscountManager;

    @InjectMocks
    BusinessLogicAPI logicAPI = new MockedBusiness();


    protected GUITestBase(String sceneName) {
        this.sceneName = sceneName;
    }


    @Start
    void start(Stage stage) throws IOException {
        setupScene();
        var app = new GUIFlightApp(logicAPI).init(false);
        app.start(stage);
        app.getSceneManager().changeScene(sceneName);
    }

    /**
     * Setup method for a dedicated scene test.
     * This method should be used to initialise and train any mocks
     * the test might need.
     */
    void setupScene() {
    }

    /**
     * Method for commonly mocked objects.
     * This is a side-effect based method. Simply calling it in {@link #setupScene()} should suffice.
     */
    void mockedGetAll() {
        when(flightManager.getAll()).thenReturn(flights);
        when(airplaneManager.getAll()).thenReturn(planes);
        when(airportManager.getAll()).thenReturn(airports);
        when(customerManager.getAll()).thenReturn(customers);
        when(bookingManager.getAll()).thenReturn(bookings);
        when(ticketManager.getAll()).thenReturn(tickets);
        when(dailyDiscountManager.getAll()).thenReturn(dailyDiscounts);
    }

    @AfterEach
    void update() throws TimeoutException {
        FxToolkit.cleanupStages();
    }

    /**
     * Look up a control element by id.
     *
     * @param controlId the ID of the control element
     * @param robot     the robot, which should perform the action
     * @param <T>       the type of the control element
     * @return the control element
     */
    <T extends Node> T lookupControl(String controlId, FxRobot robot) {
        T actualControl = robot.lookup(controlId).query();
        assertThat(actualControl).as("Selected element " + controlId + " should not be null").isNotNull();
        return actualControl;
    }

    /**
     * Click on a field, enter text and confirm with ENTER.
     *
     * @param field the field to click on
     * @param text  the text to enter
     * @param robot the robot, which should perform the action
     */
    void clickWritePress(String field, String text, FxRobot robot) {
        robot.clickOn(field);
        robot.write(text);
        robot.press(KeyCode.ENTER);
        robot.release(KeyCode.ENTER);
    }

    /**
     * Click on an item in a dropdown menu.
     *
     * @param controlId    the id of the dropdown menu
     * @param textToSelect the item to click on
     * @param robot        the robot, which should click on the item
     */
    void clickOnDropdownText(String controlId, String textToSelect, FxRobot robot) {
        ComboBox<?> box = lookupControl(controlId, robot);

        for (Node child : box.getChildrenUnmodifiable()) {
            if (child.getStyleClass().contains("arrow-button")) {
                Node arrowRegion = ((Pane) child).getChildren().get(0);
                robot.clickOn(arrowRegion);
                robot.clickOn(textToSelect);
            }
        }
    }
}
