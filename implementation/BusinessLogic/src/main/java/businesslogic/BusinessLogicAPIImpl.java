/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businesslogic;

import businessentitiesapi.*;
import persistence.DAOProvider;

/**
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
public class BusinessLogicAPIImpl implements BusinessLogicImplementationProvider, BusinessLogicAPI {

    private final DAOProvider daoProvider;
    // We cache these for performance reasons.
    private AirplaneManagerImpl airplaneManager;
    private AirportManagerImpl airportManager;
    private FlightManagerImpl flightManager;
    private CustomerManagerImpl customerManager;
    private BookingManagerImpl bookingManager;
    private TicketManagerImpl ticketManager;
    private TicketOptionManagerImpl ticketOptionManager;
    private TicketTypeManagerImpl ticketTypeManager;
    private BookedOptionManagerImpl bookedOptionManager;
    private DailyDiscountManagerImpl dailyDiscountManager;

    BusinessLogicAPIImpl(DAOProvider daoProvider) {
        this.daoProvider = daoProvider;
    }

    @Override
    public FlightManager getFlightManager() {
        if (flightManager == null) {
            flightManager = new FlightManagerImpl();
            flightManager.setDaoProvider(daoProvider.getFlightDao());
        }

        return flightManager;
    }

    @Override
    public CustomerManager getCustomerManager() {
        if (customerManager == null) {
            customerManager = new CustomerManagerImpl();
            customerManager.setDaoProvider(daoProvider.getCustomerDao());
        }

        return customerManager;
    }

    @Override
    public BookingManager getBookingManager() {
        if (bookingManager == null) {
            bookingManager = new BookingManagerImpl();
            bookingManager.setDaoProvider(daoProvider.getBookingDao());
        }

        return bookingManager;
    }

    @Override
    public TicketManager getTicketManager() {
        if (ticketManager == null) {
            ticketManager = new TicketManagerImpl();
            ticketManager.setDaoProvider(daoProvider.getTicketDao());
        }

        return ticketManager;
    }

    @Override
    public AirplaneManager getAirplaneManager() {
        if (airplaneManager == null) {
            airplaneManager = new AirplaneManagerImpl();
            airplaneManager.setDaoProvider(daoProvider.getAirplaneDao());
        }

        return airplaneManager;
    }

    @Override
    public AirportManager getAirportManager() {
        if (airportManager == null) {
            airportManager = new AirportManagerImpl();
            airportManager.setDaoProvider(daoProvider.getAirportDao());
        }

        return airportManager;
    }

    @Override
    public TicketOptionManager getTicketOptionManager() {
        if (ticketOptionManager == null) {
            ticketOptionManager = new TicketOptionManagerImpl();
            ticketOptionManager.setDaoProvider(daoProvider.getTicketOptionDao());
        }
        return ticketOptionManager;
    }

    @Override
    public TicketTypeManager getTicketTypeManager() {
        if (ticketTypeManager == null) {
            ticketTypeManager = new TicketTypeManagerImpl();
            ticketTypeManager.setDaoProvider(daoProvider.getTicketTypeDao());
        }
        return ticketTypeManager;
    }

    @Override
    public BookedOptionManager getBookedOptionManager() {
        if (bookedOptionManager == null) {
            bookedOptionManager = new BookedOptionManagerImpl();
            bookedOptionManager.setDaoProvider(daoProvider.getBookedOptionDao());
        }
        return bookedOptionManager;
    }

    @Override
    public DailyDiscountManager getDailyDiscountManager() {
        if (dailyDiscountManager == null) {
            dailyDiscountManager = new DailyDiscountManagerImpl();
            dailyDiscountManager.setDaoProvider(daoProvider.getDailyDiscountDao());
        }
        return dailyDiscountManager;
    }
}
