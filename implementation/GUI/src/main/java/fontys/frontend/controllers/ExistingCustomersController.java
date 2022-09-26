package fontys.frontend.controllers;

import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import fontys.frontend.observables.ObservableCustomer;
import helpers.ControllerUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.function.Supplier;

/**
 * Controller for Existing Customers List JavaFX scene.
 * <p>
 * The controller is used for managing the scene and processing the input
 * from the app user.
 */
public class ExistingCustomersController extends ControllerBase {

    /**
     * Super constructor.
     */
    public ExistingCustomersController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    /**
     * Simple ListView for listing customers.
     */
    @FXML
    TableView<ObservableCustomer> table = new TableView<>();

    /**
     * Create a TableColumn.
     */
    public TableColumn<ObservableCustomer, String> makeColumn(String name, String title, double width) {
        TableColumn<ObservableCustomer, String> make = new TableColumn<>(title);
        make.setPrefWidth(width);
        make.setStyle("-fx-alignment: CENTER;");
        make.setCellValueFactory(new PropertyValueFactory<>(name));
        return make;
    }

    /**
     * Initializes the columns of the table and populates it with airports.
     */
    @SuppressWarnings("unchecked")
    public void initialize() {
        table.setPlaceholder(new Label("No registered customers in the system."));

        table.setRowFactory(tv -> {
            TableRow<ObservableCustomer> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1) resetCustomers();
            });
            return row;
        });

        table.getColumns()
                .addAll(makeColumn("id", "Customer ID", 80),
                        makeColumn("name", "Customer Name", 200),
                        makeColumn("email", "Customer Email", 200),
                        makeColumn("birthdate", "Customer Birthdate", 240));

        resetCustomers();
    }

    /**
     * FX action function for switching to airportReg.fxml scene.
     */
    @FXML
    private void addCustomer() {
        sceneManager.get().changeScene("customerReg");
    }

    /**
     * FX action function for switching to employeeHub.fxml scene.
     */
    @FXML
    private void backToHub() {
        sceneManager.get().changeScene("employeeHub");
    }

    /**
     * Updates airport values in table.
     */
    public void resetCustomers() {
        var customers = getCustomerManager().getAll().stream();
        table.setItems(ControllerUtils.entitiesToObservableList(customers, ObservableCustomer::fromCustomer));
    }

}
