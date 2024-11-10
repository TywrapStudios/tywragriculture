package net.tywrapstudios.agriculture.util.datagen;

import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.util.datagen.*;

public class TywragricultureDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);

		//ExistingFileHelper helper = ExistingFileHelper.standard();
		//Tywragriculture.REGISTRATE.setupDatagen(pack, helper);
	}
}
