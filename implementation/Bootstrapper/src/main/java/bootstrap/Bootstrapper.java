package bootstrap;

import businesslogic.BusinessLogicAPI;
import businesslogic.BusinessLogicImplementationProvider;

/**
 * Bootstrapper module for the assembler entry point.
 */
public class Bootstrapper {
    /**
     * Initialise the {@link BusinessLogicAPI} layer with the default
     * {@link DAOImplementationProvider}.
     *
     * @return the initialised business logic layer
     */
    public static BusinessLogicAPI initialise() {
        var provider = DAOImplementationProvider.getImplementation();
        return BusinessLogicImplementationProvider.getImplementation(provider);
    }
}
