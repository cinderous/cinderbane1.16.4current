package net.cinderous.cinderbane.render;

import com.mojang.blaze3d.systems.RenderSystem;
import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cinderbane.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class LavaFogControl {


    @SubscribeEvent
    public void onFogRender(EntityViewRenderEvent.FogDensity event) {
        Cinderbane.LOGGER.info("SHOULD BE WORKING?");
        Minecraft minecraft = Minecraft.getInstance();

        ClientPlayerEntity player = minecraft.player;
        if (player == null) return;

        World world = player.getEntityWorld();

        EffectInstance effect = player.getActivePotionEffect(RegistryHandler.LAVA_WALKERS_EFFECT.get());
        if (effect == null) return;
        if (player.isInLava() || player.isInWater()) {
            event.setDensity(0);
            event.setCanceled(true);
            Cinderbane.LOGGER.info("SHOULD BE CHANGING OVERLAY?");
        }
    }


}