package net.tywrapstudios.agriculture.registry;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.tywrapstudios.agriculture.content.item.kitchen.BriquetteItem;
import net.tywrapstudios.agriculture.content.item.foodstuffs.RottenTomatoItem;
import net.tywrapstudios.agriculture.resources.FoodComponents;

import static net.tywrapstudios.agriculture.Tywragriculture.LOGGING;
import static net.tywrapstudios.agriculture.resources.FoodComponents.*;

public class ItemRegistry {

    public static RegistryEntry<BriquetteItem> BRIQUETTE;
    public static RegistryEntry<Item> CAKE_SLICE;
    public static RegistryEntry<AliasedBlockItem> STRAWBERRIES;
    public static RegistryEntry<Item> TOMATOES;
    public static RegistryEntry<AliasedBlockItem> TOMATO_SEEDS;
    public static RegistryEntry<RottenTomatoItem> ROTTEN_TOMATOES;
    public static RegistryEntry<AliasedBlockItem> PURPLE_CARROT;
    public static RegistryEntry<AliasedBlockItem> BLACK_CARROT;
    public static RegistryEntry<AliasedBlockItem> CABBAGES;
    public static RegistryEntry<Item> CABBAGE_LEAVES;
    public static RegistryEntry<AliasedBlockItem> SWEET_POTATOES;
    public static RegistryEntry<Item> PINEAPPLES;
    public static RegistryEntry<Item> PINEAPPLE_SLICE;
    public static RegistryEntry<Item> PEA_SHELL;
    public static RegistryEntry<AliasedBlockItem> PEAS;
    public static RegistryEntry<Item> PINE_CONE;
    public static RegistryEntry<Item> ROASTED_PINE_CONE;

    public static void registerItems(Registrate REGISTRATE) {
        BRIQUETTE = REGISTRATE.item("briquette", BriquetteItem::new)
                .defaultModel()
                .lang("Briquette")
                .register();
        CAKE_SLICE = REGISTRATE.item("cake_slice", p -> new Item(new FabricItemSettings()
                        .food(CAKE_SLICE_FOOD.get())))
                .defaultModel()
                .lang("Cake Slice")
                .register();
        STRAWBERRIES = REGISTRATE.item("strawberry", p -> new AliasedBlockItem(BlockRegistry.STRAWBERRY_BUSH, new FabricItemSettings()
                        .food(STRAWBERRY.get())))
                .defaultModel()
                .lang("Strawberry")
                .register();
        PURPLE_CARROT = REGISTRATE.item("purple_carrot", p -> new AliasedBlockItem(BlockRegistry.PURPLE_CARROT, new FabricItemSettings()
                        .food(CARROT_PURPLE.get())))
                .defaultModel()
                .lang("Purple Carrot")
                .register();
        BLACK_CARROT = REGISTRATE.item("black_carrot", p -> new AliasedBlockItem(BlockRegistry.BLACK_CARROT, new FabricItemSettings()
                        .food(CARROT_BLACK.get())))
                .defaultModel()
                .lang("Black Carrot")
                .register();
        SWEET_POTATOES = REGISTRATE.item("sweet_potato", p -> new AliasedBlockItem(BlockRegistry.SWEET_POTATO, new FabricItemSettings()
                        .food(SWEET_POTATO.get())))
                .defaultModel()
                .lang("Sweet Potato")
                .register();
        PINEAPPLES = REGISTRATE.item("pineapple", Item::new)
                .defaultModel()
                .lang("Whole Pineapple")
                .register();
        PINEAPPLE_SLICE = REGISTRATE.item("pineapple_slice", p -> new Item(new FabricItemSettings()
                        .food(FoodComponents.PINEAPPLE_SLICE.get())))
                .defaultModel()
                .lang("Pineapple Slice")
                .register();
        PEA_SHELL = REGISTRATE.item("pea_shell", Item::new)
                .defaultModel()
                .lang("Pea Shell")
                .register();
        PEAS = REGISTRATE.item("peas", p -> new AliasedBlockItem(BlockRegistry.PEA_CROP, new FabricItemSettings()))
                .defaultModel()
                .lang("Peas")
                .register();
        PINE_CONE = REGISTRATE.item("pine_cone", Item::new)
                .defaultModel()
                .lang("Pine Cone")
                .register();
        ROASTED_PINE_CONE = REGISTRATE.item("roasted_pine_cone", Item::new)
                .defaultModel()
                .lang("Roasted Pine Cone")
                .register();

        registerFDInspiredItems(REGISTRATE);
        LOGGING.debug("Items have been registered.");
    }

    public static void registerFDInspiredItems(Registrate REGISTRATE) {
        TOMATOES = REGISTRATE.item("tomato", p -> new Item(new FabricItemSettings()
                        .food(TOMATO.get())))
                .defaultModel()
                .lang("Tomato")
                .register();
        TOMATO_SEEDS = REGISTRATE.item("tomato_seeds", p -> new AliasedBlockItem(BlockRegistry.TOMATO_PLANT, new FabricItemSettings()))
                .defaultModel()
                .lang("Tomato Seeds")
                .register();
        ROTTEN_TOMATOES = REGISTRATE.item("rotten_tomato", RottenTomatoItem::new)
                .defaultModel()
                .lang("Rotten Tomato")
                .register();
        CABBAGES = REGISTRATE.item("cabbage", p -> new AliasedBlockItem(BlockRegistry.CABBAGE, new FabricItemSettings()))
                .defaultModel()
                .lang("Cabbage")
                .register();
        CABBAGE_LEAVES = REGISTRATE.item("cabbage_leaf", Item::new)
                .defaultModel()
                .lang("Cabbage Leaf")
                .register();
    }
}
