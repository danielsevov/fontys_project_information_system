package businesslogic;

import businessentitiesapi.Airport;
import businessentitiesapi.AirportManager;

import java.util.List;
import java.util.function.BiPredicate;

public class AirportManagerImpl extends ManagerImplBase<Airport> implements AirportManager {
    private final List<BiPredicate<Airport, String>> predicates = List.of(
            (a, s) -> findMatch(a.getName(), s),
            (a, s) -> findMatch(String.valueOf(a.getId()), s),
            (a, s) -> findMatch(a.getLocation(), s)
    );

    @Override
    public Airport createAirport(String name, String location) {
        return new AirportImpl(0, name, location);
    }

    @Override
    public Airport createAirport(Integer id, String name, String location) {
        return new AirportImpl(id, name, location);
    }

    @Override
    List<BiPredicate<Airport, String>> getSearchPredicates() {
        return predicates;
    }
}
