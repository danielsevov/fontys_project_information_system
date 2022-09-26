/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businesslogic;

import businessentitiesapi.*;

/**
 * Central hub with access to all {@link businessentitiesapi.Entity} managers.
 */
public interface BusinessLogicAPI {
    /**
     * Provides access to the flight manager.
     *
     * @return the flight manager
     */
    FlightManager getFlightManager();

    /**
     * Provides access to the airplane manager.
     *
     * @return the airplane manager
     */
    AirplaneManager getAirplaneManager();

    /**
     * Provides access to the airport manager.
     *
     * @return the airport manager
     */
    AirportManager getAirportManager();

    /**
     * Provides access to the customer manager.
     *
     * @return the customer manager
     */
    CustomerManager getCustomerManager();

    /**
     * Provides access to the booking manager.
     *
     * @return the booking manager
     */
    BookingManager getBookingManager();

    /**
     * Provides access to the ticket manager.
     *
     * @return the ticket manager
     */
    TicketManager getTicketManager();

    /**
     * Provides access to the ticket option manager.
     *
     * @return the ticket option manager
     */
    TicketOptionManager getTicketOptionManager();

    /**
     * Provides access to the ticket type manager.
     *
     * @return the ticket type manager
     */
    TicketTypeManager getTicketTypeManager();

    /**
     * Provides access to the booked option manager.
     *
     * @return the ticket booked option manager
     */
    BookedOptionManager getBookedOptionManager();

    /**
     * Provides access to the daily discount manager.
     *
     * @return the daily discount manager
     */
    DailyDiscountManager getDailyDiscountManager();
}
