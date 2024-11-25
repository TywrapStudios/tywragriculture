package net.tywrapstudios.agriculture.recipe;

import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.recipe.recipes.MeatGrindingRecipe;
import net.tywrapstudios.agriculture.recipe.recipes.OvenCookingRecipe;

public class Recipes {
    public static RecipeSerializer<MeatGrindingRecipe> MEAT_GRINDING_SERIALIZER;
    public static RecipeType<MeatGrindingRecipe> MEAT_GRINDING_TYPE;
    public static RecipeSerializer<OvenCookingRecipe> OVEN_COOKING_SERIALIZER;
    public static RecipeType<OvenCookingRecipe> OVEN_COOKING_TYPE;

    public static void registerRecipes() {
        MEAT_GRINDING_SERIALIZER = registerSerializer(MeatGrindingRecipe.Serializer.ID, MeatGrindingRecipe.Serializer.INSTANCE);
        MEAT_GRINDING_TYPE = registerType(MeatGrindingRecipe.Type.ID, MeatGrindingRecipe.Type.INSTANCE);
        OVEN_COOKING_SERIALIZER = registerSerializer(OvenCookingRecipe.Serializer.ID, OvenCookingRecipe.Serializer.INSTANCE);
        OVEN_COOKING_TYPE = registerType(OvenCookingRecipe.Type.ID, OvenCookingRecipe.Type.INSTANCE);
    }

    private static <T extends Recipe<?>> RecipeSerializer<T> registerSerializer(String id, RecipeSerializer<T> serInstance) {
        return Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Tywragriculture.MOD_ID, id),
                serInstance);
    }

    private static <T extends Recipe<?>> RecipeType<T> registerType(String id, RecipeType<T> typeInstance) {
        return Registry.register(Registries.RECIPE_TYPE, new Identifier(Tywragriculture.MOD_ID, id),
                typeInstance);
    }
}
