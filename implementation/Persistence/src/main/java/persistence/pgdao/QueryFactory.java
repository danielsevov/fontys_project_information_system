package persistence.pgdao;

import genericmapper.Mapper;
import nl.fontys.sebivenlo.sebiannotations.TableName;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

/**
 * Class to compute and cache query strings.
 * <p>
 * The queries are to be computed from the meta data on the java entity type in
 * the mapper. After the first invocation of on of the non private method, the
 * same should be returned on each call.
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class QueryFactory {

    final Mapper<?, ?> mapper;

    ConcurrentMap<String, String> queryTextCache = new ConcurrentHashMap<>();

    public QueryFactory(Mapper<?, ?> mapper) {
        this.mapper = mapper;
    }

    /**
     * Returned a value from the cache.
     *
     * @return formatted string of all columns
     */
    String allColumns() {
        return queryTextCache.computeIfAbsent("allColumns", x -> computeAllColumns());
    }

    /**
     * Compute the value of all columns joins with a comma.
     *
     * @return text
     */
    private String computeAllColumns() {
        return String.join(",", getAllFields());
    }

    /**
     * The name of the key column.
     *
     * @return the name of the key column
     */
    String idName() {
        return queryTextCache.computeIfAbsent("idName", x -> mapper.getKeyFieldName());
    }

    String getQueryText() {
        return queryTextCache.computeIfAbsent("selectsingle", x -> computeGetQueryText());
    }

    /**
     * Compute the select query.
     *
     * @return the text
     */
    private String computeGetQueryText() {
        var allColumns = getAllFields();
        var joinedColumns = String.join(",", allColumns);
        return format("select %1$s from %2$s where %3$s=?", joinedColumns, tableName(), mapper.getKeyFieldName());
    }

    /**
     * Get the table name fom the @TableName annotation.
     *
     * @return the table name or a synthesised name using simple plural.
     */
    String tableName() {
        Class<?> entityType = mapper.getEntityType();
        var annotation = entityType.getAnnotation(TableName.class);
        return annotation != null ? annotation.value() : entityType.getSimpleName().toLowerCase() + 's';
    }

    /**
     * Get the delete query form the cache.
     *
     * @return the text
     */
    String deleteQueryText() {
        return queryTextCache.computeIfAbsent("delete", x -> computeDeleteQueryText());
    }

    private String computeDeleteQueryText() {
        return format("delete from %1$s where %2$s=?", tableName(), mapper.getKeyFieldName());
    }

    String updateQueryText() {
        return queryTextCache.computeIfAbsent("update", x -> computeUpdateQueryText());
    }

    private String computeUpdateQueryText() {
        List<String> columnNames = getAllFields();
        columnNames.remove(idName());
        String columns = String.join(",", columnNames);
        String placeholders = makePlaceHolders(columnNames.size());
        return format(
                "update %1$s set (%2$s)=(%3$s) where (%4$s)=(?) returning  %5$s",
                tableName(),
                columns,
                placeholders,
                mapper.getKeyFieldName(),
                computeAllColumns());

    }

    /**
     * Turn helloThere into hello_there.
     *
     * @param string the string to transform
     * @return transformed string in snake case
     */
    private String camelCaseToSnakeCase(String string) {
        var name = string.replaceAll("(.)([A-Z][a-z]+)", "$1_$2");
        return name.replaceAll("([a-z0-9])([A-Z])", "$1_$2").toLowerCase();
    }

    private List<String> getAllFields() {
        return mapper.entityFields().stream().map(field -> camelCaseToSnakeCase(field.getName())).collect(toList());
    }

    final String saveQueryText() {
        return queryTextCache.computeIfAbsent("save", x -> computeSaveQueryText());
    }

    final String makePlaceHolders(final int count) {
        String[] qm = new String[count];
        Arrays.fill(qm, "?");
        return String.join(",", qm);
    }


    private List<String> getAllNonGeneratedFields() {
        var fields = getAllFields();
        fields.removeAll(mapper.generatedFieldNames());
        return fields;
    }

    private String computeSaveQueryText() {
        var fields = getAllNonGeneratedFields();
        var joinedColumns = String.join(",", fields);
        var placeholders = makePlaceHolders(fields.size());
        var all = allColumns();
        return format("insert into %1$s (%2$s) values (%3$s) returning %4$s",
                tableName(), joinedColumns, placeholders, all);
    }

    String allQuery() {
        return queryTextCache.computeIfAbsent("all", x -> computeAllQueryText());
    }

    private String computeAllQueryText() {
        return format("select %s from %s", allColumns(), tableName());
    }

    String lastIdQuery() {
        return queryTextCache.computeIfAbsent("lastIdQuery", x -> computeLastIdQuery());
    }

    private String computeLastIdQuery() {
        return format("select max(%1$s) as lastid from %2$s", mapper.getKeyFieldName(), tableName());
    }

    String dropallQuery() {
        return queryTextCache.computeIfAbsent("dropAllQuery", x -> computeDropallQuery());

    }

    String computeDropallQuery() {
        return "truncate " + tableName() + " restart identity cascade";
    }
}
