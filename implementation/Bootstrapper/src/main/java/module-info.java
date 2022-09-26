module bootstrap_module {
    requires businesslogic_module;
    requires java.sql;
    requires mapper_module;
    exports bootstrap;
}
