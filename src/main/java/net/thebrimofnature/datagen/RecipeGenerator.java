package net.thebrimofnature.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thebrimofnature.The_Brim_Of_Nature;
import net.thebrimofnature.recipe.Alloyery_Enchanter_RecipeJsonBuilder;

import java.util.function.Consumer;

import static net.thebrimofnature.registry.TheBrimOfNatureBlockRegistry.*;
import static net.thebrimofnature.registry.TheBrimOfNatureItemRegistry.*;

public class RecipeGenerator extends FabricRecipeProvider {
	public RecipeGenerator(FabricDataOutput generator) {
		super(generator);
	}

	@Override
	public void generate(Consumer<RecipeJsonProvider> exporter) {
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ENDERLITE, 4)
				.input(ENDERLITE_BLOCK)
				.criterion(FabricRecipeProvider.hasItem(ENDERLITE_BLOCK),
						FabricRecipeProvider.conditionsFromItem(ENDERLITE_BLOCK))
				.offerTo(exporter, getRecipeName(ENDERLITE));

		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ENDERLITE_BLOCK, 1)
				.pattern("bb")
				.pattern("bb")
				.input('b', ENDERLITE)
				.criterion(FabricRecipeProvider.hasItem(ENDERLITE),
						FabricRecipeProvider.conditionsFromItem(ENDERLITE))
				.offerTo(exporter, getRecipeName(ENDERLITE_BLOCK));

		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, GLIMMERSTEEL_INGOT, 4)
				.input(GLIMMER_INGOT_BLOCK)
				.criterion(FabricRecipeProvider.hasItem(GLIMMER_INGOT_BLOCK),
						FabricRecipeProvider.conditionsFromItem(GLIMMER_INGOT_BLOCK))
				.offerTo(exporter, getRecipeName(GLIMMERSTEEL_INGOT));

		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GLIMMER_INGOT_BLOCK, 1)
				.pattern("bb")
				.pattern("bb")
				.input('b', GLIMMERSTEEL_INGOT)
				.criterion(FabricRecipeProvider.hasItem(GLIMMERSTEEL_INGOT),
						FabricRecipeProvider.conditionsFromItem(GLIMMERSTEEL_INGOT))
				.offerTo(exporter, getRecipeName(GLIMMER_INGOT_BLOCK));

		Alloyery_Enchanter_RecipeJsonBuilder.create(RecipeCategory.MISC, GLIMMERSTEEL_INGOT, 1)
				.input(ENDERLITE)
				.input(GLIMMER_SHARD)
				.input(GLIMMER_SHARD)
				.input(GLIMMER_SHARD)
				.input(GLIMMER_SHARD)
				.criterion(FabricRecipeProvider.hasItem(ENDERLITE),
						FabricRecipeProvider.conditionsFromItem(ENDERLITE))
				.criterion(FabricRecipeProvider.hasItem(GLIMMER_SHARD),
						FabricRecipeProvider.conditionsFromItem(GLIMMER_SHARD))
				.offerTo(exporter, new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmersteel_ingot_alloyery_enchater_recipe"));

		//offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ENDERLITE, RecipeCategory.MISC, ENDERLITE_BLOCK);

		offerSmithingUpgradeRecipe(exporter, Items.ENCHANTING_TABLE, ENDERLITE, RecipeCategory.MISC, ALLOYERY_ENCHANTER_BLOCK.asItem());
		offerSmithingUpgradeRecipe(exporter, Items.NETHERITE_SWORD, GLIMMERSTEEL_INGOT, RecipeCategory.MISC, GLIMMERSTEEL_SWORD);
		offerSmithingUpgradeRecipe(exporter, Items.NETHERITE_AXE, GLIMMERSTEEL_INGOT, RecipeCategory.MISC, GLIMMERSTEEL_AXE);
		offerSmithingUpgradeRecipe(exporter, Items.NETHERITE_PICKAXE, GLIMMERSTEEL_INGOT, RecipeCategory.MISC, GLIMMERSTEEL_PICKAXE);
		offerSmithingUpgradeRecipe(exporter, Items.NETHERITE_HOE, GLIMMERSTEEL_INGOT, RecipeCategory.MISC, GLIMMERSTEEL_HOE);
		offerSmithingUpgradeRecipe(exporter, Items.NETHERITE_SHOVEL, GLIMMERSTEEL_INGOT, RecipeCategory.MISC, GLIMMERSTEEL_SHOVEL);
	}

	public static void offerSmithingUpgradeRecipe(Consumer<RecipeJsonProvider> exporter, Item input, Item material, RecipeCategory category, Item result, Item upgrade) {
		SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(upgrade),
						Ingredient.ofItems(input),
						Ingredient.ofItems(material), category, result)
				.criterion(hasItem(input), conditionsFromItem(input))
				.criterion(hasItem(material), conditionsFromItem(material))
				.offerTo(exporter, getRecipeName(result) + "_smithing");
	}

	public static void offerSmithingUpgradeRecipe(Consumer<RecipeJsonProvider> exporter, Item input, Item material, RecipeCategory category, Item result) {
		SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.AIR),
						Ingredient.ofItems(input),
						Ingredient.ofItems(material), category, result)
				.criterion(hasItem(input), conditionsFromItem(input))
				.criterion(hasItem(material), conditionsFromItem(material))
				.offerTo(exporter, getRecipeName(result) + "_smithing");
	}
}
