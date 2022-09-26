package businesslogic.bulkvalidator;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import static businesslogic.bulkvalidator.Validator.validateWith;
import static org.assertj.core.api.Assertions.*;

/**
 * Test BulkValidator.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
public class BulkValidatorTest {

    BulkValidator bv = new BulkValidator().addValidations(
            Map.of(
                    "customer.id", Integer::valueOf,
                    "customer.someInt", validateWith(Integer::valueOf,
                            BusinessException::new,
                            "Invalid integer"),
                    "customer.birthDate", LocalDate::parse,
                    "customer.postcode", BulkValidatorTest::validatePC
            ));

    Map<String, Function<String, Object>> conversions = Map.of(
            "Integer", Integer::valueOf,
            "LocalDate", LocalDate::parse,
            "String", x -> x
    );

    /**
     * Values that should not throw exceptions.
     *
     * @param fieldName of the input
     * @param input     the input.
     */
    @ParameterizedTest
    @CsvSource({
            "customer.postcode,1234 AB,String",
            "customer.someInt,42,Integer",
            "customer.id,123,Integer",
            "customer.birthDate,1999-03-16,LocalDate"
    })
    void validatesOkayNoExceptions(String fieldName, String input, String typeName) {
        Map<String, String> values = Map.of(fieldName, input);
        assertThatCode(() -> bv.validate(values)).doesNotThrowAnyException();
    }

    /**
     * Values that should not throw exceptions. Check for correct conversion.
     *
     * @param fieldName of the input
     * @param input     the input.
     */
    @ParameterizedTest
    @CsvSource({
            "customer.postcode,1234 AB,String",
            "customer.someInt,42,Integer",
            "customer.id,123,Integer",
            "customer.birthDate,1999-03-16,LocalDate",})
    void validatesOkayNoConversions(String fieldName, String input, String typeName) throws BulkException {
        Map<String, String> values = Map.of(fieldName, input);
        Object conversion = conversions.get(typeName).apply(input);
        Map<String, Object> expectedConversions = Map.of(fieldName, conversion);
        var validated = bv.validate(values);
        assertThat(validated).isEqualTo(expectedConversions);
    }

    Map<String, Class<? extends Throwable>> exNames = Map.of(
            "IllegalStateException", IllegalStateException.class,
            "BusinessException", BusinessException.class,
            "NumberFormatException", NumberFormatException.class,
            "DateTimeParseException", DateTimeParseException.class
    );

    /**
     * Test simple values with field name.
     * Check correct exception type.
     *
     * @param fieldName    identifies input
     * @param input        value
     * @param exName       exception
     * @param messageWords list of words expected in exception.
     */
    @ParameterizedTest
    @CsvSource({
            "unknown,1234 AB,IllegalStateException,no|validator",
            "customer.postcode,1234 A,BusinessException,1234 A|is not a valid postcode",
            "customer.id,123Q,NumberFormatException,For|input|string|123Q",
            "customer.someInt,rabarber,BusinessException,Invalid|integer",
            "customer.birthDate,not a date,DateTimeParseException,Text|not a date|could not be parsed at index"
    })
    void validatesNotOkayException(String fieldName, String input, String exName, String messageWords) {
        Class<? extends Throwable> expectedException = exNames.get(exName);
        Map<String, String> values = Map.of(fieldName, input);
        var throwable = catchThrowableOfType(() -> bv.validate(values), BulkException.class);
        assertThat(throwable.getCauses().values()).extracting("class").contains(expectedException);
    }

    static class MockHandler extends Handler {

        final StringBuilder out;

        public MockHandler(StringBuilder out) {
            this.out = out;
        }

        @Override
        public void publish(LogRecord record) {
            out.append(record.getMessage());
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() throws SecurityException {
        }

    }

    /**
     * Check that the errors are logged.
     */
    @Test
    void tCheckLogging() {
        final StringBuilder out = new StringBuilder();
        Logger logger = Logger.getLogger(BulkValidator.class.getName());
        Handler handler = new MockHandler(out);
        logger.addHandler(handler);
        SoftAssertions.assertSoftly(s -> {
            s.assertThatThrownBy(() -> bv.validate(Map.of("unknown", "whatever")))
                    .isInstanceOf(BulkException.class);
            s.assertThat(out).contains("unknown", "no validator");
        });
    }

    /**
     * Test simple values with field name.
     * Assert the proper exception message content.
     *
     * @param fieldName    identifies input
     * @param input        value
     * @param exName       exception
     * @param messageWords list of words expected in exception.
     */
    @ParameterizedTest
    @CsvSource({
            "unknown,1234 AB,IllegalStateException,no|validator",
            "customer.postcode,1234 A,BusinessException,1234 A|is not a valid postcode",
            "customer.id,123Q,NumberFormatException,For|input|string|123Q",
            "customer.someInt,rabarber,BusinessException,Invalid|integer",
            "customer.birthDate,not a date,DateTimeParseException,Text|not a date|could not be parsed at index"
    })
    void validatesNotOkayWords(String fieldName, String input, String exName, String messageWords) {
        String[] words = messageWords.split("\\|");
        Map<String, String> values = Map.of(fieldName, input);
        var throwable = catchThrowableOfType(() -> bv.validate(values), BulkException.class);
        assertThat(throwable.getCauses().values()).first()
                .extracting(Throwable::getMessage).asString().contains(words);
    }

    /**
     * Test with multiple values with two fails. Try with three mutations of
     * key,value pairs. Expect exceptions
     *
     * @param k1 pair1 key
     * @param v1 pair1 value
     * @param k2 key
     * @param v2 value
     * @param k3 key
     * @param v3 value
     * @code {NumberFormatException.class} and {@code BusinessException.class}
     */
    @ParameterizedTest
    @CsvSource({
            "customer.id,acd,customer.postcode,NO NO,customer.someInt,123",
            "customer.postcode,NO NO,customer.someInt,123,customer.id,acd",
            "customer.someInt,123,customer.postcode,NO NO,customer.id,acd",})
    void tMultipleErrors(String k1, String v1, String k2, String v2, String k3,
                         String v3) {

        Map<String, String> values = Map.of(k1, v1, k2, v2, k3, v3);
        var throwable = catchThrowableOfType(() -> bv.validate(values), BulkException.class);
        assertThat(throwable.getCauses().values()).extracting("class")
                .contains(NumberFormatException.class, BusinessException.class);
    }

    /**
     * Regex for Dutch postal code.
     */
    public static final Predicate<String> pc = Pattern.compile("^\\d{4}\\s?[A-Z]{2}$").asMatchPredicate();

    /**
     * Example validator, that uses a regular expression (above)
     *
     * @param in input string
     * @return the converted value
     * @throws BusinessException when regex does not match.
     */
    public static String validatePC(String in) {
        if (!pc.test(in)) {
            throw new BusinessException("'" + in
                    + "' is not a valid postcode",
                    null);
        }
        return in;
    }


    @Test
    public void tExampleUseOkay() {
        Map<String, String> inputs = Map.of(
                "customer.postcode", "1234 AB",
                "customer.someInt", "42",
                "customer.id", "123",
                "customer.birthDate", "1999-03-21"
        );
        Consumer<Map<String, Object>> businessCode
                = m -> m.forEach((k, v) -> System.out.println(k + "="
                + v.toString()));
        assertThatCode(() -> {
                    Map<String, Object> request = bv.validate(inputs);
                    businessCode.accept(request);
                }
        ).doesNotThrowAnyException();
    }


    @Test
    public void tExampleUseNotOkay() {
        Map<String, String> inputs = Map.of(
                "customer.postcode", "1234 AB",
                "customer.someInt", "42",
                "customer.id", "123",
                "customer.birthDate", "1999-OKTA-21",
                "unknown", "123456"
        );
        Consumer<Map<String, Object>> businessCode
                = m -> m.forEach((k, v) -> System.out.println(k + "="
                + v.toString()));

        Consumer<Map<String, Throwable>> exceptionProcessor
                = m -> m.forEach((k, v) -> System.out.println(k + "="
                + v.toString()));
        try {
            Map<String, Object> request = bv.validate(inputs);
            businessCode.accept(request);
        } catch (BulkException bex) {
            exceptionProcessor.accept(bex.getCauses());
            assertThat(bex.getCauses()).containsKey("unknown");
        }
    }
}
