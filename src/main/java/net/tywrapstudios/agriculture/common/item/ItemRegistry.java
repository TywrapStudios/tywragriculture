package net.tywrapstudios.agriculture.common.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.common.block.BlockRegistry;
import net.tywrapstudios.agriculture.common.item.custom.BriquetteItem;
import net.tywrapstudios.agriculture.common.item.custom.RottenTomatoItem;

import static net.tywrapstudios.agriculture.resources.ModFoodTypes.*;

public class ItemRegistry {

    public static final Item BRIQUETTE = registerItem("briquette", new BriquetteItem(new FabricItemSettings()
            .food(BRIQUETTE_FOOD)));
    public static final Item CAKE_SLICE = registerItem("cake_slice", new Item(new FabricItemSettings()
            .food(CAKE_SLICE_FOOD)));
    public static final Item STRAWBERRIES = registerItem("strawberry", new Item(new FabricItemSettings()
            .food(STRAWBERRY)));
    public static final Item TOMATOES = registerItem("tomato", new Item(new FabricItemSettings()
            .food(TOMATO)));
    public static final Item ROTTEN_TOMATOES = registerItem("rotten_tomato", new RottenTomatoItem(new FabricItemSettings()));
    public static final Item PURPLE_CARROT = registerItem("purple_carrot", new AliasedBlockItem(BlockRegistry.PURPLE_CARROT, new FabricItemSettings()
            .food(CARROT_PURPLE)));
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds", new AliasedBlockItem(BlockRegistry.TOMATO_PLANT, new FabricItemSettings()));
    public static final Item BLACK_CARROT = registerItem("black_carrot", new AliasedBlockItem(BlockRegistry.BLACK_CARROT, new FabricItemSettings()
            .food(CARROT_BLACK)));
    public static final Item CABBAGES = registerItem("cabbage", new Item(new FabricItemSettings()
            .food(CABBAGE)));
    public static final Item SWEET_POTATOES = registerItem("sweet_potato", new Item(new FabricItemSettings()
            .food(SWEET_POTATO)));
    public static final Item PINEAPPLE_SLICE = registerItem("pineapple_slice", new Item(new FabricItemSettings()
            .food(PINEAPPLE)));
    public static final Item PINEAPPLES = registerItem("pineapple", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Tywragriculture.MOD_ID, name), item);
    }

    public static void registerModItems() {

    }
}
