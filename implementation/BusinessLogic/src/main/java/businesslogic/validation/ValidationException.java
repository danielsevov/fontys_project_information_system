package businesslogic.validation;

/**
 * Exception that is raised during a validation attempt.
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
