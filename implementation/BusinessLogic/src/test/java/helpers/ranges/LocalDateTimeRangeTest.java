package helpers.ranges;


import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
class LocalDateTimeRangeTest extends RangeTestBase<LocalDateTimeRange, LocalDateTime, Duration> {
    private static LocalDateTime of(int day) {
        return LocalDateTime.of(2021, 3, day, 1, 1);
    }

    LocalDateTime[] pointsA = {of(3), of(6), of(8), of(15), of(18), of(22)};
    RangeTestDataFactory<LocalDateTimeRange, LocalDateTime, Duration> daf;

    @Override
    RangeTestDataFactory<LocalDateTimeRange, LocalDateTime, Duration> helper() {
        if (daf == null) {
            daf = new RangeTestDataFactory<>(pointsA) {

                @Override
                LocalDateTimeRange createRange(LocalDateTime start, LocalDateTime end) {
                    return LocalDateTimeRange.of(start, end);
                }

                @Override
                Duration distance(LocalDateTime a, LocalDateTime b) {
                    return Duration.between(a, b);
                }

            };

        }
        return daf;
    }
}

