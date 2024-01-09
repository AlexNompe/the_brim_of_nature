package net.thebrimofnature.recipe;

import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.thebrimofnature.registry.TheBrimOfNatureRecipeRegistry;

public class Alloyery_Enchanter_Recipery implements Recipe<Inventory> {
    private final Identifier id;
    final ItemStack result;
    final CraftingRecipeCategory category;
    final DefaultedList<Ingredient> ingredients;

    public Alloyery_Enchanter_Recipery(Identifier id, CraftingRecipeCategory category, ItemStack result, DefaultedList<Ingredient> ingredients) {
        this.id = id;
        this.category = category;
        this.result = result;
        this.ingredients = ingredients;
    }

    @Override
    public RecipeSerializer<Alloyery_Enchanter_Recipery> getSerializer() {
        return TheBrimOfNatureRecipeRegistry.ALLOYERY_ENCHANTER_SERIALIZER;
    }

    @Override
    public RecipeType<Alloyery_Enchanter_Recipery> getType() {
        return Type.INSTANCE;
    }

    public DefaultedList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        RecipeMatcher recipeMatcher = new RecipeMatcher();
        int i = 0;

        for(int j = 0; j < inventory.size(); ++j) {
            ItemStack itemStack = inventory.getStack(j);
            if (!itemStack.isEmpty()) {
                ++i;
                recipeMatcher.addInput(itemStack, 1);
            }
        }

        return i == this.ingredients.size() && recipeMatcher.match(this, (IntList)null);
    }

    @Override
    public ItemStack craft(Inventory inventory, DynamicRegistryManager dynamicRegistryManager) {
        return this.result.copy();
    }

    public boolean fits(int width, int height) {
        return width * height >= this.ingredients.size();
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return this.result;
    }

    public static class Type implements RecipeType<Alloyery_Enchanter_Recipery> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "alloyery_enchanting";
    }
}
