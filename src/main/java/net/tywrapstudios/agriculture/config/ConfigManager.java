package net.tywrapstudios.agriculture.config;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.api.SyntaxError;
import net.fabricmc.loader.api.FabricLoader;
import net.tywrapstudios.agriculture.util.logging.LoggingHandlers;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConfigManager {
    /**
     * The manager makes/edits the config file, and reads (loads) from it as well.
     */
    private static final Jankson jankson = Jankson.builder().build();
    private static final File configFile = new File(FabricLoader.getInstance().getConfigDir().toFile(), "tywragriculture.json5");
    public static Config config;

    public static void loadConfig() {
        if (configFile.exists()) {
            try {
                config = jankson.fromJson(jankson.load(configFile), Config.class);
            } catch (IOException | SyntaxError e) {
                e.printStackTrace();
                LoggingHandlers.error("[Config] Error loading configuration file; using default values.");
                config = new Config();
            }
        } else {
            config = new Config();
            saveConfig();
        }
    }

    public static void saveConfig() {
        try (FileOutputStream stream = new FileOutputStream(configFile)) {
            JsonElement json = jankson.toJson(config);
            stream.write(json.toJson(true, true).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
