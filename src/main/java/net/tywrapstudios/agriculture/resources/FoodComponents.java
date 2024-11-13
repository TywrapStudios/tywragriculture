package net.tywrapstudios.agriculture.resources;

import net.minecraft.item.FoodComponent;

public enum FoodComponents {
    CAKE_SLICE_FOOD(simple(8, 0.2f)),
    STRAWBERRY(simpleBuilder(2, 0.2f).snack().build()),
    TOMATO(simple(3, 0.3f)),
    CARROT_PURPLE(simple(4, 0.3f)),
    CARROT_BLACK(simple(4, 0.3f)),
    SWEET_POTATO(simple(5, 0.4f)),
    PINEAPPLE_SLICE(simple(4, 0.4f)),
    WHITE_MELON(simple(5, 0.4f)),
    ORANGE_MELON(simple(5, 0.4f));

    private final FoodComponent foodComponent;

    FoodComponents(FoodComponent foodComponent) {
        this.foodComponent = foodComponent;
    }

    public FoodComponent get() {
        return foodComponent;
    }

    private static FoodComponent simple(int hunger, float saturationModifier) {
        return simpleBuilder(hunger, saturationModifier).build();
    }

    private static FoodComponent.Builder simpleBuilder(int hunger, float saturationModifier) {
        return new FoodComponent.Builder().hunger(hunger).saturationModifier(saturationModifier);
    }
}
