package persistence.pgdao;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import persistence.dao.DAOException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * For coverage.
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
@ExtendWith(MockitoExtension.class)
public class PGTransactionTokenTest {

    @Mock
    Connection conn;

    @BeforeEach
    public void setup() throws SQLException {
        Mockito.doThrow(new SQLException("Just for fun")).when(conn).setAutoCommit(false);
    }

    @Test
    public void testExceptionOnConnection() {
        Assertions.assertThatThrownBy(() -> new PGTransactionToken(conn)).isExactlyInstanceOf(DAOException.class);
    }

}
