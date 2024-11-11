package net.tywrapstudios.agriculture.content.block.crops;

import net.minecraft.block.PotatoesBlock;
import net.minecraft.item.ItemConvertible;
import net.tywrapstudios.agriculture.registry.ItemRegistry;

public class SweetPotatoCrop extends PotatoesBlock {
    public SweetPotatoCrop(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.SWEET_POTATOES.get();
    }
}
