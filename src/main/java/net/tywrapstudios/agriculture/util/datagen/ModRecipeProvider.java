package net.tywrapstudios.agriculture.util.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
//        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RUBY, 1)
//                .pattern("SSS")
//                .pattern("SRS")
//                .pattern("SSS")
//                .input('S', Items.STONE)
//                .input('R', ModItems.RUBY)
//                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
//                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
//                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_RUBY)));
    }
}