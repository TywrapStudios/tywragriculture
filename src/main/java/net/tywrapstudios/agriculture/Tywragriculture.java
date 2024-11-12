package net.tywrapstudios.agriculture;

import com.tterrag.registrate.Registrate;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.tywrapstudios.agriculture.config.ConfigManager;
import net.tywrapstudios.agriculture.registry.Registry;
import net.tywrapstudios.agriculture.util.RandomComments;
import net.tywrapstudios.agriculture.util.logging.LoggingHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Tywragriculture implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Tywragriculture");
	public static final Logger DEBUG = LoggerFactory.getLogger("Tywragriculture-DEBUG");
	public static final String MOD_ID = "agriculture";
	public static String MOD_VERSION;
	public static String CONFIG_FORMAT;

	public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

	@Override
	public void onInitialize() {
		// Init values
		boolean FD_LOADED = FabricLoader.getInstance().isModLoaded("farmersdelight");
		MOD_VERSION = FabricLoader.getInstance().getModContainer("agriculture").get().getMetadata().getVersion().getFriendlyString();
		// Config
		CONFIG_FORMAT = "AAAA";
		ConfigManager.loadConfig();
		if (!Objects.equals(ConfigManager.config.format_version, CONFIG_FORMAT)) {
			LoggingHandlers.error("[Config] Your Config Format Version is out of Sync; we suggest you delete your old config file and re-run Minecraft.");
		}
		// Mod Init
		Registry.registerAll(REGISTRATE);
		// Init Info Logs
		LoggingHandlers.info("Mod has loaded.");
		LoggingHandlers.info(RandomComments.generateInitComment());
		LoggingHandlers.debug("Mod version: " + MOD_VERSION);
		LoggingHandlers.debug("Mod ID: " + MOD_ID);
		LoggingHandlers.debug("Fabric Loader version: " + FabricLoader.getInstance().getModContainer("fabricloader").get().getMetadata().getVersion().getFriendlyString());
		LoggingHandlers.debug("Farmer's Delight loaded: " + FD_LOADED);
		if (FD_LOADED) {
			LoggingHandlers.debug(">>version: " + FabricLoader.getInstance().getModContainer("farmersdelight").get().getMetadata().getVersion().getFriendlyString());
		}
	}
}