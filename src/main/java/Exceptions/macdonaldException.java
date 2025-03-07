package Exceptions;

/**
 * Custom exception class for handling specific exceptions in the MacDonald application.
 */
public class macdonaldException extends Exception {
    /**
     * Constructor for macdonaldException.
     * @param message The detail message to be associated with the exception.
     */
    public macdonaldException(String message) {
        super(message);
    }
}