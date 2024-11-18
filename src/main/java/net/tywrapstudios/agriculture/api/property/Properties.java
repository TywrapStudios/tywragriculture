package net.tywrapstudios.agriculture.api.property;

import net.minecraft.state.property.IntProperty;

/**
 * A Custom made class for now merely to add the {@code AGE_6} {@link IntProperty}.
 */
public class Properties {
    public static final IntProperty AGE_6;

    static {
        AGE_6 = IntProperty.of("age", 0, 6);
    }
}
