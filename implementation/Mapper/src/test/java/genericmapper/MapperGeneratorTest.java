package genericmapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import testentities.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class MapperGeneratorTest {

    @BeforeAll
    static void cleanup() throws IOException {
        File out = new File("out");
        if (out.exists() && out.isDirectory()) {
            Files.walk(Path.of("out"))
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .peek(System.out::println)
                    .forEach(File::delete);
        }
    }

    /**
     * Helper method to clean code of unneeded whitespace and empty lines.
     *
     * @param javaCode to process
     * @return list of clean lines
     */
    static List<String> cleanCode(String javaCode) {
        List<String> cleanCode
                = Stream.of(javaCode.split("\n"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(toList());
        System.out.println("<pre>");
        // a captured object must be final, but may be muttable
        AtomicInteger counter = new AtomicInteger();
        cleanCode.forEach(l -> System.out.println(counter.getAndIncrement()
                + " " + l));
        System.out.println("</pre>");
        return cleanCode;
    }

    // to abbreviate new String[]{...} to s(...) 
    static String[] s(String... s) {
        return s;
    }

    static Stream<Arguments> testData2() {
        return Stream.of(
                arguments(0, s("package", "businesslogic;")),
                arguments(1, s("import", "testentities.Student;")),
                arguments(2, s("import", "genericmapper.Mapper;")),
                arguments(3, s("import", "java.util.function.Function;")),
                arguments(7,
                        s("public", "class", "StudentMapper", "extends",
                                "Mapper<Student,", "Integer>", "{")),
                arguments(9, s("private", "StudentMapper()", "{")),
                arguments(10, s("super(", "Student.class,",
                        "java.lang.invoke.MethodHandles.lookup()", ");")),
                arguments(13, s("static", "{")),
                arguments(14, s("Mapper.register(", "new", "StudentMapper()",
                        ");")),
                arguments(15, s("}")),
                arguments(17, s("@Override")),
                arguments(18,
                        s("public", "Object[]", "deconstruct(", "Student", "s")),
                arguments(19, s("return", "new", "Object[]{")),
                arguments(32, s("@Override")),
                arguments(33, s("public", "Function<Student,", "Integer>",
                        "keyExtractor()")),
                arguments(34, s("return", "(", "Student", "s", "->",
                        "s.getSnummer();")),
                arguments(36, s("@Override")),
                arguments(37, s("public", "Class<Integer>", "keyType()", "{")),
                arguments(38, s("return", "Integer.class;"))
        );
    }

    Class<?> type = Student.class;

    /**
     * Test the preamble of the deconstructor:
     * <ol>
     * <li> package declaration</li>
     * <li> import</li>
     * <li> private constructor</li>
     * <li> static block</li>
     * <li> Register call</li>
     * <li> curly</li>
     * <li> @Override</li>
     * <li>method signature</li>
     * <li>return statement</li>
     * </ol>
     *
     * @param line     number in cleaned code, see data above
     * @param elements
     */

    @ParameterizedTest
    @MethodSource("testData2")
    void t0CodeLine(int line, String[] elements) {
        var gen = new MapperGenerator(type);
        List<String> javaCode = cleanCode(gen.javaSource());
        String[] words = javaCode.get(line).split("\\s+");
        assertThat(words).contains(elements);
    }

    /**
     * Get the getters, split into list, and check that the expected number of
     * getter is there. Test with class student. The generated code should have
     * the correct number of lines with respect to the number of fields in the
     * type.
     */

    @Test
    void t1Getters() {
        Class<?> type = Student.class;
        var gen = new MapperGenerator(type);
        List<String> javaCode = cleanCode(gen.getters());
        int fieldCount = gen.getAllFieldsInClassHierarchy().length;
        System.out.println("fieldCount = " + fieldCount);
        assertThat(javaCode.size()).isEqualTo(fieldCount);
    }

    /**
     * Count the {},(), and [], they should match in count.
     */

    @ParameterizedTest
    @CsvSource({
            "{,}",
            "[,]",
            "(,)"
    })
    void t2countBraces(char open, char close) {
        Class<?> type = Student.class;
        var gen = new MapperGenerator(type);
        String javaText = gen.javaSource();
        long opening = javaText.chars().filter(c -> c == open).count();
        long closing = javaText.chars().filter(c -> c == close).count();
        assertThat(opening).isEqualTo(closing);
    }

    /**
     * Test that main runs exception free.
     */

    @Test
    void t3MainCausesNoProblems() {
        assertThatCode(() -> {
            MapperGenerator
                    .main(new String[]{"testentities.Student"});
        }).doesNotThrowAnyException();
    }


    @Test
    void tGenerateTutorMapper() {
        assertThatCode(() -> {
            MapperGenerator
                    .main(new String[]{"testentities.Tutor"});
        }).doesNotThrowAnyException();
    }
}
