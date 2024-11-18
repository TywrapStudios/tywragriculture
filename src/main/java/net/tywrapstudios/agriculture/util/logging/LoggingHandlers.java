package net.tywrapstudios.agriculture.util.logging;

import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.config.ConfigManager;
import net.tywrapstudios.agriculture.config.Config;
import org.slf4j.Logger;

public class LoggingHandlers {
    static final Logger logger = Tywragriculture.LOGGER;
    static final Logger debug = Tywragriculture.DEBUG;

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        Config config = ConfigManager.config;
        if (!config.util_config.suppress_warns) {
            logger.warn(message);
        }
    }

    public static void error(String message) {
        Config config = ConfigManager.config;
        if (!config.util_config.suppress_warns) {
            logger.error(message);
        }
    }

    public static void debug(String message) {
        Config config = ConfigManager.config;
        if (config.util_config.debug_mode) {
            debug.info(message);
        }
        literalDebug(message);
    }

    public static void literalDebug(String message) {
        Config config = ConfigManager.config;
        if (config.util_config.debug_mode) {
            debug.debug(message);
        }
    }

    public static void literalDebug(String message, boolean ignoreConfig) {
        if (ignoreConfig) {
            debug.debug(message);
        } else {
            literalDebug(message);
        }
    }

    public static void debugWarning(String message) {
        Config config = ConfigManager.config;
        if (config.util_config.debug_mode && !config.util_config.suppress_warns) {
            debug.warn(message);
        }
        literalDebug("[WARN] " + message);
    }
}
