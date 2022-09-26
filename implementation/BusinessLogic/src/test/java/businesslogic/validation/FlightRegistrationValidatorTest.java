package businesslogic.validation;

import businesslogic.bulkvalidator.BulkException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
class FlightRegistrationValidatorTest {
    private final FlightRegistrationValidator validator = new FlightRegistrationValidator();

    @ParameterizedTest
    @CsvSource({
            "arrivalDatetime,2021-06-06T07:17",
            "departField,Hamburg Airport",
            "priceField,200",
            "planeField,XX-YY-ZZ"
    })
    void testValidateFlightInfoCorrect(String fieldName, String input) {
        // We don't make use of the converted results.
        assertThatCode(() -> validator.validateFlightInfo(Map.of(fieldName, input))).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({
            "arrivalDatetime,12312312,Provide a valid time",
            // the scraper transforms null to "null"
            "departField,null,This should not be empty",
            "priceField,-1,The price should be a positive integer",
            "priceField,hello,is not a valid price for this flight",
            "planeField,null,Select a plane for this flight"
    })
    void testValidateFlightInfoIncorrect(String fieldName, String input, String message) {
        // We only use the handler to validate user input as opposed to converting it.
        ThrowableAssert.ThrowingCallable lambda = () -> validator.validateFlightInfo(Map.of(fieldName, input));
        var exceptions = catchThrowableOfType(lambda, BulkException.class);
        assertThat(exceptions.getCauses().values()).first().asString().contains(message);
    }
}
