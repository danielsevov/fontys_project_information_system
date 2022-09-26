package persistence.pgdao;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class PgJDBCUtilsTest {
    @Test
    void tNoProblemsIfApplicationPropsMissing() {
        assertThatCode(() -> PGJDBCUtils.getDataSource("shouldNotexist")).doesNotThrowAnyException();
    }
}
