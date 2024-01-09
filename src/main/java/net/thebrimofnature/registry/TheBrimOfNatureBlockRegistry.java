package net.thebrimofnature.registry;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.thebrimofnature.The_Brim_Of_Nature;
import net.thebrimofnature.block.Alloyery_Enchanter_Block;
import net.thebrimofnature.block.Enderlite_Block;
import net.thebrimofnature.block.Glimmer_Block;
import net.thebrimofnature.block.Glimmer_Ingot_Block;

public class TheBrimOfNatureBlockRegistry {
 
    public static final Block ENDERLITE_BLOCK = new Enderlite_Block(FabricBlockSettings.create().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(10f, 20f).requiresTool());
    public static final Block ALLOYERY_ENCHANTER_BLOCK = new Alloyery_Enchanter_Block(FabricBlockSettings.create().sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(5f, 1200f).requiresTool().luminance((state) -> 7));
    public static final Block GLIMMER_BLOCK = new Glimmer_Block(FabricBlockSettings.create().sounds(BlockSoundGroup.ANCIENT_DEBRIS).strength(4f, 20f).requiresTool().luminance((state) -> 3));
    public static final BlockItem GLIMMER_BLOCK_ITEM = new BlockItem(GLIMMER_BLOCK, new FabricItemSettings());
    public static final Block GLIMMER_INGOT_BLOCK = new Glimmer_Ingot_Block(FabricBlockSettings.create().sounds(BlockSoundGroup.NETHERITE).strength(10f, 1200f).requiresTool().luminance((state) -> 2));

    public static void registering() {
        The_Brim_Of_Nature.LOGGER.info("Block registry...");
        Registry.register(Registries.BLOCK, new Identifier(The_Brim_Of_Nature.MOD_ID, "enderlite_block"), ENDERLITE_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(The_Brim_Of_Nature.MOD_ID, "enderlite_block"), new BlockItem(ENDERLITE_BLOCK, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier(The_Brim_Of_Nature.MOD_ID, "alloyery_enchanter"), ALLOYERY_ENCHANTER_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(The_Brim_Of_Nature.MOD_ID, "alloyery_enchanter"), new BlockItem(ALLOYERY_ENCHANTER_BLOCK, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmer_block"), GLIMMER_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmer_block"), GLIMMER_BLOCK_ITEM);

        Registry.register(Registries.BLOCK, new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmer_ingot_block"), GLIMMER_INGOT_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmer_ingot_block"), new BlockItem(GLIMMER_INGOT_BLOCK, new FabricItemSettings()));
    }
}