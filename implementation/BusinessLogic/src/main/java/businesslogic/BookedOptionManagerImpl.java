package businesslogic;

import businessentitiesapi.BookedOption;
import businessentitiesapi.BookedOptionManager;
import businessentitiesapi.Ticket;
import businessentitiesapi.TicketOption;

import java.util.List;
import java.util.function.BiPredicate;

public class BookedOptionManagerImpl extends ManagerImplBase<BookedOption> implements BookedOptionManager {
    private final List<BiPredicate<BookedOption, String>> predicates = List.of(
            (o, b) -> findMatch(o.getTicketOption().getName(), b)
    );

    @Override
    public BookedOption createBookedOption(Ticket ticket, TicketOption ticketOption) {
        return new BookedOptionImpl(0, ticket, ticketOption);
    }

    @Override
    List<BiPredicate<BookedOption, String>> getSearchPredicates() {
        return predicates;
    }
}
