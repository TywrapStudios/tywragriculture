package net.tywrapstudios.agriculture.registry;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.content.block.crops.*;
import net.tywrapstudios.agriculture.content.block.kitchen.*;

import static net.tywrapstudios.agriculture.Tywragriculture.LOGGING;

public class BlockRegistry {

    public static RegistryEntry<BlackCarrotCrop> BLACK_CARROT;
    public static RegistryEntry<PurpleCarrotCrop> PURPLE_CARROT;
    public static final Block GOLD_CARROT = registerBlock("gold_carrot_crop", new GoldCarrotCrop(FabricBlockSettings
            .copyOf(Blocks.CARROTS)),false);
    public static RegistryEntry<TomatoShrub> TOMATO_PLANT;
    public static RegistryEntry<SweetPotatoCrop> SWEET_POTATO;
    public static RegistryEntry<StrawberryBush> STRAWBERRY_BUSH;
    public static RegistryEntry<PeaCrop> PEA_CROP;
    public static RegistryEntry<CrateBlock> CRATE;
    public static RegistryEntry<OvenBlock> OVEN;
    public static RegistryEntry<SinkBlock> SINK;
    public static RegistryEntry<CabbageCrop> CABBAGE;
    public static RegistryEntry<LeavesBlock> PINE_CONED_SPRUCE_LEAVES;
    public static RegistryEntry<MeatGrinderBlock> MEAT_GRINDER;

    public static void registerBlocks(Registrate REGISTRATE) {
        BLACK_CARROT = REGISTRATE.block("black_carrot_crop", p -> new BlackCarrotCrop(FabricBlockSettings
                        .copyOf(Blocks.CARROTS)))
                .register();
        PURPLE_CARROT = REGISTRATE.block("purple_carrot_crop", p -> new PurpleCarrotCrop(FabricBlockSettings
                        .copyOf(Blocks.CARROTS)))
                .register();
        SWEET_POTATO = REGISTRATE.block("sweet_potato_crop", p -> new SweetPotatoCrop(FabricBlockSettings
                        .copyOf(Blocks.POTATOES)))
                .register();
        STRAWBERRY_BUSH = REGISTRATE.block("strawberry_bush", p -> new StrawberryBush(FabricBlockSettings
                        .copyOf(Blocks.SWEET_BERRY_BUSH)))
                .register();
        PEA_CROP = REGISTRATE.block("pea_crop", p -> new PeaCrop(FabricBlockSettings
                        .copyOf(Blocks.WHEAT)))
                .register();
        CRATE = REGISTRATE.block("crate", CrateBlock::new)
                .simpleItem()
                .lang("Crate")
                .register();
        OVEN = REGISTRATE.block("oven", OvenBlock::new)
                .simpleItem()
                .lang("Oven")
                .register();
        SINK = REGISTRATE.block("sink", SinkBlock::new)
                .simpleItem()
                .lang("Sink")
                .register();
        PINE_CONED_SPRUCE_LEAVES = REGISTRATE.block("pine_coned_spruce_leaves", p -> Blocks.createLeavesBlock(BlockSoundGroup.GRASS))
                .simpleItem()
                .lang("Pine Coned Spruce Leaves")
                .register();
        MEAT_GRINDER = REGISTRATE.block("meat_grinder", p -> new MeatGrinderBlock(FabricBlockSettings
                        .copyOf(Blocks.IRON_BLOCK)))
                .simpleItem()
                .lang("Meat Grinder")
                .register();


        registerFDInspiredBlocks(REGISTRATE);
        LOGGING.debug("Blocks have been registered.");
    }

    public static void registerFDInspiredBlocks(Registrate REGISTRATE) {
        TOMATO_PLANT = REGISTRATE.block("tomato_shrub", p -> new TomatoShrub(FabricBlockSettings
                .copyOf(Blocks.SWEET_BERRY_BUSH)))
                .register();
        CABBAGE = REGISTRATE.block("cabbage_crop", p -> new CabbageCrop(FabricBlockSettings
                .copyOf(Blocks.WHEAT)))
                .register();
    }

    private static Block registerBlock(String name, Block block, boolean item) {
        LOGGING.literalDebug(String.format("The Block %s was manually registered without utilizing Registrate.", block), true);
        if (item) {
            registerBlockItem(name, block);
            LOGGING.literalDebug(">> With an item associated with the Block.", true);
        }
        return Registry.register(Registries.BLOCK, new Identifier(Tywragriculture.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Tywragriculture.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
}
