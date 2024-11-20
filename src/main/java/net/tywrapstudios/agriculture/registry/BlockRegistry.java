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
import net.tywrapstudios.agriculture.resources.BlockTags;

import static net.tywrapstudios.agriculture.Tywragriculture.LOGGING;

public class BlockRegistry {

    public static Block BLACK_CARROT;
    public static Block PURPLE_CARROT;
    public static Block GOLD_CARROT;
    public static Block TOMATO_PLANT;
    public static Block SWEET_POTATO;
    public static Block STRAWBERRY_BUSH;
    public static Block PEA_CROP;
    public static Block CRATE;
    public static RegistryEntry<SinkBlock> SINK;
    public static Block CABBAGE;
    public static RegistryEntry<LeavesBlock> PINE_CONED_SPRUCE_LEAVES;
    public static RegistryEntry<MeatGrinderBlock> MEAT_GRINDER;

    public static void registerBlocks(Registrate REGISTRATE) {
        BLACK_CARROT = registerBlock("black_carrot_crop", new BlackCarrotCrop(FabricBlockSettings
                .copyOf(Blocks.CARROTS)),false);
        PURPLE_CARROT = registerBlock("purple_carrot_crop", new PurpleCarrotCrop(FabricBlockSettings
                .copyOf(Blocks.CARROTS)),false);
        GOLD_CARROT = registerBlock("gold_carrot_crop", new GoldCarrotCrop(FabricBlockSettings
                .copyOf(Blocks.CARROTS)),false);
        SWEET_POTATO = registerBlock("sweet_potato_crop", new SweetPotatoCrop(FabricBlockSettings
                .copyOf(Blocks.POTATOES)), false);
        STRAWBERRY_BUSH = registerBlock("strawberry_bush", new StrawberryBush(FabricBlockSettings
                .copyOf(Blocks.SWEET_BERRY_BUSH)), false);
        PEA_CROP = registerBlock("pea_crop", new PeaCrop(FabricBlockSettings
                .copyOf(Blocks.WHEAT)), false);
        CRATE = registerBlock("crate", new CrateBlock(FabricBlockSettings.create()), true);
        SINK = REGISTRATE.block("sink", SinkBlock::new)
                .simpleItem()
                .blockstate((blockSinkBlockDataGenContext, registrateBlockstateProvider) -> registrateBlockstateProvider.models().getExistingFile(new Identifier(Tywragriculture.MOD_ID, "block/sink")))
                .tag(BlockTags.KITCHEN.get())
                .lang("Sink")
                .register();
        PINE_CONED_SPRUCE_LEAVES = REGISTRATE.block("pine_coned_spruce_leaves", p -> Blocks.createLeavesBlock(BlockSoundGroup.GRASS))
                .simpleItem()
                .tag(net.minecraft.registry.tag.BlockTags.LEAVES)
                .lang("Pine Coned Spruce Leaves")
                .register();
        MEAT_GRINDER = REGISTRATE.block("meat_grinder", p -> new MeatGrinderBlock(FabricBlockSettings
                        .copyOf(Blocks.IRON_BLOCK)))
                .simpleItem()
                .tag(BlockTags.KITCHEN.get())
                .lang("Meat Grinder")
                .register();


        registerFDInspiredBlocks(REGISTRATE);
        LOGGING.debug("Blocks have been registered.");
    }

    public static void registerFDInspiredBlocks(Registrate REGISTRATE) {
        TOMATO_PLANT = registerBlock("tomato_shrub", new TomatoShrub(FabricBlockSettings
                .copyOf(Blocks.SWEET_BERRY_BUSH)), false);
        CABBAGE = registerBlock("cabbage_crop", new CabbageCrop(FabricBlockSettings
                .copyOf(Blocks.WHEAT)), false);
    }

    private static Block registerBlock(String name, Block block, boolean item) {
        if (item) {
            registerBlockItem(name, block);
        }
        return Registry.register(Registries.BLOCK, new Identifier(Tywragriculture.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Tywragriculture.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
}
