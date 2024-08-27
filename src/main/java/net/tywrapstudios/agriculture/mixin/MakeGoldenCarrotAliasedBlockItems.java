package net.tywrapstudios.agriculture.mixin;

import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.tywrapstudios.agriculture.common.block.BlockRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(Items.class)
public abstract class MakeGoldenCarrotAliasedBlockItems {
	@Redirect(
			method = "<clinit>",
			at = @At(value = "NEW", target = "(Lnet/minecraft/item/Item$Settings;)Lnet/minecraft/item/Item;"),
			slice = @Slice(
					from = @At(value = "CONSTANT", args = "stringValue=golden_carrot")
			)
	)
	private static Item agriculture$makeGoldenCarrotAliased(Item.Settings settings) {
		return new AliasedBlockItem(BlockRegistry.GOLD_CARROT, (new Item.Settings()).food(FoodComponents.GOLDEN_CARROT));
	}
}
	