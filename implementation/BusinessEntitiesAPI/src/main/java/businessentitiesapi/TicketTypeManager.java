package businessentitiesapi;

/**
 * {@link Manager} interface for the {@link TicketType} entity.
 */
public interface TicketTypeManager extends Manager<TicketType, Integer> {
    /**
     * Creates a new {@link TicketType} instance.
     *
     * @param name       the name of the ticket type
     * @param multiplier the price multiplier of the ticket type
     * @return the new ticket type
     */
    TicketType createTicketType(String name, double multiplier);
}
