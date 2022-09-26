package businesslogic;

import businesslogic.AirplaneImpl;
import genericmapper.Mapper;
import java.util.function.Function;

/**
 * Generated code. Do not edit, your changes will be lost.
 */
public class AirplaneImplMapper extends Mapper<AirplaneImpl, Integer> {

    // No public ctor 
    private AirplaneImplMapper() {
        super( AirplaneImpl.class, java.lang.invoke.MethodHandles.lookup()  );
    }

    // self register
    static {
        Mapper.register( new AirplaneImplMapper() );
    }

    // the method that it is all about
    @Override
    public Object[] deconstruct(  AirplaneImpl a ) {
           return new Object[]{
                            a.getId(),
              a.getRegistrationNumber(),
              a.getMaxCapacity()
           }; 
    }

    @Override
    public Function<AirplaneImpl, Integer> keyExtractor() {
        return ( AirplaneImpl a ) -> a.getId();
    }

    @Override
    public Class<Integer> keyType() {
        return Integer.class;

    }
}