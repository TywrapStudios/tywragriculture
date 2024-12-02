package net.tywrapstudios.agriculture.util.datagen;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import io.github.fabricators_of_create.porting_lib.models.generators.ConfiguredModel;
import io.github.fabricators_of_create.porting_lib.models.generators.block.VariantBlockStateBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;

public class DatagenBlockStateUtil {
    public static <T extends CropBlock> NonNullBiConsumer<DataGenContext<Block, T>, RegistrateBlockstateProvider> getCropBlockStateProvider() {
        return (ctx, provider) -> {
            T block = ctx.get();

            VariantBlockStateBuilder builder = provider.getVariantBuilder(block);

            builder.forAllStates(blockState -> {
                String path = String.format("block/%s/%s_stage%s", ctx.getName(), ctx.getName(),  blockState.get(CropBlock.AGE));

                return new ConfiguredModel[]{new ConfiguredModel(provider.models().crop(
                        path,
                        new Identifier(Tywragriculture.MOD_ID, path)))};});};
    }
}
