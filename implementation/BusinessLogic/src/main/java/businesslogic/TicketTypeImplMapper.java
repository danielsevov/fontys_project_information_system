package businesslogic;

import genericmapper.Mapper;

import java.util.function.Function;

/**
 * Generated code. Do not edit, your changes will be lost.
 */
public class TicketTypeImplMapper extends Mapper<TicketTypeImpl, Integer> {

    // No public ctor 
    private TicketTypeImplMapper() {
        super(TicketTypeImpl.class, java.lang.invoke.MethodHandles.lookup());
    }

    // self register
    static {
        Mapper.register(new TicketTypeImplMapper());
    }

    // the method that it is all about
    @Override
    public Object[] deconstruct(TicketTypeImpl t) {
        return new Object[]{
                t.getId(),
                t.getName(),
                t.getMultiplier()
        };
    }

    @Override
    public Function<TicketTypeImpl, Integer> keyExtractor() {
        return (TicketTypeImpl t) -> t.getId();
    }

    @Override
    public Class<Integer> keyType() {
        return Integer.class;

    }
}
