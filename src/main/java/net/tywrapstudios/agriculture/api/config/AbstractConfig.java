package net.tywrapstudios.agriculture.api.config;

import blue.endless.jankson.Comment;
import net.tywrapstudios.agriculture.config.Config;

/**
 * A base Config that should be extended by every main Config class.
 * This is cuz it has some crucial settings that's needed for e.g. Logging.
 * @author Tiazzz
 */
public abstract class AbstractConfig extends ConfigClass {
    /**
     * Comments work like this, they are allowed as the file is json5 and not plain json.
     */
    @Comment("Several configurations for utility features.")
    public Config.UtilConfig util_config = new Config.UtilConfig();
    /**
     * Nested Config.
     */
    public static class UtilConfig {
        /**
         * Any type of value that would work in json is allowed here.
         * <p> E.g. {@code int, String, List<String>}
         */
        @Comment("Whether to display debug information in the console.")
        public boolean debug_mode = true; // Change this back to false on release
        @Comment("Whether to suppress all warnings from this mod. NOT RECOMMENDED.")
        public boolean suppress_warns = false;
    }
}
