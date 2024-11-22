package net.tywrapstudios.agriculture.recipe;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.recipe.recipes.MeatGrindingRecipe;

public class Recipes {
    public static void registerRecipes() {
        registerRecipe(MeatGrindingRecipe.Serializer.ID, MeatGrindingRecipe.Type.ID, MeatGrindingRecipe.Serializer.INSTANCE, MeatGrindingRecipe.Type.INSTANCE);
    }

    private static <T extends Recipe<SimpleInventory>> void registerRecipe(String serId, String typeId, RecipeSerializer<T> serInstance, RecipeType<T> typeInstance) {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Tywragriculture.MOD_ID, serId),
                serInstance);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Tywragriculture.MOD_ID, typeId),
                typeInstance);
    }
}
