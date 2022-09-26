module businesslogic_module {
    requires transitive businessentities_api_module;
    requires transitive persistence_module;
    requires nl.fontys.sebivenlo.sebiannotations;
    requires mapper_module;
    requires java.logging;
    exports businesslogic.bulkvalidator;
    exports businesslogic.validation;
    exports businesslogic;
}
