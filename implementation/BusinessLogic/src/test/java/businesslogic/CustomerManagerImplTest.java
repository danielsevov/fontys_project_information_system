package businesslogic;

import businessentitiesapi.Customer;

import java.time.LocalDate;

class CustomerManagerImplTest extends ManagerTestBase<CustomerManagerImpl, Customer> {
    @Override
    Customer entityCreator(int id) {
        return new CustomerImpl(id, "Test name", "Test email", LocalDate.MAX);
    }

    @Override
    CustomerManagerImpl managerCreator() {
        return new CustomerManagerImpl();
    }
}
