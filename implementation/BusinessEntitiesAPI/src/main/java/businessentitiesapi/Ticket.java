package businessentitiesapi;

/**
 * Ticket interface.
 */
public interface Ticket extends Entity {
    /**
     * Return the associated flight of this ticket.
     *
     * @return the associated flight
     */
    Flight getFlight();

    /**
     * Return the buyer of this ticket.
     *
     * @return the buyer of this ticket
     */
    Customer getCustomer();

    /**
     * Return the booking this ticket is associated with.
     *
     * @return the booking this ticket is associated with
     */
    Booking getBooking();

    /**
     * Return the seat number for this ticket.
     *
     * @return seat number for this ticket
     */
    String getSeatNumber();

    /**
     * Return the type of this ticket.
     *
     * @return the type of this ticket
     */
    TicketType getTicketType();

    /**
     * Return the price of this ticket.
     * This also includes booked options.
     *
     * @return the price of this ticket
     */
    double getPrice();
}
