package businesslogic;

import businessentitiesapi.TicketOption;
import nl.fontys.sebivenlo.sebiannotations.ID;
import nl.fontys.sebivenlo.sebiannotations.TableName;

@TableName(value = "ticket_option")
public class TicketOptionImpl implements TicketOption {
    @ID
    private final int id;
    private final String name;
    private final int price;

    public TicketOptionImpl(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
