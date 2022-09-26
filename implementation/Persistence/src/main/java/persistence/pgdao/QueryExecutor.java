package persistence.pgdao;

import businessentitiesapi.Entity;
import genericmapper.FieldPair;
import genericmapper.ForeignKey;
import genericmapper.Mapper;
import org.postgresql.util.PGobject;
import persistence.dao.DAOException;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.String.format;

/**
 * Do the actual operations using the the database connection provided in each
 * method.
 * <p>
 * This is the lowest layer in this PG Dao service.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
class QueryExecutor<E extends Serializable, K extends Serializable> extends AbstractQueryExecutor<E, K> {

    final PGDAOFactory factory;
    final Mapper<E, K> mapper;

    public QueryExecutor(PGDAOFactory factory, Mapper<E, K> mapper) {
        this.factory = factory;
        this.mapper = mapper;
    }

    @Override
    public Optional<E> doGet(final Connection con, String sql, K id) throws
            DAOException {
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setObject(1, id);
            try (
                    ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return Optional.ofNullable(recordToEntity(rs));
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    void doDeleteAll(Connection con, String sql, List<K> keys) throws
            DAOException {
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            int col = 1;
            for (K key : keys) {
                pst.setObject(col++, key);
            }
            boolean ignored = pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName())
                    .log(Level.SEVERE, ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    void doDelete(final Connection con, String sql, K k) throws DAOException {
        try (
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setObject(1, k);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE, null,
                    ex);
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    /**
     * (Pseudo) recursively resolve all foreign key relations for a DAO object.
     *
     * @param clazz    the type of the foreign primary key
     * @param keyValue the id value of the foreign key
     * @return the constructed object
     * @throws SQLException thrown when foreign column could not be resolved properly
     */
    private Object constructFromForeignKey(Class<? extends Entity> clazz, Serializable keyValue) throws SQLException {
        // This is quite evil.
        var daoMapper = factory.getMapperFor(clazz).orElseThrow();
        var foreignDao = factory.createDao(daoMapper.getEntityType());
        var fetchedObject = foreignDao.get(keyValue);
        if (fetchedObject.isEmpty()) {
            var fmt = format("Could not resolve foreign key with ID %s and class type %s",
                    keyValue, clazz.getSimpleName());
            throw new SQLException(fmt);
        }
        return fetchedObject.get();
    }

    @Override
    @SuppressWarnings("unchecked")
    E recordToEntity(final ResultSet rs) throws SQLException {
        Object[] parts = new Object[mapper.getArraySize()];
        for (int i = 0; i < parts.length; i++) {
            var field = mapper.entityFields().get(i);
            var fieldType = field.getType();
            var object = rs.getObject(i + 1);
            // Check if we're dealing with a foreign key.
            if (field.isAnnotationPresent(ForeignKey.class) && Entity.class.isAssignableFrom(fieldType)) {
                // PG objects are guaranteed to be serializable, this cast should be safe.
                parts[i] = constructFromForeignKey((Class<? extends Entity>) fieldType, (Serializable) object);
                continue;
            }
            parts[i] = factory.marshallIn(fieldType, object);
        }
        return mapper.construct(parts);
    }

    @Override
    E doUpdate(final Connection c, String sql, E e, K key) throws DAOException {
        try (PreparedStatement pst = c.prepareStatement(sql)) {
            Object[] parts = mapper.deconstruct(e);
            var list = Arrays.asList(parts).subList(1, parts.length);
            int j = 1;

            // all fields
            for (Object part : list) {
                if (part == null) {
                    pst.setObject(j++, null);
                    continue;
                }
                Object po = factory.marshallOut(part);
                if (po instanceof PGobject) {
                    pst.setObject(j++, part, Types.OTHER);
                } else {
                    pst.setObject(j++, part);
                }
            }
            pst.setObject(j, key);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return recordToEntity(rs);
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE, null,
                    ex);
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    List<E> doGetAll(final Connection c, String sql) throws DAOException {
        try (
                PreparedStatement pst = c.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {
            List<E> result = new ArrayList<>();
            while (rs.next()) {
                E e = recordToEntity(rs);
                result.add(e);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    List<E> doGetByColumnValues(Connection c, String sql, List<FieldPair> fp)
            throws DAOException {
        try (PreparedStatement pst = c.prepareStatement(sql)) {
            int j = 1;
            for (FieldPair fieldPair : fp) {

                Object value = fieldPair.value();
                if (fieldPair.value() == null) {
                    pst.setObject(j++, null);
                    continue;
                }
                Object po = factory.marshallOut(value);
                if (po instanceof PGobject) {
                    pst.setObject(j++, value, java.sql.Types.OTHER);
                } else {
                    pst.setObject(j++, value);
                }
            }
            // receive result
            try (ResultSet rs = pst.executeQuery()) {
                List<E> result = new ArrayList<>();
                while (rs.next()) {
                    // note columns start at 1
                    E e = recordToEntity(rs);
                    result.add(e);
                }
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    int doExecuteIntQuery(final Connection c, String sql, K k) throws
            DAOException {
        try (
                PreparedStatement pst = c.prepareStatement(sql)) {
            pst.setObject(1, k);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    return 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName())
                    .log(Level.SEVERE, ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    int doExecuteIntQuery(final Connection c, String sql) {
        try (
                PreparedStatement pst = c.prepareStatement(sql)) {
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    return 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    /**
     * Execute a query that produces a List of E.
     *
     * @param con       connection to use
     * @param queryText sql text
     * @param params    positional parameters in the query
     * @return list of e, produced by the query.
     */
    @Override
    List<E> doAnyQuery(Connection con, String queryText, Object... params) {
        try (PreparedStatement pst = con.prepareStatement(queryText)) {
            int j = 1;
            for (Object param : params) {
                pst.setObject(j++, param);
            }
            try (ResultSet rs = pst.executeQuery()) {
                List<E> result = new ArrayList<>();
                while (rs.next()) {
                    // note columns start at 1
                    E e = recordToEntity(rs);
                    result.add(e);
                }
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    Optional<E> doSave(final Connection c, String queryText, E t) {
        try (PreparedStatement pst = populateSaveStatement(c, queryText, t)) {

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(recordToEntity(rs));
                } else {
                    // cannot cover without serious jumping through loops,
                    // so we will not bother.
                    return Optional.empty();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    PreparedStatement populateSaveStatement(Connection c, String queryText, E e) throws SQLException {
        List<FieldPair> remainingFields = mapper.nonGeneratedFieldPairs(e);
        PreparedStatement pst = c.prepareStatement(queryText);
        return fillPreparedStatement(pst, remainingFields);
    }

    @Override
    List<E> doSaveAll(final Connection c, String sql, List<E> entities, List<E> result) throws DAOException {
        try (PreparedStatement pst = c.prepareStatement(sql)) {
            for (E e : entities) {

                fillPreparedStatement(pst, mapper.nonGeneratedFieldPairs(e));

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        result.add(recordToEntity(rs));
                    }
                }
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    PreparedStatement
    fillPreparedStatement(final PreparedStatement pst,
                          List<FieldPair> fields)
            throws SQLException {
        int j = 1;
        for (FieldPair fp : fields) {
            Object value = fp.value();
            if (value == null) {
                pst.setObject(j++, value);
                continue;
            }
            Object po = factory.marshallOut(value);
            if (po instanceof PGobject) {
                pst.setObject(j++, value, java.sql.Types.OTHER);
            } else {
                pst.setObject(j++, value);
            }
        }
        return pst;
    }

    /**
     * Execute a query that produces no result.
     *
     * @param con       connection to use
     * @param queryText sql text
     * @param params    positional parameters in the query
     */
    @Override
    void doAnyVoidQuery(Connection con, String queryText, Object... params) {
        try (PreparedStatement pst = con.prepareStatement(queryText)) {
            int j = 1;
            for (Object param : params) {
                pst.setObject(j++, param);
            }
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    E doUpdateColumn(Connection con, String queryText, Object value, K key) {
        try (PreparedStatement pst = con.prepareStatement(queryText)) {
            pst.setObject(1, factory.marshallOut(value));
            pst.setObject(2, key);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return recordToEntity(rs);
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }
}
