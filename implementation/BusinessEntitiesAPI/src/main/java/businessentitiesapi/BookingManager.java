package businessentitiesapi;

/**
 * {@link Manager} interface for the {@link Booking} entity.
 */
public interface BookingManager extends Manager<Booking, Integer> {

    /**
     * Creates a new {@link Booking} instance.
     *
     * @param customer the customer-buyer
     * @return the new booking
     */
    Booking createBooking(Customer customer);

    /**
     * Creates a new {@link Booking} instance.
     *
     * @param customer the customer-buyer
     * @param id       the id of the booking (placeholder)
     * @return the new booking
     */
    Booking createBooking(Integer id, Customer customer);
}
