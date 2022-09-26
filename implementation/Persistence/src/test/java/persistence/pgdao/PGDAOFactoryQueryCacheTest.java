package persistence.pgdao;


import entities.Employee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Pieter van den Hombergh (879417) {@code p.vandenhombergh@fontys.nl}
 */
public class PGDAOFactoryQueryCacheTest extends PGDAOTestBase {

    @Test
    public void testCreatesCache() {
        PGDAO<Employee, Integer> edao = daof.createDao(Employee.class);
        int size = daof.queryStringCache.size();
        assertThat(size).as("has one elements").isEqualTo(1);
    }

}
