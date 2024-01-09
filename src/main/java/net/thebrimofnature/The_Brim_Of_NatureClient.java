package net.thebrimofnature;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.RenderLayer;
import net.thebrimofnature.block.entity.screen.Alloyery_Enchanter_Screen;
import net.thebrimofnature.client.renderer.block.Alloyery_Enchanter_BlockRenderer;
import net.thebrimofnature.registry.TheBrimOfNatureBlockEntityRegistry;
import net.thebrimofnature.registry.TheBrimOfNatureBlockRegistry;
import net.thebrimofnature.registry.TheBrimOfNatureScreenHandlerRegistry;
import software.bernie.example.client.renderer.block.GeckoHabitatBlockRenderer;
import software.bernie.example.registry.BlockEntityRegistry;

@Environment(EnvType.CLIENT)
public final class The_Brim_Of_NatureClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(TheBrimOfNatureBlockRegistry.ALLOYERY_ENCHANTER_BLOCK, RenderLayer.getCutout());

        BlockEntityRendererFactories.register(TheBrimOfNatureBlockEntityRegistry.ALLOYERY_ENCHANTER_BLOCK_ENTITY,
                context -> new Alloyery_Enchanter_BlockRenderer());

        HandledScreens.register(TheBrimOfNatureScreenHandlerRegistry.ALLOYERY_ENCHANTER_SCREENHANDLER, Alloyery_Enchanter_Screen::new);
    }
}