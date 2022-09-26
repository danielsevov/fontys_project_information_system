package businesslogic;

import genericmapper.Mapper;

import java.util.function.Function;

/**
 * Generated code. Do not edit, your changes will be lost.
 */
public class CustomerImplMapper extends Mapper<CustomerImpl, Integer> {

    // No public ctor
    private CustomerImplMapper() {
        super(CustomerImpl.class, java.lang.invoke.MethodHandles.lookup());
    }

    // self register
    static {
        Mapper.register(new CustomerImplMapper());
    }

    // the method that it is all about
    @Override
    public Object[] deconstruct(CustomerImpl a) {
        return new Object[]{
                a.getId(),
                a.getName(),
                a.getEmail(),
                a.getBirthDate()
        };
    }

    @Override
    public Function<CustomerImpl, Integer> keyExtractor() {
        return (CustomerImpl a) -> a.getId();
    }

    @Override
    public Class<Integer> keyType() {
        return Integer.class;

    }
}
