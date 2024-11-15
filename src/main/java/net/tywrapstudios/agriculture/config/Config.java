package net.tywrapstudios.agriculture.config;

import blue.endless.jankson.Comment;
import net.tywrapstudios.agriculture.content.command.AgricultureCommand;

/**
 * This is where the Configuration Options are defined, you can make use of {@link blue.endless.jankson.Comment} to add a // type comment to the file.
 * <br/> Comments are allowed as the file is initialized as .json5 and not plain .json.
 * <br/> This is also considerably nicer for us to manage.
 * <br/>
 * <br/> I'd love to transfer over this system to all our other mods.
 * <br/>
 * <br/> DON'T FORGET TO TRANSFER NEW DETAILS OVER TO {@link AgricultureCommand} and {@code README}
 */
public class Config {
    public String format_version = "AAAA";
    @Comment("Several configurations for in-world features.")
    public WorldConfig world_config = new WorldConfig();
    public static class WorldConfig {
        @Comment("Whether to allow right-clicking to harvest crops.")
        public boolean right_click_harvest = true;
    }
    @Comment("Several configurations for utility features.")
    public UtilConfig util_config = new UtilConfig();
    public static class UtilConfig {
        @Comment("Whether to display debug information in the console.")
        public boolean debug_mode = false;
        @Comment("Whether to suppress all warnings from this mod. NOT RECOMMENDED.")
        public boolean suppress_warns = false;
    }
}
