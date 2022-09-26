package businessentitiesapi;

/**
 * Booking interface, representing a collection of tickets.
 */
public interface Booking extends Entity {
    /**
     * Return the buyer of this booking.
     *
     * @return the buyer of this booking
     */
    Customer getBuyer();
}
