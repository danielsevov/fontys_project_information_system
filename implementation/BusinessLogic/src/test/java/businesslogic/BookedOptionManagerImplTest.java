package businesslogic;

import businessentitiesapi.BookedOption;
import businessentitiesapi.Ticket;

class BookedOptionManagerImplTest extends ManagerTestBase<BookedOptionManagerImpl, BookedOption> {
    private final Ticket nullTicket = new TicketImpl(0, null, null, null, null, null, 0);

    @Override
    BookedOption entityCreator(int id) {
        return new BookedOptionImpl(id, nullTicket, new TicketOptionImpl(0, "Test Option", 0));
    }

    @Override
    BookedOptionManagerImpl managerCreator() {
        return new BookedOptionManagerImpl();
    }
}
