/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import persistence.DAOProvider;

/**
 * Provides access to the underlying {@link BusinessLogicAPI} layer.
 */
public interface BusinessLogicImplementationProvider extends BusinessLogicAPI {
    /**
     * Provides access to the concrete {@link BusinessLogicAPI} implementation.
     *
     * @param daoProvider the persistence api to pass
     * @return the concrete business logic api implementation
     */
    static BusinessLogicAPI getImplementation(DAOProvider daoProvider) {
        return new BusinessLogicAPIImpl(daoProvider);
    }
}
