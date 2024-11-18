package net.tywrapstudios.agriculture.api.crops.aged;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class Age2CropBlock extends CropBlock {
    public static final int MAX_AGE = 2;
    public static final IntProperty AGE = Properties.AGE_2;

    public Age2CropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
