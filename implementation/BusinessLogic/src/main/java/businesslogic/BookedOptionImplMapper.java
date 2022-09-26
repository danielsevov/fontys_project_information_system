package businesslogic;

import genericmapper.Mapper;

import java.util.function.Function;

/**
 * Generated code. Do not edit, your changes will be lost.
 */
public class BookedOptionImplMapper extends Mapper<BookedOptionImpl, Integer> {

    // No public ctor
    private BookedOptionImplMapper() {
        super(BookedOptionImpl.class, java.lang.invoke.MethodHandles.lookup());
    }

    // self register
    static {
        Mapper.register(new BookedOptionImplMapper());
    }

    // the method that it is all about
    @Override
    public Object[] deconstruct(BookedOptionImpl b) {
        return new Object[]{
                b.getId(),
                b.getTicket().getId(),
                b.getTicketOption().getId()
        };
    }

    @Override
    public Function<BookedOptionImpl, Integer> keyExtractor() {
        return (BookedOptionImpl b) -> b.getId();
    }

    @Override
    public Class<Integer> keyType() {
        return Integer.class;

    }
}
