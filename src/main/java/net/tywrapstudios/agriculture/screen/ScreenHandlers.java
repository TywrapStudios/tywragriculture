package net.tywrapstudios.agriculture.screen;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.MenuEntry;
import net.tywrapstudios.agriculture.screen.screens.MeatGrinderScreen;
import net.tywrapstudios.agriculture.screen.screens.MeatGrinderScreenHandler;
import net.tywrapstudios.agriculture.screen.screens.OvenScreen;
import net.tywrapstudios.agriculture.screen.screens.OvenScreenHandler;

import static net.tywrapstudios.agriculture.Tywragriculture.LOGGING;

public class ScreenHandlers {
    public static MenuEntry<MeatGrinderScreenHandler> MEAT_GRINDER_SCREEN;
    public static MenuEntry<OvenScreenHandler> OVEN_SCREEN;

    public static void registerScreenHandlers(Registrate REGISTRATE) {
        MEAT_GRINDER_SCREEN = REGISTRATE.menu("meat_grinder_gui",
                (type, syncId, playerInventory, buf) -> new MeatGrinderScreenHandler(syncId, playerInventory, buf),
                        () -> MeatGrinderScreen::new)
                .register();
        OVEN_SCREEN = REGISTRATE.menu("oven_gui",
                (type, syncId, playerInventory, buf) -> new OvenScreenHandler(syncId, playerInventory),
                        () -> OvenScreen::new)
                .register();

        LOGGING.debug("ScreenHandlers have been registered.");
    }
}
