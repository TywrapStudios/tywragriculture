package net.tywrapstudios.agriculture.util.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.tywrapstudios.agriculture.common.item.ItemRegistry;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
//      blockStateModelGenerator.registerSimpleCubeAll(BLOCK);






    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
         itemModelGenerator.register(ItemRegistry.BRIQUETTE, Models.GENERATED);
         itemModelGenerator.register(ItemRegistry.BLACK_CARROT, Models.GENERATED);
         itemModelGenerator.register(ItemRegistry.CABBAGES, Models.GENERATED);
         itemModelGenerator.register(ItemRegistry.CAKE_SLICE, Models.GENERATED);
         itemModelGenerator.register(ItemRegistry.PINEAPPLES, Models.GENERATED);
         itemModelGenerator.register(ItemRegistry.PINEAPPLE_SLICE, Models.GENERATED);
         itemModelGenerator.register(ItemRegistry.SWEET_POTATOES, Models.GENERATED);
         itemModelGenerator.register(ItemRegistry.TOMATOES, Models.GENERATED);
         itemModelGenerator.register(ItemRegistry.PURPLE_CARROT, Models.GENERATED);
         itemModelGenerator.register(ItemRegistry.STRAWBERRIES, Models.GENERATED);
    }
}
