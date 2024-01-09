package net.thebrimofnature.registry;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.thebrimofnature.The_Brim_Of_Nature;
import net.thebrimofnature.block.entity.screenhandler.Alloyery_Enchanter_ScreenHandler;

public final class TheBrimOfNatureScreenHandlerRegistry {
    public static final ScreenHandlerType<Alloyery_Enchanter_ScreenHandler> ALLOYERY_ENCHANTER_SCREENHANDLER = new ExtendedScreenHandlerType<>(Alloyery_Enchanter_ScreenHandler::new);


    public static void registering() {
        The_Brim_Of_Nature.LOGGER.info("ScreenHandler registry...");
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(The_Brim_Of_Nature.MOD_ID, "alloyery_enchanter"), ALLOYERY_ENCHANTER_SCREENHANDLER);
    }
}
