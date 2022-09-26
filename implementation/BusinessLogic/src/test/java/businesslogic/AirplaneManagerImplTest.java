package businesslogic;

import businessentitiesapi.Airplane;

class AirplaneManagerImplTest extends ManagerTestBase<AirplaneManagerImpl, Airplane> {
    @Override
    Airplane entityCreator(int id) {
        return new AirplaneImpl(id, "Test Airplane " + id, 0);
    }

    @Override
    AirplaneManagerImpl managerCreator() {
        return new AirplaneManagerImpl();
    }
}
