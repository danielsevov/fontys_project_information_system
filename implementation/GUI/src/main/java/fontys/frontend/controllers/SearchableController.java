package fontys.frontend.controllers;

import businessentitiesapi.Entity;
import businessentitiesapi.Manager;
import businesslogic.BusinessLogicAPI;
import fontys.frontend.SceneManager;
import fontys.frontend.observables.ObservableEntity;
import helpers.RowFactory;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.function.Supplier;

import static helpers.ControllerUtils.entitiesToObservableList;
import static javafx.collections.FXCollections.observableArrayList;

/**
 * Controller base for all controllers that make use of a search field.
 *
 * @param <E> the type for all entities this controller lists
 * @param <T> the observable mirror type for all entities
 */
public abstract class SearchableController<E extends Entity, T extends ObservableEntity>
        extends ControllerBase {

    /**
     * Text field for performing lookup-based searches.
     */
    @FXML
    TextField searchTerm;
    /**
     * Simple {@link TableView} for listing entities.
     */
    @FXML
    TableView<T> table;
    /**
     * List of entities for the table view.
     */
    ObservableList<T> entities = observableArrayList();

    protected SearchableController(Supplier<SceneManager> sceneManager, BusinessLogicAPI businessLogicAPI) {
        super(sceneManager, businessLogicAPI);
    }

    /**
     * The creator function used by {@link #toObservableEntityList(List)}.
     * This is needed for mapping an {@link Entity} to its {@link ObservableEntity} counter-part
     *
     * @return the creator function
     */
    abstract Function<? super E, ? extends T> entityCreator();

    /**
     * The {@link Manager} for this searchable controller.
     *
     * @return the manager
     */
    abstract Manager<E, Integer> getManager();

    /**
     * Injection based initialisation method for this controller base.
     * This method calls {@link #additionalSetup()} internally and also resets all entities
     * via {@link #resetEntities()}.
     *
     * @see javafx.fxml.Initializable#initialize(URL, ResourceBundle)
     */
    @FXML
    public final void initialize() {
        additionalSetup();
        searchTerm.textProperty().addListener(this::search);
        resetEntities();
    }

    /**
     * Update the table view with entities matching the provided search term.
     *
     * @param observableValue the value of the observable
     * @param originalValue   the previous value of the search field
     * @param searchTerm      the new value of the search field
     */
    void search(final ObservableValue<? extends String> observableValue, String originalValue, String searchTerm) {
        entities.clear();
        if (searchTerm.isEmpty()) {
            entities.addAll(toObservableEntityList(getManager().getAll()));
        } else {
            entities.addAll(toObservableEntityList(getManager().search(searchTerm)));
        }
    }

    /**
     * Setup hook for {@link #initialize()}.
     * <br>
     * <b>Note:</b> This is called after all FXML annotated fields have been initialised.
     */
    void additionalSetup() {
    }

    /**
     * Convert a list of entities to a list of observables via {@link #entityCreator()}.
     *
     * @param list the provided entities
     * @return the converted entities
     */
    ObservableList<T> toObservableEntityList(List<? extends E> list) {
        return entitiesToObservableList(list.stream(), entityCreator());
    }

    /**
     * Create a new {@link TableRow}, which spawns a scene with a stage and a window title.
     *
     * @param stageName the stage to spawn
     * @param title     the title of the new stage
     * @return the new table row
     * @see RowFactory#create(String, Callback, String, Runnable)
     */
    Callback<TableView<T>, TableRow<T>> createRowFactory(String stageName, String title) {
        var fac = sceneManager.get().controllerFactory;
        return tv -> RowFactory.create(stageName, fac, title, this::resetEntities);
    }

    /**
     * Create a new {@link TableRow}, which spawns a scene with a stage.
     *
     * @param stageName the stage to spawn
     * @return the new table row
     * @see RowFactory#create(String, Callback, String, Runnable)
     */
    Callback<TableView<T>, TableRow<T>> createRowFactory(String stageName) {
        return createRowFactory(stageName, null);
    }


    /**
     * Reset all entities of this controller base.
     */
    void resetEntities() {
        entities = toObservableEntityList(getManager().getAll());
        table.setItems(entities);
    }
}
