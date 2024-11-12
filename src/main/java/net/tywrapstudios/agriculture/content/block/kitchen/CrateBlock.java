package net.tywrapstudios.agriculture.content.block.kitchen;

import net.minecraft.block.BarrelBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class CrateBlock extends BarrelBlock {
    public static final DirectionProperty FACING;
    public static final BooleanProperty OPEN;

    public CrateBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(OPEN, false));
    }

    static {
        FACING = Properties.FACING;
        OPEN = Properties.OPEN;
    }
}