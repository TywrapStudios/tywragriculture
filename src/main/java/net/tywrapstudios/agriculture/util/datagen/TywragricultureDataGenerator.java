package net.tywrapstudios.agriculture.util.datagen;

import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.tywrapstudios.agriculture.Tywragriculture;
import net.tywrapstudios.agriculture.util.datagen.*;

import java.nio.file.Path;

public class TywragricultureDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		ExistingFileHelper helper = ExistingFileHelper.withResourcesFromArg();
		Tywragriculture.REGISTRATE.setupDatagen(pack, helper);
	}
}