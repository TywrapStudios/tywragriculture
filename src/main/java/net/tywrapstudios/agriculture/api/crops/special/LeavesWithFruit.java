package net.tywrapstudios.agriculture.api.crops.special;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.tywrapstudios.agriculture.api.property.Propertiess;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link LeavesBlock} that has the functionality to be able to carry and grow fruits.
 * <p> Data Info: <p/>
 * - This block has two {@link BlockState}{@code s} -> {@code has_fruit=true||false}
 * <p>- You probably don't want to add your regular type leaf drops to these, though it is not discouraged.
 * @author Tiazzz
 */
public class LeavesWithFruit extends LeavesBlock {
    public static final BooleanProperty HAS_FRUIT = Propertiess.HAS_FRUIT;

    public LeavesWithFruit(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(HAS_FRUIT, true));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HAS_FRUIT);
        super.appendProperties(builder);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(Propertiess.HAS_FRUIT)) {
            return tryPickFruit(state, world, pos, Items.STICK, 0);
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }

    /**
     * This method is used to make the picking of the actual fruits more usable, rather than forcing users to use {@code onUse(...)} for only that purpose, also so other stuff can be done before actually picking the fruit.
     * @param state The current {@link BlockState}
     * @param world The current {@link World}
     * @param pos The current {@link BlockPos}
     * @param drop An {@link ItemConvertible} item that represents the bare fruit picked from the block.
     * @param chanceForExtraDrops An {@link Integer} that represents the maximum extra of the fruit that may be randomly dropped. There will always be dropped at least one of the fruit.
     * @return An {@link ActionResult}
     */
    protected static @NotNull ActionResult tryPickFruit(BlockState state, World world, BlockPos pos, ItemConvertible drop, int chanceForExtraDrops) {
        world.setBlockState(pos, state.with(Propertiess.HAS_FRUIT, false));
        int dropAmount = 1 + world.random.nextInt(chanceForExtraDrops);
        Block.dropStack(world, pos, new ItemStack(drop, dropAmount));
        return ActionResult.SUCCESS;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        tickWithChance(state, world, pos, random, 60.0f);
        super.randomTick(state, world, pos, random);
    }

    /**
     * This method allows you to run this block's tick logic with an extra chance that may differ from time to time.
     * @param state The current {@link BlockState}
     * @param world The current {@link World}
     * @param pos The current {@link BlockPos}
     * @param random A {@link Random} to work with.
     * @param chance A {@link Float} that represents the added chance. Suggested to be a full number, but it already gets cast to {@link Integer}
     */
    protected static void tickWithChance(BlockState state, ServerWorld world, BlockPos pos, Random random, float chance) {
        if (!state.get(HAS_FRUIT)) {
            if (random.nextInt((int) chance) == 0) {
                world.setBlockState(pos, state.with(Propertiess.HAS_FRUIT, true));
            }
        }
    }

    /**
     * When you {@link Override} this method it is suggested to run {@code super.hasRandomTicks(...)} somewhere.
     */
    @Override
    public boolean hasRandomTicks(BlockState state) {
        return super.hasRandomTicks(state) || !state.get(HAS_FRUIT);
    }
}
