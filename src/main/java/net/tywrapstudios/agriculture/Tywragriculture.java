package net.tywrapstudios.agriculture;

import com.tterrag.registrate.Registrate;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.tywrapstudios.agriculture.content.block.BlockRegistry;
import net.tywrapstudios.agriculture.content.item.ItemRegistry;
import net.tywrapstudios.agriculture.content.item.ModItemGroup;
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

	public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

	@Override
	public void onInitialize() {
		boolean FD_LOADED = FabricLoader.getInstance().isModLoaded("farmersdelight");

		ConfigManager.loadConfig();

		ItemRegistry.registerModItems(REGISTRATE);
		LoggingHandlers.debug("Items have been registered.");
		BlockRegistry.registerModBlocks(REGISTRATE);
		LoggingHandlers.debug("Blocks have been registered.");
		Fuels.register();
		LoggingHandlers.debug("Fuels have been registered.");
		ModItemGroup.registerItemGroup(REGISTRATE);
		LoggingHandlers.debug("Item group has been registered.");

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
}