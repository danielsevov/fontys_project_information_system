package businessentitiesapi;

/**
 * Daily discount interface, representing a daily discount entity.
 */
public interface DailyDiscount extends Entity {
    /**
     * Returns the day of the week for which this discount is valid.
     *
     * @return the day of the week of the discount
     */
    String getDay();

    /**
     * Returns the multiplier of this discount.
     *
     * @return the multiplier
     */
    double getMultiplier();

    /**
     * Returns the ID of this airplane.
     *
     * @return the ID
     */
    int getId();
}
