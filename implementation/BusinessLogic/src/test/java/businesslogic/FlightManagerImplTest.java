package businesslogic;

import businessentitiesapi.Airport;
import businessentitiesapi.Flight;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class FlightManagerImplTest extends businesslogic.ManagerTestBase<FlightManagerImpl, Flight> {
    private final Airport testAirport = new AirportImpl(0, "Test airport", "Test location");

    @Override
    Flight entityCreator(int id) {
        var plane = new AirplaneImpl(0, "Test airplane", 0);
        return new FlightImpl(id, LocalDateTime.MIN, LocalDateTime.MAX, plane, testAirport, testAirport, 0);
    }

    @Override
    FlightManagerImpl managerCreator() {
        return new FlightManagerImpl();
    }

    @Test
    void testFindQualifiedAirplanes() {
        // This is a DB query with no real involvement of the pre-query cache.
        when(dao.anyQuery(anyString(), any(), any(), any())).thenReturn(allValues());
        var got = getManager().findQualifiedAirplanes(LocalDateTime.MIN, LocalDateTime.MAX, testAirport);
        verify(cache, times(got.size())).put(anyInt(), any());
        var planes = allValues().stream().map(Flight::getPlane).collect(Collectors.toList());
        assertThat(got).isEqualTo(planes);
    }
}
