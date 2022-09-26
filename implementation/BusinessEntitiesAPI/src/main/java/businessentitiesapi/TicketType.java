package businessentitiesapi;

/**
 * Ticket type interface for varying ticket price classes.
 */
public interface TicketType extends Entity {
    /**
     * Return the name of this ticket type.
     *
     * @return the name of this ticket type
     */
    String getName();

    /**
     * Return the default multiplier of this ticket type.
     * This is used to compute the finalised price of a ticket.
     *
     * @return the multiplier of this ticket type
     */
    double getMultiplier();
}
