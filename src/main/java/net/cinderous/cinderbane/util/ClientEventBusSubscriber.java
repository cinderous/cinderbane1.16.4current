package net.cinderous.cinderbane.util;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.RegistryHandler;
import net.cinderous.cinderbane.client.entity.model.render.CinderousZealotRender;
import net.cinderous.cinderbane.client.entity.model.render.HyphinityWispRender;
import net.cinderous.cinderbane.client.entity.model.render.LavaSquidRender;

import net.cinderous.cinderbane.render.TesseractRender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Cinderbane.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {




    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent e) {
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.LAVA_SQUID.get(), LavaSquidRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.HYPHINITY_WISP.get(), HyphinityWispRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.CINDEROUS_ZEALOT.get(), CinderousZealotRender::new);

    }
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(RegistryHandler.CINDERBANE_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.CINDERKELP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.CINDERKELP_TOP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.CINDEROUS_TESSERACT.get(), RenderType.getCutout());

        ClientRegistry.bindTileEntityRenderer(RegistryHandler.CINDEROUS_TESSERACT_TILE_ENTITY.get(), TesseractRender::new);
    }






}