package businesslogic;

import businessentitiesapi.Entity;
import businessentitiesapi.Manager;
import persistence.dao.DAO;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Abstract base class for all {@link Manager} implementations.
 * This manager base provides delegated access to the {@link DAO} layer.
 * All entities are cached to reduce the query overhead.
 *
 * @param <T> the bound {@link Entity} type
 */
public abstract class ManagerImplBase<T extends Entity> implements Manager<T, Integer> {
    private DAO<T, Integer> dao;
    private Map<Integer, T> entityCache;

    /**
     * Sets the underlying {@link DAO} for this {@link Entity} type.
     *
     * @param dao the storage service
     */
    public void setDaoProvider(DAO<T, Integer> dao) {
        this.dao = dao;
    }

    /**
     * Sets the underlying internal cache (for testing).
     * This should generally not be invoked directly as it can mess up the cache state.
     *
     * @param entityCache the new entity cache
     */
    public void setEntityCache(Map<Integer, T> entityCache) {
        this.entityCache = entityCache;
    }

    protected ManagerImplBase() {
        this(null, new ConcurrentHashMap<>());
    }

    private ManagerImplBase(DAO<T, Integer> dao, Map<Integer, T> cache) {
        this.dao = dao;
        this.entityCache = cache;
    }

    @Override
    public Optional<T> get(Integer id) {
        if (entityCache.containsKey(id)) {
            return Optional.of(entityCache.get(id));
        }
        var got = dao.get(id);
        got.ifPresent(o -> entityCache.put(o.getId(), o));
        return got;
    }

    /**
     * {@inheritDoc}
     * <br><br>
     * Note: This operation does <b>not</b> rely on the internal cache.
     * However, fetched objects are still added to the global cache.
     *
     * @param keyValues even sized parameter list like
     *                  ("id",1).
     * @return the collection of entities matching key value pairs.
     */
    @Override
    public List<T> getByColumnValues(Object... keyValues) {
        var got = dao.getByColumnValues(keyValues);
        got.forEach(o -> entityCache.put(o.getId(), o));
        return got;
    }

    @Override
    public List<T> getAll() {
        if (entityCache.isEmpty()) {
            var objects = dao.getAll();
            objects.forEach(o -> entityCache.put(o.getId(), o));
        }

        return new ArrayList<>(entityCache.values());
    }


    @Override
    public Optional<T> save(T t) {
        var saved = dao.save(t);
        saved.ifPresent(o -> entityCache.put(o.getId(), o));
        return saved;
    }

    @Override
    public T update(T t) {
        var updated = dao.update(t);
        entityCache.put(updated.getId(), updated);
        return updated;
    }

    @Override
    public void deleteEntity(T t) {
        dao.deleteEntity(t);
        entityCache.remove(t.getId());
    }

    @Override
    public void deleteById(Integer integer) {
        dao.deleteById(integer);
        entityCache.remove(integer);
    }


    @Override
    public int size() {
        return dao.size();
    }

    @Override
    public int lastId() {
        return dao.lastId();
    }


    @Override
    public List<? extends T> saveAll(List<T> entities) {
        var allSaved = dao.saveAll(entities);
        allSaved.forEach(o -> entityCache.put(o.getId(), o));
        return allSaved;
    }

    @SafeVarargs
    @Override
    public final List<? extends T> saveAll(T... entities) {
        var allSaved = dao.saveAll(entities);
        allSaved.forEach(o -> entityCache.put(o.getId(), o));
        return allSaved;
    }

    @Override
    public void deleteAll(Iterable<T> entities) {
        dao.deleteAll(entities);
        entities.forEach(f -> entityCache.remove(f.getId()));
    }

    @SafeVarargs
    @Override
    public final void deleteAll(T... entities) {
        dao.deleteAll(entities);
        Arrays.stream(entities).forEach(f -> entityCache.remove(f.getId()));
    }

    @Override
    public List<T> anyQuery(String queryText, Object... params) {
        var returned = dao.anyQuery(queryText, params);
        returned.forEach(o -> entityCache.put(o.getId(), o));
        return returned;
    }

    @Override
    public void dropAll() {
        dao.dropAll();
    }

    @Override
    public List<T> getAllMatching(Predicate<T> predicate) {
        return getAll().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public T updateColumnFor(T e, String column, Object value) {
        var updated = dao.updateColumn(e, column, value);
        entityCache.put(updated.getId(), updated);
        return updated;
    }

    /**
     * Search for possible matches in a source string with a given search term.
     * This is useful for managers that need to provide access to search functionalities.
     *
     * @param source     the source string
     * @param searchTerm the search term
     * @return whether the search term was found in the source string
     */
    boolean findMatch(String source, String searchTerm) {
        var split = searchTerm.toLowerCase().split(" ");
        var str = source.toLowerCase();
        return Arrays.stream(split).anyMatch(str::contains);
    }

    /**
     * Return all search predicates of this entity.
     * These are usually used in combination with {@link Manager#search(String)}.
     *
     * @return search predicates of this entity
     */
    abstract List<BiPredicate<T, String>> getSearchPredicates();

    @Override
    public List<T> search(String searchTerm) {
        var predicate = getSearchPredicates().stream().reduce(BiPredicate::or).orElse((a, b) -> true);
        return getAllMatching(f -> predicate.test(f, searchTerm));
    }
}
