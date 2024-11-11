package net.tywrapstudios.agriculture.content.block.crops;

import net.minecraft.item.ItemConvertible;
import net.tywrapstudios.agriculture.api.agedcropblocks.Age5CropBlock;
import net.tywrapstudios.agriculture.registry.ItemRegistry;

public class StrawberryBush extends Age5CropBlock {
    public StrawberryBush(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.STRAWBERRIES.get();
    }
}
