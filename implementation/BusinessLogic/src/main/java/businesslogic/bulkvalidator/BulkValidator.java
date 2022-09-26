package businesslogic.bulkvalidator;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Validate key value pairs an mass, for instance when scraping a
 * user interface.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
public class BulkValidator {

    /**
     * Map of field-name to validator.
     * <p>
     * Typical usage: addValidation(Map.of("userform.dob",LocalDate::parse))
     */
    private final Map<String, Validator<?, ?>> validations = new HashMap<>();

    /**
     * Add validation rules as a map.
     *
     * @param values to add
     * @return this BulkValidator
     */
    public final BulkValidator addValidations(Map<String, Validator<?, ?>> values) {
        validations.putAll(values);
        return this;
    }

    /**
     * This 'validator' is used when no validator for a key is provided.
     */
    public static final Validator<Object, IllegalStateException> FAILING_VALIDATOR = (String t) -> {
        throw new IllegalStateException("There is no validator");
    };

    private static final Logger logger = Logger.getLogger(BulkValidator.class.getName());

    /**
     * Validate the values and by attempting to convert them using the
     * registered validators and collect exceptions that occur.
     *
     * @param keyValues to validate
     * @return map of converted inputs
     * @throws BulkException when a validation fails
     */
    public final Map<String, Object> validate(Map<String, String> keyValues) throws BulkException {
        Map<String, Throwable> thrown = new LinkedHashMap<>();
        Map<String, Object> result = new HashMap<>();

        for (Map.Entry<String, String> entry : keyValues.entrySet()) {
            var key = entry.getKey();
            var validator = validations.getOrDefault(key, FAILING_VALIDATOR);

            try {
                result.put(key, validator.validate(entry.getValue()));
            } catch (Throwable throwable) {
                logger.log(Level.SEVERE, String.format("%s %s", key, throwable.getMessage()));
                thrown.put(key, throwable);
            }
        }

        if (!thrown.isEmpty()) {
            throw new BulkException(thrown);
        }
        return result;
    }

}
