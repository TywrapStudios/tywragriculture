package net.tywrapstudios.agriculture.resources;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.tywrapstudios.agriculture.Tywragriculture;

public enum BlockTags {
    KITCHEN(of("kitchen")),
    FD_INSPIRED(of("fd_inspired"));

    private final TagKey<Block> blockTagKey;

    BlockTags(TagKey<Block> blockTagKey) {
        this.blockTagKey = blockTagKey;
    }

    public TagKey<Block> get() {
        return blockTagKey;
    }

    private static TagKey<Block> of(String tagName) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(Tywragriculture.MOD_ID, tagName));
    }
}
