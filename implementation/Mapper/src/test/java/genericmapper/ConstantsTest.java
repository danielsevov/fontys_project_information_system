package genericmapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class ConstantsTest {
    @SuppressWarnings("unused")
    String fieldWithName;

    @ParameterizedTest
    @CsvSource({
            "bean,getFieldWithName",
            "record,fieldWithName",})
    void tFieldStrategy(String strategy, String expected) {
        Field f = getClass().getDeclaredFields()[0];
        System.setProperty("genericmapper.getternamestyle", strategy);
        assertThat(Constants.getterName(f)).isEqualTo(expected);
    }


    @Test
    void tjavaFileName() {
        String generatedJavaFileName = Constants.generatedJavaFileName(getClass());
        assertThat(generatedJavaFileName).endsWith("genericmapper/ConstantsTestMapper.java");
    }
}
