package net.thebrimofnature.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import static net.thebrimofnature.registry.TheBrimOfNatureItemRegistry.*;

public class Glimmersteel_ToolMaterial implements ToolMaterial {

    public static final Glimmersteel_ToolMaterial INSTANCE = new Glimmersteel_ToolMaterial();
    @Override
    public int getDurability() {
        return 3600;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 11.0F;
    }

    @Override
    public float getAttackDamage() {
        return 5.0F;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(GLIMMERSTEEL_INGOT);
    }
}
