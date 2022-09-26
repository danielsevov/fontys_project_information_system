package businessentitiesapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

/**
 * Central Manager for all entity managers.
 * This serves as bounded interface.
 *
 * @param <T> bounded type, which must extend from {@link Entity}.
 */
public interface Manager<T extends Entity, K> {
    /**
     * Get the entity by id, if any.
     *
     * @param id of the entity
     * @return a nullable optional containing the entity or not.
     */
    Optional<T> get(K id);

    /**
     * Get all entities.
     *
     * @return all entities available through this dao.
     */
    List<T> getAll();

    /**
     * Get by column key values pairs. Convenience method to get a entities by
     * field=value[,field=value].
     *
     * @param keyValues even sized parameter list like
     *                  ("id",1).
     * @return the collection of entities matching key value pairs.
     */
    List<T> getByColumnValues(Object... keyValues);

    /**
     * Persist an entity.
     *
     * @param T to save
     * @return the update entity, primary key and all
     */
    Optional<T> save(T T);

    /**
     * Update and entity. In a typical database scenario, all fields are set to
     * the new values. It is up to the user to ensure that the id value is
     * stable throughout this operation.
     *
     * @param T entity to update
     * @return the updated entity
     */
    T update(T T);

    /**
     * Delete t using its key (id). This method extracts the key and uses that
     * to delete the entity.
     *
     * @param T entity to delete
     */
    void deleteEntity(T T);

    /**
     * Get the number of entities accessible through this DAO.
     *
     * @return the size of the backing store (table, lst, map...)
     */
    int size();

    /**
     * Get the highest id used in this DAO.
     *
     * @return the last used number.
     */
    int lastId();

    /**
     * Save all entities, returning the result in a collection with the saved
     * versions of the entities, generated fields and all.
     * <p>
     * The caller is advised to give this DAO a transaction token, so this
     * operation can perform atomically for those persistence implementations
     * that support proper commit and rollback.
     * <p>
     * Implementations that recreate resources on every call of
     * {@code dao.save(T)} should probably overwrite this default implementation
     * for improved performance and memory efficiency.
     *
     * @param entities to save
     * @return the saved entities
     * @since 0.4
     */
    default List<? extends T> saveAll(List<T> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(T -> save(T).get()).collect(toList());
    }

    /**
     * Save the given entities, returning the result as a list.
     * <p>
     * This default implementation will benefit from any improvements by an
     * overwritten {@code saveAll(Collection &lt;T&gt;entities)}
     *
     * @param entities to save
     * @return the saved versions of the entities in a list.
     * @since 0.4
     */
    default List<? extends T> saveAll(T... entities) {
        return saveAll(Arrays.asList(entities));
    }

    /**
     * Delete the given entities.
     *
     * @param entities to delete.
     * @since 0.5
     */
    default void deleteAll(Iterable<T> entities) {
        StreamSupport.stream(entities.spliterator(), false).forEach(this::deleteEntity);
    }

    /**
     * Delete the given entities, array version.
     *
     * @param entities to delete
     * @since 0.5
     */
    default void deleteAll(T... entities) {
        deleteAll(List.of(entities));
    }

    /**
     * Execute a query with some query text for a prepared statement. Usecase:
     * in a RDBMS (postgres) sometimes you want to call a function in a query,
     * which is not directly supported by the DAO. This implementation returns
     * an empty list. Useful work is left to the implementing class.
     *
     * @param queryText sql with positional parameters
     * @param params    the values for the position parameters
     * @return a list of T.
     */
    List<T> anyQuery(String queryText, Object... params);

    /**
     * Remove all entities from the backing store of this  dao.
     * Optional operation.
     */
    default void dropAll() {
    }

    /**
     * Delete an entity by key.
     *
     * @param id the key (id) of the entity to delete
     */
    void deleteById(K id);

    /**
     * Return all entities that match the predicate.
     *
     * @param predicate the predicate
     * @return all matching entities
     */
    List<T> getAllMatching(Predicate<T> predicate);

    /**
     * Update a single column of an entity.
     *
     * @param e      the entity
     * @param column the column to update
     * @param value  the new value
     * @return the updated entity
     */
    T updateColumnFor(T e, String column, Object value);

    /**
     * Search for entities based on the provided search term.
     *
     * @param searchTerm the search term
     * @return list of filtered entities
     */
    List<T> search(String searchTerm);
}
