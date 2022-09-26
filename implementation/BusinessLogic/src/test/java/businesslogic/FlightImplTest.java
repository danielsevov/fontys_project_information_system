package businesslogic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
class FlightImplTest {
    private final static LocalDateTime NOW = LocalDateTime.now();

    private static LocalDateTime offsetBy(int hours) {
        return NOW.plusHours(hours);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> provideOverlapInfo() {
        return Stream.of(
                Arguments.of(NOW, offsetBy(5), offsetBy(2), offsetBy(6), true),
                Arguments.of(NOW, NOW, offsetBy(2), offsetBy(6), false),
                Arguments.of(NOW, offsetBy(2), offsetBy(2), offsetBy(6), false),
                Arguments.of(NOW, offsetBy(2), offsetBy(2), offsetBy(1), true),
                Arguments.of(offsetBy(2), offsetBy(4), offsetBy(2), offsetBy(4), true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideOverlapInfo")
    void testHasOverlapWith(LocalDateTime firstStart, LocalDateTime firstEnd,
                            LocalDateTime secondStart, LocalDateTime secondEnd, boolean expectedResult) {
        // This is already tested by proxy with LocalDateTimeRange tests.
        var flight = new FlightImpl(0, firstStart, firstEnd, null, null, null, 0);
        var result = flight.hasOverlapWith(secondStart, secondEnd);
        assertThat(result).isEqualTo(expectedResult);
    }
}
