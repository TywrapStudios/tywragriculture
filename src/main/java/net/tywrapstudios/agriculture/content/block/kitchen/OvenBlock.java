package net.tywrapstudios.agriculture.content.block.kitchen;

import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

/*
TODO: Make our own fully Custom OvenBlock class, instead of extending FurnaceBlock
 This includes RecipeType
 Maybe make it an API thing
*/
public class OvenBlock extends FurnaceBlock {
    public static final DirectionProperty FACING;
    public static final BooleanProperty LIT;

    public OvenBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(LIT, false));
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        LIT = Properties.LIT;
    }
}