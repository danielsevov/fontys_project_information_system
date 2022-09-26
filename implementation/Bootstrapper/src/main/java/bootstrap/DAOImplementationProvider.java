package bootstrap;

import persistence.DAOProvider;

/**
 * Implementation provider for all DAOs.
 */
public interface DAOImplementationProvider {
    /**
     * Get the default implementation of {@link DAOProvider}.
     *
     * @return the dao provider
     */
    static DAOProvider getImplementation() {
        return new DAOProviderImpl();
    }
}
