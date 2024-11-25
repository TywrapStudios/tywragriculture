package net.tywrapstudios.agriculture.api.crops.special;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
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
import net.tywrapstudios.agriculture.api.crops.aged.Age4CropBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * An {@link Age4CropBlock}, that has properties of a standard shrub like plant. e.g. Tomatoes or Strawberries.
 * <p>NOTE THAT YOU SHOULD NOT ADD CROP LOOT TABLES FOR THESE AND INSTEAD JUST NORMAL LOOT TABLES.
 * @author Tiazzz
 */
public class ShrubLike extends Age4CropBlock {
    public ShrubLike(Settings settings) {
        super(settings);
    }

    /**
     * This method is used to make the picking of the actual fruits more usable, rather than forcing users to use {@code onUse(...)}, also so other stuff can be done before actually picking the fruit.
     * @param state The current {@link BlockState}
     * @param world The current {@link World}
     * @param pos The current {@link BlockPos}
     * @param player The current {@link PlayerEntity}
     * @param hand The current {@link Hand}
     * @param fruit The current {@link ItemConvertible} item that is the bare fruit picked from the plant.
     * @param rottenFruit The current {@link ItemConvertible} item that is the rotten fruit picked from the plant. May be {@code null} to not drop any rotten variants.
     * @return An {@link ActionResult}
     */
    protected @NotNull ActionResult pickFruit(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemConvertible fruit, @Nullable ItemConvertible rottenFruit) {
        boolean mature = ((CropBlock) state.getBlock()).isMature(state);
        if (!mature && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        } else if (mature) {
            int dropAmount = 1 + world.random.nextInt(2);
            Block.dropStack(world, pos, new ItemStack(fruit, dropAmount));

            if (rottenFruit != null) {
                float chanceToBeRotten = world.random.nextFloat();
                if (chanceToBeRotten < 0.07) {
                    Block.dropStack(world, pos, new ItemStack(rottenFruit));
                }
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
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return pickFruit(state, world, pos, player, hand, Items.WHEAT, null);
    }
}
