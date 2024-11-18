package net.tywrapstudios.agriculture.config;


import blue.endless.jankson.Comment;
import net.tywrapstudios.agriculture.api.config.AbstractConfig;

public class TywragricultureConfig extends AbstractConfig {
    @Comment("DO NOT TOUCH THIS. IT IS IMPORTANT INTERNAL STUFF.")
    public String format_version = "1.0";
    @Comment("Several configurations for in-world features.")
    public WorldConfig world_config = new WorldConfig();
    public static class WorldConfig {
        @Comment("Whether to allow right-clicking to harvest crops.")
        public boolean right_click_harvest = true;
    }

    @Override
    public void validate() {
        if (world_config == null) {
            world_config = new WorldConfig();
        }
        super.validate();
    }
}
