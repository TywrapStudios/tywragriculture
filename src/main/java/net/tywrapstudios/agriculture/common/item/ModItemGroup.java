package net.tywrapstudios.agriculture.common.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;
import static net.tywrapstudios.agriculture.common.item.ItemRegistry.*;

public class ModItemGroup {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Tywragriculture.MOD_ID, "agriculture"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.agriculture"))
                    .icon(() -> new ItemStack(BRIQUETTE)).entries((displayContext, entries) -> {
                        entries.add(BRIQUETTE);
                        entries.add(STRAWBERRIES);
                        entries.add(CAKE_SLICE);
                        entries.add(TOMATOES);
                        entries.add(ROTTEN_TOMATOES);
                        entries.add(PURPLE_CARROT);
                        entries.add(BLACK_CARROT);
                        entries.add(CABBAGES);
                        entries.add(SWEET_POTATOES);
                        entries.add(PINEAPPLE_SLICE);
                        entries.add(PINEAPPLES);
                    }).build());

    public static void registerItemGroup() {

    }
}
