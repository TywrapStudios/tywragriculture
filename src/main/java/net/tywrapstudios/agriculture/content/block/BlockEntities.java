package net.tywrapstudios.agriculture.content.block;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.BlockEntityBuilder;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.tywrapstudios.agriculture.content.block.kitchen.CrateBlockEntity;
import net.tywrapstudios.agriculture.content.block.kitchen.MeatGrinderBlockEntity;

import static net.tywrapstudios.agriculture.registry.BlockRegistry.*;

public class BlockEntities {
    public static BlockEntityEntry<CrateBlockEntity> CRATE_ENTITY;
    public static BlockEntityEntry<MeatGrinderBlockEntity> MEAT_GRINDER_ENTITY;

    public static void registerBlockEntities(Registrate REGISTRATE) {
        CRATE_ENTITY = REGISTRATE.blockEntity("crate_entity",
                (BlockEntityBuilder.BlockEntityFactory<CrateBlockEntity>)
                        (type, pos, state) -> new CrateBlockEntity(pos, state))
                .validBlocks(CRATE)
                .register();
        MEAT_GRINDER_ENTITY = REGISTRATE.blockEntity("meat_grinder_entity",
                        (BlockEntityBuilder.BlockEntityFactory<MeatGrinderBlockEntity>)
                                (type, pos, state) -> new MeatGrinderBlockEntity(pos, state))
                .validBlocks(MEAT_GRINDER)
                .register();
    }
}
