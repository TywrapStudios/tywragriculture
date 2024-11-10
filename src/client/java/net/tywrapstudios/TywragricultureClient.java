package net.tywrapstudios;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.tywrapstudios.agriculture.content.block.BlockRegistry;

public class TywragricultureClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Cutouts, this is to properly render crops.
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
				BlockRegistry.BLACK_CARROT.get(),
				BlockRegistry.GOLD_CARROT.get(),
				BlockRegistry.PURPLE_CARROT.get(),
				BlockRegistry.TOMATO_PLANT.get()
		);
	}
}