package net.tywrapstudios.agriculture.content.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.content.block.kitchen.CrateBlockEntity;
import net.tywrapstudios.agriculture.content.block.kitchen.MeatGrinderBlockEntity;
import net.tywrapstudios.agriculture.content.block.kitchen.OvenBlockEntity;
import net.tywrapstudios.agriculture.registry.BlockRegistry;
import net.tywrapstudios.agriculture.util.logging.LoggingHandlers;

public class BlockEntities {
    public static final BlockEntityType<CrateBlockEntity> CRATE =
            create("crate_entity", CrateBlockEntity::new, BlockRegistry.CRATE.get());
    public static BlockEntityType<OvenBlockEntity> OVEN =
            create("oven_entity", OvenBlockEntity::new, BlockRegistry.OVEN.get());
    public static BlockEntityType<MeatGrinderBlockEntity> MEAT_GRINDER =
            create("meat_grinder_entity", MeatGrinderBlockEntity::new, BlockRegistry.MEAT_GRINDER.get());

    private static <T extends BlockEntity> BlockEntityType<T> create(String id, FabricBlockEntityTypeBuilder.Factory<T> factory, Block... blocks) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Tywragriculture.MOD_ID, id),
                FabricBlockEntityTypeBuilder.create(factory, blocks).build());
    }

    public static void register() {
        LoggingHandlers.debug("BlockEntities have been registered.");
    }
}
