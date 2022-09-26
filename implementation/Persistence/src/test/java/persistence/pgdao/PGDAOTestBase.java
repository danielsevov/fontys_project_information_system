package persistence.pgdao;


import entities.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import persistence.usertypes.Email;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

/**
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class PGDAOTestBase extends DBTestHelpers {

    PGDAO<Employee, Integer> eDao;

    @BeforeAll
    public static void setupHelpers() throws ClassNotFoundException {
        DataSource ds = PGJDBCUtils.getTestDataSource("test_db");
        assumeThat(ds).isNotNull();

        DBTestHelpers.setupClass();
        Class.forName("entities.CompanyMapper");
        Class.forName("entities.DepartmentMapper");
        Class.forName("entities.EmployeeMapper");
        Class.forName("entities.TruckMapper");
    }

    @BeforeEach
    void setUp() throws Throwable {
        assertThat(daof).isNotNull();
        daof.registerPGMashallers(Email.class, Email::new, x -> PGDAOFactory.pgobject("citext", x));
        eDao = daof.createDao(Employee.class);
        assumeThat(eDao).isNotNull();
        insertPiet();
    }

}
