package persistence.pgdao;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hom
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */

public class PGJDBCUtils {

    public static final String APPLICATION_PROPERTIES = "application.properties";
    private static final String SEPARATOR = File.separator;
    public static final String TEST_PROPERTIES = "test_application.properties";
    private static final Map<String, DataSource> datasourceByName = new HashMap<>();

    private static String getPathFor(String resource) {
        return SEPARATOR + "integration_test_data" + SEPARATOR + resource;
    }

    static DataSource fromProperties(Properties props, String sourceName) {
        PGSimpleDataSource source = new PGSimpleDataSource();

        String prefix = sourceName + ".";
        String[] serverNames = {props.getProperty(prefix + "dbhost")};
        source.setServerNames(serverNames);
        source.setUser(props.getProperty(prefix + "username"));
        source.setDatabaseName(props.getProperty(prefix + "dbname"));
        source.setPassword(props.getProperty(prefix + "password"));

        String pingQuery = "SELECT current_database(), now()::TIMESTAMP as now;";
        try (Connection con = source.getConnection();
             PreparedStatement pst = con.prepareStatement(pingQuery)) {
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Object db = rs.getObject("current_database");
                    Object now = rs.getObject("now");
                    System.out.println("connected to db " + db + ", date/time is " + now);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PGJDBCUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return source;
    }

    public static DataSource getDataSource(final String sourceName) {
        File propFile = new File(APPLICATION_PROPERTIES);
        if (!propFile.exists()) {
            return null;
        }

        return datasourceByName.computeIfAbsent(sourceName,
                s -> fromProperties(properties(APPLICATION_PROPERTIES), sourceName)
        );
    }

    public static DataSource getTestDataSource(String sourceName) {
        // Get the application file from the resources folder.
        Properties props = properties(getURL(TEST_PROPERTIES).getPath());
        return datasourceByName.computeIfAbsent(sourceName, s -> fromProperties(props, sourceName));
    }

    static URL getURL(String sourceName) {
        var resolvedPath = getPathFor(sourceName);
        var resource = PGJDBCUtils.class.getResource(resolvedPath);
        if (resource == null) {
            throw new IllegalArgumentException("Bad path provided " + resolvedPath);
        }
        return resource;
    }

    private static Properties properties(String propFileName) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(propFileName)) {
            properties.load(fis);
        } catch (IOException ex) {
            Logger.getLogger(PGJDBCUtils.class.getName())
                    .log(Level.INFO, "attempt to read file from known location ", ex);
        }
        return properties;
    }
}
