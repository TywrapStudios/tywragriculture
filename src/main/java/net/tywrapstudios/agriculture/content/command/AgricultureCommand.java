package net.tywrapstudios.agriculture.content.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.config.Config;
import net.tywrapstudios.agriculture.config.ConfigManager;
import net.tywrapstudios.agriculture.util.logging.LoggingHandlers;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class AgricultureCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("agriculture")
                .executes(AgricultureCommand::executePlain)
                .then(CommandManager.literal("reload")
                        .executes(AgricultureCommand::reload).requires((source) -> source.hasPermissionLevel(2)))
                .then(CommandManager.literal("dump_config")
                        .executes(AgricultureCommand::dumpConfig))
        );
    }

    private static int executePlain(@NotNull CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();
        boolean FD_LOADED = FabricLoader.getInstance().isModLoaded("farmersdelight");
        String message = String.format("""
                    ----[Tywragriculture]----
                    > Mod Version: %s
                    > Farmer's Delight loaded: %s
                    -----------------------""", Tywragriculture.MOD_VERSION, FD_LOADED);
        source.sendFeedback(() -> Text.literal(message).formatted(Formatting.GRAY), false);
        return 1;
    }

    private static int reload(@NotNull CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();
        if (Objects.equals(ConfigManager.config.format_version, Tywragriculture.CONFIG_FORMAT)) {
            source.sendFeedback(() -> Text.literal("[Tywragriculture] Reloading!").formatted(Formatting.GRAY), true);
            ConfigManager.reloadConfig(context);
        } else {
            source.sendFeedback(() -> Text.literal("[Tywragriculture] Could not reload Config: Format Version out of sync, please delete your config file and rerun Minecraft.") .formatted(Formatting.RED), false);
            LoggingHandlers.error("[Config] Your Config Version is out of Sync, please delete your config file and reload Minecraft.");
        }
        return 1;
    }

    private static int dumpConfig(@NotNull CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();
        String message = String.format("""
                    --------[Config]---------
                    %s
                    -----------------------""",
                ConfigManager.getConfigJsonAsString());
        source.sendFeedback(() -> Text.literal(message).formatted(Formatting.GRAY), false);
        return 1;
    }
}
