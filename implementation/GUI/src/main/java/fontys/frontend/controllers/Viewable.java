package fontys.frontend.controllers;

import javafx.stage.Stage;

/**
 * Interface for all controllers that implement a single-view window.
 */
public interface Viewable {
    /**
     * Brings an entity into focus for a given stage.
     *
     * @param id    the ID of the entity
     * @param stage the stage to use
     */
    void setFocusForId(int id, Stage stage);
}
