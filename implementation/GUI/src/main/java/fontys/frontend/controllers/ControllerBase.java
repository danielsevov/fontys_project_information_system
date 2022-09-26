package fontys.frontend.controllers;

import businessentitiesapi.*;
import businesslogic.BusinessLogicAPI;
import businesslogic.bulkvalidator.BulkException;
import fontys.frontend.SceneManager;
import javafx.css.PseudoClass;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Controller base for all JavaFx controllers.
 */
public abstract class ControllerBase {
    final Supplier<SceneManager> sceneManager;
    final BusinessLogicAPI businessLogicAPI;

    protected ControllerBase(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        this.sceneManager = sceneManager;
        this.businessLogicAPI = businessLogicAPI;
    }

    /**
     * Creates a TableColumn.
     */
    <T> TableColumn<T, String> makeColumn(String name, String title, double width) {
        TableColumn<T, String> make = new TableColumn<>(title);
        make.setPrefWidth(width);
        make.setStyle("-fx-alignment: CENTER;");
        make.setCellValueFactory(new PropertyValueFactory<>(name));
        return make;
    }

    /**
     * Return the {@link FlightManager} of this businesslogic layer.
     *
     * @return the flight manager
     */
    FlightManager getFlightManager() {
        return businessLogicAPI.getFlightManager();
    }

    /**
     * Return the {@link AirplaneManager} of this businesslogic layer.
     *
     * @return the airplane manager
     */
    AirplaneManager getAirplaneManager() {
        return businessLogicAPI.getAirplaneManager();
    }

    /**
     * Return the {@link AirportManager} of this businesslogic layer.
     *
     * @return the airport manager
     */
    AirportManager getAirportManager() {
        return businessLogicAPI.getAirportManager();
    }

    /**
     * Return the {@link CustomerManager} of this businesslogic layer.
     *
     * @return the customer manager
     */
    CustomerManager getCustomerManager() {
        return businessLogicAPI.getCustomerManager();
    }

    /**
     * Return the {@link BookingManager} of this businesslogic layer.
     *
     * @return the booking manager
     */
    BookingManager getBookingManager() {
        return businessLogicAPI.getBookingManager();
    }

    /**
     * Return the {@link TicketManager} of this businesslogic layer.
     *
     * @return the ticket manager
     */
    TicketManager getTicketManager() {
        return businessLogicAPI.getTicketManager();
    }

    /**
     * Return the {@link TicketOptionManager} of this businesslogic layer.
     *
     * @return the ticket option manager
     */
    TicketOptionManager getTicketOptionManager() {
        return businessLogicAPI.getTicketOptionManager();
    }

    /**
     * Return the {@link TicketTypeManager} of this businesslogic layer.
     *
     * @return the ticket type manager
     */
    TicketTypeManager getTicketTypeManager() {
        return businessLogicAPI.getTicketTypeManager();
    }

    /**
     * Return the {@link BookedOptionManager} of this businesslogic layer.
     *
     * @return the booked option manager
     */
    BookedOptionManager getBookedOptionManager() {
        return businessLogicAPI.getBookedOptionManager();
    }

    /**
     * Return the {@link DailyDiscountManager} of this businesslogic layer.
     *
     * @return the daily discount manager
     */
    DailyDiscountManager getDailyDiscountManager() {
        return businessLogicAPI.getDailyDiscountManager();
    }


    /**
     * Create a border and tooltip for an erroneous node.
     *
     * @param node      the erroneous node
     * @param throwable the error that caused the exception for this node
     */
    void setErrorInformation(Node node, Throwable throwable) {
        var hasError = throwable != null;
        var errorClass = PseudoClass.getPseudoClass("error");
        node.pseudoClassStateChanged(errorClass, hasError);
        if (hasError) {
            var tooltip = new Tooltip(throwable.getMessage());
            Tooltip.install(node, tooltip);
        } else {
            Tooltip.uninstall(node, null);
        }
    }

    /**
     * Generate error messages for all nodes that raised validation exceptions.
     *
     * @param bex       the bulk validation exception with a hashmap of erroneous nodes.
     * @param nodesList the list containing all nodes
     */
    void displayErrors(BulkException bex, List<Node> nodesList) {
        Map<String, Throwable> causes = bex.getCauses();
        // Mark missing fields with a red border and tooltip.
        nodesList.forEach(node -> setErrorInformation(node, causes.get(node.getId())));
    }
}
