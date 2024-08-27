package net.tywrapstudios.agriculture.common.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.common.block.custom.crops.TomatoBlock;
import net.tywrapstudios.agriculture.common.block.custom.crops.BlackCarrotCrop;
import net.tywrapstudios.agriculture.common.block.custom.crops.GoldCarrotCrop;
import net.tywrapstudios.agriculture.common.block.custom.crops.PurpleCarrotCrop;
import net.tywrapstudios.agriculture.common.item.ItemRegistry;

public class BlockRegistry {


    public static final Block BLACK_CARROT = registerCropBlock("black_carrot_crop", new BlackCarrotCrop(FabricBlockSettings.
            copyOf(Blocks.CARROTS)));
    public static final Block PURPLE_CARROT = registerCropBlock("purple_carrot_crop", new PurpleCarrotCrop(FabricBlockSettings.
            copyOf(Blocks.CARROTS)));
    public static final Block GOLD_CARROT = registerCropBlock("gold_carrot_crop", new GoldCarrotCrop(FabricBlockSettings.
            copyOf(Blocks.CARROTS)));
    public static final Block TOMATO_PLANT = registerCropBlock("tomato_shrub", new TomatoBlock(FabricBlockSettings.
            copyOf(Blocks.SWEET_BERRY_BUSH)));


    private static Block registerCropBlock(String name, Block block) {
//      Make sure to pick your custom Crop class as block, and set some settings!
        return Registry.register(Registries.BLOCK, new Identifier(Tywragriculture.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Tywragriculture.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Tywragriculture.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
    }
}
