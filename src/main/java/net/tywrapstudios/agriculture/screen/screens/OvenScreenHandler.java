package net.tywrapstudios.agriculture.screen.screens;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import net.tywrapstudios.agriculture.recipe.Recipes;
import net.tywrapstudios.agriculture.screen.ScreenHandlers;

public class OvenScreenHandler extends AbstractFurnaceScreenHandler {
    public OvenScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ScreenHandlers.OVEN_SCREEN.get(), Recipes.OVEN_COOKING_TYPE, RecipeBookCategory.FURNACE, syncId, playerInventory);
    }

    public OvenScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(ScreenHandlers.OVEN_SCREEN.get(), Recipes.OVEN_COOKING_TYPE, RecipeBookCategory.FURNACE, syncId, playerInventory, inventory, propertyDelegate);
    }
}
