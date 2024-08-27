package net.tywrapstudios.agriculture.common.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;

public class ModItemGroup {
    public static final ItemGroup AGRICULTURE_MAIN = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Tywragriculture.MOD_ID, "agriculture"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.agriculture"))
                    .icon(() -> new ItemStack(ItemRegistry.BRIQUETTE)).entries((displayContext, entries) -> {
                        entries.add(ItemRegistry.BRIQUETTE);
                        entries.add(ItemRegistry.STRAWBERRIES);
                        entries.add(ItemRegistry.CAKE_SLICE);
                        entries.add(ItemRegistry.TOMATOES);
                        entries.add(ItemRegistry.ROTTEN_TOMATOES);
                        entries.add(ItemRegistry.TOMATO_SEEDS);
                        entries.add(ItemRegistry.PURPLE_CARROT);
                        entries.add(ItemRegistry.BLACK_CARROT);
                        entries.add(Items.GOLDEN_CARROT);
                        entries.add(ItemRegistry.CABBAGES);
                        entries.add(ItemRegistry.SWEET_POTATOES);
                        entries.add(ItemRegistry.PINEAPPLE_SLICE);
                        entries.add(ItemRegistry.PINEAPPLES);
                    }).build());

    public static void registerItemGroup() {
    }
}
