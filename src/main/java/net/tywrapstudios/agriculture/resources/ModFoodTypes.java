package net.tywrapstudios.agriculture.resources;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodTypes {
    public static final FoodComponent BRIQUETTE_FOOD = registerFoodType(2, 0.2f,
            new StatusEffectInstance(StatusEffects.HUNGER, 120), 1f);
    public static final FoodComponent CAKE_SLICE_FOOD = registerFoodType(8, 0.2f);
    public static final FoodComponent STRAWBERRY = registerFoodType(2, 0.2f, true);
    public static final FoodComponent TOMATO = registerFoodType(3, 0.3f);
    public static final FoodComponent CARROT_PURPLE = registerFoodType(4, 0.3f);
    public static final FoodComponent CARROT_BLACK = registerFoodType(4, 0.3f);
    public static final FoodComponent CABBAGE = registerFoodType(3, 0.2f);
    public static final FoodComponent SWEET_POTATO = registerFoodType(5, 0.4f);
    public static final FoodComponent PINEAPPLE = registerFoodType(4, 0.4f);
    public static final FoodComponent WHITE_MELON = registerFoodType(5, 0.4f);
    public static final FoodComponent ORANGE_MELON = registerFoodType(5, 0.4f);

    private static FoodComponent registerFoodType(int hunger, float saturation) {
        return new FoodComponent.Builder()
                .hunger(hunger)
                .saturationModifier(saturation)
                .build();
    }

    private static FoodComponent registerFoodType(int hunger, float saturation, boolean fast) {
        return new FoodComponent.Builder()
                .hunger(hunger)
                .saturationModifier(saturation)
                .snack()
                .build();
    }

    private static FoodComponent registerFoodType(int hunger, float saturation, StatusEffectInstance effect,
            float chance) {
        return new FoodComponent.Builder()
                .hunger(hunger)
                .saturationModifier(saturation)
                .statusEffect(effect, chance)
                .build();
    }
}
