package net.tywrapstudios.agriculture;

import com.tterrag.registrate.Registrate;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.tywrapstudios.agriculture.content.command.AgricultureCommand;
import net.tywrapstudios.agriculture.registry.BlockRegistry;
import net.tywrapstudios.agriculture.registry.ItemRegistry;
import net.tywrapstudios.agriculture.registry.ItemGroupRegistry;
import net.tywrapstudios.agriculture.config.ConfigManager;
import net.tywrapstudios.agriculture.resources.Fuels;
import net.tywrapstudios.agriculture.util.RandomComments;
import net.tywrapstudios.agriculture.util.logging.LoggingHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tywragriculture implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Tywragriculture");
	public static final Logger DEBUG = LoggerFactory.getLogger("Tywragriculture-DEBUG");
	public static final String MOD_ID = "agriculture";
	public static final String MOD_VERSION = "1.0.0";
	public static final String CONFIG_FORMAT = "a";

	public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

	@Override
	public void onInitialize() {
		boolean FD_LOADED = FabricLoader.getInstance().isModLoaded("farmersdelight");

		ConfigManager.loadConfig();

		ItemRegistry.registerModItems(REGISTRATE);
		BlockRegistry.registerModBlocks(REGISTRATE);
		Fuels.register();
		ItemGroupRegistry.registerItemGroup(REGISTRATE);
		registerCommands();

		REGISTRATE.register();
		LoggingHandlers.debug("General REGISTRATE has been registered.");

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

	public static void registerCommands() {
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, registrationEnvironment) -> AgricultureCommand.register(dispatcher));
		LoggingHandlers.debug("Commands have been registered.");
	}
}