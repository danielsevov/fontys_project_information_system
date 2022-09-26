package businessentitiesapi;

/**
 * {@link Manager} interface for the {@link Airplane} entity.
 */
public interface AirplaneManager extends Manager<Airplane, Integer> {
    /**
     * Creates a new {@link Airplane} instance.
     *
     * @param registrationNumber the registration number of the new airplane.
     * @param maxCapacity        the maximum capacity of the new airplane.
     * @return the new airplane
     */
    Airplane createAirplane(String registrationNumber, int maxCapacity);

    Airplane createAirplane(Integer id, String registrationNumber, int maxCapacity);
}
