package hospital.exception;

/**
 * An exception that is thrown if a person can't be removed.
 */
public class RemoveException extends Exception {
    private static final Long serialVersionUID = 1L;

    /**
     * Prints an error if the exception is thrown.
     *
     * @param exceptionMessage The errormessage to be shown.
     */
    public RemoveException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
