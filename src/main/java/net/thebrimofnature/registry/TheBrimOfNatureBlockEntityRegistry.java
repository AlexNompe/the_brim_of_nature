package net.thebrimofnature.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thebrimofnature.The_Brim_Of_Nature;
import net.thebrimofnature.block.Alloyery_Enchanter_Block;
import net.thebrimofnature.block.entity.Alloyery_Enchanter_BlockEntity;
import software.bernie.example.block.entity.GeckoHabitatBlockEntity;
import software.bernie.example.registry.BlockRegistry;
import software.bernie.geckolib.GeckoLib;

public final class TheBrimOfNatureBlockEntityRegistry {
    public static final BlockEntityType<Alloyery_Enchanter_BlockEntity> ALLOYERY_ENCHANTER_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(Alloyery_Enchanter_BlockEntity::new, TheBrimOfNatureBlockRegistry.ALLOYERY_ENCHANTER_BLOCK).build(null);


    public static void registering() {
        The_Brim_Of_Nature.LOGGER.info("BlockEntity registry...");
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(The_Brim_Of_Nature.MOD_ID, "alloyery_enchanter"), ALLOYERY_ENCHANTER_BLOCK_ENTITY);
    }
}
