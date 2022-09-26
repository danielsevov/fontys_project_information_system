package fontys.frontend.observables;

import businessentitiesapi.DailyDiscount;
import helpers.ControllerUtils;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Observable entity for populating the TableView with discount data.
 * <p>
 * The fields of the ObservableDailyDiscount are SimpleIntegerProperty, SimpleStringProperties
 * and SimpleDoubleProperty and correspond to the fields of the actual discount.
 */
public class ObservableDailyDiscount implements ObservableEntity {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty day;
    private final SimpleDoubleProperty multiplier;

    /**
     * Simple constructor for setting up the properties.
     */
    private ObservableDailyDiscount(int id, String day, double multi) {
        this.id = new SimpleIntegerProperty(id);
        this.day = new SimpleStringProperty(day);
        this.multiplier = new SimpleDoubleProperty(multi);
    }

    /**
     * Creates ObservableDailyDiscount from DailyDiscount.
     */
    public static ObservableDailyDiscount fromDailyDiscount(DailyDiscount discount) {
        return new ObservableDailyDiscount(
                discount.getId(),
                discount.getDay(),
                ControllerUtils.round(discount.getMultiplier(), 2)
        );
    }

    /**
     * The getters and setters are needed for setting the cell value
     * factory of the TableView by extracting the corresponding
     * property value (field value) with a PropertyValueFactory.
     * <p>
     * Setter and getter for multiplier.
     */
    public void setMultiplier(double value) {
        multiplier.set(value);
    }

    public double getMultiplier() {
        return multiplier.get();
    }

    /**
     * Setter and getter for day of the week.
     */
    public void setDay(String value) {
        day.set(value);
    }

    public String getDay() {
        return day.get();
    }

    /**
     * Setter and getter for ID.
     */
    public void setId(Integer value) {
        id.set(value);
    }

    @Override
    public int getId() {
        return id.get();
    }

    /**
     * Returns text representation of Daily Discount
     */
    public String toString(){
        return "Static daily discount (" + id.get() + ")  for " + day.get() + " : " + multiplier.get();
    }
}
