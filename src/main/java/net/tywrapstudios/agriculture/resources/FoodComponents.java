package net.tywrapstudios.agriculture.resources;

import net.minecraft.item.FoodComponent;

public enum FoodComponents {
    CAKE_SLICE_FOOD(new FoodComponent.Builder().hunger(8).saturationModifier(0.2f).build()),
    STRAWBERRY(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).snack().build()),
    TOMATO(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build()),
    CARROT_PURPLE(new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).build()),
    CARROT_BLACK(new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).build()),
    SWEET_POTATO(new FoodComponent.Builder().hunger(5).saturationModifier(0.4f).build()),
    PINEAPPLE_SLICE(new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).build()),
    WHITE_MELON(new FoodComponent.Builder().hunger(5).saturationModifier(0.4f).build()),
    ORANGE_MELON(new FoodComponent.Builder().hunger(5).saturationModifier(0.4f).build());

    private final FoodComponent foodComponent;

    FoodComponents(FoodComponent foodComponent) {
        this.foodComponent = foodComponent;
    }

    public FoodComponent get() {
        return foodComponent;
    }
}
