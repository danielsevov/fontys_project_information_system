package businesslogic;

import genericmapper.Mapper;

import java.util.function.Function;

/**
 * Generated code. Do not edit, your changes will be lost.
 */
public class AirportImplMapper extends Mapper<AirportImpl, Integer> {

    // No public ctor 
    private AirportImplMapper() {
        super(AirportImpl.class, java.lang.invoke.MethodHandles.lookup());
    }

    // self register
    static {
        Mapper.register(new AirportImplMapper());
    }

    // the method that it is all about
    @Override
    public Object[] deconstruct(AirportImpl a) {
        return new Object[]{
                a.getId(),
                a.getName(),
                a.getLocation()
        };
    }

    @Override
    public Function<AirportImpl, Integer> keyExtractor() {
        return (AirportImpl a) -> a.getId();
    }

    @Override
    public Class<Integer> keyType() {
        return Integer.class;

    }
}
