package businessentitiesapi;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Flight interface, representing an established flight from
 * a {@link Flight#getDepartureAirport() departure airport} to an {@link Flight#getArrivalAirport() arrival airport}.
 */
public interface Flight extends Entity {
    /**
     * Returns the airplane that is associated with this flight.
     *
     * @return the associated airplane
     */
    Airplane getPlane();

    /**
     * Returns the departure airport of this flight.
     *
     * @return the departure airport
     */
    Airport getDepartureAirport();

    /**
     * Returns the arrival airport of this flight.
     *
     * @return the arrival airport
     */
    Airport getArrivalAirport();

    /**
     * Returns the arrival time of this flight. The arrival time generally comes after
     * the departure time of a flight.
     *
     * @return the arrival time
     */
    LocalDateTime getArrivalDatetime();

    /**
     * Returns the departure time of this flight. The departure time generally comes before
     * the arrival time of a flight.
     *
     * @return the departure time
     */
    LocalDateTime getDepartureDatetime();

    /**
     * Returns whether this flight overlaps with a specified time range.
     * The flight overlaps with a time range if [startTime, endTime) collides with
     * its own [departure, arrival) time range.
     *
     * @param startTime the start time of this range
     * @param endTime   the end time of this range
     * @return <code>true</code> if this flight overlaps with the time range;
     * <code>false</code> otherwise.
     */
    boolean hasOverlapWith(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * Returns the ID of this flight.
     *
     * @return the ID
     */
    int getId();

    /**
     * Returns the price of this flight.
     *
     * @return the price
     */
    Double getPrice();

    /**
     * Returns the duration of this flight.
     *
     * @return the duration
     */
    Duration getDuration();
}
