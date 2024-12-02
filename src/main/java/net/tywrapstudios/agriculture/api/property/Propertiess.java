package net.tywrapstudios.agriculture.api.property;

import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;

/**
 * A Custom made class to add a few {@link Property}{@code 's} (wacko Grammar)
 * @author Tiazzz
 */
public class Propertiess extends Properties {
    public static final IntProperty AGE_6;

    public static final BooleanProperty HAS_FRUIT;

    static {
        AGE_6 = IntProperty.of("age", 0, 6);
        HAS_FRUIT = BooleanProperty.of("has_fruit");
    }
}
