package fontys.frontend.observables;

import businessentitiesapi.Airplane;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Observable entity for populating the TableView with airplane data.
 * <p>
 * The fields of the ObservableAirplane are SimpleStringProperties
 * and correspond to the fields of the actual airplane.
 */
public class ObservableAirplane implements ObservableEntity {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty registration;
    private final SimpleIntegerProperty capacity;

    /**
     * Simple constructor for setting up the properties.
     */
    private ObservableAirplane(int id, String reg, Integer cap) {
        this.id = new SimpleIntegerProperty(id);
        this.registration = new SimpleStringProperty(reg);
        this.capacity = new SimpleIntegerProperty(cap);
    }

    /**
     * Creates ObservableAirplane from Airplane.
     */
    public static ObservableAirplane fromPlane(Airplane plane) {
        return new ObservableAirplane(
                plane.getId(),
                plane.getRegistrationNumber(),
                plane.getMaxCapacity()
        );
    }

    /**
     * The getters and setters are needed for setting the cell value
     * factory of the TableView by extracting the corresponding
     * property value (field value) with a PropertyValueFactory.
     * <p>
     * Setter and getter for maxCapacity.
     */
    public void setCapacity(Integer value) {
        capacity.set(value);
    }

    public Integer getCapacity() {
        return capacity.get();
    }

    /**
     * Setter and getter for registration.
     */
    public void setRegistration(String value) {
        registration.set(value);
    }

    public String getRegistration() {
        return registration.get();
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

    /**
     * Returns text representation of Airplane
     */
    public String toString() {
        return "Airplane " + id.getValue() + " : " + registration.getValue();
    }
}
