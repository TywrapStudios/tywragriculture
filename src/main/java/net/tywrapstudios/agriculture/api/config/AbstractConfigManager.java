package net.tywrapstudios.agriculture.api.config;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonObject;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.tywrapstudios.agriculture.util.logging.LoggingHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;

/**
 * I attempted to make a modular ConfigManager class, that can be extended.
 * <p>Sadly my knowledge on Java isn't that good, so I'll have to look further into this.
 * @author Tiazzz
 */
public abstract class AbstractConfigManager {
    private static final Jankson jankson = Jankson.builder().build();
    private static File configFile = new File(FabricLoader.getInstance().getConfigDir().toFile(), getConfigFileName());
    private static String FILE_NAME = "ts_api.json5";
    private static LoggingHandler LOGGING;
    public static ConfigClass config;

    public AbstractConfigManager(String fileName, LoggingHandler loggingHandler) {
        FILE_NAME = fileName;
        LOGGING = loggingHandler;
        configFile = new File(FabricLoader.getInstance().getConfigDir().toFile(), fileName);
    }

    public static File getConfigFile() {
        return configFile;
    }

    public static String getConfigFileName() {
        return FILE_NAME;
    }

    public static ConfigClass getConfig() {
        return config;
    }

    public static String getConfigJsonAsString() {
        try {
            JsonObject jsonObject = jankson.load(getConfigFile());
            return jsonObject.toJson(false, true).replace("\t", "  ");
        } catch (Exception e) {
            e.printStackTrace();
            return "An exception occurred while getting the Config JsonElement, view the logs for more details.";
        }
    }

    public static <T extends ConfigClass> void loadConfig(Class<T> configClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (getConfigFile().exists()) {
            try {
                config = jankson.fromJson(jankson.load(getConfigFile()), configClass);
                LOGGING.info("[Config] Loaded configuration file.");
            } catch (Exception e) {
                LOGGING.error("[Config] Error loading configuration file; using default values.");
                e.printStackTrace();
                config = configClass.getDeclaredConstructor().newInstance();
            }
        } else {
            config = configClass.getDeclaredConstructor().newInstance();
            LOGGING.info("[Config] No configuration file found, created new one.");
            LOGGING.info(String.format("[Config] `.../config/%s`.", getConfigFileName()));
            saveConfig();
        }
    }

    public static <T extends ConfigClass> void reloadConfig(CommandContext ctx, Class<T> configClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ServerCommandSource source = (ServerCommandSource) ctx.getSource();
        if (getConfigFile().exists()) {
            try {
                config = jankson.fromJson(jankson.load(getConfigFile()), configClass);
                LOGGING.info("[Config] Reloaded configuration file.");
                source.sendFeedback(() -> Text.literal("[Config] Reloaded configuration file.").formatted(Formatting.GRAY), true);
            } catch (Exception e) {
                LOGGING.error("[Config] Error loading configuration file; using default values.");
                e.printStackTrace();
                source.sendFeedback(() -> Text.literal("[Config] Error loading configuration file; using default values.").formatted(Formatting.RED), true);
                config = configClass.getDeclaredConstructor().newInstance();
            }
        } else {
            config = configClass.getDeclaredConstructor().newInstance();
            LOGGING.info("[Config] No configuration file found, created new one.");
            LOGGING.info(String.format("[Config] `.../config/%s`.", getConfigFileName()));
            LOGGING.warn("[Config] Note that this generally shouldn't be happening, a file should be made and available before your run!");
            source.sendFeedback(() -> Text.literal(String.format("""
                    [Config] No configuration file found, created new one.
                    [Config] `.../config/%s`.""", getConfigFileName())).formatted(Formatting.GRAY), true);
            source.sendFeedback(() -> Text.literal("[Config] Note that this generally shouldn't be happening, a file should be made and available before your run!").formatted(Formatting.GOLD), true);
            saveConfig();
        }
    }

    public static void saveConfig() {
        try (FileOutputStream stream = new FileOutputStream(getConfigFile())) {
            JsonElement json = jankson.toJson(config);
            stream.write(json.toJson(true, true).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
