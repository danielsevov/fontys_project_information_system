package utils;

import businessentitiesapi.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static utils.EntityUtils.*;

public class TestData {
    public static List<Airplane> planes = List.of(
            createAirplane(1, "XB-HCW", 100),
            createAirplane(2, "MX-HCW", 20),
            createAirplane(3, "FF-NYC", 30),
            createAirplane(4, "NS-K0R", 40),
            createAirplane(5, "N711GZ", 50),
            createAirplane(6, "D0KAR1", 60),
            createAirplane(7, "FF1092", 70),
            createAirplane(8, "K0N4E", 80)
    );

    public static List<Airport> airports = List.of(
            createAirport(1, "Hamburg Airport", "Hamburg"),
            createAirport(2, "Venlo Airport", "Venlo"),
            createAirport(3, "Eindhoven Airport", "Eindhoven"),
            createAirport(4, "Amsterdam Airport", "Amsterdam"),
            createAirport(5, "Frankfurt Airport", "Frankfurt"),
            createAirport(6, "Dusseldorf Airport", "Dusseldorf")
    );

    public static List<Flight> flights = createFlights();

    private static List<Flight> createFlights() {
        var flights = new ArrayList<Flight>();
        var size = airports.size();
        var now = LocalDate.now().atStartOfDay();
        int cn = 1;
        for (int i = 0; i < size - 2; i += 2) {
            var airportA = airports.get(i);
            var airportB = airports.get(i + 1);
            var airplane = planes.get(i);
            // [a+2,a+4)
            var dep = now.plusHours(i + 2);
            var arrival = now.plusHours(i + 4);
            flights.add(createFlight(cn, airplane, airportA, airportB, dep, arrival, 100));
            cn++;
        }

        // Force overlap with our first flight.
        var airportOverlapA = airports.get(size - 2);
        var airportOverlapB = airports.get(size - 1);
        var overlapDep = now.plusHours(3);
        var overlapArr = now.plusHours(4);
        flights.add(createFlight(cn, planes.get(size - 2), airportOverlapA, airportOverlapB, overlapDep, overlapArr, 150));
        return flights;
    }

    public static List<Customer> customers = List.of(
            createCustomer(1, "Ivan Ivanov", "ivan@ivanov.com", LocalDate.of(1980, 1, 1)),
            createCustomer(2, "John Jameson", "john@jameson.com", LocalDate.of(1985, 2, 2)),
            createCustomer(3, "Mark Spencer", "mark@spencer.com", LocalDate.of(1990, 3, 3)),
            createCustomer(4, "Philip Ros", "philip@ros.com", LocalDate.of(1995, 4, 4)),
            createCustomer(5, "Johnny B Goode", "johnny@goode.com", LocalDate.of(1959, 4, 4)),
            createCustomer(6, "Megan Thompson", "megan@thompson.com", LocalDate.of(2000, 5, 5))
    );

    public static List<Booking> bookings = List.of(
            createBooking(1, customers.get(0)),
            createBooking(2, customers.get(1)),
            createBooking(3, customers.get(2)),
            createBooking(4, customers.get(3)),
            createBooking(5, customers.get(4)),
            createBooking(6, customers.get(5))
    );

    public static List<TicketType> types = List.of(
            createTicketType(1, "First Class", 3),
            createTicketType(2, "Business Class", 2),
            createTicketType(3, "Economy Class", 1)
    );

    public static List<TicketOption> options = List.of(
            createTicketOption(1, "Extra leg room", 50),
            createTicketOption(2, "Dinner", 25),
            createTicketOption(3, "More luggage", 12)
    );

    public static List<Ticket> tickets = List.of(
            createTicket(1, flights.get(0), customers.get(0), "F1", bookings.get(0), types.get(0), 0),
            createTicket(2, flights.get(0), customers.get(1), "F2", bookings.get(0), types.get(0), 0),
            createTicket(3, flights.get(1), customers.get(1), "B1", bookings.get(1), types.get(1), 0),
            createTicket(4, flights.get(2), customers.get(2), "E1", bookings.get(2), types.get(2), 0),
            createTicket(5, flights.get(2), customers.get(3), "E2", bookings.get(2), types.get(2), 0),
            createTicket(6, flights.get(2), customers.get(4), "E3", bookings.get(2), types.get(2), 0),
            createTicket(7, flights.get(0), customers.get(4), "F3", bookings.get(3), types.get(0), 0),
            createTicket(8, flights.get(0), customers.get(5), "F4", bookings.get(3), types.get(0), 0),
            createTicket(9, flights.get(1), customers.get(3), "B2", bookings.get(4), types.get(1), 0),
            createTicket(10, flights.get(2), customers.get(0), "E4", bookings.get(5), types.get(2), 0),
            createTicket(11, flights.get(2), customers.get(1), "E5", bookings.get(5), types.get(2), 0),
            createTicket(12, flights.get(2), customers.get(2), "E6", bookings.get(5), types.get(2), 0)
    );

    public static List<DailyDiscount> dailyDiscounts = List.of(
            createDailyDiscount(1, "Monday", 1),
            createDailyDiscount(1, "Tuesday", 1),
            createDailyDiscount(1, "Wednesday", 1),
            createDailyDiscount(1, "Thursday", 1),
            createDailyDiscount(1, "Friday", 1),
            createDailyDiscount(1, "Saturday", 1),
            createDailyDiscount(1, "Sunday", 1)
    );
}
