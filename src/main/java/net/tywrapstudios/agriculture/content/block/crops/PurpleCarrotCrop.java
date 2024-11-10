package net.tywrapstudios.agriculture.content.block.crops;

import net.minecraft.item.ItemConvertible;
import net.tywrapstudios.agriculture.api.agedcropblocks.Age6CropBlock;
import net.tywrapstudios.agriculture.content.item.ItemRegistry;

public class PurpleCarrotCrop extends Age6CropBlock {
    public PurpleCarrotCrop(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.PURPLE_CARROT.get();
    }
}