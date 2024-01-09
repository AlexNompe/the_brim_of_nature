package net.thebrimofnature;

import net.fabricmc.api.ModInitializer;

import net.thebrimofnature.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class The_Brim_Of_Nature implements ModInitializer {
	public static final String MOD_ID = "thebrimofnature";
    public static final Logger LOGGER = LoggerFactory.getLogger("the_brim_of_nature");

	@Override
	public void onInitialize() {
		TheBrimOfNatureBlockRegistry.registering();
		TheBrimOfNatureItemRegistry.registering();
		TheBrimOfNatureItemGroupRegistry.registering();
		TheBrimOfNatureRecipeRegistry.registering();
		//TheBrimOfNatureFeatureRegistry.registering();
		TheBrimOfNatureBlockEntityRegistry.registering();
		TheBrimOfNatureScreenHandlerRegistry.registering();
	}
}