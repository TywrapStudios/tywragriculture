package net.tywrapstudios.agriculture.screen;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.MenuEntry;
import net.tywrapstudios.agriculture.screen.screens.MeatGrinderScreen;
import net.tywrapstudios.agriculture.screen.screens.MeatGrinderScreenHandler;

import static net.tywrapstudios.agriculture.Tywragriculture.LOGGING;

public class ScreenHandlers {
    public static MenuEntry<MeatGrinderScreenHandler> MEAT_GRINDER_SCREEN;

    public static void registerScreenHandlers(Registrate REGISTRATE) {
        MEAT_GRINDER_SCREEN = REGISTRATE.menu("meat_grinder_gui",
                (type, syncId, playerInventory, buf) -> new MeatGrinderScreenHandler(syncId, playerInventory, buf),
                        () -> MeatGrinderScreen::new)
                .register();


        LOGGING.debug("ScreenHandlers have been registered.");
    }
}
