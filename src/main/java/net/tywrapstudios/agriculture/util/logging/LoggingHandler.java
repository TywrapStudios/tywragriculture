package net.tywrapstudios.agriculture.util.logging;

import net.tywrapstudios.agriculture.config.ConfigManager;
import net.tywrapstudios.agriculture.config.Config;
import org.slf4j.Logger;

/**
 * A class I'd like to turn into a feature of the general API I'm going to be developing for our mods.
 * <p>
 * This class adds a few general use logging implementations, it could be used the following way:
 * <p> {@code private static final Logger LOGGER = LoggerFactory.getLogger("Tywragriculture");
 * 	private static final Logger DEBUG = LoggerFactory.getLogger("Tywragriculture-DEBUG");
 * 	public static final LoggingHandler LOGGING = new LoggingHandler(LOGGER, DEBUG);}
 * 	<p> to then access the logging handlers using e.g. {@code LOGGING.info("Hello world!)}
 * @author Tiazzz
 */
public class LoggingHandler {
    private static Logger MAIN;
    private static Logger DEBUG;

    public LoggingHandler(Logger mainLogger, Logger debugLogger) {
        MAIN = mainLogger;
        DEBUG = debugLogger;
    }

    /**
     * Log a String to the info level of the MAIN logger.
     * @param message The Message String to log.
     */
    public void info(String message) {
        MAIN.info(message);
    }

    /**
     * Log a String to the warn level of the MAIN logger.
     * @param message The Message String to log.
     */
    public void warn(String message) {
        Config config = ConfigManager.config;
        if (!config.util_config.suppress_warns) {
            MAIN.warn(message);
        }
    }

    /**
     * Log a String to the error level of the MAIN logger.
     * @param message The Message String to log.
     */
    public void error(String message) {
        Config config = ConfigManager.config;
        if (!config.util_config.suppress_warns) {
            MAIN.error(message);
        }
    }

    /**
     * Log a String to the info and debug level of the DEBUG Logger.
     * @param message The Message String to log.
     */
    public void debug(String message) {
        Config config = ConfigManager.config;
        if (config.util_config.debug_mode) {
            DEBUG.info(message);
        }
        literalDebug(message);
    }

    /**
     * Log a String to the debug level of the DEBUG logger.
     * @param message The Message String to log.
     */
    public void literalDebug(String message) {
        Config config = ConfigManager.config;
        if (config.util_config.debug_mode) {
            DEBUG.debug(message);
        }
    }

    /**
     * Alternative Version of {@link #literalDebug(String message)}
     * @param message The Message String to log.
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
     * Log a String to the warn level of the DEBUG logger.
     * @param message The Message String to log.
     */
    public void debugWarning(String message) {
        Config config = ConfigManager.config;
        if (config.util_config.debug_mode && !config.util_config.suppress_warns) {
            DEBUG.warn(message);
        }
        literalDebug("[WARN] " + message);
    }

    /*
     * The reason as to why there is no debugError(String message) is because you should always log errors regardless of any Configs.
     */
}
