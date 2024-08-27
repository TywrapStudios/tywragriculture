package net.tywrapstudios;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.tywrapstudios.agriculture.common.block.BlockRegistry;

public class TywragricultureClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// For the cutouts.
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
				BlockRegistry.BLACK_CARROT,
				BlockRegistry.GOLD_CARROT,
				BlockRegistry.PURPLE_CARROT,
				BlockRegistry.TOMATO_PLANT
		);
	}
}