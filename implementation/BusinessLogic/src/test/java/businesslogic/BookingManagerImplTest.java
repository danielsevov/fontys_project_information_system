package businesslogic;

import businessentitiesapi.Booking;

import java.time.LocalDate;

class BookingManagerImplTest extends ManagerTestBase<BookingManagerImpl, Booking> {
    @Override
    Booking entityCreator(int id) {
        return new BookingImpl(id, new CustomerImpl(0, "Test name", "Test email", LocalDate.MAX));
    }

    @Override
    BookingManagerImpl managerCreator() {
        return new BookingManagerImpl();
    }
}
