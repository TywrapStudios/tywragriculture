package net.tywrapstudios.agriculture.resources;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;

public enum ItemTags {
    KNIVES(of("knives")),
    CONSUMABLES(of("consumables")),
    DRINKS(of("drinks")),
    FOODS(of("foods")),
    CUTTABLES(of("cuttables")),
    FD_INSPIRED(of("fd_inspired"));

    private final TagKey<Item> itemTagKey;

    ItemTags(TagKey<Item> itemTagKey) {
        this.itemTagKey = itemTagKey;
    }

    public TagKey<Item> get() {
        return itemTagKey;
    }

    private static TagKey<Item> of(String tagName) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(Tywragriculture.MOD_ID, tagName));
    }
}