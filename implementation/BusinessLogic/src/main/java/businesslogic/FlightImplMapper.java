package businesslogic;

import genericmapper.Mapper;

import java.util.function.Function;

/**
 * Generated code. Do not edit, your changes will be lost.
 */
public class FlightImplMapper extends Mapper<FlightImpl, Integer> {

    // No public ctor 
    private FlightImplMapper() {
        super( FlightImpl.class, java.lang.invoke.MethodHandles.lookup()  );
    }

    // self register
    static {
        Mapper.register( new FlightImplMapper() );
    }

    // the method that it is all about
    @Override
    public Object[] deconstruct(  FlightImpl f ) {
           return new Object[]{
                   f.getId(),
                   f.getDepartureDatetime(),
                   f.getArrivalDatetime(),
                   f.getPlane().getId(),
                   f.getDepartureAirport().getId(),
                   f.getArrivalAirport().getId(),
                   f.getPrice()
           }; 
    }

    @Override
    public Function<FlightImpl, Integer> keyExtractor() {
        return ( FlightImpl f ) -> f.getId();
    }

    @Override
    public Class<Integer> keyType() {
        return Integer.class;

    }
}
