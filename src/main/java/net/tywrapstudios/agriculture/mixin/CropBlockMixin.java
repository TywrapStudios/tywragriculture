package net.tywrapstudios.agriculture.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.config.TywragricultureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

import static net.tywrapstudios.agriculture.Tywragriculture.LOGGING;

@Mixin(CropBlock.class)
public abstract class CropBlockMixin extends PlantBlock implements Fertilizable {
    @Shadow protected abstract IntProperty getAgeProperty();

    public CropBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockState oldState = world.getBlockState(pos);
        TywragricultureConfig config = Tywragriculture.CONFIG_MANAGER.getConfig();
        if (config.world_config.right_click_harvest && !player.getStackInHand(hand).isOf(Items.BONE_MEAL) && !player.isSneaking() && oldState.getBlock() instanceof CropBlock block) {
            if (block.isMature(oldState)) {
                try {
                    LootContextParameterSet.Builder builder = (new LootContextParameterSet.Builder(world.getServer().getWorld(world.getRegistryKey())).add(LootContextParameters.ORIGIN, Vec3d.ofCenter(pos)).add(LootContextParameters.TOOL, ItemStack.EMPTY));
                    List<ItemStack> oldItemStackList = oldState.getDroppedStacks(builder);
                    LOGGING.literalDebug(String.format("1 %s | %s", oldItemStackList, oldItemStackList.size()));
                    ItemStack cropItemStack = block.getPickStack(world, pos, oldState);
                    LOGGING.literalDebug(String.format("2 %s", cropItemStack));
                    oldItemStackList.remove(cropItemStack);
                    LOGGING.literalDebug(String.format("3 %s | %s", oldItemStackList, oldItemStackList.size()));
                    for (ItemStack itemStack : oldItemStackList) {
                        dropStack(world, pos, itemStack);
                        LOGGING.literalDebug(String.format("4 %s | %s", oldItemStackList, oldItemStackList.size()));
                    }
                    world.playSound(null, pos,
                            SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES,
                            SoundCategory.BLOCKS, 1f, 0.8f);
                    world.setBlockState(pos, state.with(getAgeProperty(), 0));
                    player.swingHand(hand);
                    return ActionResult.SUCCESS;
                } catch (NullPointerException e) {
                    LOGGING.debugWarning("When right clicking crops, NullPointerException was thrown. View the error stacktrace below for more information.");
                    e.printStackTrace();
                    return ActionResult.PASS;
                }
            }
        }
        return ActionResult.PASS;
    }
}
