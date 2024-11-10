package net.tywrapstudios.agriculture.resources;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.tywrapstudios.agriculture.content.item.ItemRegistry;

public class Fuels {

    public static void addFuelType(Item item, Integer value) {
        FuelRegistry.INSTANCE.add(item, value);
    }

    public static void register() {
        addFuelType(ItemRegistry.BRIQUETTE.get(), 1800);
    }
}
