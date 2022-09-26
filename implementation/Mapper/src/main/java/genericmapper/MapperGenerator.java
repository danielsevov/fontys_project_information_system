package genericmapper;

import nl.fontys.sebivenlo.sebiannotations.ID;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static genericmapper.Constants.*;
import static java.util.stream.Collectors.joining;

/**
 * Generates mappers for named Types. The types are fully qualified types to be
 * read from the class path.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class MapperGenerator {

    public static void main(String[] args) throws ClassNotFoundException,
            IOException,
            InterruptedException {
        System.err.println("generic mapper generator");
        for (String arg : args) {
            System.err.flush();
            System.out.println("// generating for " + arg);
            Class<?> clz = Class.forName(arg);
            String fileName = generatedJavaFileName(clz);
            File dir = new File(fileName);
            dir.getParentFile().mkdirs();
            System.out.println("fileName = " + fileName);
            String javaSource = new MapperGenerator(clz).javaSource();
            System.out.println("classText = " + javaSource);
            System.out.println("Generated to " + dir.getAbsolutePath());
            if (!javaSource.isBlank()) {
                try (PrintStream out = new PrintStream(fileName)) {
                    out.print(javaSource);
                    out.flush();
                }
            }
        }
    }

    final Class<?> entityType;

    public MapperGenerator(Class<?> entitype) {
        this.entityType = entitype;
    }

    /**
     * Generate the java code using the template MAPPER_TEMPLATE.
     *
     * @return the template text or an empty string when the class has no usable
     * id field.
     */
    final String javaSource() {
        String typeName = entityType.getSimpleName();
        String qualName = entityType.getName();
        String paramName = typeName.substring(0, 1).toLowerCase();
        Field keyField = getKeyField();
        return String.format(TEMPLATE,
                GENERATED_PACKAGE, // <1>
                qualName, // <2>
                typeName, // <3>
                keyField.getType().getSimpleName(), // <4>
                paramName, // <5>
                getters(), // <6>
                getterName(keyField) // <7>
        );
    }

    /**
     * Turn the fields of a class into getter call strings.
     *
     * @return The getters as one indented string.
     */
    final String getters() {
        String typeName = entityType.getSimpleName();
        String paramName = typeName.substring(0, 1).toLowerCase();
        String paramNameDot = paramName + ".";
        Field[] declaredFields = getAllFieldsInClassHierarchy();
        String indent = "              ";
        return Stream.of(declaredFields)
                .map(this::getterName)
                .map(s -> indent + paramNameDot + s)
                .collect(joining(",\n"));
    }

    /**
     * Generate the array of fields in top down declaration order. Top down
     * means the super stuff first.
     *
     * @return the array of all declared fields in the class hierarchy.
     */
    final Field[] getAllFieldsInClassHierarchy() {
        List<Field[]> classFields = new ArrayList<>();
        Class<?> curr = entityType;
        while (curr != null) {
            classFields.add(curr.getDeclaredFields());
            curr = curr.getSuperclass();
        }
        Collections.reverse(classFields);
        return classFields.stream().flatMap(Stream::of).toArray(Field[]::new);
    }

    /**
     * Produce a getter call like getName().
     *
     * @param f for field
     * @return getName() for field name.
     */
    String getterName(Field f) {
        var name = f.getName();
        return String.format("get%s%s()", name.substring(0, 1).toUpperCase(), name.substring(1));
    }

    /**
     * Try to find the Annotation @ID and if that fails the field called "id".
     *
     * @return the field.
     * @throws NoSuchFieldError after two attempts
     */
    Field getKeyField() {
        return Stream.of(entityType.getDeclaredFields())
                .peek(System.out::println)
                .filter(f -> f.getAnnotation(ID.class) != null)
                .findFirst()
                .or(this::getFieldNamedId)
                .orElseThrow();

    }

    Optional<Field> getFieldNamedId() {
        return Stream.of(entityType.getDeclaredFields()).filter(
                f -> "id".equals(f.getName()))
                .findFirst();
    }
}
