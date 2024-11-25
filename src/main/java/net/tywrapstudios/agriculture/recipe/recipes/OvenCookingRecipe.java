package net.tywrapstudios.agriculture.recipe.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.recipe.Recipes;

public class OvenCookingRecipe extends AbstractCookingRecipe {
    public OvenCookingRecipe(Identifier id, String group, CookingRecipeCategory category, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(Recipes.OVEN_COOKING_TYPE, id, group, category, input, output, experience, cookTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Recipes.OVEN_COOKING_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return Recipes.OVEN_COOKING_TYPE;
    }

    public static class Type implements RecipeType<OvenCookingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "oven_cooking";
    }

    public static class Serializer extends CookingRecipeSerializer<OvenCookingRecipe> {
        public static final Serializer INSTANCE = new Serializer(OvenCookingRecipe::new,200);
        public static final String ID = "oven_cooking";

        public Serializer(RecipeFactory<OvenCookingRecipe> recipeFactory, int cookingTime) {
            super(recipeFactory, cookingTime);
        }
    }
}
