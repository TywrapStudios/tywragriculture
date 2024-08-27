package net.tywrapstudios.agriculture.common.block.custom.crops;

import net.minecraft.item.ItemConvertible;
import net.tywrapstudios.agriculture.api.agecropblocks.Age6CropBlock;
import net.tywrapstudios.agriculture.common.item.ItemRegistry;

public class PurpleCarrotCrop extends Age6CropBlock {
    public PurpleCarrotCrop(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.PURPLE_CARROT;
    }
}