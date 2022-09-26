package businesslogic;

import businessentitiesapi.Customer;
import businessentitiesapi.CustomerManager;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BiPredicate;

public class CustomerManagerImpl extends ManagerImplBase<Customer> implements CustomerManager {
    private final List<BiPredicate<Customer, String>> predicates = List.of(
            (c, s) -> findMatch(c.getName(), s),
            (c, s) -> findMatch(String.valueOf(c.getId()), s),
            (c, s) -> findMatch(c.getEmail(), s),
            (c, s) -> findMatch(c.getBirthDate().toString(), s)
    );

    @Override
    public Customer createCustomer(String name, String email, LocalDate birthdate) {
        return new CustomerImpl(0, name, email, birthdate);
    }

    @Override
    public Customer createCustomer(Integer id, String name, String email, LocalDate birthdate) {
        return new CustomerImpl(id, name, email, birthdate);
    }

    @Override
    List<BiPredicate<Customer, String>> getSearchPredicates() {
        return predicates;
    }
}
