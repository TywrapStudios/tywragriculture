package net.tywrapstudios.agriculture.registry;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.loot.condition.LootConditionTypes;
import net.minecraft.loot.context.LootContext;
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
    public static RegistryEntry<LeavesBlock> PINE_CONED_SPRUCE_LEAVES;
    public static RegistryEntry<MeatGrinderBlock> MEAT_GRINDER;

    public static void registerBlocks(Registrate REGISTRATE) {
        /*  TODO: Properly check these .loot() calls
             I honestly don't know if this is the correct way to do this for crops, also because
             the parameter names in the base class methods of the lambda parameter lootTables
             is very weird and obfuscated, as it was generated content.
         */
        BLACK_CARROT = REGISTRATE.block("black_carrot_crop", p -> new BlackCarrotCrop(FabricBlockSettings
                    .copyOf(Blocks.CARROTS)))
                .loot((lootTables, crop) -> lootTables.cropDrops(crop, ItemRegistry.BLACK_CARROT.get(), ItemRegistry.BLACK_CARROT.get(), () -> new LootCondition() {
                    @Override
                    public boolean test(LootContext lootContext) {
                        return false;
                    }

                    @Override
                    public LootConditionType getType() {
                        return LootConditionTypes.ANY_OF;
                    }
                }).build())
                .blockstate((context, provider) -> provider.models().crop("black_carrot_crop", new Identifier(Tywragriculture.MOD_ID, "black_carrot_crop")))
                .register();
        PURPLE_CARROT = REGISTRATE.block("purple_carrot_crop", p -> new PurpleCarrotCrop(FabricBlockSettings
                    .copyOf(Blocks.CARROTS)))
                .loot((lootTables, crop) -> lootTables.cropDrops(crop, ItemRegistry.PURPLE_CARROT.get(), ItemRegistry.PURPLE_CARROT.get(), () -> new LootCondition() {
                    @Override
                    public boolean test(LootContext lootContext) {
                        return false;
                    }

                    @Override
                    public LootConditionType getType() {
                        return LootConditionTypes.ANY_OF;
                    }
                }).build())
                .blockstate((context, provider) -> provider.models().crop("purple_carrot_crop", new Identifier(Tywragriculture.MOD_ID, "purple_carrot_crop")))
                .register();
        SWEET_POTATO = REGISTRATE.block("sweet_potato_crop", p -> new SweetPotatoCrop(FabricBlockSettings
                    .copyOf(Blocks.POTATOES)))
                .blockstate((context, provider) -> provider.simpleBlock(context.get()))
                .register();
        STRAWBERRY_BUSH = REGISTRATE.block("strawberry_bush", p -> new StrawberryBush(FabricBlockSettings
                    .copyOf(Blocks.SWEET_BERRY_BUSH)))
                .blockstate((context, provider) -> provider.simpleBlock(context.get()))
                .register();
        PEA_CROP = REGISTRATE.block("pea_crop", p -> new PeaCrop(FabricBlockSettings
                    .copyOf(Blocks.WHEAT)))
                .blockstate((context, provider) -> provider.simpleBlock(context.get()))
                .register();
        CRATE = REGISTRATE.block("crate", CrateBlock::new)
                .item((crateBlock, settings) -> new BlockItem(crateBlock, new FabricItemSettings()))
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
                .blockstate((context, provider) -> provider.models().getExistingFile(new Identifier(Tywragriculture.MOD_ID, "block/sink")))
                .tag(BlockTags.KITCHEN.get())
                .register();
        PINE_CONED_SPRUCE_LEAVES = REGISTRATE.block("pine_coned_spruce_leaves", p -> Blocks.createLeavesBlock(BlockSoundGroup.GRASS))
                .simpleItem()
                .blockstate((context, provider) -> provider.models().singleTexture("pine_coned_spruce_leaves", new Identifier("block/leaves"), "all", new Identifier(Tywragriculture.MOD_ID, "pine_coned_spruce_leaves")))
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
                .model((context, provider) -> provider.generatedModels.get(new Identifier(Tywragriculture.MOD_ID, "block/oven/oven")))
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
        TOMATO_PLANT = REGISTRATE.block("tomato_plant", p -> new TomatoShrub(FabricBlockSettings
                .copyOf(Blocks.SWEET_BERRY_BUSH)))
                .blockstate((context, provider) -> provider.simpleBlock(context.get()))
                .tag(BlockTags.FD_INSPIRED.get())
                .register();
        CABBAGE = REGISTRATE.block("cabbage_crop", p -> new CabbageCrop(FabricBlockSettings
                .copyOf(Blocks.WHEAT)))
                .blockstate((context, provider) -> provider.simpleBlock(context.get()))
                .tag(BlockTags.FD_INSPIRED.get())
                .register();
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Tywragriculture.MOD_ID, name), block);
    }
}
