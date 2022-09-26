package persistence.pgdao;

import entities.Company;
import entities.Employee;
import genericmapper.Mapper;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class QueryFactoryTest {
    Mapper<?, ?> mapper = Mapper.mapperFor(Employee.class);
    QueryFactory fac = new QueryFactory(mapper);


    @Test
    void tSaveQueryText() {
        String queryText = cachedTest(() -> fac.saveQueryText());
        // Test probing.
        assertThat(queryText).isEqualTo(queryText);
    }


    @Test
    void tDeleteQueryText() {
        String queryText = cachedTest(() -> fac.deleteQueryText());
        assertThat(queryText).isEqualTo("delete from employees where employeeid=?");
    }


    @Test
    void tUpdateQueryText() {
        String queryText = cachedTest(() -> fac.updateQueryText());
        assertThat(queryText).isEqualTo("update employees set (lastname,firstname,email,departmentid,available,dob,hiredate)=(?,?,?,?,?,?,?) where (employeeid)=(?) returning  employeeid,lastname,firstname,email,departmentid,available,dob,hiredate");
    }


    @Test
    void tSelectQueryText() {
        String queryText = cachedTest(() -> fac.getQueryText());
        assertThat(queryText).isEqualTo("select employeeid,lastname,firstname,email,departmentid,available,dob,hiredate from employees where employeeid=?");
    }


    @Test
    void tSelectAllQueryText() {
        String queryText = cachedTest(() -> fac.allQuery());
        assertThat(queryText).isEqualTo("select employeeid,lastname,firstname,email,departmentid,available,dob,hiredate from employees");
    }


    @Test
    void tLastIdQuery() {
        String queryText = cachedTest(() -> fac.lastIdQuery());
        assertThat(queryText).contains("select", "max(employeeid)", "as", "lastid", "from", "employees");
    }


    @Test
    void tDropAllQuery() {
        String queryText = cachedTest(() -> fac.dropallQuery());
        assertThat(queryText).contains("truncate", "employees", "restart", "identity", "cascade");
    }

    @Test
    void tAllColumnsQuery() {
        String queryText = cachedTest(() -> fac.allColumns());
        assertThat(queryText).contains("employeeid", "lastname", "firstname", "email", "departmentid", "available", "dob", "hiredate");
    }
    /*
    @Test
    void tIdNameQuery() {
        String queryText = cachedTest(() -> fac.idName());
        assertThat(queryText).contains("employeeid");
    }
     */

    /**
     * Check if a call result is cached.
     *
     * @param supplier
     * @return
     */
    String cachedTest(Supplier<String> supplier) {
        String first = supplier.get();
        assertThat(supplier.get()).isSameAs(first);
        return first;
    }


    @Test
    void tTableNameAnnotationUsed() {
        Mapper<?, ?> cmapper = Mapper.mapperFor(Company.class);
        QueryFactory fac = new QueryFactory(cmapper);

        assertThat(cachedTest(fac::tableName)).isEqualTo("companies");
//        fail( "method TableNameAnnotationUsed completed succesfully; you know what to do" );
    }
}
