package net.tywrapstudios.agriculture.content.item;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.tywrapstudios.agriculture.content.block.BlockRegistry;
import net.tywrapstudios.agriculture.content.item.custom.BriquetteItem;
import net.tywrapstudios.agriculture.content.item.custom.RottenTomatoItem;

import static net.tywrapstudios.agriculture.resources.FoodComponents.*;

public class ItemRegistry {

    public static RegistryEntry<BriquetteItem> BRIQUETTE;
    public static RegistryEntry<Item> CAKE_SLICE;
    public static RegistryEntry<Item> STRAWBERRIES;
    public static RegistryEntry<Item> TOMATOES;
    public static RegistryEntry<AliasedBlockItem> TOMATO_SEEDS;
    public static RegistryEntry<RottenTomatoItem> ROTTEN_TOMATOES;
    public static RegistryEntry<AliasedBlockItem> PURPLE_CARROT;
    public static RegistryEntry<AliasedBlockItem> BLACK_CARROT;
    public static RegistryEntry<Item> CABBAGES;
    public static RegistryEntry<AliasedBlockItem> SWEET_POTATOES;
    public static RegistryEntry<Item> PINEAPPLES;
    public static RegistryEntry<Item> PINEAPPLE_SLICE;

    public static void registerModItems(Registrate REGISTRATE) {
        BRIQUETTE = REGISTRATE.item("briquette", p -> new BriquetteItem(new FabricItemSettings()
                .food(BRIQUETTE_FOOD.get())))
                .register();
        CAKE_SLICE = REGISTRATE.item("cake_slice", p -> new Item(new FabricItemSettings()
                .food(CAKE_SLICE_FOOD.get())))
                .register();
        STRAWBERRIES = REGISTRATE.item("strawberry", p -> new Item(new FabricItemSettings()
                .food(STRAWBERRY.get())))
                .register();
        PURPLE_CARROT = REGISTRATE.item("purple_carrot", p -> new AliasedBlockItem(BlockRegistry.PURPLE_CARROT.get(), new FabricItemSettings()
                .food(CARROT_PURPLE.get())))
                .register();
        BLACK_CARROT = REGISTRATE.item("black_carrot", p -> new AliasedBlockItem(BlockRegistry.BLACK_CARROT.get(), new FabricItemSettings()
                .food(CARROT_BLACK.get())))
                .register();
        SWEET_POTATOES = REGISTRATE.item("sweet_potato", p -> new AliasedBlockItem(BlockRegistry.SWEET_POTATO.get(), new FabricItemSettings()
                .food(SWEET_POTATO.get())))
                .register();
        PINEAPPLES = REGISTRATE.item("pineapple", Item::new)
                .register();
        PINEAPPLE_SLICE = REGISTRATE.item("pineapple_slice", Item::new)
                .register();

        registerFDInspiredItems(REGISTRATE);
    }

    public static void registerFDInspiredItems(Registrate REGISTRATE) {
        TOMATOES = REGISTRATE.item("tomato", p -> new Item(new FabricItemSettings()
                        .food(TOMATO.get())))
                .register();
        TOMATO_SEEDS = REGISTRATE.item("tomato_seeds", p -> new AliasedBlockItem(BlockRegistry.TOMATO_PLANT.get(), new FabricItemSettings()))
                .register();
        ROTTEN_TOMATOES = REGISTRATE.item("rotten_tomato", RottenTomatoItem::new)
                .register();
        CABBAGES = REGISTRATE.item("cabbage", Item::new)
                .register();
    }
}
