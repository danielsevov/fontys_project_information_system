module persistence_module {
    requires transitive businessentities_api_module;
    requires mapper_module;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires java.naming;
    exports persistence;
    exports persistence.dao;
    exports persistence.pgdao;
    exports persistence.memory;
}
