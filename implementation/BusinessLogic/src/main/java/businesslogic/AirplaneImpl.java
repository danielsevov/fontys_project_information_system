package businesslogic;

import businessentitiesapi.Airplane;
import nl.fontys.sebivenlo.sebiannotations.ID;
import nl.fontys.sebivenlo.sebiannotations.TableName;

@TableName(value = "airplane")
public class AirplaneImpl implements Airplane {
    @ID
    private final Integer id;
    private final String registrationNumber;
    private final int maxCapacity;

    public AirplaneImpl(Integer id, String name, int maxCapacity) {
        this.id = id;
        this.registrationNumber = name;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public int getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public int getId() {
        return id;
    }

    public String toString() {
        return String.format("Airplane %d : %s", id, registrationNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirplaneImpl airplane = (AirplaneImpl) o;

        if (maxCapacity != airplane.maxCapacity) return false;
        if (!id.equals(airplane.id)) return false;
        return registrationNumber.equals(airplane.registrationNumber);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + registrationNumber.hashCode();
        result = 31 * result + maxCapacity;
        return result;
    }
}
