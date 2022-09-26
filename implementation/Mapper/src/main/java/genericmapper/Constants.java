package genericmapper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.function.Function;

/**
 * Constant String values used in Mapper api.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public enum Constants {
    ;// no values

    public static final String GENERATED_PACKAGE = "businesslogic";
    public static final String DESTINATION_DIRNAME = "implementation/BusinessLogic/src/main/java/";
    public static final String TEMPLATE = "package %1$s;\n" +
            "\n" +
            "import %2$s;\n" +
            "import genericmapper.Mapper;\n" +
            "import java.util.function.Function;\n" +
            "\n" +
            "/**\n" +
            " * Generated code. Do not edit, your changes will be lost.\n" +
            " */\n" +
            "public class %3$sMapper extends Mapper<%3$s, %4$s> {\n" +
            "\n" +
            "    // No public ctor \n" +
            "    private %3$sMapper() {\n" +
            "        super( %3$s.class, java.lang.invoke.MethodHandles.lookup()  );\n" +
            "    }\n" +
            "\n" +
            "    // self register\n" +
            "    static {\n" +
            "        Mapper.register( new %3$sMapper() );\n" +
            "    }\n" +
            "\n" +
            "    // the method that it is all about\n" +
            "    @Override\n" +
            "    public Object[] deconstruct(  %3$s %5$s ) {\n" +
            "           return new Object[]{\n" +
            "              %6$s\n" +
            "           }; \n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public Function<%3$s, %4$s> keyExtractor() {\n" +
            "        return ( %3$s %5$s ) -> %5$s.%7$s;\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public Class<%4$s> keyType() {\n" +
            "        return %4$s.class;\n" +
            "\n" +
            "    }\n" +
            "}";

    public static String mapperName(Class<?> entityType) {
        return entityType.getName() + "Mapper";
    }


    public static String generatedJavaFileName(Class<?> type) {
        String n = mapperTypeName(type);
        return (DESTINATION_DIRNAME + "/" + n).replace('.', '/') + ".java";
    }

    public static String mapperTypeName(Class<?> type) {
        return type.getName() + "Mapper";
    }

    private static final Map<String, Function<String, String>> getterNameStrategy
            = Map.of("record", x -> x, "bean", Constants::beanStyle);

    static String beanStyle(String s) {
        return "get" + s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static Function<String, String> getterNameStrategy() {
        String strat = System.getProperty("genericmapper.getternamestyle", "bean");
        return getterNameStrategy.get(strat);

    }

    public static String getterName(Field f) {
        return getterNameStrategy().apply(f.getName());
    }

    /**
     * Helper to check for non normal fields.
     *
     * @return true if not static nor synthetic.
     */
    public static boolean isNotStaticOrSynthetic(Field f) {
        return !(f.isSynthetic() || Modifier.isStatic(f.getModifiers()));
    }

}
