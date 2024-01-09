package net.thebrimofnature.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.thebrimofnature.The_Brim_Of_Nature;

import java.util.Optional;

import static net.thebrimofnature.registry.TheBrimOfNatureBlockRegistry.*;
import static net.thebrimofnature.registry.TheBrimOfNatureItemRegistry.*;

public class ModelGenerator extends FabricModelProvider {
	public ModelGenerator(FabricDataOutput generator) {
		super(generator);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		blockStateModelGenerator.registerSimpleCubeAll(ENDERLITE_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(GLIMMER_BLOCK);
		blockStateModelGenerator.registerSimpleCubeAll(GLIMMER_INGOT_BLOCK);
		//blockStateModelGenerator.registerSimpleCubeAll(ALLOYERY_ENCHANTER_BLOCK); Whenever custom models are involved, just turn around and do them manually

		//blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(Tutorial.MACHINE_BLOCK)
		//		.with(When.create().set(Properties.HORIZONTAL_FACING, Direction.NORTH),
		//				BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.X)));
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ENDERLITE, Models.GENERATED);
		itemModelGenerator.register(GLIMMER_SHARD, Models.GENERATED);
		itemModelGenerator.register(GLIMMERSTEEL_INGOT, Models.GENERATED);

		itemModelGenerator.register(GLIMMERSTEEL_SWORD, Models.HANDHELD);
		itemModelGenerator.register(GLIMMERSTEEL_AXE, Models.HANDHELD);
		itemModelGenerator.register(GLIMMERSTEEL_PICKAXE, Models.HANDHELD);
		itemModelGenerator.register(GLIMMERSTEEL_HOE, Models.HANDHELD);
		itemModelGenerator.register(GLIMMERSTEEL_SHOVEL, Models.HANDHELD);

		//itemModelGenerator.register(Item.fromBlock(ENDERLITE_BLOCK), Models.GENERATED); This doesn't work, give up, just do it manually...
		//itemModelGenerator.register(GLIMMER_BLOCK_ITEM, Models.GENERATED);
	}


}
