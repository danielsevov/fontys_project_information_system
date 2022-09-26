package helpers.ranges;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assumptions.assumeThat;

/**
 * Tests the Range interface via leaf class R.
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
abstract class RangeTestBase<R extends Range<R, P, D>, P extends Comparable<? super P>, D extends Comparable<? super D>> {
    /**
     * @return helper factory method
     */
    abstract RangeTestDataFactory<R, P, D> helper();

    /**
     * Create range using helper.
     *
     * @param rp1 range spec
     * @return a range
     */
    R createRange(String rp1) {
        return helper().createRange(rp1);
    }

    /**
     * Create range using helper.
     *
     * @param p1 point
     * @param p2 point
     * @return range
     */
    R createRange(P p1, P p2) {
        return helper().createRange(p1, p2);
    }

    /**
     * Helper to shorten writing the tests.
     *
     * @param key
     * @return
     */
    P lookupPoint(String key) {
        return helper().lookupPoint(key);
    }

    /**
     * Helper to compute distance.
     *
     * @param a point
     * @param b point
     * @return P distance
     */
    D distance(P a, P b) {
        return helper().distance(a, b);
    }

    /**
     * Test the default max function in Range.
     *
     * @param as  specifies a
     * @param bs  specifies a
     * @param exs specifies expected point
     */
    @ParameterizedTest
    @CsvSource({
            "a,b,b",
            "c,b,c",
            "a,a,a"
    })
    void t01Max(String as, String bs, String exs) {
        P a = lookupPoint(as);
        P b = lookupPoint(bs);
        P expected = lookupPoint(exs);
        assertThat(Range.max(a, b)).isEqualTo(expected);
    }

    /**
     * Test the default max function in Range.
     *
     * @param as  specifies a
     * @param bs  specifies a
     * @param exs specifies expected point
     */
    @ParameterizedTest
    @CsvSource({
            "a,b,a",
            "c,b,b",
            "a,a,a"
    })
    void t02Min(String as, String bs, String exs) {
        P a = lookupPoint(as);
        P b = lookupPoint(bs);
        P expected = lookupPoint(exs);
        assertThat(Range.min(a, b)).isEqualTo(expected);
    }

    /**
     * Test the default minmax function in Range.
     *
     * @param as        specifies a
     * @param bs        specifies a
     * @param expected0 specifies expected0 point
     * @param expected1 specifies expected1 point
     */
    @ParameterizedTest
    @CsvSource({
            "a,a,a,a",
            "a,b,a,b",
            "d,c,c,d",})
    void t03MinmaxTest(String as, String bs, String expected0,
                       String expected1) {
        P a = lookupPoint(as);
        P b = lookupPoint(bs);
        P exp0 = lookupPoint(expected0);
        P exp1 = lookupPoint(expected1);
        P[] t = Range.minmax(a, b);
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(t[0]).isEqualTo(exp0);
            s.assertThat(t[1]).isEqualTo(exp1);
        });

    }

    /**
     * Test Range#meets.
     *
     * @param as       specifies a
     * @param bs       specifies b
     * @param cs       specifies c
     * @param ds       specifies d
     * @param expected outcome
     */
    @ParameterizedTest
    @CsvSource({
            "a,b,c,d,false",
            "c,d,a,b,false",
            "a,b,b,d,true",
            "c,d,a,c,true",})
    void t04Meets(String as, String bs, String cs, String ds, boolean expected) {
        P a = lookupPoint(as);
        P b = lookupPoint(bs);
        P c = lookupPoint(cs);
        P d = lookupPoint(ds);
        // Create ranges.
        var rangeA = createRange(a, b);
        var rangeB = createRange(c, d);

        assertThat(rangeA.meets(rangeB)).isEqualTo(expected);
    }

    /**
     * Test the helper method Range#between. Given.
     */
    @Test
    void t05CreateBetween() {
        P a = lookupPoint("a");
        P b = lookupPoint("b");
        P c = lookupPoint("c");
        // helper is needed to get access to the between method.
        R helper = createRange(c, c);
        R rt = helper.between(a, b);
        assertThat(rt).extracting("start", "end").containsExactly(a, b);
    }

    /**
     * Test Range#rangeHashCode and Range#rangeEquals implicitly through
     * concrete R. Given.
     */
    @Test
    void t06HashCodeEquals() {
        P a = lookupPoint("a");
        P b = lookupPoint("b");
        P c = lookupPoint("c");

        R ref = createRange(a, b);
        R equ = createRange(a, b);
        R diffB = createRange(a, c);
        R diffC = createRange(c, b);

        TestUtils.verifyEqualsAndHashCode(ref, equ, diffB, diffC);
    }

    /**
     * Test length function.
     */
    @Test
    void t07Length() {
        P a = lookupPoint("a");
        P b = lookupPoint("b");
        assertThat(createRange(a, b).length()).isEqualTo(distance(a, b));
    }

    /**
     * Test the overlaps function. The method is given. Add more test values.
     *
     * @param rp1      point pair 1
     * @param rp2      point pair 2
     * @param overlaps expected outcome
     */
    @ParameterizedTest
    @CsvSource(value = {
            "ab,cd,false", // disjunct
            "ac,cd,false", // meet
            "ac,bd,true", //  B < C < D
    }
    )
    void t08Overlaps(String rp1, String rp2, boolean overlaps) {
        R r1 = createRange(rp1);
        R r2 = createRange(rp2);
        assertThat(r1.overlaps(r2)).isEqualTo(overlaps);
    }

    /**
     * Compute the overlap function as long.
     *
     * @param rp1 point pair one defining first range
     * @param rp2 point pair two defining second range
     * @param rp3 point pair with expected length
     */
    @ParameterizedTest
    @CsvSource(value = {
            // first, second, distance  points
            "ab,cd,aa", // disjunct
            "ab,bc,bb", // disjunct
            "ac,bd,bc", //  B < C < P
            "cd,ce,cd"
    }
    )
    void t09overLap(String rp1, String rp2, String rp3) {
        var rangeA = createRange(rp1);
        var rangeB = createRange(rp2);
        var expectedLength = createRange(rp3).length();
        assertThat(rangeA.overlap(rangeB)).isEqualTo(expectedLength);
    }

    /**
     * Assert that the range constructor puts start and end in the proper order.
     * Assert that end of range is less or equal to start, using compareTo.
     */
    @Test
    void t10normalizes() {
        P a = lookupPoint("a");
        P b = lookupPoint("b");
        var range = createRange(a, b);
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(range.start()).isEqualTo(a);
            s.assertThat(range.end()).isEqualTo(b);
        });
    }

    /**
     * Check the contain(p) method word correctly. Method is given. Add test
     * values.
     *
     * @param pp       first range lookup
     * @param point    to check
     * @param contains expected value
     */
    @ParameterizedTest
    @CsvSource({
            "bc,a,false",
            "bc,d,false",
            "df,e,true",
            "bd,c,true"
    })
    void t11ContainsPoint(String pp, String point, boolean contains) {
        var range = createRange(pp);
        assertThat(range.contains(lookupPoint(point))).isEqualTo(contains);
    }


    @Test
    void t12ToStringTest() {
        P a = lookupPoint("a");
        P b = lookupPoint("b");
        var range = createRange(a, b);
        assertThat(range).hasToString("[" + a + "," + b + ")");
    }

    /**
     * Test that method checkMeetsOrOverlaps throws exception at the proper
     * situation. In this the exception should NOT occur.
     *
     * @param pp1
     * @param pp2
     */
    @ParameterizedTest
    @CsvSource({
            "ab,bc",
            "ac,bd"
    })
    void t13aCheckMeetsOrOverlaps(String pp1, String pp2) {
        R r1 = createRange(pp1);
        R r2 = createRange(pp2);
        assertThatCode(() -> r1.checkMeetsOrOverlaps(r2)).doesNotThrowAnyException();
    }

    /**
     * Test that method checkMeetsOrOverlaps throws exception at the proper
     * situation. In this test the Exception IS expected.
     *
     * @param pp1
     * @param pp2
     */
    @ParameterizedTest
    @CsvSource({
            "ab,cd",
            "ac,de"
    })
    void t13bCheckMeetsOrOverlaps(String pp1, String pp2) {
        R r1 = createRange(pp1);
        R r2 = createRange(pp2);
        // code that should throw or not throw exception.
        assertThatThrownBy(() -> r1.checkMeetsOrOverlaps(r2))
                .isInstanceOf(RuntimeException.class)
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Check joinWith. The test values should all produce a join, the exception
     * throwing is tested elsewhere.
     *
     * @param pp1           first range spec
     * @param pp2           second range spec.
     * @param expectedRange in the test
     */
    @ParameterizedTest
    @CsvSource({
            "ab,bc,ac",
            "ac,bd,ad"
    })
    void t14JoinWith(String pp1, String pp2, String expectedRange) {
        var rangeA = createRange(pp1);
        var rangeB = createRange(pp2);
        var expected = createRange(expectedRange);
        assertThat(rangeA.joinWith(rangeB)).isEqualTo(expected);
    }

    /**
     * Check the intersect method part 1. In this test all values should produce
     * a non-empty intersection.
     *
     * @param rp1          range specification
     * @param rp2          cutter range spec
     * @param interSection expected result of cut.
     */
    @ParameterizedTest
    @CsvSource({
            // this, cutter, cuts, expected result
            "ac,bd,bc",
            "cd,ce,cd"
    })
    void t15aCommonRangeSuccess(String rp1, String rp2, String interSection) {
        var range = createRange(rp1);
        var cutter = createRange(rp2);
        var expected = createRange(interSection);
        var result = range.intersectWith(cutter);

        assumeThat(result.isPresent()).isTrue();
        assertThat(result.get()).isEqualTo(expected);
    }

    /**
     * Check the intersect method part 2. In this test all values should produce
     * an empty intersection.
     *
     * @param rp1 range specification
     * @param rp2 cutter range spec
     */
    @ParameterizedTest
    @CsvSource({
            // this, cutter, cuts
            "ab,cd",
            "bc,de",
            "ac,df"

    })
    void t15bCommonRangeEmpty(String rp1, String rp2) {
        R range = createRange(rp1);
        R cutter = createRange(rp2);
        assertThat(range.intersectWith(cutter)).isEmpty();

    }

    /**
     * Test if range is fully contained in other. (contains method)
     * <p>
     * Method is given. Add test values
     *
     * @param rp1      this range
     * @param rp2      other range
     * @param expected result of contains call
     */
    @ParameterizedTest
    @CsvSource(value = {
            // this, cutter, cuts, expected result
            "ab,cd,false", // disjunct
            "ab,ab,true",
            "af,ab,true",
            "af,de,true",
            "ac,de,false"
    })
    void t16ContainsRange(String rp1, String rp2, boolean expected) {
        R range = createRange(rp1);
        R other = createRange(rp2);
        assertThat(range.contains(other)).isEqualTo(expected);
    }

    /**
     * Test the punchThrough method. Test is given. Add test values.
     * <p>
     * In expected value ab|bc means a stream with exactly the elements [ab) and
     * [bc).
     *
     * @param rangeP     range value
     * @param punchP     punch value
     * @param restPairs, | separated list of expected ranges in stream
     */
    @ParameterizedTest
    @CsvSource(value = {
            // range, punch, results, | separated
            "ab,ab,ab", // full punch
            "ac,ab,ab|bc", // left punch
            "af,cd,ac|cd|df",
            "af,df,ad|df",
            "ab,de,ab"
    }
    )
    void t17PunchThrough(String rangeP, String punchP, String restPairs) {
        R range = createRange(rangeP);
        R punch = createRange(punchP);
        var expectedParts = helper().restRanges("\\|", restPairs);
        Stream<R> result = range.punchThrough(punch);
        assertThat(result).containsSequence(expectedParts);

    }

    /**
     * Test compareTo. The outcome is negative, zero or positive, which is
     * expressed in the table as -1, 0. or 1.
     * <p>
     * To test for zero is easy, but a special case. To test for the negative
     * value, multiply expected with the actual value and test it to be greater
     * than 0.
     * <p>
     * we need to detect that result and expected have the same // sign or are
     * equal. // we can achieve
     *
     * @param pp1      range 1
     * @param pp2      range 2
     * @param expected value
     */
    @ParameterizedTest
    @CsvSource({
            "ab,ac,0", // same start
            "ac,bd,-1", // start left of
            "bc,ad,1", // start right of
    })
    void t18CompareTo(String pp1, String pp2, int expected) {
        R r1 = createRange(pp1);
        R r2 = createRange(pp2);
        assertThat(r1.compareTo(r2)).isEqualTo(expected);
    }
}
