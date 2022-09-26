package businesslogic;

import businessentitiesapi.*;

import java.util.List;
import java.util.function.BiPredicate;

public class TicketManagerImpl extends ManagerImplBase<Ticket> implements TicketManager {
    private final List<BiPredicate<Ticket, String>> predicates = List.of(
            (t, s) -> findMatch(t.getSeatNumber(), s),
            (t, s) -> findMatch(String.valueOf(t.getId()), s),
            (t, s) -> findMatch(t.getCustomer().getName(), s)
    );

    @Override
    public Ticket createTicket(Flight flight, Customer customer, String seatNumber, Booking booking, TicketType ticketType, double price) {
        return new TicketImpl(0, flight, customer, seatNumber, booking, ticketType, price);
    }

    @Override
    List<BiPredicate<Ticket, String>> getSearchPredicates() {
        return predicates;
    }
}
