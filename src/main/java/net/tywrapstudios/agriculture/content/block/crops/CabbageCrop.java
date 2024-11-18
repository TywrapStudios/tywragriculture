package net.tywrapstudios.agriculture.content.block.crops;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.tywrapstudios.agriculture.api.crops.aged.Age3CropBlock;
import net.tywrapstudios.agriculture.registry.ItemRegistry;

public class CabbageCrop extends Age3CropBlock {
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(6.0, -1.0, 6.0, 10.0, 2.0, 10.0),
            Block.createCuboidShape(5.0, -1.0, 5.0, 11.0, 2.0, 11.0),
            Block.createCuboidShape(5.0, -1.0, 5.0, 11.0, 2.0, 11.0),
            Block.createCuboidShape(4.0, -1.0, 4.0, 12.0, 5.0, 12.0)};

    public CabbageCrop(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.CABBAGES.get();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[this.getAge(state)];
    }
}
