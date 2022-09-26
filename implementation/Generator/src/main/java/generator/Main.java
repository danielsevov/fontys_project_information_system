package generator;

import genericmapper.MapperGenerator;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * Driver for our generator. This avoids a circular dependency.
 */
class Main {
    private static final String PACKAGE = "businesslogic.";

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        // Yes, this is suboptimal but it's the best we can do without reflection.
        var allClasses = Stream.of(
                "FlightImpl", "AirplaneImpl", "AirportImpl", "BookingImpl",
                "CustomerImpl", "TicketImpl", "TicketOptionImpl",
                "TicketTypeImpl", "BookedOptionImpl", "DailyDiscountImpl"
        );
        var mapped = allClasses.map(s -> PACKAGE + s).toArray(String[]::new);
        MapperGenerator.main(mapped);
    }
}
