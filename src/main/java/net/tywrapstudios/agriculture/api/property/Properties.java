package net.tywrapstudios.agriculture.api.property;

import net.minecraft.state.property.IntProperty;

public class Properties {
    /**
     <p> I custom added the value AGE_6 and its other values respectively,
     <p> This is because the original code didn't have this, but it was needed for {@link net.tywrapstudios.agriculture.api.agecropblocks.Age6CropBlock}
     */

    public static final IntProperty AGE_6;

    protected Properties() {
    }

    static {
        AGE_6 = IntProperty.of("age", 0, 6);
    }
}
