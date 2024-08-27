package net.tywrapstudios.agriculture.common.block.custom.crops;

import net.minecraft.item.ItemConvertible;
import net.tywrapstudios.agriculture.api.agecropblocks.Age6CropBlock;
import net.tywrapstudios.agriculture.common.item.ItemRegistry;

public class BlackCarrotCrop extends Age6CropBlock {
    public BlackCarrotCrop(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.BLACK_CARROT;
    }
}