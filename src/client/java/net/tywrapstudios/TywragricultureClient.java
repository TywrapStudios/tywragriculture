package net.tywrapstudios;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.tywrapstudios.agriculture.registry.BlockRegistry;

import static net.tywrapstudios.agriculture.Tywragriculture.REGISTRATE;

public class TywragricultureClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Cutouts, this is to properly render crops.
		for (RegistryEntry<Block> block : REGISTRATE.getAll(Registries.BLOCK.getKey())) {
			if (block.get() instanceof CropBlock) {
				BlockRenderLayerMap.INSTANCE.putBlock(block.get(), RenderLayer.getCutout());
			}
		}
	}
}