package businessentitiesapi;

import java.time.LocalDate;

/**
 * {@link Manager} interface for the {@link Customer} entity.
 */
public interface CustomerManager extends Manager<Customer, Integer> {

    /**
     * Creates a new {@link Customer} instance.
     *
     * @param name      the name of the new customer
     * @param email     the email of the new customer
     * @param birthdate the email of the new customer
     * @return the new customer
     */
    Customer createCustomer(String name, String email, LocalDate birthdate);

    /**
     * Creates a new {@link Customer} instance.
     *
     * @param name      the name of the new customer
     * @param email     the email of the new customer
     * @param birthdate the email of the new customer
     * @param id        the id of the customer (placeholder)
     * @return the new customer
     */
    Customer createCustomer(Integer id, String name, String email, LocalDate birthdate);
}
