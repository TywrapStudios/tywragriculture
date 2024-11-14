package net.tywrapstudios.agriculture.content.block.crops;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tywrapstudios.agriculture.api.agedcropblocks.Age4CropBlock;
import net.tywrapstudios.agriculture.registry.ItemRegistry;

public class TomatoShrub extends Age4CropBlock {
    public TomatoShrub(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int age = state.get(getAgeProperty());
        boolean mature = age == getMaxAge();
        if (!mature && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        } else if (mature) {
            int dropAmount = 1 + world.random.nextInt(2);
            Block.dropStack(world, pos, new ItemStack(ItemRegistry.TOMATOES.get(), dropAmount));

            float chanceToBeRotten = world.random.nextFloat();
            if (chanceToBeRotten < 0.07) {
                Block.dropStack(world, pos, new ItemStack(ItemRegistry.ROTTEN_TOMATOES.get()));
            }
            world.playSound(null, pos,
                    SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES,
                    SoundCategory.BLOCKS, 1f, 0.8f);
            world.setBlockState(pos, state.with(getAgeProperty(), 3));

            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.TOMATO_SEEDS.get();
    }
}
