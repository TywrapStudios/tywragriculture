package net.tywrapstudios.agriculture.config;

import blue.endless.jankson.Comment;

public class Config {
    @Comment("Several configurations for utility features.")
    public UtilConfig util_config = new UtilConfig();
    public static class UtilConfig {
        @Comment("Whether to display debug information in the console.")
        public boolean debug_mode = true;
        @Comment("Whether to suppress all warnings from this mod. NOT RECOMMENDED.")
        public boolean suppress_warns = false;
    }
    @Comment("Several configurations for in-world features.")
    public WorldConfig world_config = new WorldConfig();
    public static class WorldConfig {
        @Comment("Whether to allow golden carrots to be grown.")
        public boolean allow_golden_carrot_crops = true;
        @Comment("Whether to allow right-clicking to harvest crops.")
        public boolean right_click_harvest = true;
    }
}
