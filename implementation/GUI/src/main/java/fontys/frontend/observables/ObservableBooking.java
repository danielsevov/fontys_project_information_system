package fontys.frontend.observables;

import businessentitiesapi.Booking;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Observable entity for populating the TableView with airport data.
 * <p>
 * The fields of the ObservableBooking are SimpleStringProperties
 * and correspond to the fields of the actual airport.
 */
public class ObservableBooking implements ObservableEntity {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty customer;

    /**
     * Simple constructor for setting up the properties.
     */
    private ObservableBooking(int id, String customer) {
        this.id = new SimpleIntegerProperty(id);
        this.customer = new SimpleStringProperty(customer);
    }

    /**
     * Creates ObservableCustomer from Customer.
     */
    public static ObservableBooking fromBooking(Booking booking) {
        return new ObservableBooking(booking.getId(), booking.getBuyer().getName());
    }

    /**
     * The getters and setters are needed for setting the cell value
     * factory of the TableView by extracting the corresponding
     * property value (field value) with a PropertyValueFactory.
     * <p>
     * Setter and getter for name.
     */
    public void setCustomer(String value) {
        customer.set(value);
    }

    public String getCustomer() {
        return customer.get();
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

    public String toString(){
        return "Booking " + id.get();
    }
}
