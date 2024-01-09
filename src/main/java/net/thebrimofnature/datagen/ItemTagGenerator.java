package net.thebrimofnature.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

import static net.thebrimofnature.registry.TheBrimOfNatureBlockRegistry.*;
import static net.thebrimofnature.registry.TheBrimOfNatureBlockRegistry.GLIMMER_INGOT_BLOCK;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
	public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup arg) {

	}
}
