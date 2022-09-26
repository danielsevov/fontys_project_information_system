package businesslogic;

import businessentitiesapi.Booking;
import businessentitiesapi.Customer;
import genericmapper.ForeignKey;
import nl.fontys.sebivenlo.sebiannotations.ID;
import nl.fontys.sebivenlo.sebiannotations.TableName;

@TableName(value = "booking")
public class BookingImpl implements Booking {
    @ID
    private final int id;
    @ForeignKey
    private final Customer customer;

    public BookingImpl(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    @Override
    public Customer getBuyer() {
        return customer;
    }

    @Override
    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }
}
