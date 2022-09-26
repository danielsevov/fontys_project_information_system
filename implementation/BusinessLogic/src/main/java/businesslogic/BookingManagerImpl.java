package businesslogic;

import businessentitiesapi.Booking;
import businessentitiesapi.BookingManager;
import businessentitiesapi.Customer;

import java.util.List;
import java.util.function.BiPredicate;

public class BookingManagerImpl extends ManagerImplBase<Booking> implements BookingManager {
    private final List<BiPredicate<Booking, String>> predicates = List.of(
            (b, s) -> findMatch(b.getBuyer().getName(), s),
            (b, s) -> findMatch(String.valueOf(b.getId()), s)
    );

    @Override
    public Booking createBooking(Customer customer) {
        return new BookingImpl(0, customer);
    }

    @Override
    public Booking createBooking(Integer id, Customer customer) {
        return new BookingImpl(id, customer);
    }

    @Override
    List<BiPredicate<Booking, String>> getSearchPredicates() {
        return predicates;
    }
}
