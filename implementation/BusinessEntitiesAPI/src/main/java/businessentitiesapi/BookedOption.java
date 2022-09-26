package businessentitiesapi;

public interface BookedOption extends Entity {
    /**
     * Return the associated ticket.
     *
     * @return the associated ticket
     */
    Ticket getTicket();

    /**
     * Return the associated ticket option.
     *
     * @return the associated ticket option
     */
    TicketOption getTicketOption();
}
