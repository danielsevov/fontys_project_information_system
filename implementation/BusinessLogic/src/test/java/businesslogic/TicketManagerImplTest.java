package businesslogic;

import businessentitiesapi.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

class TicketManagerImplTest extends ManagerTestBase<TicketManagerImpl, Ticket> {
    private final Airplane plane = new AirplaneImpl(0, "Test airplane", 0);
    private final Airport airport = new AirportImpl(0, "Test airport", "Test location");
    private final Customer customer = new CustomerImpl(0, "Test", "email", LocalDate.MAX);
    private final Flight flight = new FlightImpl(0, LocalDateTime.MIN, LocalDateTime.MAX, plane, airport, airport, 0);

    @Override
    Ticket entityCreator(int id) {
        return new TicketImpl(
                id,
                flight,
                customer,
                "1A",
                new BookingImpl(0, customer),
                new TicketTypeImpl(0, "Test type", 0),
                0);
    }

    @Override
    TicketManagerImpl managerCreator() {
        return new TicketManagerImpl();
    }
}
