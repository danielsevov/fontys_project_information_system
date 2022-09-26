package businesslogic;

import genericmapper.Mapper;

import java.util.function.Function;

/**
 * Generated code. Do not edit, your changes will be lost.
 */
public class TicketOptionImplMapper extends Mapper<TicketOptionImpl, Integer> {

    // No public ctor 
    private TicketOptionImplMapper() {
        super(TicketOptionImpl.class, java.lang.invoke.MethodHandles.lookup());
    }

    // self register
    static {
        Mapper.register(new TicketOptionImplMapper());
    }

    // the method that it is all about
    @Override
    public Object[] deconstruct(TicketOptionImpl t) {
        return new Object[]{
                t.getId(),
                t.getName(),
                t.getPrice(),
        };
    }

    @Override
    public Function<TicketOptionImpl, Integer> keyExtractor() {
        return (TicketOptionImpl t) -> t.getId();
    }

    @Override
    public Class<Integer> keyType() {
        return Integer.class;

    }
}
