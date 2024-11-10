package net.tywrapstudios.agriculture.content.block;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.tywrapstudios.agriculture.content.block.crops.*;

public class BlockRegistry {

    public static RegistryEntry<BlackCarrotCrop> BLACK_CARROT;
    public static RegistryEntry<PurpleCarrotCrop> PURPLE_CARROT;
    public static RegistryEntry<GoldCarrotCrop> GOLD_CARROT;
    public static RegistryEntry<TomatoShrub> TOMATO_PLANT;
    public static RegistryEntry<SweetPotatoCrop> SWEET_POTATO;

    public static void registerModBlocks(Registrate REGISTRATE) {
        BLACK_CARROT = REGISTRATE.block("black_carrot_crop", p -> new BlackCarrotCrop(FabricBlockSettings
                .copyOf(Blocks.CARROTS)))
                .register();
        PURPLE_CARROT = REGISTRATE.block("purple_carrot_crop", p -> new PurpleCarrotCrop(FabricBlockSettings
                .copyOf(Blocks.CARROTS)))
                .register();
        GOLD_CARROT = REGISTRATE.block("gold_carrot_crop", p -> new GoldCarrotCrop(FabricBlockSettings
                .copyOf(Blocks.CARROTS)))
                .register();
        SWEET_POTATO = REGISTRATE.block("sweet_potato_crop", p -> new SweetPotatoCrop(FabricBlockSettings
                .copyOf(Blocks.POTATOES)))
                .register();

        registerFDInspiredBlocks(REGISTRATE);
    }

    public static void registerFDInspiredBlocks(Registrate REGISTRATE) {
        TOMATO_PLANT = REGISTRATE.block("tomato_shrub", p -> new TomatoShrub(FabricBlockSettings
                .copyOf(Blocks.SWEET_BERRY_BUSH)))
                .register();
    }
}
