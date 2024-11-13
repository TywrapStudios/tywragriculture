package net.tywrapstudios.agriculture.util.datagen;

import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.loader.FabricLoader;
import net.fabricmc.loader.impl.FabricLoaderImpl;
import net.minecraft.resource.ResourceType;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.util.datagen.*;

public class TywragricultureDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		//ExistingFileHelper helper = ExistingFileHelper.withResources();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);

		//Tywragriculture.REGISTRATE.setupDatagen(pack, helper);
	}
}
