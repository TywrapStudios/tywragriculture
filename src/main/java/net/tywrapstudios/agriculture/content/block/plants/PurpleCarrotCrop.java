package net.tywrapstudios.agriculture.content.block.plants;

import net.minecraft.item.ItemConvertible;
import net.tywrapstudios.agriculture.api.crops.aged.Age6CropBlock;
import net.tywrapstudios.agriculture.registry.ItemRegistry;

public class PurpleCarrotCrop extends Age6CropBlock {
    public PurpleCarrotCrop(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.PURPLE_CARROT.get();
    }
}