package net.tywrapstudios.agriculture;

import com.tterrag.registrate.Registrate;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.tywrapstudios.agriculture.config.TywragricultureConfig;
import net.tywrapstudios.agriculture.registry.Registry;
import net.tywrapstudios.agriculture.util.Util;
import net.tywrapstudios.blossombridge.api.config.ConfigManager;
import net.tywrapstudios.blossombridge.api.config.InvalidConfigFormatException;
import net.tywrapstudios.blossombridge.api.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Objects;

public class Tywragriculture implements ModInitializer {
	public static final ConfigManager<TywragricultureConfig> CONFIG_MANAGER =
			new ConfigManager<>(TywragricultureConfig.class, new File(FabricLoader.getInstance().getConfigDir().toFile(),
					"tywragriculture.json5"));

	public static LoggingHandler<TywragricultureConfig> LOGGING;

	public static final String MOD_ID = "agriculture";
	public static String MOD_VERSION;
	public static String CONFIG_FORMAT;

	public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

	@Override
	public void onInitialize() {
		// Init values
		boolean FD_LOADED = FabricLoader.getInstance().isModLoaded("farmersdelight");
		MOD_VERSION = Util.getModVer("agriculture");
		// Config
		CONFIG_FORMAT = "1.0";
		CONFIG_MANAGER.loadConfig();
		TywragricultureConfig config = CONFIG_MANAGER.getConfig();

		LOGGING = new LoggingHandler<>("Tywragriculture", CONFIG_MANAGER.getConfig());

		if (!Objects.equals(config.format_version, CONFIG_FORMAT)) {
			throw new InvalidConfigFormatException("Config version out of Sync. Expected: " + CONFIG_FORMAT + " Actual: " + config.format_version);
		}
		// Mod Init
		Registry.registerAll(REGISTRATE);
		// Init Info Logs
		LOGGING.info("Mod has loaded.");
		LOGGING.info(Util.generateInitPhrase());
	}
}