package net.thebrimofnature.registry;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thebrimofnature.The_Brim_Of_Nature;
import net.thebrimofnature.recipe.Alloyery_Enchanter_Recipery;
import net.thebrimofnature.recipe.Alloyery_Enchanter_RecipeSerializer;

public class TheBrimOfNatureRecipeRegistry {

    public static final RecipeSerializer ALLOYERY_ENCHANTER_SERIALIZER = Alloyery_Enchanter_RecipeSerializer.INSTANCE;
    public static void registering() {
        The_Brim_Of_Nature.LOGGER.info("Recipe registry...");
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(The_Brim_Of_Nature.MOD_ID, Alloyery_Enchanter_RecipeSerializer.ID),
                ALLOYERY_ENCHANTER_SERIALIZER);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(The_Brim_Of_Nature.MOD_ID, Alloyery_Enchanter_Recipery.Type.ID),
                Alloyery_Enchanter_Recipery.Type.INSTANCE);
    }
}
