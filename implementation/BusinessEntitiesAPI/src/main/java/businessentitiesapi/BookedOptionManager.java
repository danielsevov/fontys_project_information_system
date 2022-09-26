package businessentitiesapi;

public interface BookedOptionManager extends Manager<BookedOption, Integer> {
    /**
     * Create a new booked option for a ticket.
     *
     * @param ticket       the associated ticket
     * @param ticketOption the booking option that was chosen
     * @return the finalised booked option
     */
    BookedOption createBookedOption(Ticket ticket, TicketOption ticketOption);
}
