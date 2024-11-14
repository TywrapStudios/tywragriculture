package net.tywrapstudios.agriculture.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tywrapstudios.agriculture.config.ConfigManager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CropBlock.class)
public abstract class CropBlockMixin extends PlantBlock implements Fertilizable {
    public CropBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockState oldState = world.getBlockState(pos);
        if (!ConfigManager.config.world_config.right_click_harvest || player.getStackInHand(hand).isOf(Items.BONE_MEAL) || player.isSneaking() || !(oldState.getBlock() instanceof CropBlock block) ) {
            return ActionResult.PASS;
        } else  {
            if (block.isMature(oldState)) {
                world.breakBlock(pos, true, player);
            }
            world.setBlockState(pos, block.getPlacementState(new ItemPlacementContext(world, player, hand, player.getStackInHand(hand), hit)));
            player.swingHand(hand);
            return ActionResult.SUCCESS;
        }
    }
}
