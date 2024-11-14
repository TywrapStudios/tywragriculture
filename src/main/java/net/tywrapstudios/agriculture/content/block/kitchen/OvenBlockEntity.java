package net.tywrapstudios.agriculture.content.block.kitchen;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.tywrapstudios.agriculture.content.block.kitchen.abstracts.AbstractOvenBlockEntity;
import net.tywrapstudios.agriculture.screen.OvenScreenHandler;

public class OvenBlockEntity extends AbstractOvenBlockEntity {
    public OvenBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityType.FURNACE, pos, state, RecipeType.SMELTING);
    }

    protected Text getContainerName() {
        return Text.translatable("container.agriculture.oven");
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new OvenScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
