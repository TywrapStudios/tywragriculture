package net.tywrapstudios.agriculture.content.block.kitchen;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.tywrapstudios.agriculture.content.block.BlockEntities;
import net.tywrapstudios.agriculture.recipe.Recipes;
import net.tywrapstudios.agriculture.screen.screens.OvenScreenHandler;

public class OvenBlockEntity extends AbstractFurnaceBlockEntity {
    public OvenBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.OVEN_ENTITY.get(), pos, state, Recipes.OVEN_COOKING_TYPE);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.agriculture.oven");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new OvenScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
