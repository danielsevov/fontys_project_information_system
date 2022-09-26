package businesslogic;

import businessentitiesapi.TicketType;
import businessentitiesapi.TicketTypeManager;

import java.util.List;
import java.util.function.BiPredicate;

public class TicketTypeManagerImpl extends ManagerImplBase<TicketType> implements TicketTypeManager {
    @Override
    public TicketType createTicketType(String name, double multiplier) {
        return new TicketTypeImpl(0, name, multiplier);
    }

    @Override
    List<BiPredicate<TicketType, String>> getSearchPredicates() {
        return List.of((ticketType, b) -> findMatch(ticketType.getName(), b));
    }
}
