package persistence.memory;


import genericmapper.Mapper;
import persistence.dao.DAO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An in memory implementation of a DAO, typically used for testing.
 *
 * @param <K> key for lookup
 * @param <E> type of entity
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class InMemoryDAO<E extends Serializable, K extends Serializable> implements DAO<E, K>, Serializable {
    final Mapper<E, K> mapper;
    final Class<E> entityType;
    final String storageFileName;

    /**
     * Create a DAO, deriving the name for the on disk storage from the type
     * name.
     *
     * @param entityType managed by this DAO
     */
    public InMemoryDAO(Class<E> entityType) {
        this.entityType = entityType;
        mapper = Mapper.mapperFor(entityType);

        this.storageFileName = entityType.getCanonicalName() + ".ser";
        if (Files.exists(Paths.get(this.storageFileName))) {
            System.out.println("loaded " + storageFileName);
            this.load(this.storageFileName);
        }
        Thread saveThread = new Thread(this::persistToDisk);
        Runtime.getRuntime().addShutdownHook(saveThread);
    }

    private final Map<K, E> storage = new HashMap<>();

    @Override
    public Optional<E> get(K id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<E> getAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<E> save(E t) {

        storage.put(extractId(t), t);
        return Optional.of(t);
    }

    @Override
    public E update(E t) {
        storage.replace(extractId(t), t);
        return t;
    }

    @Override
    public Mapper<E, K> getMapper() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E updateColumn(E e, String column, Object value) {
        return null;
    }

    private void persistToDisk() {
        if (storage.isEmpty()) {
            return; // nothing to do
        }
        try (
                ObjectOutputStream out = new ObjectOutputStream(
                        new FileOutputStream(storageFileName))) {
            out.writeObject(this.storage);
        } catch (IOException ex) {
            Logger.getLogger(InMemoryDAO.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    private void load(String aStorageName) {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(aStorageName))) {
            this.storage.clear();
            Map<K, E> readMap = (Map<K, E>) in.readObject();

            this.storage.putAll(readMap);

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(InMemoryDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Get the storage name.
     *
     * @return the name
     */
    String getStorageFileName() {
        return this.storageFileName;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void deleteEntity(E e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteById(K k) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
