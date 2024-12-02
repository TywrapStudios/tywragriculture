package net.tywrapstudios.agriculture.content.block.plants;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.api.crops.special.LeavesWithFruit;
import net.tywrapstudios.agriculture.api.property.Propertiess;
import net.tywrapstudios.agriculture.config.TywragricultureConfig;
import net.tywrapstudios.agriculture.registry.ItemRegistry;

public class PineConeLeavesBlock extends LeavesWithFruit {
    public PineConeLeavesBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(Propertiess.HAS_FRUIT)) {
            return tryPickFruit(state,world,pos,ItemRegistry.PINE_CONE.get(),2);
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        TywragricultureConfig.WorldConfig world_config = Tywragriculture.CONFIG_MANAGER.getConfig().world_config;
        tickWithChance(state, world, pos, random, world_config.pine_cone_chance);
        super.randomTick(state, world, pos, random);
    }
}
