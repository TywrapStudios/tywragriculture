package net.tywrapstudios.agriculture.content.block.plants;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tywrapstudios.agriculture.api.crops.special.ShrubLike;
import net.tywrapstudios.agriculture.registry.ItemRegistry;

public class TomatoShrub extends ShrubLike {
    public TomatoShrub(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return tryPickFruit(state, world, pos, player, hand, ItemRegistry.TOMATOES.get(), ItemRegistry.ROTTEN_TOMATOES.get());
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.TOMATO_SEEDS.get();
    }
}
