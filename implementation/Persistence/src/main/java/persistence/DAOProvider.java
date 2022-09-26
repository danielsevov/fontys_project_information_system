package persistence;

import businessentitiesapi.*;
import persistence.dao.DAO;

/**
 * Central access point for all {@link DAO}s.
 */
public interface DAOProvider {
    /**
     * Provides access to the {@link Airport} DAO.
     *
     * @return the airport dao
     */
    default DAO<Airport, Integer> getAirportDao() {
        return null;
    }

    /**
     * Provides access to the {@link Airplane} DAO.
     *
     * @return the airplane dao
     */
    default DAO<Airplane, Integer> getAirplaneDao() {
        return null;
    }

    /**
     * Provides access to the {@link Flight} DAO.
     *
     * @return the flight dao
     */
    default DAO<Flight, Integer> getFlightDao() {
        return null;
    }

    /**
     * Provides access to the {@link Customer} DAO.
     *
     * @return the customer dao
     */
    default DAO<Customer, Integer> getCustomerDao() {
        return null;
    }

    /**
     * Provides access to the {@link Booking} DAO.
     *
     * @return the booking dao
     */
    default DAO<Booking, Integer> getBookingDao() {
        return null;
    }

    /**
     * Provides access to the {@link Ticket} DAO.
     *
     * @return the ticket dao
     */
    default DAO<Ticket, Integer> getTicketDao() {
        return null;
    }

    /**
     * Provides access to the {@link TicketOption} DAO.
     *
     * @return the ticket option dao
     */
    default DAO<TicketOption, Integer> getTicketOptionDao() {
        return null;
    }

    /**
     * Provides access to the {@link TicketType} DAO.
     *
     * @return the ticket type dao
     */
    default DAO<TicketType, Integer> getTicketTypeDao() {
        return null;
    }

    /**
     * Provides access to the {@link BookedOption} DAO.
     *
     * @return the booked option dao
     */
    default DAO<BookedOption, Integer> getBookedOptionDao() {
        return null;
    }

    /**
     * Provides access to the {@link DailyDiscount} DAO.
     *
     * @return the daily discount dao
     */
    default DAO<DailyDiscount, Integer> getDailyDiscountDao() {
        return null;
    }
}
