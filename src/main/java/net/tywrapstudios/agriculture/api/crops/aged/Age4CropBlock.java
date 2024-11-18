package net.tywrapstudios.agriculture.api.crops.aged;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

/**
 * A {@link CropBlock} with an Age property of {@code 4}, it has {@code 5} BlockStates.
 * @author Tiazzz
 */
public class Age4CropBlock extends CropBlock {
    public static final int MAX_AGE = 4;
    public static final IntProperty AGE = Properties.AGE_4;

    public Age4CropBlock(Settings settings) {
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
