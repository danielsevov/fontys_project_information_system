package utils;

import businessentitiesapi.*;
import businesslogic.BusinessLogicAPI;

/**
 * This is a stand-in class for the {@link BusinessLogicAPI}.
 * Properties are injected via {@link org.mockito.InjectMocks} in the test base class.
 */
public class MockedBusiness implements BusinessLogicAPI {
    private FlightManager flightManager;
    private AirplaneManager airplaneManager;
    private AirportManager airportManager;
    private CustomerManager customerManager;
    private BookingManager bookingManager;
    private TicketManager ticketManager;
    private TicketOptionManager ticketOptionManager;
    private TicketTypeManager ticketTypeManager;
    private BookedOptionManager bookedOptionManager;
    private DailyDiscountManager dailyDiscountManager;


    @Override
    public FlightManager getFlightManager() {
        return flightManager;
    }

    @Override
    public AirplaneManager getAirplaneManager() {
        return airplaneManager;
    }

    @Override
    public AirportManager getAirportManager() {
        return airportManager;
    }

    @Override
    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    @Override
    public BookingManager getBookingManager() {
        return bookingManager;
    }

    @Override
    public TicketManager getTicketManager() {
        return ticketManager;
    }

    @Override
    public TicketOptionManager getTicketOptionManager() {
        return ticketOptionManager;
    }

    @Override
    public TicketTypeManager getTicketTypeManager() {
        return ticketTypeManager;
    }

    @Override
    public BookedOptionManager getBookedOptionManager() {
        return bookedOptionManager;
    }

    @Override
    public DailyDiscountManager getDailyDiscountManager() {
        return dailyDiscountManager;
    }
}
