package net.tywrapstudios.agriculture.registry;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.content.block.plants.*;
import net.tywrapstudios.agriculture.content.block.kitchen.*;
import net.tywrapstudios.agriculture.resources.BlockTags;

import java.util.function.Supplier;

import static net.tywrapstudios.agriculture.Tywragriculture.LOGGING;
import static net.tywrapstudios.agriculture.util.datagen.DatagenLootUtil.*;
import static net.tywrapstudios.agriculture.util.datagen.DatagenBlockStateUtil.*;

public class BlockRegistry {

    public static RegistryEntry<BlackCarrotCrop> BLACK_CARROT;
    public static RegistryEntry<PurpleCarrotCrop> PURPLE_CARROT;
    public static Block GOLD_CARROT = registerBlock("gold_carrot_crop", new GoldCarrotCrop(FabricBlockSettings
            .copyOf(Blocks.CARROTS))); // Needs to be registered alternatively in favor of ItemsMixin$agriculture$makeGoldenCarrotAliased(...)
    public static RegistryEntry<TomatoShrub> TOMATO_PLANT;
    public static RegistryEntry<SweetPotatoCrop> SWEET_POTATO;
    public static RegistryEntry<StrawberryBush> STRAWBERRY_BUSH;
    public static RegistryEntry<PeaCrop> PEA_CROP;
    public static RegistryEntry<CrateBlock> CRATE;
    public static RegistryEntry<OvenBlock> OVEN;
    public static RegistryEntry<SinkBlock> SINK;
    public static RegistryEntry<CabbageCrop> CABBAGE;
    public static RegistryEntry<PineConeLeavesBlock> PINE_CONED_SPRUCE_LEAVES;
    public static RegistryEntry<MeatGrinderBlock> MEAT_GRINDER;

    public static void registerBlocks(Registrate REGISTRATE) {
        BLACK_CARROT = REGISTRATE.block("black_carrot_crop", p -> new BlackCarrotCrop(FabricBlockSettings
                    .copyOf(Blocks.CARROTS)))
                .loot(generateCropLoot(ItemRegistry.BLACK_CARROT.get(), ItemRegistry.BLACK_CARROT.get(), 2.0f, 5.0f))
                .properties(settings -> FabricBlockSettings.copy(Blocks.CARROTS))
                .blockstate(getCropBlockStateProvider())
                .register();
        PURPLE_CARROT = REGISTRATE.block("purple_carrot_crop", p -> new PurpleCarrotCrop(FabricBlockSettings
                    .copyOf(Blocks.CARROTS)))
                .initialProperties(() -> Blocks.CARROTS)
                .loot(generateCropLoot(ItemRegistry.PURPLE_CARROT.get(), ItemRegistry.PURPLE_CARROT.get(), 2.0f, 5.0f))
                .blockstate(getCropBlockStateProvider())
                .register();
        SWEET_POTATO = REGISTRATE.block("sweet_potato_crop", p -> new SweetPotatoCrop(FabricBlockSettings
                    .copyOf(Blocks.POTATOES)))
                .initialProperties(() -> Blocks.POTATOES)
                .loot(generateCropLoot(ItemRegistry.SWEET_POTATOES.get(), ItemRegistry.SWEET_POTATOES.get(), 2.0f, 5.0f))
                .blockstate(getCropBlockStateProvider())
                .register();
        STRAWBERRY_BUSH = REGISTRATE.block("strawberry_bush", p -> new StrawberryBush(FabricBlockSettings
                    .copyOf(Blocks.SWEET_BERRY_BUSH)))
                .initialProperties(() -> Blocks.SWEET_BERRY_BUSH)
                .loot(generateSingleItemLoot(ItemRegistry.STRAWBERRIES.get()))
                .blockstate(getCropBlockStateProvider())
                .register();
        PEA_CROP = REGISTRATE.block("pea_crop", p -> new PeaCrop(FabricBlockSettings
                    .copyOf(Blocks.WHEAT)))
                .initialProperties(() -> Blocks.WHEAT)
                .loot(generateSingleItemLoot(ItemRegistry.PEAS.get()))
                .blockstate(getCropBlockStateProvider())
                .register();
        CRATE = REGISTRATE.block("crate", CrateBlock::new)
                .item(BlockItem::new)
                .model((context, provider) -> provider.generatedModels.get(new Identifier(Tywragriculture.MOD_ID, "block/crate/crate")))
                .build()
                .blockstate((context, provider) -> provider.directionalBlock(context.get(), state ->
                        provider.models().getExistingFile(
                                new Identifier(Tywragriculture.MOD_ID,
                                        "block/crate/crate" + (state.get(CrateBlock.OPEN) ? "_open" : "")
                                )
                        )
                ))
                .tag(BlockTags.KITCHEN.get())
                .register();
        SINK = REGISTRATE.block("sink", SinkBlock::new)
                .simpleItem()
                .blockstate((context, provider) -> provider.models().cubeBottomTop("sink", new Identifier(Tywragriculture.MOD_ID, "block/sink/sink_side"), new Identifier(Tywragriculture.MOD_ID, "block/sink/sink_bottom"), new Identifier(Tywragriculture.MOD_ID, "block/sink/sink_top")))
                .tag(BlockTags.KITCHEN.get())
                .register();
        PINE_CONED_SPRUCE_LEAVES = REGISTRATE.block("pine_coned_spruce_leaves", p ->
                        createPineConeLeavesBlock(BlockSoundGroup.GRASS))
                .simpleItem()
                .defaultBlockstate()
                .loot((lootTables, block) -> getLootPoolForLeavesBlock(block, Items.SPRUCE_SAPLING, ItemRegistry.PINE_CONE.get()).build())
                .tag(net.minecraft.registry.tag.BlockTags.LEAVES)
                .register();
        MEAT_GRINDER = REGISTRATE.block("meat_grinder", p -> new MeatGrinderBlock(FabricBlockSettings
                        .copyOf(Blocks.IRON_BLOCK)))
                .simpleItem()
                .tag(BlockTags.KITCHEN.get())
                .register();
        OVEN = REGISTRATE.block("oven", p -> new OvenBlock(FabricBlockSettings
                    .copyOf(Blocks.FURNACE)))
                .item((ovenBlock, settings) -> new BlockItem(ovenBlock, new FabricItemSettings()))
                .model((context, provider) -> provider.blockItem(() -> context.get().getBlock(), "/oven"))
                .build()
                .blockstate((context, provider) -> provider.horizontalBlock(context.get(), state ->
                        provider.models().getExistingFile(
                                new Identifier(Tywragriculture.MOD_ID,
                                        "block/oven/oven" + (state.get(OvenBlock.LIT) ? "_on" : "")
                                )
                        )
                ))
                .tag(BlockTags.KITCHEN.get())
                .register();


        registerFDInspiredBlocks(REGISTRATE);
        LOGGING.debug("Blocks have been registered.");
    }

    public static void registerFDInspiredBlocks(Registrate REGISTRATE) {
        TOMATO_PLANT = REGISTRATE.block("tomato_shrub", p -> new TomatoShrub(FabricBlockSettings
                    .copyOf(Blocks.SWEET_BERRY_BUSH)))
                .initialProperties(() -> Blocks.SWEET_BERRY_BUSH)
                .blockstate(getCropBlockStateProvider())
                .tag(BlockTags.FD_INSPIRED.get())
                .register();
        CABBAGE = REGISTRATE.block("cabbage_crop", p -> new CabbageCrop(FabricBlockSettings
                    .copyOf(Blocks.WHEAT)))
                .initialProperties(() -> Blocks.WHEAT)
                .blockstate(getCropBlockStateProvider())
                .tag(BlockTags.FD_INSPIRED.get())
                .register();
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Tywragriculture.MOD_ID, name), block);
    }

    private static PineConeLeavesBlock createPineConeLeavesBlock(BlockSoundGroup soundGroup) {
        return new PineConeLeavesBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).strength(0.2F).ticksRandomly().sounds(soundGroup).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never));
    }
}
