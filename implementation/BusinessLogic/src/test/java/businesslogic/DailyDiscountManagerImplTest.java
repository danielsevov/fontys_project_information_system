package businesslogic;

import businessentitiesapi.DailyDiscount;

class DailyDiscountManagerImplTest extends ManagerTestBase<DailyDiscountManagerImpl, DailyDiscount> {
    @Override
    DailyDiscount entityCreator(int id) {
        return new DailyDiscountImpl(id, "0", 0);
    }

    @Override
    DailyDiscountManagerImpl managerCreator() {
        return new DailyDiscountManagerImpl();
    }
}
