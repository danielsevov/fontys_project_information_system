package businesslogic;

import businessentitiesapi.Airport;
import nl.fontys.sebivenlo.sebiannotations.ID;
import nl.fontys.sebivenlo.sebiannotations.TableName;

@TableName(value = "airport")
public class AirportImpl implements Airport {
    @ID
    private final Integer id;
    private final String name;
    private final String location;

    public AirportImpl(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
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
    public String getLocation() {
        return location;
    }

    public String toString() {
        return name + ", " + location;
    }
}
