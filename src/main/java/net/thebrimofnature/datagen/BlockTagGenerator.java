package net.thebrimofnature.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.thebrimofnature.registry.TheBrimOfNatureBlockRegistry.*;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
	public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup arg) {
		getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
				.add(ALLOYERY_ENCHANTER_BLOCK)
				.add(ENDERLITE_BLOCK)
				.add(GLIMMER_BLOCK)
				.add(GLIMMER_INGOT_BLOCK);

		getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
				.add(ALLOYERY_ENCHANTER_BLOCK)
				.add(ENDERLITE_BLOCK)
				.add(GLIMMER_BLOCK);

		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
				.add(GLIMMER_INGOT_BLOCK);
	}
}
