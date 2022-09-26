package entities;

import genericmapper.Mapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static entities.Email.email;
import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

/**
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class EmployeeMapperTest {

    @BeforeAll
    static void setupClass() throws ClassNotFoundException {
        Class.forName("entities.EmployeeMapper");
    }

    @Test
    public void tMapper() {
        Mapper<Employee, Integer> em = Mapper.mapperFor(Employee.class);
        assumeThat(em).isNotNull();
        List<Field> entityFields = em.entityFields();
        assertThat(entityFields).hasSize(8);
        Object[] parts = new Object[]{
                1, "Puk", "Piet", email("piet@student.fontys.nl"), 42, true, now(), now()
        };
        Employee construct = em.construct(parts);
        assertThat(em.construct(parts)).isNotNull();
        assertThat(construct.getEmail()).isNotNull();
    }

}
