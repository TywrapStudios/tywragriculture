package net.tywrapstudios.agriculture.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.recipe.recipes.MeatGrindingRecipe;

public class Recipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Tywragriculture.MOD_ID, MeatGrindingRecipe.Serializer.ID),
                MeatGrindingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Tywragriculture.MOD_ID, MeatGrindingRecipe.Type.ID),
                MeatGrindingRecipe.Type.INSTANCE);
    }
}
