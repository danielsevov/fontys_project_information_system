package businessentitiesapi;

/**
 * Airport interface.
 */
public interface Airport extends Entity {
    int getId();

    /**
     * Returns the name of this airport.
     *
     * @return the name of this airport
     */
    String getName();

    /**
     * Returns the location of this airport.
     *
     * @return the location of this airport
     */
    String getLocation();
}
