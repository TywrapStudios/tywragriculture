package net.tywrapstudios.agriculture.mixin;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidDrainable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.tywrapstudios.agriculture.registry.BlockRegistry;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BucketItem.class)
public class BucketItemMixin extends Item {
    public BucketItemMixin(Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();
        BlockPos pos = context.getBlockPos();
        BlockState state = context.getWorld().getBlockState(pos);
        World world = context.getWorld();
        assert player != null;
        ItemStack itemStack = player.getStackInHand(hand);
        if (state.getBlock() == BlockRegistry.SINK.get() && !player.isSneaking()) {
            if (state.getBlock() instanceof FluidDrainable fluidDrainable) {
                ItemStack itemStack2 = fluidDrainable.tryDrainFluid(world, pos, state);
                if (!itemStack2.isEmpty()) {
                    player.incrementStat(Stats.USED.getOrCreateStat(Items.BUCKET));
                    fluidDrainable.getBucketFillSound().ifPresent((sound) -> player.playSound(sound, 1.0F, 1.0F));
                    world.emitGameEvent(player, GameEvent.FLUID_PICKUP, pos);
                    ItemUsage.exchangeStack(itemStack, player, itemStack2);
                    if (!world.isClient) {
                        Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity) player, itemStack2);
                    }
                    return ActionResult.success(world.isClient());
                }
            }
        } else {
            return ActionResult.PASS;
        }
        return ActionResult.PASS;
    }
}
