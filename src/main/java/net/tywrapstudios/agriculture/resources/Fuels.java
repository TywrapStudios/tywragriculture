package net.tywrapstudios.agriculture.resources;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.tywrapstudios.agriculture.registry.ItemRegistry;
import net.tywrapstudios.agriculture.util.logging.LoggingHandlers;

public class Fuels {
    public static void register() {
        FuelRegistry.INSTANCE.add(ItemRegistry.BRIQUETTE.get(), 1800);
        LoggingHandlers.debug("Fuels have been registered.");
    }
}
