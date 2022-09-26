package helpers.ranges;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * The range's reason of existence is testing, measuring, finding or avoiding
 * overlaps.
 *
 * <p>
 * The range should comply to the invariant that the start is less or equal its
 * end. Depending on the type, this can mean start is (left of, before, lower)
 * than end, or equal to end.</p>
 *
 * <p>
 * This range definition is of the <i>half open</i> type. The start is included
 * in the range, the end is not. The mathematical notation for half open ranges
 * of this kind is [start,end), indeed with two different brackets. The square
 * bracket is the closed end, the parenthesis is at the open end.</p>
 *
 * <p>
 * The demarcation and distance units can be of different types, like a dates as
 * demarcation and days between them.</p>
 *
 * @param <R> Range, always needed in definition of extending class since
 *            this abstract class has a recursive generic definition.
 * @param <P> the demarcation point type. Type of start and end.
 * @param <D> the distance dimension. Like days between dates.
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
public abstract class Range<R extends Range<R, P, D>, P extends Comparable<? super P>, D extends Comparable<? super D>>
        implements Comparable<R> {

    private final P start;
    private final P end;

    Range(P[] p) {
        start = p[0];
        end = p[1];
    }

    /**
     * Get the start demarcation of this range. Start is part of this range.
     *
     * @return start
     */
    P start() {
        return start;
    }

    /**
     * Get the end demarcation of this range. All points in the range are before
     * (less than) the end of this range.
     *
     * @return end
     */
    P end() {
        return end;
    }

    /**
     * Is a point contained in this range.
     *
     * @param point the point
     * @return true if point not before start and not after end.
     */
    public boolean contains(P point) {
        return start().compareTo(point) <= 0 && end().compareTo(point) > 0;
    }

    /**
     * Does this range overlap with another one.
     *
     * @param other to check
     * @return true on overlap with other
     */
    public boolean overlaps(R other) {
        return overlap(other) != zero();
    }

    /**
     * Obvious maximum function to get the maximum or right most of two
     * comparable elements.
     *
     * @param <Z> type of elements
     * @param a   element a
     * @param b   element b
     * @return the maximum of a and b
     */
    static <Z extends Comparable<? super Z>> Z max(Z a, Z b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    /**
     * Obvious minimum function to get the minimum or left most of two
     * comparable elements.
     *
     * @param <Z> type of elements
     * @param a   element a
     * @param b   element b
     * @return the minimum of a and b
     */
    static <Z extends Comparable<? super Z>> Z min(Z a, Z b) {
        return a.compareTo(b) <= 0 ? a : b;
    }

    /**
     * Get the length of this range in {@link D}. The effective operation is (end- start).
     *
     * @return the length
     */
    public D length() {
        return meter().apply(start(), end());
    }


    /**
     * Compute the length of the overlap between this range and another.
     * This method returns {@link Range#zero()} for delta <= 0;
     *
     * @param other range
     * @return the length of the overlap
     */
    public D overlap(R other) {
        var distance = meter().apply(max(start(), other.start()), min(end(), other.end()));
        return distance.compareTo(zero()) <= 0 ? zero() : distance;
    }

    /**
     * Does this and other just meet. this.start== other.end or
     * other.start=this.end
     *
     * @param other range
     * @return meet
     */
    public boolean meets(R other) {
        return max(start(), other.start()).equals(min(end(), other.end()));
    }

    /**
     * Helper to check that join is allowed, or intersection or punchThrough is
     * meaningful.
     *
     * @param other to test
     * @throws IllegalArgumentException when overlap is not possible
     */
    public void checkMeetsOrOverlaps(R other) {
        if (!(meets(other) || overlaps(other))) {
            throw new IllegalArgumentException("this range " + toString()
                    + " and other " + other.toString()
                    + " do not meet nor overlap");
        }

    }

    /**
     * Join this range with other range.
     *
     * @param other range to join
     * @return new joined range.
     * @throws IllegalArgumentException when this and other have no points in
     *                                  common, in other words do not overlap or meet.
     */
    public R joinWith(R other) throws IllegalArgumentException {
        checkMeetsOrOverlaps(other);
        return between(min(start(), other.start()), max(end(), other.end()));
    }

    /**
     * Get the method to determine distances between points.
     *
     * @return a function to compute the distance from a to b.
     */
    abstract BiFunction<P, P, D> meter();

    /**
     * Helper to avoid code duplication.
     *
     * @return the hash code for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(start(), end());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range<?, ?, ?> other = (Range<?, ?, ?>) o;
        return Objects.equals(start(), other.start()) && Objects.equals(end(), other.end());
    }

    @Override
    public String toString() {
        return "[" + start() + "," + end() + ")";

    }

    /**
     * Helper to put endpoints or ranges in natural order. The minimum element
     * is put at position 0, the maximum at position 1.
     *
     * @param <Y> type of elements to sort
     * @param a   arrays size 2 of input elements
     * @return sorted input array.
     */
    @SafeVarargs
    static <Y extends Comparable<? super Y>> Y[] minmax(Y... a) {
        if (a[0].compareTo(a[1]) > 0) {
            Y y = a[0];
            a[0] = a[1];
            a[1] = y;
        }
        return a;
    }

    /**
     * Create a new Range using part of this range as the input. It is a helper
     * to make some other operations easier to implement.
     *
     * @param startInclusive start of the new range
     * @param endExclusive   end of the new range
     * @return new range
     */
    abstract R between(P startInclusive, P endExclusive);

    /**
     * Compare this range with the other range. Only the start points of the
     * ranges are considered.
     *
     * @param other to compare with this
     * @return integer &lt; 0, == 0, or &gt; 0 for this start less, equal, or
     * greater than other start.
     */
    @Override
    public int compareTo(R other) {
        return start().compareTo(other.start());
    }

    /**
     * Return the intersection between this and other Range as Optional.
     * Optional is empty when there is no overlap.
     *
     * @param other that cuts this range
     * @return an Optional{@code Range<T,U>>} which is not empty when this and
     * cutter have an overlap.
     */
    public Optional<R> intersectWith(R other) {
        if (!overlaps(other)) {
            return Optional.empty();
        }
        return Optional.of(between(max(start(), other.start()), min(end(), other.end())));
    }

    /**
     * Test if other range is fully contained in this range, that is all points
     * of other are also part of this range.
     * <p>
     * Note the handling of the end value. With same ends, contains is still
     * possible, in other words [ac) contains [bc) and [ac).
     *
     * @param other range
     * @return is the other range completely inside this range?
     */
    public boolean contains(R other) {
        // our start <= their start
        // our end >= their end
        return start().compareTo(other.start()) <= 0 && end().compareTo(other.end()) >= 0;
    }

    /**
     * Try to replace this range with another Range, as if it would punch
     * through this range and replaces the knocked out part by it selves.
     * <p>
     * The operation results in a stream that contains the remainders (if any)
     * of this range and the punch, if the punch would be exactly on target,
     * that is within the bounds of this range.For example when this is [a,c)
     * and the punch is [a,b), the result would be [[a-b),[b-c)]. The stream
     * will contain at minimum 1 and at maximum 3 Ranges.
     *
     * @param punch to knockout parts of this range
     * @return a stream, either containing this range on a miss or the parts of
     * this range if there is something left over, and the punch between the
     * parts, or before or after the left over part.
     */
    public Stream<R> punchThrough(R punch) {
        if (!contains(punch)) {
            // missed: this
            return Stream.of(self());
        }
        if (equals(punch)) {
            // full punch: punch
            return Stream.of(punch);
        }
        if (start().equals(punch.start())) {
            // left punch: punch, remainder
            R remainder = between(punch.end(), end());
            return Stream.of(punch, remainder);
        }
        if (end().equals(punch.end())) {
            // right punch: remainder punch
            R remainder = between(start(), punch.start());
            return Stream.of(remainder, punch);
        }
        R leftRemainder = between(start(), punch.start());
        R rightRemainder = between(punch.end(), end());
        return Stream.of(leftRemainder, punch, rightRemainder);
    }

    /**
     * Make this class self-aware. See
     * <a href='http://web.archive.org/web/20130721224442/http:/passion.forco.de/content/emulating-self-types-using-java-generics-simplify-fluent-api-implementation'>emulated
     * self types</a>
     *
     * @return this, cast to the generic type of R.
     */
    @SuppressWarnings("unchecked")
    public R self() {
        return (R) this;
    }

    /**
     * For some computations we need a zero distance. This provides it.
     *
     * @return the zero value.
     */
    abstract D zero();
}
