package helpers.ranges;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.BiFunction;

/**
 * {@link LocalDateTime} based implementation of the {@link Range} class.
 * This implementation uses {@link Duration} as distance unit.
 *
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
public class LocalDateTimeRange extends Range<LocalDateTimeRange, LocalDateTime, Duration> {
    private LocalDateTimeRange(LocalDateTime[] p) {
        super(p);
    }

    @Override
    public BiFunction<LocalDateTime, LocalDateTime, Duration> meter() {
        return Duration::between;
    }

    @Override
    public LocalDateTimeRange between(LocalDateTime startInclusive, LocalDateTime endExclusive) {
        return of(startInclusive, endExclusive);
    }

    @Override
    public Duration zero() {
        return Duration.ZERO;
    }

    public static LocalDateTimeRange of(LocalDateTime a, LocalDateTime b) {
        return new LocalDateTimeRange(Range.minmax(a, b));
    }

    @Override
    public int compareTo(LocalDateTimeRange other) {
        var comp = start().compareTo(other.start());
        return Integer.compare(comp, 0);
    }
}
