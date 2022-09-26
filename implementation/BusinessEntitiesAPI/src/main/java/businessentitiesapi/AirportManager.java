package businessentitiesapi;

/**
 * {@link Manager} interface for the {@link Airport} entity.
 */
public interface AirportManager extends Manager<Airport, Integer> {
    /**
     * Creates a new {@link Airport} instance.
     *
     * @param name     the name of the new airport
     * @param location the location of the new airport
     * @return the new airport
     */
    Airport createAirport(String name, String location);

    Airport createAirport(Integer id, String name, String location);
}
