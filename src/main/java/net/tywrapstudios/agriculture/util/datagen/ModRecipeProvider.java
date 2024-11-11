package net.tywrapstudios.agriculture.util.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.registry.ItemRegistry;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemRegistry.PEAS.get(), 2)
                .input(ItemRegistry.PEA_SHELL.get());
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemRegistry.TOMATO_SEEDS.get(), 2)
                .input(ItemRegistry.TOMATOES.get());
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemRegistry.TOMATO_SEEDS.get(), 2)
                .input(ItemRegistry.ROTTEN_TOMATOES.get());
    }
}