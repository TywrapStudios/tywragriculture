package net.tywrapstudios.agriculture.api.config;

/**
 * Should be thrown when the Config file is invalid.
 * @author Tiazzz
 */
public class InvalidConfigFileException extends RuntimeException {
    /**
     * A simple {@link InvalidConfigFileException}.
     * @param message The Message to display in the StackTrace.
     */
    public InvalidConfigFileException(String message) {
        super(message);
    }

    /**
     * A simple {@link InvalidConfigFileException}, but with a {@code cause}.
     * @param message The Message to display in the StackTrace.
     * @param cause The {@link Throwable} cause.
     */
    public InvalidConfigFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
