package businessentitiesapi;

import java.time.LocalDateTime;
import java.util.List;

/**
 * {@link Manager} interface for the {@link Flight} entity.
 */
public interface FlightManager extends Manager<Flight, Integer> {
    /**
     * Creates a new flight instance.
     *
     * @param airplane         the airplane that is associated with the new flight
     * @param departure        the departure time of the new flight
     * @param arrival          the arrival time of the new flight
     * @param departureAirport the departure airport of the new flight
     * @param arrivalAirport   the arrival airport of the new flight
     * @param price            the price of the new flight
     * @return the new flight
     */
    Flight createFlight(Airplane airplane, LocalDateTime departure, LocalDateTime arrival,
                        Airport departureAirport, Airport arrivalAirport, double price);

    /**
     * Find qualified airplanes for a given interval and departure airport.
     *
     * @param departure        the departure time
     * @param arrival          the arrival time
     * @param departureAirport the departure airport
     * @return list of qualified airplanes
     */
    List<Airplane> findQualifiedAirplanes(LocalDateTime departure, LocalDateTime arrival, Airport departureAirport);

}
