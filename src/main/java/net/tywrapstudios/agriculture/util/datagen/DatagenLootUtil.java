package net.tywrapstudios.agriculture.util.datagen;

import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.block.CropBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.ExplosionDecayLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import org.jetbrains.annotations.NotNull;

public class DatagenLootUtil {
    public static @NotNull <T extends CropBlock> NonNullBiConsumer<RegistrateBlockLootTables, T> generateCropLoot(ItemConvertible seed, ItemConvertible drop, float minChance, float maxChance) {
        return (lootTables, crop) -> lootTables.addDrop(crop,
                LootTable.builder().pool(LootPool.builder()
                        .with(ItemEntry.builder(seed)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f))))
                        .with(ItemEntry.builder(drop)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minChance, maxChance)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 2))
                                .conditionally(BlockStatePropertyLootCondition.builder(crop)
                                        .properties(StatePredicate.Builder.create()
                                                .exactMatch(CropBlock.AGE, crop.getMaxAge()))))));
    }

    public static @NotNull <T extends CropBlock> NonNullBiConsumer<RegistrateBlockLootTables, T> generateItemLoot(ItemConvertible item, float count) {
        return (lootTables, crop) -> lootTables.addDrop(crop,
                LootTable.builder().pool(LootPool.builder()
                        .with(ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count))))));
    }

    public static @NotNull <T extends CropBlock> NonNullBiConsumer<RegistrateBlockLootTables, T> generateSingleItemLoot(ItemConvertible item) {
        return generateItemLoot(item, 1.0f);
    }

    public static LootTable.Builder getLootPoolForLeavesBlock(LeavesBlock block, ItemConvertible sapling, ItemConvertible extraBlockDrop) {
        return LootTable.builder()
                .pool(LootPool.builder()
                        .with(AlternativeEntry.builder()
                                .alternatively(ItemEntry.builder(block)
                                        .conditionally(AnyOfLootCondition.builder(
                                                MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                                        .items(Items.SHEARS)),
                                                MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                                        .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1))))
                                        )))
                                .alternatively(ItemEntry.builder(sapling)
                                        .conditionally(SurvivesExplosionLootCondition.builder())
                                        .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.05f, 0.0625f, 0.083333336f, 0.1f)))))
                .pool(LootPool.builder()
                        .conditionally(InvertedLootCondition.builder(AnyOfLootCondition.builder(
                                MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                        .items(Items.SHEARS)),
                                MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                        .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1))))
                        )))
                        .with(ItemEntry.builder(Items.STICK)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f), false))
                                .apply(ExplosionDecayLootFunction.builder())
                                .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f)))
                        .with(ItemEntry.builder(extraBlockDrop)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))
                                .apply(ExplosionDecayLootFunction.builder())
                                .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f))
                        ));
    }
}
