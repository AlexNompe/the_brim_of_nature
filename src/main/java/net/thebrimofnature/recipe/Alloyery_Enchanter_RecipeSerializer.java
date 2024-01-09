package net.thebrimofnature.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.MapCodec.*;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.dynamic.Codecs.*;

import java.util.Iterator;
public class Alloyery_Enchanter_RecipeSerializer implements RecipeSerializer<Alloyery_Enchanter_Recipery> {
    public static final Alloyery_Enchanter_RecipeSerializer INSTANCE = new Alloyery_Enchanter_RecipeSerializer();
    public static final String ID = "alloyery_enchanting";

    public Alloyery_Enchanter_RecipeSerializer() {
    }

    @Override
    public Alloyery_Enchanter_Recipery read(Identifier identifier, JsonObject jsonObject) {
        String string = JsonHelper.getString(jsonObject, "group", "");
        CraftingRecipeCategory craftingRecipeCategory = (CraftingRecipeCategory)CraftingRecipeCategory.CODEC.byId(JsonHelper.getString(jsonObject, "category", (String)null), CraftingRecipeCategory.MISC);
        DefaultedList<Ingredient> defaultedList = getIngredients(JsonHelper.getArray(jsonObject, "ingredients"));
        if (defaultedList.isEmpty()) {
            throw new JsonParseException("No ingredients for shapeless recipe");
        } else if (defaultedList.size() > 7) {
            throw new JsonParseException("Too many ingredients for shapeless recipe");
        } else {
            ItemStack itemStack = ShapedRecipe.outputFromJson(JsonHelper.getObject(jsonObject, "result"));
            return new Alloyery_Enchanter_Recipery(identifier, craftingRecipeCategory, itemStack, defaultedList);
        }
    }

    private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
        DefaultedList<Ingredient> defaultedList = DefaultedList.of();

        for(int i = 0; i < json.size(); ++i) {
            Ingredient ingredient = Ingredient.fromJson(json.get(i), false);
            if (!ingredient.isEmpty()) {
                defaultedList.add(ingredient);
            }
        }

        return defaultedList;
    }

    public Alloyery_Enchanter_Recipery read(Identifier identifier, PacketByteBuf packetByteBuf) {
        String string = packetByteBuf.readString();
        CraftingRecipeCategory craftingRecipeCategory = (CraftingRecipeCategory)packetByteBuf.readEnumConstant(CraftingRecipeCategory.class);
        int i = packetByteBuf.readVarInt();
        DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i, Ingredient.EMPTY);

        for(int j = 0; j < defaultedList.size(); ++j) {
            defaultedList.set(j, Ingredient.fromPacket(packetByteBuf));
        }

        ItemStack itemStack = packetByteBuf.readItemStack();
        return new Alloyery_Enchanter_Recipery(identifier, craftingRecipeCategory, itemStack, defaultedList);
    }

    @Override
    public void write(PacketByteBuf packetByteBuf, Alloyery_Enchanter_Recipery recipe) {
        packetByteBuf.writeEnumConstant(recipe.category);
        packetByteBuf.writeVarInt(recipe.ingredients.size());
        Iterator var3 = recipe.ingredients.iterator();

        while(var3.hasNext()) {
            Ingredient ingredient = (Ingredient)var3.next();
            ingredient.write(packetByteBuf);
        }

        packetByteBuf.writeItemStack(recipe.result);
    }
}