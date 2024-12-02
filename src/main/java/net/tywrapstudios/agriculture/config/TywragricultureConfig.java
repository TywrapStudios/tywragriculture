package net.tywrapstudios.agriculture.config;


import blue.endless.jankson.Comment;
import net.tywrapstudios.blossombridge.api.config.AbstractConfig;

public class TywragricultureConfig extends AbstractConfig {
    @Comment("DO NOT TOUCH THIS. IT IS IMPORTANT INTERNAL STUFF.")
    public String format_version = "1.0";
    @Comment("Several configurations for in-world features.")
    public WorldConfig world_config = new WorldConfig();
    public static class WorldConfig {
        @Comment("Whether to allow right-clicking to harvest crops.")
        public boolean right_click_harvest = true;
        @Comment("The chance for a Pine Cone to grow.")
        public float pine_cone_chance = 60.0f;
        @Comment("The chance for an Apple to grow.")
        public float apple_chance = 110.0f;
    }

    @Override
    public void validate() {
        if (world_config == null) {
            world_config = new WorldConfig();
        }
        super.validate();
    }
}
