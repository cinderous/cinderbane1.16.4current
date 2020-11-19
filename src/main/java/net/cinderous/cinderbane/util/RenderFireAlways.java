//package net.cinderous.cinderbane.util;
//
//import com.mojang.blaze3d.matrix.MatrixStack;
//import com.mojang.blaze3d.systems.RenderSystem;
//import net.cinderous.cinderbane.Cinderbane;
//import net.cinderous.cinderbane.RegistryHandler;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.entity.player.ClientPlayerEntity;
//import net.minecraft.client.gui.ScreenManager;
//import net.minecraft.client.renderer.*;
//import net.minecraft.client.renderer.model.ModelBakery;
//import net.minecraft.client.renderer.texture.TextureAtlasSprite;
//import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
//import net.minecraft.potion.EffectInstance;
//import net.minecraft.potion.Effects;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.math.MathHelper;
//import net.minecraft.util.math.vector.Matrix4f;
//import net.minecraft.util.math.vector.Vector3f;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.client.event.RenderWorldLastEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.client.registry.ClientRegistry;
//import net.minecraftforge.fml.client.registry.RenderingRegistry;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
//
//@Mod.EventBusSubscriber(modid = Cinderbane.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
//public class RenderFireAlways {
//    private static final ResourceLocation TEXTURE_CLEARVISION_OVERLAY = new ResourceLocation(Cinderbane.MODID, "textures/misc/cleavision_overlay.png");
//
//    @SubscribeEvent
//    public static void RenderFireAlways(final RenderWorldLastEvent event) {
//        Minecraft minecraft = Minecraft.getInstance();
//        MatrixStack matrixStackIn = new MatrixStack();
//        ClientPlayerEntity player = minecraft.player;
//        if (player == null) return;
//
//        EffectInstance effect = player.getActivePotionEffect(RegistryHandler.LAVA_WALKERS_EFFECT.get());
//        if (effect == null) return;
//
//        BufferBuilder bufferbuilder = Tessellator.getInstance().getBuffer();
//        RenderSystem.depthFunc(519);
//        RenderSystem.depthMask(false);
//        RenderSystem.enableBlend();
//        RenderSystem.defaultBlendFunc();
//        RenderSystem.enableTexture();
//        TextureAtlasSprite textureatlassprite = ModelBakery.LOCATION_FIRE_1.getSprite();
//        minecraft.getTextureManager().bindTexture(textureatlassprite.getAtlasTexture().getTextureLocation());
//        float f = textureatlassprite.getMinU();
//        float f1 = textureatlassprite.getMaxU();
//        float f2 = (f + f1) / 2.0F;
//        float f3 = textureatlassprite.getMinV();
//        float f4 = textureatlassprite.getMaxV();
//        float f5 = (f3 + f4) / 2.0F;
//        float f6 = textureatlassprite.getUvShrinkRatio();
//        float f7 = MathHelper.lerp(f6, f, f2);
//        float f8 = MathHelper.lerp(f6, f1, f2);
//        float f9 = MathHelper.lerp(f6, f3, f5);
//        float f10 = MathHelper.lerp(f6, f4, f5);
//        float f11 = 1.0F;
//
//        for(int i = 0; i < 2; ++i) {
//            matrixStackIn.push();
//            float f12 = -0.5F;
//            float f13 = 0.5F;
//            float f14 = -0.5F;
//            float f15 = 0.5F;
//            float f16 = -0.5F;
//            matrixStackIn.translate((double)((float)(-(i * 2 - 1)) * 0.24F), (double)-0.3F, 0.0D);
//            matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float)(i * 2 - 1) * 10.0F));
//            Matrix4f matrix4f = matrixStackIn.getLast().getMatrix();
//            bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR_TEX);
//            bufferbuilder.pos(matrix4f, -0.5F, -0.5F, -0.5F).color(1.0F, 1.0F, 1.0F, 0.9F).tex(f8, f10).endVertex();
//            bufferbuilder.pos(matrix4f, 0.5F, -0.5F, -0.5F).color(1.0F, 1.0F, 1.0F, 0.9F).tex(f7, f10).endVertex();
//            bufferbuilder.pos(matrix4f, 0.5F, 0.5F, -0.5F).color(1.0F, 1.0F, 1.0F, 0.9F).tex(f7, f9).endVertex();
//            bufferbuilder.pos(matrix4f, -0.5F, 0.5F, -0.5F).color(1.0F, 1.0F, 1.0F, 0.9F).tex(f8, f9).endVertex();
//            bufferbuilder.finishDrawing();
//            WorldVertexBufferUploader.draw(bufferbuilder);
//            matrixStackIn.pop();
//        }
//
//        RenderSystem.disableBlend();
//        RenderSystem.depthMask(true);
//        RenderSystem.depthFunc(515);
//    }
//}