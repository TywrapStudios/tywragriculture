package net.tywrapstudios.agriculture.registry;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.util.logging.LoggingHandlers;

public class ItemGroupRegistry {

    public static void registerItemGroups(Registrate REGISTRATE) {
        final ItemGroup AGRICULTURE_MAIN = Registry.register(Registries.ITEM_GROUP,
                new Identifier(Tywragriculture.MOD_ID, "agriculture"), FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.agriculture.main"))
                        .icon(() -> new ItemStack(ItemRegistry.SWEET_POTATOES.get()))
                        .entries((displayContext, entries) -> {
                            for (RegistryEntry<Item> item : REGISTRATE.getAll(Registries.ITEM.getKey())) {
                                entries.add(item.get());
                            }
                        }).build());
        LoggingHandlers.debug("ItemGroup has been registered.");
    }
}
