package businesslogic;

import businessentitiesapi.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiPredicate;

public class TicketOptionManagerImpl extends ManagerImplBase<TicketOption> implements TicketOptionManager {
    @Override
    List<BiPredicate<TicketOption, String>> getSearchPredicates() {
        return List.of((option, search) -> findMatch(option.getName(), search));
    }

    @Override
    public TicketOption createTicketOption(Integer id, String name, int price
    ) {
        return new TicketOptionImpl(id, name, price);
    }

    @Override
    public TicketOption createTicketOption(String name, int price
    ) {
        return createTicketOption(0, name, price);
    }

}
