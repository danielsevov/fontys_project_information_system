package businesslogic;

import genericmapper.Mapper;

import java.util.function.Function;

/**
 * Generated code. Do not edit, your changes will be lost.
 */
public class BookingImplMapper extends Mapper<BookingImpl, Integer> {

    // No public ctor
    private BookingImplMapper() {
        super(BookingImpl.class, java.lang.invoke.MethodHandles.lookup());
    }

    // self register
    static {
        Mapper.register(new BookingImplMapper());
    }

    // the method that it is all about
    @Override
    public Object[] deconstruct(BookingImpl a) {
        return new Object[]{
                a.getId(),
                a.getBuyer().getId()
        };
    }

    @Override
    public Function<BookingImpl, Integer> keyExtractor() {
        return (BookingImpl a) -> a.getId();
    }

    @Override
    public Class<Integer> keyType() {
        return Integer.class;

    }
}
