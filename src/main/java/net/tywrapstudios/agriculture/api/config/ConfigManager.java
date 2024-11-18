package net.tywrapstudios.agriculture.api.config;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonGrammar;
import blue.endless.jankson.api.SyntaxError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Manages the Configuration files for a mod.
 * @param <T> The {@link ConfigClass} that the {@link ConfigManager} will manage.
 * @author Tiazzz
 */
public class ConfigManager<T extends ConfigClass> {
    private final Logger LOGGER = LoggerFactory.getLogger(ConfigManager.class);
    private final Jankson jankson;
    private final Class<T> configClass;
    private final File configFile;
    private T configInstance;

    /**
     * Constructor for a {@link ConfigManager}.
     * @param configClass The {@link ConfigClass} that the {@link ConfigManager} will manage.
     * @param configFile The {@link File} that the {@link ConfigManager} will use to save and load the configuration. Note that this HAS to be a JSON5 file.
     */
    public ConfigManager(Class<T> configClass, File configFile) {
        File finalConfigFile;
        this.jankson = Jankson.builder().build();
        this.configClass = configClass;
        if (!configFile.getName().endsWith(".json5")) {
            throw new InvalidConfigFileException("Config file must have a .json5 extension: " + configFile.getName());
        } else {
            finalConfigFile = configFile;
        }
        this.configFile = finalConfigFile;
    }

    /**
     * Loads the configuration from a file. If the file does not exist, creates a default config.
     */
    public void loadConfig() {
        try {
            if (!configFile.exists()) {
                // Create a default configuration if the file doesn't exist
                this.configInstance = configClass.getDeclaredConstructor().newInstance();
                saveConfig();
                return;
            }

            // Read the file and deserialize
            try (FileReader reader = new FileReader(configFile)) {
                this.configInstance = jankson.fromJson(
                        jankson.load(String.valueOf(reader)),
                        configClass
                );

                if (this.configInstance != null) {
                    this.configInstance.validate();
                }
            }

        } catch (IOException | InstantiationException | IllegalAccessException | NoSuchMethodException | SyntaxError | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the current configuration instance to the file.
     */
    public void saveConfig() {
        try (FileWriter writer = new FileWriter(configFile)) {
            String json = jankson.toJson(configInstance).toJson(JsonGrammar.JANKSON);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getConfigJsonAsString() {
        return jankson.toJson(configInstance).toJson().replace("\t", "  ");
    }

    /**
     * Returns the current configuration instance.
     */
    public T getConfig() {
        return configInstance;
    }
}

