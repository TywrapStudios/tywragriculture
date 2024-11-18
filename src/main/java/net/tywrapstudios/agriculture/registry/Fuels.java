package net.tywrapstudios.agriculture.registry;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.tywrapstudios.agriculture.util.logging.LoggingHandlers;

public class Fuels {
    public static void registerFuels() {
        FuelRegistry.INSTANCE.add(ItemRegistry.BRIQUETTE.get(), 1800);
        LoggingHandlers.debug("Fuels have been registered.");
    }
}
