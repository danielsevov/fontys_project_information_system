package persistence.pgdao;

import entities.Company;
import entities.Employee;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.dao.DAOException;
import persistence.dao.TransactionToken;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static persistence.usertypes.Email.email;

/**
 * Make sure all tests run within a transaction.
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class PGDAOTransactionalTest extends PGDAOTestBase {

    PGTransactionToken tok;

    @BeforeEach
    @Override
    void setUp() throws Throwable {
        super.setUp();
        eDao.close(); // close existing from super
        eDao = daof.createDao(Employee.class);
        try {
            tok = eDao.startTransaction();
        } catch (DAOException notexpected) {
            Logger.getLogger(PGDAOTransactionalTest.class.getName()).log(Level.SEVERE, null, notexpected);
        }
    }

    @AfterEach
    public void tearDown() throws Exception {
        tok.close();
    }

    @Test
    public void testExecuteInt0() {
        int id = eDao.executeIntQuery("select employeeid from employees where firstname='Batman'");
        assertThat(id).isEqualTo(0);
    }

    @Test
    public void testSize() {
        int size = eDao.size();
        assertThat(size).as("there should be a piet").isEqualTo(1);
    }

    @Test
    public void testGetByColumnKeyValues() {
        ThrowingCallable code = () -> eDao.getByColumnValues("batcar", "black");
        assertThatThrownBy(code).isExactlyInstanceOf(DAOException.class);
    }

    @Test
    public void testExecuteIntQueryInt1() {
        int id = eDao.executeIntQuery(
                "select departmentid from employees where employeeid=?", 1);
        assertThat(id).as("piet is in dept 1").isEqualTo(1);
    }

    @Test
    public void testGetConnection() {
        Connection connection = eDao.getConnection();
        assertThat(connection).as("having my connection").isNotNull();
    }

    @Test
    public void testUsingTransactionConnection() throws SQLException {
        PGTransactionToken tok = new PGTransactionToken(ds.getConnection());
        Connection tokCon = tok.getConnection();
        eDao.setTransactionToken(tok);
        Connection c = eDao.getConnection();
        assertThat(c).as("using one and the same connection").isSameAs(tokCon);
        assertThat(eDao.getTransactionToken()).isSameAs(tok);
    }

    @Test
    public void testSaveAll() throws Exception {
        LocalDate d = LocalDate.of(1999, 5, 6);
        LocalDate d2 = LocalDate.of(1999, 2, 3);
        Employee jan = new Employee(0, "Klaassen", "Jan", email(
                "j.klaassen@fontys.nl"), 1, true, d, LocalDate.now());
        Employee kat = new Employee(0, "Hansen", "Katrien", email(
                "j.hansen@fontys.nl"), 1, false, d2, LocalDate.now());
        System.out.println("jan = " + jan);
        System.out.println("kat = " + kat);
        var dao = daof.createDao(Employee.class);
        try (final TransactionToken tok = dao.startTransaction()) {
            var saveAll = dao.saveAll(jan, kat);
            assertThat(saveAll.size()).as("using one and the same connection").isEqualTo(2);
            PGDAO pdao = dao;
            assertThat(pdao.getConnection().isClosed()).isFalse();
            var x = saveAll.iterator().next();
            Employee e1 = saveAll.iterator().next();
            Employee e2 = saveAll.iterator().next();
            dao.deleteAll(e1, e2);
            tok.commit();
        }
    }

    @Test
    public void testNullableFields() {
        String tick = "BAS";
        Company c = new Company(null, null, null, null, tick, null);
        var cdao = daof.createDao(Company.class);
        Company sC = cdao.save(c).get();
        cdao.deleteAll(c);
        assertSoftly(softly -> {
            assertThat(sC.getTicker()).isEqualTo(tick);
            assertThat(sC.getName()).as("name is null").isNull();
            assertThat(sC.getSomeInt()).as("someint").isEqualTo(0);
            assertThat(sC.getSomeInteger()).as("someinteger").isEqualTo(null);
        });
    }

    @Test
    public void testDropGeneratedEmp() {
        LocalDate d = LocalDate.of(1999, 5, 6);
        PGDAO<Employee, Integer> edao = daof.createDao(Employee.class);
        Employee jan = new Employee(0, "Klaassen", "Jan",
                email("j.klaassen@fontys.nl"), 1, true, d, null);
        Object[] parts = edao.getMapper().deconstruct(jan);
        assertThat(parts.length).as("part count").isEqualTo(8);
    }

    @Test
    public void anyQuery() {
        PGDAO<Employee, Integer> eDaoa = daof.createDao(Employee.class);
        String sql = "select * from employees where employeeid = ?";
        List<Employee> list = eDaoa.anyQuery(sql, 1);
        for (Employee employee : list) {
            System.out.println("employee = " + employee);
        }
        assertThat(list).hasSize(1);
    }
}
