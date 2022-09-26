package businesslogic;

import businessentitiesapi.DailyDiscount;
import businessentitiesapi.DailyDiscountManager;

import java.util.List;
import java.util.function.BiPredicate;

public class DailyDiscountManagerImpl extends ManagerImplBase<DailyDiscount> implements DailyDiscountManager {
    private final List<BiPredicate<DailyDiscount, String>> predicates = List.of(
            (a, s) -> findMatch(a.getDay(), s),
            (a, s) -> findMatch(String.valueOf(a.getId()), s)
    );

    @Override
    List<BiPredicate<DailyDiscount, String>> getSearchPredicates() {
        return predicates;
    }
}
