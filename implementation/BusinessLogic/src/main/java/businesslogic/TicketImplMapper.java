package businesslogic;

import genericmapper.Mapper;

import java.util.function.Function;

/**
 * Generated code. Do not edit, your changes will be lost.
 */
public class TicketImplMapper extends Mapper<TicketImpl, Integer> {

    // No public ctor
    private TicketImplMapper() {
        super(TicketImpl.class, java.lang.invoke.MethodHandles.lookup());
    }

    // self register
    static {
        Mapper.register(new TicketImplMapper());
    }

    // the method that it is all about
    @Override
    public Object[] deconstruct(TicketImpl a) {
        return new Object[]{
                a.getId(),
                a.getFlight().getId(),
                a.getCustomer().getId(),
                a.getSeatNumber(),
                a.getBooking().getId(),
                a.getTicketType().getId(),
                a.getPrice()
        };
    }

    @Override
    public Function<TicketImpl, Integer> keyExtractor() {
        return (TicketImpl a) -> a.getId();
    }

    @Override
    public Class<Integer> keyType() {
        return Integer.class;

    }
}
