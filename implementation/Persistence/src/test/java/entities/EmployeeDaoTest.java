package entities;


import genericmapper.FieldPair;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import persistence.dao.DAO;
import persistence.dao.DAOException;
import persistence.pgdao.DBTestHelpers;
import persistence.pgdao.PGDAOFactory;
import persistence.pgdao.PGJDBCUtils;
import persistence.usertypes.Email;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assumptions.assumeThat;
import static persistence.pgdao.DBTestHelpers.daof;
import static persistence.pgdao.DBTestHelpers.loadDatabase;
import static persistence.usertypes.Email.email;

/**
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class EmployeeDaoTest {

    @BeforeAll
    public static void setupClass() {
        DataSource ds = PGJDBCUtils.getTestDataSource("test_db");
        assumeThat(ds).isNotNull();

        try {
            Class.forName("entities.EmployeeMapper");
            System.out.println("loaded \"entities.EmployeeMapper\"");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDaoTest.class.getName())
                    .log(Level.SEVERE, ex.getMessage());
        }
        loadDatabase();
        daof = new PGDAOFactory(ds).registerInMarshaller(Email.class, Email::new);
        daof.registerPGMashallers(Email.class, Email::new, x -> PGDAOFactory.pgobject("citext", x));
    }

    DAO<Employee, Integer> edao;

    @BeforeEach
    public void setupData() {
        try {
            edao = daof.createDao(Employee.class);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDaoTest.class.getName())
                    .log(Level.SEVERE, "***************************" + ex
                            .getMessage());
        }
        assumeThat(edao).isNotNull();
        DBTestHelpers.insertPiet();
        assertThat(edao.size()).isEqualTo(1);
    }

    @AfterEach
    public void cleanup() {
    }

    @Test
    public void test00Size() {
        int size = edao.size();
        assertThat(size).as("tests start out with one element")
                .isEqualTo(1);

    }

    @Test
    public void test01Get() {
        int lastId = edao.lastId();
        Optional<Employee> e = edao.get(lastId);

        assertThat(e.isPresent()).as("got an employee").isTrue();
        assertThat(e.get().getFirstname()).as("It's Piet").isEqualTo("Piet");
    }

    @Test
    public void test02GetAll() {
        try {
            Collection<Employee> el = edao.getAll();
            assertThat(el.size()).isEqualTo(1);
            assertThat(el.iterator().next().getFirstname())
                    .isEqualTo("Piet");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

    @Test
    public void test03Delete() {
        Employee dummy = new Employee(1, null, null, null, null, null, null,
                null);
        edao.deleteEntity(dummy); // will drop piet
        Optional<Employee> oe = edao.get(1);
        Assertions.assertThat(oe).isEmpty();
    }

    @Test
    public void test04Create() {
        Collection<Employee> el = edao.getAll();
        int preSize = el.size();
        Employee savedJan = edao.save(JAN).get();
        int postSize = edao.getAll().size();
        assertThat(postSize).isEqualTo(1 + preSize);
        edao.deleteEntity(savedJan);
    }

    private static final Employee JAN = new Employee(0, "Klaassen", "Jan",
            email("jan@example.com"), 1, true, LocalDate.of(1991, 2, 23),
            LocalDate.of(1973, Month.MARCH, 4));

    @Test
    public void test05Update() {
        Employee savedJan = edao.save(JAN).get();
        assertThat(savedJan).isNotNull();
        assertThat(edao.getMapper().keyExtractor().apply(savedJan)).isNotEqualTo(0);
        System.out.println("savedJan = " + savedJan);

        savedJan = edao.getMapper().replaceFields(savedJan, new FieldPair("email", email("janklaassen@outlook.com")));
        assertThat(savedJan).isNotNull();
        edao.update(savedJan); // ignore result for now
        Employee updatedJan = edao.get(savedJan.getEmployeeid()).get();
        assertThat(savedJan.getEmail()).extracting(Email::toString).isEqualTo("janklaassen@outlook.com");
    }

    @Test
    public void test00GetByKeyValues() {
        // should get default piet.
        Employee savedJan = edao.save(JAN).get();
        Collection<Employee> col = edao.getByColumnValues("email", JAN.getEmail());
        assertThat(col.isEmpty()).isFalse();
        Employee firstEmployee = col.iterator().next();
        assertThat(firstEmployee.getFirstname()).isEqualTo("Jan");
        edao.deleteEntity(savedJan);
    }

    @Test
    public void testSaveUniqueViolation() {
        Employee jean = new Employee(0, "Klaassen", "Jean",
                email("jan@example.com"), 1, true, LocalDate.of(1991, 2, 23),
                null);
        // should get default piet.
        Employee savedJean = edao.save(jean).get();
        assertThatThrownBy(() -> edao.save(jean).get()).isExactlyInstanceOf(DAOException.class);
    }
}
