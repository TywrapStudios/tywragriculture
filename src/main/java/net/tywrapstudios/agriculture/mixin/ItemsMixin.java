package net.tywrapstudios.agriculture.mixin;

import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(Items.class)
public abstract class ItemsMixin {
	@Redirect(
		method = "<clinit>",
		at = @At(value = "NEW", target = "(Lnet/minecraft/item/Item$Settings;)Lnet/minecraft/item/Item;"),
		slice = @Slice(
			from = @At(value = "CONSTANT", args = "stringValue=golden_carrot")
		)
	)
	private static Item agriculture$makeGoldenCarrotAliased(Item.Settings settings) {
		return new Item((new Item.Settings()).food(FoodComponents.GOLDEN_CARROT));
		//return new AliasedBlockItem(BlockRegistry.GOLD_CARROT.get(), (new Item.Settings()).food(FoodComponents.GOLDEN_CARROT));
	}
}
	