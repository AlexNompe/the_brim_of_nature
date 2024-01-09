package net.thebrimofnature.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.thebrimofnature.The_Brim_Of_Nature;

import static net.thebrimofnature.registry.TheBrimOfNatureBlockRegistry.*;
import static net.thebrimofnature.registry.TheBrimOfNatureItemRegistry.*;

public class TheBrimOfNatureItemGroupRegistry {
    private static final ItemGroup THEBRIMOFNATURE_ITEMGROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ENDERLITE))
            .displayName(Text.translatable("itemGroup.thebrimofnature.the_brim_of_nature"))
            .entries((context, entries) -> {
                entries.add(ENDERLITE);
                entries.add(ENDERLITE_BLOCK);
                entries.add(ALLOYERY_ENCHANTER_BLOCK);
                entries.add(GLIMMER_SHARD);
                entries.add(GLIMMERSTEEL_INGOT);
                entries.add(GLIMMER_BLOCK);
                entries.add(GLIMMER_INGOT_BLOCK);
                entries.add(GLIMMERSTEEL_SWORD);
                entries.add(GLIMMERSTEEL_AXE);
                entries.add(GLIMMERSTEEL_PICKAXE);
                entries.add(GLIMMERSTEEL_HOE);
                entries.add(GLIMMERSTEEL_SHOVEL);
            })
            .build();

    public static void registering() {
        The_Brim_Of_Nature.LOGGER.info("ItemGroup registry...");
        Registry.register(Registries.ITEM_GROUP, new Identifier(The_Brim_Of_Nature.MOD_ID, "the_brim_of_nature"), THEBRIMOFNATURE_ITEMGROUP);
    }
}
