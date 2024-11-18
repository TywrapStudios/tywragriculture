package net.tywrapstudios.agriculture.registry;

import net.fabricmc.fabric.api.registry.FuelRegistry;

import static net.tywrapstudios.agriculture.Tywragriculture.LOGGING;

public class Fuels {
    public static void registerFuels() {
        FuelRegistry.INSTANCE.add(ItemRegistry.BRIQUETTE.get(), 1800);
        LOGGING.debug("Fuels have been registered.");
    }
}
