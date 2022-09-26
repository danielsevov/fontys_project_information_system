package businessentitiesapi;

/**
 * Airplane interface, representing an airplane of an airline company.
 */
public interface Airplane extends Entity {
    /**
     * Returns the name if this airplane.
     *
     * @return the name of the airplane
     */
    String getRegistrationNumber();

    /**
     * Returns the maximum capacity of this airplane.
     * This includes all classes (first class, business class, economy).
     *
     * @return the maximum capacity
     */
    int getMaxCapacity();

    /**
     * Returns the ID of this airplane.
     *
     * @return the ID
     */
    int getId();
}
