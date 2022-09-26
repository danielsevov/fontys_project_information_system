package businesslogic;

import businessentitiesapi.TicketOption;

class TicketOptionManagerImplTest extends ManagerTestBase<TicketOptionManagerImpl, TicketOption> {
    @Override
    TicketOption entityCreator(int id) {
        return new TicketOptionImpl(id, "Test option", 0);
    }

    @Override
    TicketOptionManagerImpl managerCreator() {
        return new TicketOptionManagerImpl();
    }
}
