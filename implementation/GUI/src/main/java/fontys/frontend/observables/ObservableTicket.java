package fontys.frontend.observables;

import businessentitiesapi.Ticket;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Observable entity for populating the TableView with airport data.
 * <p>
 * The fields of the ObservableTicket are SimpleStringProperties
 * and correspond to the fields of the actual airport.
 */
public class ObservableTicket implements ObservableEntity {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty flight;
    private final SimpleStringProperty customer;
    private final SimpleStringProperty seat_number;
    private final SimpleStringProperty booking;
    private final SimpleStringProperty ticket_type;
    private final SimpleStringProperty price;

    /**
     * Simple constructor for setting up the properties.
     */
    private ObservableTicket(int id, String flight, String customer, String seatNumber, String booking, String ticketType, String price) {
        this.id = new SimpleIntegerProperty(id);
        this.flight = new SimpleStringProperty(flight);
        this.customer = new SimpleStringProperty(customer);
        this.seat_number = new SimpleStringProperty(seatNumber);
        this.booking = new SimpleStringProperty(booking);
        this.ticket_type = new SimpleStringProperty(ticketType);
        this.price = new SimpleStringProperty(price);
    }

    /**
     * Creates ObservableCustomer from Customer.
     */
    public static ObservableTicket fromTicket(Ticket ticket) {
        return new ObservableTicket(
                ticket.getId(),
                ticket.getFlight().toString(),
                ticket.getCustomer().getName(),
                ticket.getSeatNumber(),
                String.valueOf(ticket.getBooking().getId()),
                String.valueOf(ticket.getTicketType().getName()),
                String.valueOf(ticket.getPrice())
        );
    }

    /**
     * The getters and setters are needed for setting the cell value
     * factory of the TableView by extracting the corresponding
     * property value (field value) with a PropertyValueFactory.
     * <p>
     * Setter and getter for location.
     */
    public void setFlight(String value) {
        flight.set(value);
    }

    public String getFlight() {
        return flight.get();
    }

    /**
     * Setter and getter for name.
     */
    public void setCustomer(String value) {
        customer.set(value);
    }

    public String getCustomer() {
        return customer.get();
    }

    /**
     * Setter and getter for seat_number.
     */
    public void setSeat_number(String value) {
        seat_number.set(value);
    }

    public String getSeat_number() {
        return seat_number.get();
    }

    /**
     * Setter and getter for ticket_type.
     */
    public void setTicket_type(String value) {
        ticket_type.set(value);
    }

    public String getTicket_type() {
        return ticket_type.get();
    }


    /**
     * Setter and getter for booking.
     */
    public void setBooking(String value) {
        booking.set(value);
    }

    public String getBooking() {
        return booking.get();
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
        return "Ticket " + id.get();
    }
}
