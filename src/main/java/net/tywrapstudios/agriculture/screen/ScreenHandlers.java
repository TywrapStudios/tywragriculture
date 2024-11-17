package net.tywrapstudios.agriculture.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.screen.screens.MeatGrinderScreenHandler;
import net.tywrapstudios.agriculture.util.logging.LoggingHandlers;

public class ScreenHandlers {
    public static final ScreenHandlerType<MeatGrinderScreenHandler> MEAT_GRINDER =
            create("meat_grinder_gui", MeatGrinderScreenHandler::new);

    private static <T extends ScreenHandler> ExtendedScreenHandlerType<T> create(String id, ExtendedScreenHandlerType.ExtendedFactory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(Tywragriculture.MOD_ID, id),
                new ExtendedScreenHandlerType<>(factory));
    }

    public static void register() {
        LoggingHandlers.debug("ScreenHandlers have been registered.");
    }
}
