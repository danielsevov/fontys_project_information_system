package fontys.frontend.observables;

import businessentitiesapi.Flight;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Observable entity for populating the TableView with flight data.
 * <p>
 * The fields of the ObservableFlight are SimpleStringProperties
 * and correspond to the fields of the actual flight.
 */
public class ObservableFlight implements ObservableEntity {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty plane;
    private final SimpleStringProperty departurePort;
    private final SimpleStringProperty arrivalPort;
    private final SimpleStringProperty departureTime;
    private final SimpleStringProperty arrivalTime;
    private final SimpleStringProperty price;

    /**
     * Simple constructor for setting up the properties.
     */
    private ObservableFlight(int id, String plane, String departurePort, String arrivalPort, String departureTime, String arrivalTime, String price) {
        this.id = new SimpleIntegerProperty(id);
        this.plane = new SimpleStringProperty(plane);
        this.departurePort = new SimpleStringProperty(departurePort);
        this.arrivalPort = new SimpleStringProperty(arrivalPort);
        this.departureTime = new SimpleStringProperty(departureTime);
        this.arrivalTime = new SimpleStringProperty(arrivalTime);
        this.price = new SimpleStringProperty(price);
    }

    /**
     * Creates ObservableFlight from Flight.
     */
    public static ObservableFlight fromFlight(Flight flight) {
        return new ObservableFlight(
                flight.getId(),
                flight.getPlane().getRegistrationNumber(),
                flight.getDepartureAirport().getName(),
                flight.getArrivalAirport().getName(),
                flight.getDepartureDatetime().toString(),
                flight.getArrivalDatetime().toString(),
                flight.getPrice().toString()
        );
    }

    /**
     * The getters and setters are needed for setting the cell value
     * factory of the TableView by extracting the corresponding
     * property value (field value) with a PropertyValueFactory.
     * <p>
     * Setter and getter for plane.
     */
    public void setPlane(String value) {
        plane.set(value);
    }

    public String getPlane() {
        return plane.get();
    }

    /**
     * Setter and getter for departurePort.
     */
    public void setDeparturePort(String value) {
        departurePort.set(value);
    }

    public String getDeparturePort() {
        return departurePort.get();
    }

    /**
     * Setter and getter for arrivalPort.
     */
    public void setArrivalPort(String value) {
        arrivalPort.set(value);
    }

    public String getArrivalPort() {
        return arrivalPort.get();
    }

    /**
     * Setter and getter for departureTime.
     */
    public void setDepartureTime(String value) {
        departureTime.set(value);
    }

    public String getDepartureTime() {
        return departureTime.get();
    }

    /**
     * Setter and getter for price.
     */
    public void setPrice(String value) {
        price.set(value);
    }

    public String getPrice() {
        return price.get();
    }

    /**
     * Setter and getter for arrivalTime.
     */
    public void setArrivalTime(String value) {
        arrivalTime.set(value);
    }

    public String getArrivalTime() {
        return arrivalTime.get();
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
        return String.format("Flight %s : %s-%s", id, departurePort.getValue(), arrivalPort.getValue());
    }
}
