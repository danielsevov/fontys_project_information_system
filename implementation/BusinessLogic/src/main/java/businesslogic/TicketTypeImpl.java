package businesslogic;

import businessentitiesapi.TicketType;
import nl.fontys.sebivenlo.sebiannotations.ID;
import nl.fontys.sebivenlo.sebiannotations.TableName;

@TableName(value = "ticket_type")
public class TicketTypeImpl implements TicketType {
    @ID
    private final int id;
    private final String name;
    private final double multiplier;

    public TicketTypeImpl(int id, String name, double multiplier) {
        this.id = id;
        this.name = name;
        this.multiplier = multiplier;
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
    public double getMultiplier() {
        return multiplier;
    }
}
