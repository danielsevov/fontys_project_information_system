package businesslogic;

import businessentitiesapi.TicketType;

class TicketTypeManagerImplTest extends ManagerTestBase<TicketTypeManagerImpl, TicketType> {
    @Override
    TicketType entityCreator(int id) {
        return new TicketTypeImpl(id, "Test type", 0);
    }

    @Override
    TicketTypeManagerImpl managerCreator() {
        return new TicketTypeManagerImpl();
    }
}
