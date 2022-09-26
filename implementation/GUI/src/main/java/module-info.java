module GUI_module {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires businessentities_api_module;
    requires transitive businesslogic_module;
    requires java.logging;
    requires nl.homberghp.fxuiscraper;
    requires tornadofx.controls;

    opens fontys.frontend to javafx.fxml;
    opens fontys.frontend.observables to javafx.fxml;
    opens fontys.frontend.controllers to javafx.fxml;
    exports fontys.frontend;
    exports fontys.frontend.observables;
    exports fontys.frontend.controllers;
}
