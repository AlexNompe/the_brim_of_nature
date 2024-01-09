package net.thebrimofnature.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.thebrimofnature.The_Brim_Of_Nature;
import net.thebrimofnature.item.Enderlite;
import net.thebrimofnature.item.Glimmer_Shard;
import net.thebrimofnature.item.Glimmersteel_Ingot;
import net.thebrimofnature.item.Glimmersteel_ToolMaterial;

public class TheBrimOfNatureItemRegistry {
    public static final Item ENDERLITE = new Enderlite(new FabricItemSettings());
    public static final Item GLIMMER_SHARD = new Glimmer_Shard(new FabricItemSettings());
    public static final Item GLIMMERSTEEL_INGOT = new Glimmersteel_Ingot(new FabricItemSettings());

    public static ToolItem GLIMMERSTEEL_SWORD = new SwordItem(Glimmersteel_ToolMaterial.INSTANCE, 3, -2.4F, new FabricItemSettings().fireproof());
    public static ToolItem GLIMMERSTEEL_AXE = new AxeItem(Glimmersteel_ToolMaterial.INSTANCE, 5, -3.0F, new FabricItemSettings().fireproof());
    public static ToolItem GLIMMERSTEEL_PICKAXE = new PickaxeItem(Glimmersteel_ToolMaterial.INSTANCE, 1, -2.8F, new FabricItemSettings().fireproof());
    public static ToolItem GLIMMERSTEEL_HOE = new HoeItem(Glimmersteel_ToolMaterial.INSTANCE, -5, 0.0F, new FabricItemSettings().fireproof());
    public static ToolItem GLIMMERSTEEL_SHOVEL = new ShovelItem(Glimmersteel_ToolMaterial.INSTANCE, 1.5F, -3.0F, new FabricItemSettings().fireproof());

    public static void registering() {
        The_Brim_Of_Nature.LOGGER.info("Item registry...");
        Registry.register(Registries.ITEM, new Identifier(The_Brim_Of_Nature.MOD_ID, "enderlite"), ENDERLITE);
        Registry.register(Registries.ITEM, new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmer_shard"), GLIMMER_SHARD);
        Registry.register(Registries.ITEM, new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmersteel_ingot"), GLIMMERSTEEL_INGOT);
        Registry.register(Registries.ITEM, new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmersteel_sword"), GLIMMERSTEEL_SWORD);
        Registry.register(Registries.ITEM, new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmersteel_axe"), GLIMMERSTEEL_AXE);
        Registry.register(Registries.ITEM, new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmersteel_pickaxe"), GLIMMERSTEEL_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmersteel_hoe"), GLIMMERSTEEL_HOE);
        Registry.register(Registries.ITEM, new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmersteel_shovel"), GLIMMERSTEEL_SHOVEL);
    }
}