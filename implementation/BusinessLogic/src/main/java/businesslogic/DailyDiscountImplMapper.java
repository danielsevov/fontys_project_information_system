package businesslogic;

import genericmapper.Mapper;
import java.util.function.Function;

/**
 * Generated code. Do not edit, your changes will be lost.
 */
public class DailyDiscountImplMapper extends Mapper<DailyDiscountImpl, Integer> {

    // No public ctor 
    private DailyDiscountImplMapper() {
        super( DailyDiscountImpl.class, java.lang.invoke.MethodHandles.lookup()  );
    }

    // self register
    static {
        Mapper.register( new DailyDiscountImplMapper() );
    }

    // the method that it is all about
    @Override
    public Object[] deconstruct(  DailyDiscountImpl d ) {
           return new Object[]{
                            d.getId(),
              d.getDay(),
              d.getMultiplier()
           }; 
    }

    @Override
    public Function<DailyDiscountImpl, Integer> keyExtractor() {
        return ( DailyDiscountImpl d ) -> d.getId();
    }

    @Override
    public Class<Integer> keyType() {
        return Integer.class;

    }
}