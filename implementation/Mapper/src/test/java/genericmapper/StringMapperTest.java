package genericmapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class StringMapperTest {


    @Test
    void tgetMapper() {
        assertThatCode(() -> {
            Mapper<String, String> sm = Mapper.mapperFor(String.class);
        }).doesNotThrowAnyException();
//        fail( "method getMapper completed succesfully; you know what to do" );
    }


    @Test
    void tLoadStringMapperClass() {
        assertThatCode(() -> {
            Mapper.loadMapperClass(String.class);
        }).doesNotThrowAnyException();
//        fail( "method LoadStringMapperClass completed succesfully; you know what to do" );
    }


    @Test
    void tStringDeconstructMakesArray() {
        Mapper<String, String> sm = Mapper.mapperFor(String.class);
        assertThat(sm.deconstruct("Hi")).hasSize(1);
//        fail( "method StringDeconstructMakesArray completed succesfully; you know what to do" );
    }


    @Test
    void tKeyExtractor() {
        String hi = "Hi";
        Mapper<String, String> sm = Mapper.mapperFor(String.class);
        assertThat(sm.keyExtractor().apply(hi)).isSameAs(hi);
//        fail( "method keyExtractor completed succesfully; you know what to do" );
    }


    @Test
    void tKeyType() {
        Mapper<String, String> sm = Mapper.mapperFor(String.class);
        assertThat(sm.keyType()).isSameAs(String.class);
//        fail( "method KeyType completed succesfully; you know what to do" );
    }
}
