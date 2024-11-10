package net.tywrapstudios.agriculture.content.block.crops;

import net.minecraft.item.ItemConvertible;
import net.tywrapstudios.agriculture.api.agedcropblocks.Age6CropBlock;
import net.tywrapstudios.agriculture.content.item.ItemRegistry;

public class BlackCarrotCrop extends Age6CropBlock {
    public BlackCarrotCrop(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.BLACK_CARROT.get();
    }
}