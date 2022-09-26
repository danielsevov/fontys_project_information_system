package persistence.pgdao;


import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class PGDAOFactoryTest {

    @Test
    public void marshallLocalDate() {
        LocalDate ld0 = LocalDate.now();
        Date d = Date.valueOf(ld0);
        PGDAOFactory fac = new PGDAOFactory(null);

        LocalDate ld = fac.marshallIn(LocalDate.class, d);

        Date d2 = java.sql.Date.valueOf(ld);

        assertThat(d2).as("date match").isEqualTo(d);
    }

}
