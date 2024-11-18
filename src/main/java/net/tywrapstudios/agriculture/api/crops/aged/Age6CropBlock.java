package net.tywrapstudios.agriculture.api.crops.aged;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.tywrapstudios.agriculture.api.property.Properties;

/**
 * A {@link CropBlock} with an Age property of {@code 6}, it has {@code 7} BlockStates.
 * <p> This {@link IntProperty} is assigned a Custom made value from our {@link Properties}</p>
 * @author Tiazzz
 */
public class Age6CropBlock extends CropBlock {
    public static final int MAX_AGE = 6;
    public static final IntProperty AGE = Properties.AGE_6;

    public Age6CropBlock(Settings settings) {
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
