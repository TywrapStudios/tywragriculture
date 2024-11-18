package net.tywrapstudios.agriculture.api.logging;

import net.tywrapstudios.agriculture.api.config.AbstractConfig;
import org.slf4j.Logger;

/**
 * A general-purpose Logging Handler compatible with the modular configuration system.
 * This class dynamically fetches configuration values for logging behavior.
 * <p> Note that this should only be used when a Main Config Object (which have to extend {@link AbstractConfig} anyway) object is available.
 * @param <T> The Main Config class of the mod, which is usually already an instance of {@link AbstractConfig}.
 * @author Tiazzz
 */
public class LoggingHandler<T extends AbstractConfig> {
    private final Logger MAIN;
    private final Logger DEBUG;
    private final T config;

    public LoggingHandler(Logger mainLogger, Logger debugLogger, T config) {
        this.MAIN = mainLogger;
        this.DEBUG = debugLogger;
        this.config = config;
    }

    /**
     * Log a String to the info level of the main logger.
     *
     * @param message The Message String to log.
     */
    public void info(String message) {
        MAIN.info(message);
    }

    /**
     * Log a String to the warn level of the main logger.
     *
     * @param message The Message String to log.
     */
    public void warn(String message) {
        if (!config.util_config.suppress_warns) {
            MAIN.warn(message);
        }
    }

    /**
     * Log a String to the error level of the main logger.
     *
     * @param message The Message String to log.
     */
    public void error(String message) {
        if (!config.util_config.suppress_warns) {
            MAIN.error(message);
        }
    }

    /**
     * Log a String to the info and debug level of the debug logger.
     *
     * @param message The Message String to log.
     */
    public void debug(String message) {
        if (config.util_config.debug_mode) {
            DEBUG.info(message);
        }
        literalDebug(message);
    }

    /**
     * Log a String to the debug level of the debug logger.
     *
     * @param message The Message String to log.
     */
    public void literalDebug(String message) {
        if (config.util_config.debug_mode) {
            DEBUG.debug(message);
        }
    }

    /**
     * Alternative version of {@link #literalDebug(String)} that optionally ignores config settings.
     *
     * @param message     The Message String to log.
     * @param ignoreConfig Whether to ignore any Config settings.
     */
    public void literalDebug(String message, boolean ignoreConfig) {
        if (ignoreConfig) {
            DEBUG.debug(message);
        } else {
            literalDebug(message);
        }
    }

    /**
     * Log a String to the warn level of the debug logger.
     *
     * @param message The Message String to log.
     */
    public void debugWarning(String message) {
        if (config.util_config.debug_mode && !config.util_config.suppress_warns) {
            DEBUG.warn(message);
        }
        literalDebug("[WARN] " + message);
    }
}

