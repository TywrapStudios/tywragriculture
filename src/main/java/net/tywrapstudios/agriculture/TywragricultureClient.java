package net.tywrapstudios.agriculture;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.tywrapstudios.agriculture.registry.BlockRegistry;
import net.tywrapstudios.agriculture.screen.ScreenHandlers;
import net.tywrapstudios.agriculture.screen.screens.MeatGrinderScreen;

import static net.tywrapstudios.agriculture.Tywragriculture.REGISTRATE;

public class TywragricultureClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Cutouts, this is to properly render e.g. crops.
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BlockRegistry.GOLD_CARROT);
		for (RegistryEntry<Block> block : REGISTRATE.getAll(Registries.BLOCK.getKey())) {
			if (block.get() instanceof CropBlock) {
				BlockRenderLayerMap.INSTANCE.putBlock(block.get(), RenderLayer.getCutout());
			}
		}
	}
}