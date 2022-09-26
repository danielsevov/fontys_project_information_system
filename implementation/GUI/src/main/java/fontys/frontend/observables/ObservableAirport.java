package fontys.frontend.observables;

import businessentitiesapi.Airport;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Observable entity for populating the TableView with airport data.
 * <p>
 * The fields of the ObservableAirport are SimpleStringProperties
 * and correspond to the fields of the actual airport.
 */
public class ObservableAirport implements ObservableEntity {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty location;

    /**
     * Simple constructor for setting up the properties.
     */
    private ObservableAirport(int id, String name, String location) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.location = new SimpleStringProperty(location);
    }

    /**
     * Creates ObservableAirport from Airport.
     */
    public static ObservableAirport fromPort(Airport port) {
        return new ObservableAirport(
                port.getId(),
                port.getName(),
                port.getLocation()
        );
    }

    /**
     * The getters and setters are needed for setting the cell value
     * factory of the TableView by extracting the corresponding
     * property value (field value) with a PropertyValueFactory.
     * <p>
     * Setter and getter for location.
     */
    public void setLocation(String value) {
        location.set(value);
    }

    public String getLocation() {
        return location.get();
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
        return name.getValue() + ", " + location.getValue();
    }
}
