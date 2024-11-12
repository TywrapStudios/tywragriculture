package net.tywrapstudios.agriculture.mixin;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResult;
import net.tywrapstudios.agriculture.registry.BlockRegistry;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;


@Debug(export = true)
@Mixin(GlassBottleItem.class)
public abstract class GlassBottleItemMixin extends Item {
    public GlassBottleItemMixin(Settings settings) {
        super(settings);
    }

    @Shadow protected abstract ItemStack fill(ItemStack stack, PlayerEntity player, ItemStack outputStack);

    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemStack itemStack = context.getStack();
        ItemStack itemStack1 = PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER);
        Block block = context.getWorld().getBlockState(context.getBlockPos()).getBlock();
        PlayerEntity playerEntity = context.getPlayer();
        assert playerEntity != null;
        if (block == BlockRegistry.SINK.get() && !playerEntity.isSneaking()) {
            fill(itemStack, playerEntity, itemStack1);
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }
}
