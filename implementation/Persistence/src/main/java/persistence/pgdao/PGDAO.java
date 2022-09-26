package persistence.pgdao;

import businessentitiesapi.Entity;
import genericmapper.FieldPair;
import genericmapper.Mapper;
import persistence.dao.DAO;
import persistence.dao.DAOException;
import persistence.dao.TransactionToken;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.StreamSupport;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * PostgreSQL based DAO.
 *
 * @param <K> key to retrieve entity.
 * @param <E> type of elements for the this data access object.
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class PGDAO<E extends Entity, K extends Serializable> implements DAO<E, K> {

    /**
     * When a transaction is taking place .
     */
    protected PGTransactionToken transactionToken;

    final PGDAOFactory factory;
    final Mapper<E, K> mapper;

    final QueryFactory queryFactory;

    @Override
    public Mapper<E, K> getMapper() {
        return mapper;
    }

    boolean logQuery;
    final AbstractQueryExecutor<E, K> qe;

    /**
     * Create a DAO for a data source and a mapper.
     *
     * @param fac            factory for this type of daos.
     * @param queryTextCache cache to save work
     */
    PGDAO(PGDAOFactory fac, Class<E> entityType,
          QueryFactory queryTextCache) {
        this(fac, entityType, queryTextCache, new QueryExecutor<>(fac, Mapper.mapperFor(entityType)));
    }

    /**
     * Create a dao, accepting the given AbstractQueryExecutoit to make this
     * class testable.
     *
     * @param fac            factory
     * @param entityType     Create a dao, accepting the given
     *                       AbstractQueryExecutor to make this class testable.
     * @param queryTextCache to save work done
     * @param qe
     */
    PGDAO(PGDAOFactory fac, Class<E> entityType, QueryFactory queryTextCache, AbstractQueryExecutor<E, K> qe) {
        factory = fac;
        mapper = Mapper.mapperFor(entityType);
        queryFactory = queryTextCache;
        logQuery = Boolean.getBoolean("logQuery");
        this.qe = qe;
    }

    /**
     * Transaction capable version.
     *
     * @param id of E to get
     * @return optionally the E
     */
    @Override
    public Optional<E> get(K id) {
        if (null != transactionToken) {
            Connection con = transactionToken.getConnection();
            return get(con, id);
        }
        try (Connection con = getConnection()) {
            return get(con, id);
        } catch (SQLException ex) { // cannot test cover this, unless connection breaks mid-air
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    /**
     * Use the connection provided.
     *
     * @param con connection
     * @param id  value
     * @return Optional of E
     */
    Optional<E> get(final Connection con, K id) {
        String sql = queryFactory.getQueryText();
        System.out.println("get   sql = " + sql);
        return qe.doGet(con, sql, id);
    }

    E recordToEntity(final ResultSet rs) throws SQLException {
        Object[] parts = new Object[mapper.getArraySize()];
        for (int i = 0; i < parts.length; i++) {
            Class<?> type = mapper.entityFields().get(i).getType();
            parts[i] = factory.marshallIn(type, rs.getObject(i + 1));
        }
        return mapper.construct(parts);
    }

    @Override
    public void deleteAll(Iterable<E> entities) {
        deleteAll(getConnection(), entities);
    }

    private void deleteAll(Connection con, Iterable<E> entities) {
        List<K> keys = StreamSupport.stream(entities.spliterator(), false)
                .map(mapper.keyExtractor())
                .collect(toList());
        String placeHolders = queryFactory.makePlaceHolders(keys.size());
        String sql = format("delete from %s where %s in (%s)",
                tableName(), mapper.getKeyFieldName(), placeHolders);
        System.out.println("sql = " + sql);
        qe.doDeleteAll(con, sql, keys);
    }

    private void delete(final Connection con, K k) {
        String sql = queryFactory.deleteQueryText();
        System.out.println("sql = " + sql);
        qe.doDelete(con, sql, k);
    }

    @Override
    public E update(E t) {
        if (null != transactionToken) {
            return update(transactionToken.getConnection(), t);
        }
        try (Connection con = getConnection()) {
            return update(con, t);
        } catch (SQLException ex) { // cannot test cover this, unless connection breaks mid-air
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    private E update(final Connection c, E e) {
        String sql = queryFactory.updateQueryText();
        K key = mapper.keyExtractor().apply(e);
        return qe.doUpdate(c, sql, e, key);
    }

    @Override
    public Optional<E> save(E e) {
        String queryText = queryFactory.saveQueryText();
        if (null != transactionToken) {
            return qe.doSave(transactionToken.getConnection(), queryText, e);
        }

        try (Connection c = getConnection()) {
            return qe.doSave(c, queryText, e);
        } catch (SQLException ex) { // cannot test cover this, unless connection breaks mid-air
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public List<E> saveAll(List<E> entities) {
        if (null != transactionToken) {
            return saveAll(transactionToken.getConnection(), entities);
        }

        try (Connection c = getConnection()) {
            return saveAll(c, entities);
        } catch (SQLException ex) { // cannot test cover this, unless connection breaks mid-air
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    private List<E> saveAll(final Connection c, List<E> entities) {
        if (entities.isEmpty()) {
            return Collections.emptyList();
        }
        String sql = queryFactory.saveQueryText();
        List<E> result = new ArrayList<>();
        return qe.doSaveAll(c, sql, entities, result);
    }

    @Override
    public List<E> getAll() {
        if (null != transactionToken) {
            return getAll(transactionToken.getConnection());
        }
        try (Connection c = getConnection()) {
            return getAll(c);
        } catch (SQLException ex) { // cannot test cover this, unless connection breaks mid-air
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    private List<E> getAll(final Connection c) {

        String sql = queryFactory.allQuery();
        return qe.doGetAll(c, sql);
    }

    @Override
    public List<E> getByColumnValues(Object... keyValues) {
        if (null != transactionToken) {
            return getByColumnValues(transactionToken.getConnection(),
                    keyValues);
        }
        try (Connection con = getConnection()) {
            return getByColumnValues(con, keyValues);
        } catch (SQLException ex) { // cannot test cover this, unless connection breaks mid-air
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }

    }

    List<E> getByColumnValues(Connection c, Object... keyValues) {
        List<FieldPair> fp = new ArrayList<>();
        for (int i = 0; i < keyValues.length; i += 2) {
            fp.add(new FieldPair((String) keyValues[i], keyValues[i + 1]));
        }
        String columns = fp.stream().map(FieldPair::key).collect(joining(","));
        String placeholders = queryFactory.makePlaceHolders(fp.size());

        String sql = format("select %s from %s where (%s) =(%s)",
                queryFactory.allColumns(),
                tableName(),
                columns,
                placeholders);
        return qe.doGetByColumnValues(c, sql, fp);
    }

    @Override
    public int lastId() {
        String sql = queryFactory.lastIdQuery();
        return executeIntQuery(sql);
    }

    /**
     * Execute a query that produces an int value such as count.
     *
     * @param sql to execute
     * @return the value found or 0
     */
    final int executeIntQuery(String sql) {
        if (transactionToken != null) {
            return qe.doExecuteIntQuery(transactionToken.getConnection(), sql);
        }
        try (Connection c = getConnection()) {
            return qe.doExecuteIntQuery(c, sql);
        } catch (SQLException ex) { // cannot test cover this, unless connection breaks mid-air
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    /**
     * Execute a query with a key parameter that produces and int.
     *
     * @param sql the query text
     * @param k   the parameter
     * @return the value or 0 if not found
     */
    final int executeIntQuery(String sql, K k) {
        if (transactionToken != null) {
            return qe.doExecuteIntQuery(transactionToken.getConnection(), sql, k);
        }
        try (Connection c = getConnection()) {
            return qe.doExecuteIntQuery(c, sql, k);
        } catch (SQLException ex) { // cannot test cover this, unless connection breaks mid-air
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE,
                    ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public int size() {
        String sql = format("select count(1) as size from %s", tableName());
        return executeIntQuery(sql);
    }

    /**
     * Get the connection this DAO is using. Get the connection to do hand
     * crafted queries for problems that this DAO does not support. The returned
     * connection may already be participating in a transaction when this DAO
     * already is.
     * <p>
     * When using the returned connection it is still good style to use
     * {@link TransactionToken#commit} to commit the transaction. You can obtain
     * the token by invoking {@link DAO#getTransactionToken()}.
     *
     * @return the connection.
     */
    public Connection getConnection() {
        PGTransactionToken tok = getTransactionToken();
        if (tok != null) {
            return tok.getConnection();
        }

        try {
            return factory.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }

    }

    @Override
    public PGTransactionToken getTransactionToken() {
        return transactionToken;
    }

    @Override
    public PGDAO<E, K> setTransactionToken(TransactionToken tok) {
        if (tok instanceof PGTransactionToken) {
            transactionToken = (PGTransactionToken) tok;
        }
        return this;
    }

    @Override
    public PGTransactionToken startTransaction() {
        if (null == transactionToken) {
            transactionToken = new PGTransactionToken(getConnection());
        }
        return transactionToken;
    }

    @Override
    public void close() throws Exception {
        if (transactionToken != null) {
            transactionToken.close();
            transactionToken = null;
        }
    }

    @Override
    public String toString() {
        return format("PGDAO{tableName=%s, idName=%s, mapper=%s}", tableName(), queryFactory.idName(), mapper);
    }

    /**
     * Execute a query producing a list. Use case: a function is part of the
     * query, and the query may in fact produce an update on the underlying
     * database
     *
     * @param queryText sql of prepared statement
     * @param params    positional parameters to the prepared statement
     * @return a list
     */
    @Override
    public List<E> anyQuery(String queryText, Object... params) {
        if (transactionToken != null) {
            return qe.doAnyQuery(transactionToken.getConnection(), queryText, params);
        }
        try (Connection con = getConnection()) {
            return qe.doAnyQuery(con, queryText, params);
        } catch (SQLException ex) { // cannot test cover this, unless connection breaks mid-air
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public void deleteEntity(E e) {
        deleteById(mapper.keyExtractor().apply(e));
    }

    @Override
    public void deleteById(K k) {
        delete(getConnection(), k);
    }

    @Override
    public void dropAll() {
        String queryText = queryFactory.dropallQuery();
        if (transactionToken != null) {
            qe.doAnyVoidQuery(transactionToken.getConnection(), queryText);
            return;
        }

        try (Connection con = getConnection()) {
            qe.doAnyVoidQuery(con, queryText);
        } catch (SQLException ex) { // cannot test cover this, unless connection breaks mid-air
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    @Override
    public E updateColumn(E e, String column, Object value) {
        K key = mapper.keyExtractor().apply(e);
        var statement = format(
                "update %s set %s = ? where %s = ? returning %s",
                tableName(), column, queryFactory.idName(), queryFactory.allColumns()
        );

        if (transactionToken != null) {
            return qe.doUpdateColumn(transactionToken.getConnection(), statement, value, key);
        }

        try (Connection con = getConnection()) {
            return qe.doUpdateColumn(con, statement, value, key);
        } catch (SQLException ex) {
            Logger.getLogger(PGDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }
}
