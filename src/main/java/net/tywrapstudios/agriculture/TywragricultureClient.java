package net.tywrapstudios.agriculture;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.tywrapstudios.agriculture.registry.BlockRegistry;

import static net.tywrapstudios.agriculture.Tywragriculture.REGISTRATE;

public class TywragricultureClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BlockRegistry.GOLD_CARROT);
		for (RegistryEntry<Block> block : REGISTRATE.getAll(Registries.BLOCK.getKey())) {
			// Cutouts, this is to properly render e.g. crops.
			if (block.get() instanceof CropBlock cropBlock) {
				BlockRenderLayerMap.INSTANCE.putBlock(cropBlock, RenderLayer.getCutout());
			}
			// ColorProviders, this is to properly render e.g. leaves.
			ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
				if (world != null && pos != null) {
					return FoliageColors.getSpruceColor();
				}
				return -1;
				}, BlockRegistry.PINE_CONED_SPRUCE_LEAVES.get());
		}
	}
}