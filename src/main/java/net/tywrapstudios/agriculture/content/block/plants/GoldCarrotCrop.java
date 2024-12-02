package net.tywrapstudios.agriculture.content.block.plants;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.tywrapstudios.agriculture.api.crops.aged.Age6CropBlock;

public class GoldCarrotCrop extends Age6CropBlock {
    public GoldCarrotCrop(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return Items.GOLDEN_CARROT;
    }
}