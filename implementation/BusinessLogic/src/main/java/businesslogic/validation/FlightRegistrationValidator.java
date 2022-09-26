package businesslogic.validation;

import businesslogic.bulkvalidator.BulkException;
import businesslogic.bulkvalidator.BulkValidator;

import java.time.LocalDateTime;
import java.util.Map;

import static java.lang.String.format;

/**
 * Handler class for user input that is gathered in the flight registration controller.
 *
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
public class FlightRegistrationValidator {
    private final BulkValidator validator = new BulkValidator().addValidations(
            Map.of(
                    "departDatetime", this::validateDateTime,
                    "arrivalDatetime", this::validateDateTime,
                    "departField", this::notNullOrBlank,
                    "arriveField", this::notNullOrBlank,
                    "priceField", this::validatePrice,
                    "planeField", this::validatePlane
            )
    );

    private LocalDateTime validateDateTime(String string) {
        try {
            return LocalDateTime.parse(string);
        } catch (Exception e) {
            throw new ValidationException("Provide a valid time!");
        }
    }

    private String notNullOrBlank(String string) {
        if ("null".equals(string) || string.isBlank()) {
            throw new ValidationException("This should not be empty!");
        }
        // we don't really care about the return type of this.
        return string;
    }

    private String validatePlane(String plane) {
        if ("null".equals(plane)) {
            throw new ValidationException("Select a plane for this flight!");
        }
        return plane;
    }

    private int validatePrice(String price) {
        int parsed;
        try {
            parsed = Integer.parseInt(price);
        } catch (NumberFormatException ex) {
            throw new ValidationException(format("'%s' is not a valid price for this flight!", price));
        }

        if (parsed <= 0) {
            throw new ValidationException("The price should be a positive integer!");
        }

        return parsed;
    }

    /**
     * Validate whether the provided user input passes all checks.
     *
     * @param userInput the provided user input
     * @throws BulkException the exception that is thrown on check failure
     */
    public void validateFlightInfo(Map<String, String> userInput) throws BulkException {
        validator.validate(userInput);
    }
}
