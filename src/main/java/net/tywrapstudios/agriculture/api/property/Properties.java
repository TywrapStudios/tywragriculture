package net.tywrapstudios.agriculture.api.property;

import net.minecraft.state.property.IntProperty;
import net.tywrapstudios.agriculture.api.crops.aged.Age6CropBlock;

public class Properties {
    /**
     <p> I added the value AGE_6 and its other values respectively,
     <p> This is because the base code doesn't have this, but it was needed for {@link Age6CropBlock}
     */

    public static final IntProperty AGE_6;

    protected Properties() {
    }

    static {
        AGE_6 = IntProperty.of("age", 0, 6);
    }
}
