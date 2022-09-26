package genericmapper;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import testentities.Course;
import testentities.Student;
import testentities.Tutor;

import java.util.stream.Stream;

import static genericmapper.TestData.*;
import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

/**
 * For TestData see separate test data class.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class MapperTest {

    @BeforeAll
    static void loadMapper() throws ClassNotFoundException {
        Class<?> forName = Class.forName("client.StudentMapper");
        System.out.println("loaded studentmapper " + forName.getName());
    }

    Mapper<Student, Integer> mapper = Mapper
            .mapperFor(Student.class);

    Object[] studentArgs = new Object[]{
            snummer, studentLastName, studentTussenVoegsel,
            studentFirstname, studentDob, cohort, studentEmail,
            studentGender, group, true
    };


    /**
     * Assert that constructed xJan equals the real jan.
     */
    @Test
    public void tStudentMapperConstructs() {
        var real = jan;
        var constructed = mapper.construct(studentArgs);
        assertThat(constructed).isEqualTo(real);
    }


    @Test
    public void tStudentMapperDeconstructs() {
        var deconstructed = mapper.deconstruct(jan);
        assertThat(deconstructed).isEqualTo(studentArgs);
    }


    @Test
    public void tMapperStreams() {
        Stream<FieldPair> stream = mapper.stream(jan);
        assertThat(stream).contains(fp("lastname", "Klaassen"), fp(
                "cohort", 2018));
    }

    // helper
    private FieldPair fp(String fName, Object fValue) {
        return new FieldPair(fName, fValue);
    }


    @Test
    public void tgetMapper() {
        var secondMapper = Mapper.mapperFor(Student.class);
        assertThat(secondMapper).isEqualTo(mapper);
    }

    /**
     * Check stream contents. It is sufficient to test for fieldpair with non
     * primitives, e.g. lastname and one with primitive, e.g. cohort.
     */

    @Test
    void tStream() {
        // Duplicate
        Stream<FieldPair> stream = mapper.stream(jan);
        assertThat(stream).contains(fp("lastname", "Klaassen"), fp("cohort", 2018));
    }

    @Test
    public void tUnknownClassShouldThrow() {
        ThrowingCallable code = () -> {
            var mapper1 = Mapper.mapperFor(Course.class);
        };

        assertThatThrownBy(code)
                .isInstanceOf(RuntimeException.class);
    }


    @Test
    void tExtractorTest() {
        assertThat(mapper.keyExtractor().apply(jan)).isEqualTo(snummer);
//        fail( "method ExtractorTest completed succesfully; you know what to do" );
    }


    @Test
    void tLoadTutor() {

        assertThatCode(() -> {
            Mapper<Tutor, Object> tutorMapper = Mapper.mapperFor(testentities.Tutor.class);
            assertThat(tutorMapper.keyType()).isSameAs(Integer.class);
        }).doesNotThrowAnyException();
//        fail( "method LoadTutor completed succesfully; you know what to do" );
    }


    @Test
    void tLoadEntityFields() {
        assertThatCode(() -> {
            Mapper<Tutor, Object> tutorMapper = Mapper.mapperFor(testentities.Tutor.class);
            assertThat(tutorMapper.entityFields()).hasSize(9);
        }).doesNotThrowAnyException();
//        fail( "method LoadEnityFields completed succesfully; you know what to do" );
    }


    @Test
    void tReplaceFields() {
        Student piet = new Student(123432, "Puk", null, "Piet",
                of(1977, 6, 7), 1999, "p.puk@student.fantys.nl", "M", "ALUMNI", Boolean.FALSE);

        Mapper<Student, Integer> studentMapper = Mapper.mapperFor(Student.class);
        final Student pieterNel = studentMapper.replaceFields(piet, fp("gender", "F"), fp("firstname", "Pieternel"));

        assertSoftly(s -> {
            s.assertThat(pieterNel.getFirstname()).isEqualTo("Pieternel");
            s.assertThat(pieterNel.getGender()).isEqualTo("F");
        });
//        fail( "method ReplaceFields completed succesfully; you know what to do" );
    }

}
