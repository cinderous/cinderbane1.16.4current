//package net.cinderous.cinderbane.util;
//
//import com.mojang.blaze3d.systems.RenderSystem;
//import net.cinderous.cinderbane.Cinderbane;
//import net.cinderous.cinderbane.RegistryHandler;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.material.Material;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.entity.player.ClientPlayerEntity;
//import net.minecraft.client.renderer.*;
//import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
//import net.minecraft.entity.Entity;
//import net.minecraft.potion.EffectInstance;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.vector.Vector3d;
//import net.minecraft.world.IWorldReader;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.client.event.RenderWorldLastEvent;
//import net.minecraftforge.common.extensions.IForgeBlock;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = Cinderbane.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
//public class ForgeRenderWorldEvent {
//    private static final ResourceLocation TEXTURE_CLEARVISION_OVERLAY = new ResourceLocation(Cinderbane.MODID, "textures/misc/cleavision_overlay.png");
//
//    @SubscribeEvent
//    public static void ForgeRenderWorldEvent(final RenderWorldLastEvent event) {
//        Minecraft minecraft = Minecraft.getInstance();
//
//        ClientPlayerEntity player = minecraft.player;
//        if (player == null) return;
//
//        EffectInstance effect = player.getActivePotionEffect(RegistryHandler.LAVA_WALKERS_EFFECT.get());
//        if (effect == null) return;
//
//        minecraft.getTextureManager().bindTexture(TEXTURE_CLEARVISION_OVERLAY);
//
//        BufferBuilder builder = Tessellator.getInstance().getBuffer();
//
//        RenderSystem.enableBlend();
//        RenderSystem.defaultBlendFunc();
//
//        // These values follow the values used in OverlayRenderer#renderUnderwater
//        float f7 = -minecraft.player.rotationYaw / 64.0F;
//        float f8 = minecraft.player.rotationPitch / 64.0F;
//
////        final float alpha = 0.2F * (effect.getAmplifier() + 1);
//        final float alpha = 0.1F + (0.3F * (effect.getAmplifier() + 1));
//        final float brightness = 1.0F;
//        final float zValue = -0.1F;
//
//        builder.begin(7, DefaultVertexFormats.POSITION_COLOR_TEX);
//
//        builder.pos(-1.0F, -1.0F, zValue).color(brightness, brightness, brightness, alpha).tex(4.0F + f7, 4.0F + f8).endVertex();
//        builder.pos(1.0F, -1.0F, zValue).color(brightness, brightness, brightness, alpha).tex(0.0F + f7, 4.0F + f8).endVertex();
//        builder.pos(1.0F, 1.0F, zValue).color(brightness, brightness, brightness, alpha).tex(0.0F + f7, 0.0F + f8).endVertex();
//        builder.pos(-1.0F, 1.0F, zValue).color(brightness, brightness, brightness, alpha).tex(4.0F + f7, 0.0F + f8).endVertex();
//
//        builder.finishDrawing();
//
//        WorldVertexBufferUploader.draw(builder);
//        RenderSystem.disableBlend();
//    }
//
//
//}