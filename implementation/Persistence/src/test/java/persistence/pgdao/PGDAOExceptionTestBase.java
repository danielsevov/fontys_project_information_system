package persistence.pgdao;


import entities.Employee;
import genericmapper.Mapper;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import persistence.dao.DAO;
import persistence.dao.DAOException;
import persistence.dao.TransactionToken;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
abstract class PGDAOExceptionTestBase extends DBTestHelpers {

    Employee gp = new Employee(1, null, null, null, null, null, null, null);
    @Mock
    DataSource ds;

    DAO<Employee, Integer> eDao;
    Mapper<Employee, Integer> mapper;
    private Connection connection;

    abstract Connection getConnection();

    @BeforeEach
    void setup() throws SQLException {
        MockitoAnnotations.initMocks(this);
        this.connection = getConnection();
        Mockito.when(ds.getConnection()).thenReturn(this.connection);
        mapper = Mapper.mapperFor(Employee.class);
        daof = new PGDAOFactory(ds);
        daof.registerMapper(Employee.class, mapper);
        eDao = daof.createDao(Employee.class);
    }

    @AfterEach
    void cleanup() {
        try {
            this.connection.close();
        } catch (SQLException zipit) {
            Logger.getLogger(PGDAOExceptionTestBase.class.getName()).
                    log(Level.SEVERE, zipit.getMessage());
        }
    }

    @Test
    void delete() {
        ThrowingCallable suspectCode = () -> {
            eDao.deleteEntity(gp);
        };
        assertThatThrownBy(suspectCode).isInstanceOf(DAOException.class);
    }

    @Test
    void get() {
        assertThatThrownBy(() -> eDao.get(1)).isInstanceOf(DAOException.class);

    }

    @Test
    void getAll() {
        assertThatThrownBy(() -> eDao.getAll()).isInstanceOf(DAOException.class);

    }

    @Test
    void getByColumnValues() {
        assertThatThrownBy(() -> eDao.getByColumnValues("name", "nothing")).isInstanceOf(DAOException.class);

    }

    @Test
    void intQuery() {
        assertThatThrownBy(() -> ((PGDAO) eDao).executeIntQuery("select count(1) from employees"))
                .isInstanceOf(DAOException.class);
    }

    @Test
    void lastId() {
        assertThatThrownBy(() -> eDao.lastId()).isInstanceOf(DAOException.class);
    }

    @Test
    void save() {
        assertThatThrownBy(() -> {
            TransactionToken tok = eDao.getTransactionToken();
            if (null != tok) {
                tok.close();
            }
            eDao.save(gp);
        }).isInstanceOf(DAOException.class);
    }

    @Test
    void setTransactionToken() {
        assertThatCode(() -> eDao.setTransactionToken(null)).doesNotThrowAnyException();
    }

    @Test
    void size() {
        assertThatThrownBy(() -> eDao.size()).isInstanceOf(DAOException.class);
    }

    @Test
    void update() {
        assertThatThrownBy(() -> eDao.update(gp)).isInstanceOf(DAOException.class);
    }

    @Test
    void executeIntQueryInt1() {
        assertThatThrownBy(() -> ((PGDAO) eDao).executeIntQuery(
                "select departmentid from employees where employeeid=?", 1)).isInstanceOf(DAOException.class);
    }

}
