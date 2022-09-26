package businesslogic;

import businessentitiesapi.*;
import genericmapper.ForeignKey;
import nl.fontys.sebivenlo.sebiannotations.ID;
import nl.fontys.sebivenlo.sebiannotations.TableName;

@TableName(value = "ticket")
public class TicketImpl implements Ticket {
    @ID
    private final int id;
    @ForeignKey
    private final Flight flight;
    @ForeignKey
    private final Customer customer;
    private final String seatNumber;
    @ForeignKey
    private final Booking booking;
    @ForeignKey
    private final TicketType ticketType;
    private final double price;

    public TicketImpl(int id, Flight flight, Customer customer, String seatNumber,
                      Booking booking, TicketType ticketType, double price) {
        this.id = id;
        this.flight = flight;
        this.customer = customer;
        this.seatNumber = seatNumber;
        this.booking = booking;
        this.ticketType = ticketType;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Flight getFlight() {
        return flight;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public Booking getBooking() {
        return booking;
    }

    @Override
    public TicketType getTicketType() {
        return ticketType;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
