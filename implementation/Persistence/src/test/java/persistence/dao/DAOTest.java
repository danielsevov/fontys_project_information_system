package persistence.dao;


import entities.Employee;
import genericmapper.FieldPair;
import genericmapper.Mapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static persistence.usertypes.Email.email;

/**
 * Coverage.
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
public class DAOTest {

    static class DummyDAO implements DAO<Employee, Integer> {

        final Mapper<Employee, Integer> mapper = Mapper.mapperFor(Employee.class);

        public DummyDAO() {

        }

        @Override
        public Optional<Employee> get(Integer id) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public List<Employee> getAll() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Optional<Employee> save(Employee e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Employee update(Employee e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void deleteEntity(Employee e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void deleteById(Integer k) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Mapper getMapper() {
            return mapper;
        }

        @Override
        public Employee updateColumn(Employee employee, String column, Object value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

    TransactionToken ignoredToken = new TransactionToken() {
    };

    DAO<Employee, Integer> dao = new DummyDAO();

    /**
     * This test serves to cover the default implementations in DAO.
     *
     * @throws Exception no expected
     */
    @Test
    public void testAllCovered() throws Exception {

        assertThat(dao.startTransaction()).isNull();
        dao.setTransactionToken(ignoredToken);
        assertThat(dao.getTransactionToken()).isNull();
        assertThat(dao.size()).isEqualTo(0);
        assertThat(dao.lastId()).isEqualTo(0);
        try {
            dao.close();
        } catch (Exception e) {
            fail("should not throw exception, threw " + e);
        }
    }

    @Test
    public void testNotImplemented() {
        assertThatThrownBy(() -> dao.getByColumnValues("key", "value"))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void tDropGeneratedFields() {
        Employee jean = new Employee(0, "Klaassen", "Jean",
                email("jan@example.com"), 1, true, LocalDate.of(1991,
                2, 23),
                LocalDate.of(1973, Month.MARCH, 4));
        dao.getMapper().deconstruct(jean);
        List<FieldPair> dropGeneratedFields = dao.dropGeneratedFields(jean);
        final List<String> remainingFields = dropGeneratedFields.stream()
                .map(FieldPair::key)
                .collect(
                        toList());

        assertSoftly(softly -> {
            softly.assertThat(remainingFields).as(
                    "id should have been dropped")
                    .hasSize(6);
            softly.assertThat(remainingFields).containsExactly("lastname",
                    "firstname", "email", "departmentid", "available", "dob");
        });
    }
}
