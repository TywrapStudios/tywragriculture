package net.tywrapstudios.agriculture.api.crops.aged;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

/**
 * A {@link CropBlock} with an Age property of {@code 1}, it has {@code 2} BlockStates.
 * @author Tiazzz
 */
public class Age1CropBlock extends CropBlock {
    public static final int MAX_AGE = 1;
    public static final IntProperty AGE = Properties.AGE_1;

    public Age1CropBlock(Settings settings) {
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
