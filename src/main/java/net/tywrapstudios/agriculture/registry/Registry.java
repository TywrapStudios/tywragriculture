package net.tywrapstudios.agriculture.registry;

import com.tterrag.registrate.Registrate;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.tywrapstudios.agriculture.content.command.AgricultureCommand;

import static net.tywrapstudios.agriculture.Tywragriculture.LOGGING;
import static net.tywrapstudios.agriculture.content.block.BlockEntities.registerBlockEntities;
import static net.tywrapstudios.agriculture.registry.BlockRegistry.registerBlocks;
import static net.tywrapstudios.agriculture.registry.Fuels.registerFuels;
import static net.tywrapstudios.agriculture.registry.ItemGroupRegistry.registerItemGroups;
import static net.tywrapstudios.agriculture.registry.ItemRegistry.registerItems;
import static net.tywrapstudios.agriculture.screen.ScreenHandlers.registerScreenHandlers;

public class Registry {
    public static void registerAll(Registrate REGISTRATE) {
        registerItems(REGISTRATE);
        registerBlocks(REGISTRATE);
        registerBlockEntities(REGISTRATE);
        registerScreenHandlers(REGISTRATE);
        registerFuels();
        registerItemGroups(REGISTRATE);
        registerCommands();

        REGISTRATE.register();
        LOGGING.debug("General REGISTRATE has been registered.");
    }

    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, registrationEnvironment) -> AgricultureCommand.register(dispatcher));
        LOGGING.debug("Commands have been registered.");
    }
}
