package businesslogic;

import businessentitiesapi.DailyDiscount;
import nl.fontys.sebivenlo.sebiannotations.ID;
import nl.fontys.sebivenlo.sebiannotations.TableName;

@TableName(value = "daily_discount")
public class DailyDiscountImpl implements DailyDiscount {
    @ID
    private final Integer id;
    private final String day;
    private final double multiplier;

    public DailyDiscountImpl(Integer id, String day, double multiplier) {
        this.id = id;
        this.day = day;
        this.multiplier = multiplier;
    }

    @Override
    public String getDay() {
        return day;
    }

    @Override
    public double getMultiplier() {
        return multiplier;
    }

    @Override
    public int getId() {
        return id;
    }

    public String toString(){
        return "Static daily discount (" + this.id + ")  for " + this.day + " : " + multiplier;
    }
}
