package net.tywrapstudios.agriculture.api.config;

/**
 * Should be thrown when the Config Format version is invalid.
 * @author Tiazzz
 */
public class InvalidConfigFormatException extends RuntimeException {
    /**
     * A simple {@link InvalidConfigFormatException}.
     * @param message The Message to display in the StackTrace.
     */
    public InvalidConfigFormatException(String message) {
        super(message);
    }

    /**
     * A simple {@link InvalidConfigFormatException}, but with a {@code cause}.
     * @param message The Message to display in the StackTrace.
     * @param cause The {@link Throwable} cause.
     */
    public InvalidConfigFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
