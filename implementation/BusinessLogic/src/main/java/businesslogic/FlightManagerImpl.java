package businesslogic;

import businessentitiesapi.Airplane;
import businessentitiesapi.Airport;
import businessentitiesapi.Flight;
import businessentitiesapi.FlightManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class FlightManagerImpl extends ManagerImplBase<Flight> implements FlightManager {
    // List of predicates for our look-up function.
    private final List<BiPredicate<Flight, String>> predicates = List.of(
            (f, s) -> findMatch(f.getArrivalAirport().getName(), s),
            (f, s) -> findMatch(f.getDepartureAirport().getName(), s),
            (f, s) -> findMatch(f.getPlane().getRegistrationNumber(), s),
            (f, s) -> findMatch(String.valueOf(f.getId()), s)
    );

    @Override
    public Flight createFlight(Airplane airplane, LocalDateTime departure, LocalDateTime arrival,
                               Airport departureAirport, Airport arrivalAirport, double price) {
        return new FlightImpl(0, departure, arrival, airplane, departureAirport,
                arrivalAirport, price);
    }

    @Override
    List<BiPredicate<Flight, String>> getSearchPredicates() {
        return predicates;
    }

    @Override
    public List<Airplane> findQualifiedAirplanes(LocalDateTime departure, LocalDateTime arrival, Airport departureAirport) {
        var query = "SELECT * FROM flight WHERE departure_airport = ? AND tsrange(departure_datetime, arrival_datetime)" +
                " && tsrange(?::timestamp, ?::timestamp) = false";
        return anyQuery(query, departureAirport.getId(), departure, arrival).stream()
                .map(Flight::getPlane).collect(Collectors.toList());
    }
}
