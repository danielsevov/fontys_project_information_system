package bootstrap;

import businessentitiesapi.*;
import businesslogic.*;
import genericmapper.Mapper;
import persistence.DAOProvider;
import persistence.dao.DAO;
import persistence.pgdao.PGDAOFactory;
import persistence.pgdao.PGJDBCUtils;

@SuppressWarnings("unchecked")
class DAOProviderImpl implements DAOProvider {
    private static final PGDAOFactory factory;

    static {
        factory = new PGDAOFactory(PGJDBCUtils.getDataSource("airline"));
        // These are needed for foreign key support.
        factory.registerMapper(Airplane.class, Mapper.mapperFor(AirplaneImpl.class));
        factory.registerMapper(Airport.class, Mapper.mapperFor(AirportImpl.class));
        factory.registerMapper(Flight.class, Mapper.mapperFor(FlightImpl.class));
        factory.registerMapper(Customer.class, Mapper.mapperFor(CustomerImpl.class));
        factory.registerMapper(Booking.class, Mapper.mapperFor(BookingImpl.class));
        factory.registerMapper(Ticket.class, Mapper.mapperFor(TicketImpl.class));
        factory.registerMapper(TicketType.class, Mapper.mapperFor(TicketTypeImpl.class));
        factory.registerMapper(TicketOption.class, Mapper.mapperFor(TicketOptionImpl.class));
        factory.registerMapper(BookedOption.class, Mapper.mapperFor(BookedOptionImpl.class));
        factory.registerMapper(DailyDiscount.class, Mapper.mapperFor(DailyDiscountImpl.class));
    }

    @Override
    public DAO<Airport, Integer> getAirportDao() {
        return (DAO) factory.createDao(AirportImpl.class);
    }

    @Override
    public DAO<Airplane, Integer> getAirplaneDao() {
        return (DAO) factory.createDao(AirplaneImpl.class);
    }

    @Override
    public DAO<Flight, Integer> getFlightDao() {
        return (DAO) factory.createDao(FlightImpl.class);
    }

    @Override
    public DAO<Customer, Integer> getCustomerDao() {
        return (DAO) factory.createDao(CustomerImpl.class);
    }

    @Override
    public DAO<Booking, Integer> getBookingDao() {
        return (DAO) factory.createDao(BookingImpl.class);
    }

    @Override
    public DAO<Ticket, Integer> getTicketDao() {
        return (DAO) factory.createDao(TicketImpl.class);
    }

    @Override
    public DAO<TicketOption, Integer> getTicketOptionDao() {
        return (DAO) factory.createDao(TicketOptionImpl.class);
    }

    @Override
    public DAO<TicketType, Integer> getTicketTypeDao() {
        return (DAO) factory.createDao(TicketTypeImpl.class);
    }

    @Override
    public DAO<BookedOption, Integer> getBookedOptionDao() {
        return (DAO) factory.createDao(BookedOptionImpl.class);
    }

    @Override
    public DAO<DailyDiscount, Integer> getDailyDiscountDao() {
        return (DAO) factory.createDao(DailyDiscountImpl.class);
    }
}
