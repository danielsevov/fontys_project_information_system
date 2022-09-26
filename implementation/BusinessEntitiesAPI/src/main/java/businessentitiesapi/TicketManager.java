package businessentitiesapi;

/**
 * {@link Manager} interface for the {@link Ticket} entity.
 */
public interface TicketManager extends Manager<Ticket, Integer> {
    /**
     * Creates a new {@link Ticket} instance.
     *
     * @param flight     the flight of the new ticket
     * @param customer   the customer of the new ticket
     * @param seatNumber the seat_number of the new ticket
     * @param booking    the booking of the new ticket
     * @param ticketType the type of the new ticket.
     * @param price      the price of this ticket.
     * @return the new ticket
     */
    Ticket createTicket(Flight flight, Customer customer, String seatNumber, Booking booking, TicketType ticketType, double price);
}
