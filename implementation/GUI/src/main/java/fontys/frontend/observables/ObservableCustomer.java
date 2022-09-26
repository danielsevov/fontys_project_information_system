package fontys.frontend.observables;

import businessentitiesapi.Customer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Observable entity for populating the TableView with airport data.
 * <p>
 * The fields of the ObservableCustomer are SimpleStringProperties
 * and correspond to the fields of the actual airport.
 */
public class ObservableCustomer implements ObservableEntity {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty email;
    private final SimpleStringProperty birthdate;

    /**
     * Simple constructor for setting up the properties.
     */
    private ObservableCustomer(int id, String name, String email, String birthdate) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.birthdate = new SimpleStringProperty(birthdate);
    }

    /**
     * Creates ObservableCustomer from Customer.
     */
    public static ObservableCustomer fromCustomer(Customer customer) {
        return new ObservableCustomer(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getBirthDate().toString()
        );
    }

    /**
     * The getters and setters are needed for setting the cell value
     * factory of the TableView by extracting the corresponding
     * property value (field value) with a PropertyValueFactory.
     * <p>
     * Setter and getter for location.
     */
    public void setEmail(String value) {
        email.set(value);
    }

    public String getEmail() {
        return email.get();
    }

    /**
     * Setter and getter for name.
     */
    public void setName(String value) {
        name.set(value);
    }

    public String getName() {
        return name.get();
    }

    /**
     * Setter and getter for birthdate.
     */
    public void setBirthdate(String value) {
        birthdate.set(value);
    }

    public String getBirthdate() {
        return birthdate.get();
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

    public String toString() {
        return this.name.getValue() + ", " + this.email.getValue() + ", born on " + this.birthdate.getValue();
    }
}
