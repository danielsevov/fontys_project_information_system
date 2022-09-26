package businessentitiesapi;

import java.io.Serializable;

/**
 * Marker interface for all business entities within the domain.
 * This serves as bound type for all entities.
 *
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
public interface Entity extends Serializable {
    /**
     * Return the associated ID of an entity.
     *
     * @return the id
     */
    int getId();
}
