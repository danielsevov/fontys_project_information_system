package businessentitiesapi;

/**
 * Ticket options for a selected flight.
 */
public interface TicketOption extends Entity {
    /**
     * Return the name of this option.
     *
     * @return the name of this option
     */
    String getName();

    /**
     * Return the price of this option.
     *
     * @return the price of this option
     */
    int getPrice();
}
