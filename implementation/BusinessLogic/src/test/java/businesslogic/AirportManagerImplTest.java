package businesslogic;

import businessentitiesapi.Airport;

class AirportManagerImplTest extends ManagerTestBase<AirportManagerImpl, Airport> {
    @Override
    Airport entityCreator(int id) {
        return new AirportImpl(id, "Test Airport " + id, "Test Location");
    }

    @Override
    AirportManagerImpl managerCreator() {
        return new AirportManagerImpl();
    }
}
