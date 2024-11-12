package net.tywrapstudios.agriculture.registry;

import com.tterrag.registrate.Registrate;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.tywrapstudios.agriculture.content.command.AgricultureCommand;
import net.tywrapstudios.agriculture.util.logging.LoggingHandlers;

public class Registry {
    public static void registerAll(Registrate REGISTRATE) {
        ItemRegistry.registerModItems(REGISTRATE);
        BlockRegistry.registerModBlocks(REGISTRATE);
        Fuels.register();
        ItemGroupRegistry.registerItemGroup(REGISTRATE);
        registerCommands();

        REGISTRATE.register();
        LoggingHandlers.debug("General REGISTRATE has been registered.");
    }

    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, registrationEnvironment) -> AgricultureCommand.register(dispatcher));
        LoggingHandlers.debug("Commands have been registered.");
    }
}
