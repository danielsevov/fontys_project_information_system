package businesslogic.validation;

import businesslogic.bulkvalidator.BulkException;
import businesslogic.bulkvalidator.BulkValidator;

import java.util.Map;

/**
 * Handler class for user input that is gathered in the ticket creation controller.
 */
public class TicketRegistrationHandler {
    private final BulkValidator validator = new BulkValidator().addValidations(
            Map.of(
                    "flightField", this::notNullOrBlank,
                    "customerField", this::notNullOrBlank,
                    "classField", this::notNullOrBlank,
                    "optionField", this::optionalString
            )
    );

    private String notNullOrBlank(String string) {
        if ("null".equals(string) || string.isBlank()) {
            throw new ValidationException("This field should not be empty!");
        }
        // we don't really care about the return type of this.
        return string;
    }

    private String optionalString(String string) {
        return string;
    }

    /**
     * Validate whether the provided user input passes all checks.
     *
     * @param userInput the provided user input
     * @throws BulkException the exception that is thrown on check failure
     */
    public void validateTicketInfo(Map<String, String> userInput) throws BulkException {
        validator.validate(userInput);
    }
}
