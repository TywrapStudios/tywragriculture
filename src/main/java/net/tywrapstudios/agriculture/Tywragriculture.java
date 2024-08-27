package net.tywrapstudios.agriculture;

import net.fabricmc.api.ModInitializer;
import net.tywrapstudios.agriculture.common.block.BlockRegistry;
import net.tywrapstudios.agriculture.common.item.ItemRegistry;
import net.tywrapstudios.agriculture.common.item.ModItemGroup;
import net.tywrapstudios.agriculture.resources.ModBurnableTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tywragriculture implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Tywragriculture");
	public static final String MOD_ID = "agriculture";

	@Override
	public void onInitialize() {

		ItemRegistry.registerModItems();
		BlockRegistry.registerModBlocks();
		ModItemGroup.registerItemGroup();
		ModBurnableTypes.register();

		LOGGER.info("Mod has loaded. Fawming Fwunny UwU.");
	}
}