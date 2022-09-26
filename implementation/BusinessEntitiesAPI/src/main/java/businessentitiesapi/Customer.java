package businessentitiesapi;

import java.time.LocalDate;

/**
 * Customer interface for tickets and bookings.
 */
public interface Customer extends Entity {

    /**
     * Returns the name of this customer.
     *
     * @return the name of this customer
     */
    String getName();

    /**
     * Returns the email of this customer.
     *
     * @return the email of this customer
     */
    String getEmail();

    /**
     * Returns the birthdate of this customer.
     *
     * @return the birthdate of this customer
     */
    LocalDate getBirthDate();
}
