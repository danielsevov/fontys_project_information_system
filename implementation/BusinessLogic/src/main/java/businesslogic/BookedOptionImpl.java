package businesslogic;

import businessentitiesapi.BookedOption;
import businessentitiesapi.Ticket;
import businessentitiesapi.TicketOption;
import genericmapper.ForeignKey;
import nl.fontys.sebivenlo.sebiannotations.ID;
import nl.fontys.sebivenlo.sebiannotations.TableName;

@TableName(value = "booked_option")
public class BookedOptionImpl implements BookedOption {
    @ID
    private final int id;
    @ForeignKey
    private final Ticket ticket;
    @ForeignKey
    private final TicketOption ticketOption;

    public BookedOptionImpl(int id, Ticket ticket, TicketOption ticketOption) {
        this.id = id;
        this.ticket = ticket;
        this.ticketOption = ticketOption;
    }

    @Override
    public Ticket getTicket() {
        return ticket;
    }

    @Override
    public TicketOption getTicketOption() {
        return ticketOption;
    }

    @Override
    public int getId() {
        return id;
    }
}
