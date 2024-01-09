package net.thebrimofnature.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

import static net.thebrimofnature.registry.TheBrimOfNatureBlockRegistry.*;
import static net.thebrimofnature.registry.TheBrimOfNatureItemRegistry.*;

public class BlockLootTables extends FabricBlockLootTableProvider {
	public BlockLootTables(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		addDrop(ENDERLITE_BLOCK, drops(ENDERLITE_BLOCK));
		addDrop(ALLOYERY_ENCHANTER_BLOCK, drops(ALLOYERY_ENCHANTER_BLOCK));
		addDrop(GLIMMER_BLOCK, drops(GLIMMER_SHARD));
		addDrop(GLIMMER_INGOT_BLOCK, drops(GLIMMER_INGOT_BLOCK));
	}
}
