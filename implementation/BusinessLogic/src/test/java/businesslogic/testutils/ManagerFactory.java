package businesslogic.testutils;

import businessentitiesapi.Entity;
import businesslogic.ManagerImplBase;
import persistence.dao.DAO;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Abstract factory class for all {@link ManagerImplBase} dervied tests.
 *
 * @param <M> the bound {@link ManagerImplBase} type
 * @param <T> the {@link Entity} this manager takes care of.
 */
abstract public class ManagerFactory<M extends ManagerImplBase<T>, T extends Entity> {
    private final List<T> testValues;
    private final Function<Integer, T> creator;

    protected ManagerFactory(Function<Integer, T> creator) {
        this.testValues = createEntityList(creator);
        this.creator = creator;
    }

    /**
     * Create an instantiate a new manager with dao and cache component.
     *
     * @param cache the cache to use
     * @param dao   the dao to use
     * @return the created manager
     */
    public M createManager(Map<Integer, T> cache, DAO<T, Integer> dao) {
        var manager = createManager();
        manager.setDaoProvider(dao);
        manager.setEntityCache(cache);
        return manager;
    }

    /**
     * Create a new entity {@link T} with id.
     *
     * @param id the id of the new entity
     * @return the new entity
     */
    public T createEntityWithId(int id) {
        return creator.apply(id);
    }

    /**
     * Create a new manager.
     *
     * @return the new manager
     */
    public abstract M createManager();

    private List<T> createEntityList(Function<Integer, T> creator) {
        return IntStream.rangeClosed(0, 9).mapToObj(creator::apply).collect(Collectors.toUnmodifiableList());
    }

    /**
     * Get the first entity from the internal list of entities.
     *
     * @return the first entity
     */
    public T getFirstEntity() {
        return testValues.get(0);
    }

    /**
     * Get all test values.
     *
     * @return all test values
     */
    public List<T> getTestValues() {
        return testValues;
    }
}
