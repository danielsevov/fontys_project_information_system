package fontys.frontend.observables;

import businessentitiesapi.TicketOption;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Observable entity for populating the TableView with airport data.
 * <p>
 * The fields of the ObservableTicketOption are SimpleStringProperties
 * and correspond to the fields of the actual ticket option.
 */
public class ObservableTicketOption implements ObservableEntity {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty price;

    /**
     * Simple constructor for setting up the properties.
     */
    private ObservableTicketOption(int id, String name, Integer price) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
    }

    /**
     * Creates ObservableCustomer from Customer.
     */
    public static ObservableTicketOption fromOption(TicketOption option) {
        return new ObservableTicketOption(option.getId(), option.getName(), option.getPrice());
    }

    /**
     * The getters and setters are needed for setting the cell value
     * factory of the TableView by extracting the corresponding
     * property value (field value) with a PropertyValueFactory.
     * <p>
     * Setter and getter for name.
     */
    public void setName(String value) {
        name.set(value);
    }

    public String getName() {
        return name.get();
    }

    /**
     * Setter and getter for price.
     */
    public void setPrice(Integer value) {
        price.set(value);
    }

    public Integer getPrice() {
        return price.get();
    }

    /**
     * Setter and getter for ID.
     */
    public void setId(Integer value) {
        id.set(value);
    }

    @Override
    public int getId() {
        return id.get();
    }
}
