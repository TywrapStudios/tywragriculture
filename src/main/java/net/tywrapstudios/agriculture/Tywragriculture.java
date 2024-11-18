package net.tywrapstudios.agriculture;

import com.tterrag.registrate.Registrate;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.tywrapstudios.agriculture.config.ConfigManager;
import net.tywrapstudios.agriculture.registry.Registry;
import net.tywrapstudios.agriculture.util.Util;
import net.tywrapstudios.agriculture.util.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Tywragriculture implements ModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("Tywragriculture");
	private static final Logger DEBUG = LoggerFactory.getLogger("Tywragriculture-DEBUG");
	public static final LoggingHandler LOGGING = new LoggingHandler(LOGGER, DEBUG);
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
		CONFIG_FORMAT = "AAAA";
		ConfigManager.loadConfig();

		if (!Objects.equals(ConfigManager.config.format_version, CONFIG_FORMAT)) {
			LOGGING.error("[Config] Your Config Format Version is out of Sync; we suggest you delete your old config file and re-run Minecraft.");
		}
		// Mod Init
		Registry.registerAll(REGISTRATE);
		// Init Info Logs
		LOGGING.info("Mod has loaded.");
		LOGGING.info(Util.generateInitPhrase());
		LOGGING.debug("Mod version: " + MOD_VERSION);
		LOGGING.debug("Mod ID: " + MOD_ID);
		LOGGING.debug("Fabric Loader version: " + Util.getModVer("fabricloader"));
		LOGGING.debug("Farmer's Delight loaded: " + FD_LOADED);
		if (FD_LOADED) {
			LOGGING.debug(">>version: " + Util.getModVer("farmersdelight"));
		}
	}
}