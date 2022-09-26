package persistence.dao;

import org.junit.jupiter.api.Test;

/**
 * Coverage.
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class TransactionTokenTest {

    TransactionToken tok = new TransactionToken() {
    };

    /**
     * Test that all default methods have no effect. For coverage.
     *
     * @throws java.lang.Exception not expected
     */
    @Test
    public void testCallingMethodsCausesNoTrouble() throws Exception {
        tok.commit();
        tok.rollback();
        tok.close();
    }

}
