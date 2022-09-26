package businesslogic.validation;

import businesslogic.bulkvalidator.BulkException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class TicketRegistrationHandlerTest {
    private final TicketRegistrationHandler handler = new TicketRegistrationHandler();

    @ParameterizedTest
    @CsvSource({
            "flightField,Flight 1",
            "customerField,Ivan Ivanov",
            "classField,Business Class"
    })
    void testValidateFlightInfoCorrect(String fieldName, String input) {
        // We don't make use of the converted results.
        assertThatCode(() -> handler.validateTicketInfo(Map.of(fieldName, input))).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({
            "flightField,null,This field should not be empty!",
            "customerField,null,This field should not be empty!",
            "classField,null,This field should not be empty!",
    })
    void testValidateFlightInfoIncorrect(String fieldName, String input, String message) {
        // We only use the handler to validate user input as opposed to converting it.
        ThrowableAssert.ThrowingCallable lambda = () -> handler.validateTicketInfo(Map.of(fieldName, input));
        var exceptions = catchThrowableOfType(lambda, BulkException.class);
        assertThat(exceptions.getCauses().values()).first().asString().contains(message);
    }
}
