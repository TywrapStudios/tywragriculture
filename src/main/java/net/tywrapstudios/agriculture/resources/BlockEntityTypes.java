package net.tywrapstudios.agriculture.resources;

import com.mojang.datafixers.types.Type;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;
import net.tywrapstudios.agriculture.content.block.kitchen.CrateBlockEntity;
import net.tywrapstudios.agriculture.registry.BlockRegistry;
import net.tywrapstudios.agriculture.util.logging.LoggingHandlers;

public class BlockEntityTypes {
    public static BlockEntityType<CrateBlockEntity> CRATE;

    static {
        CRATE = create("crate", BlockEntityType.Builder.create(CrateBlockEntity::new, BlockRegistry.CRATE.get()));
    }

    private static <T extends BlockEntity> BlockEntityType<T> create(String id, BlockEntityType.Builder<T> builder) {
        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, builder.build(type));
    }

    public static void init() {
        LoggingHandlers.debug("BlockEntityTypes have been registered.");
    }
}
