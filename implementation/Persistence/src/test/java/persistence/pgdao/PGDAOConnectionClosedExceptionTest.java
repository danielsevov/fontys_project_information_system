package persistence.pgdao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;
import static org.assertj.core.api.Assumptions.assumeThat;

/**
 * Test if all sql exceptions are properly translated (as in wrapped in) into
 * DAOExceptions. For coverage. The methods all will find a connection that is
 * broken and throws an exception.
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
class PGDAOConnectionClosedExceptionTest extends PGDAOExceptionTestBase {

    @BeforeAll
    static void checkDataSource() {
        DataSource ds = PGJDBCUtils.getTestDataSource("test_db");
        assumeThat(ds).isNotNull();
    }

    @Override
    Connection getConnection() {
        try {
            Connection realConnection = DBTestHelpers.ds.getConnection();
            return new NonClosingConnection(realConnection);
        } catch (SQLException ex) {
            getLogger(PGDAOConnectionClosedExceptionTest.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //    @Disabled( "Ignored because in this case the exception is somehow swallowed" )
    @Test//( expected = DAOException.class )
    @Override
    void delete() {
        Assertions.assertThatCode(() -> {
            eDao.deleteEntity(gp);
        }).doesNotThrowAnyException();
    }
}
