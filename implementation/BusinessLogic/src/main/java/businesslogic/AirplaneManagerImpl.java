package businesslogic;

import businessentitiesapi.Airplane;
import businessentitiesapi.AirplaneManager;

import java.util.List;
import java.util.function.BiPredicate;

public class AirplaneManagerImpl extends ManagerImplBase<Airplane> implements AirplaneManager {
    private final List<BiPredicate<Airplane, String>> predicates = List.of(
            (a, s) -> findMatch(a.getRegistrationNumber(), s),
            (a, s) -> findMatch(String.valueOf(a.getId()), s),
            (a, s) -> findMatch(String.valueOf(a.getMaxCapacity()), s)
    );

    @Override
    public Airplane createAirplane(String registrationNumber, int maxCapacity) {
        return new AirplaneImpl(0, registrationNumber, maxCapacity);
    }

    @Override
    public Airplane createAirplane(Integer id, String registrationNumber, int maxCapacity) {
        return new AirplaneImpl(id, registrationNumber, maxCapacity);
    }

    @Override
    List<BiPredicate<Airplane, String>> getSearchPredicates() {
        return predicates;
    }
}
