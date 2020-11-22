package net.cinderous.cinderbane.client.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.cinderous.cinderbane.entity.HyphinityWisp;
import net.cinderous.cinderbane.entity.LavaSquid;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

import java.util.Arrays;

public class HyphinityWispModel<T extends HyphinityWisp> extends EntityModel<T> {
    private final ModelRenderer VoxelGroup;
    private final ModelRenderer Head;
    private final ModelRenderer Orbs;

    public HyphinityWispModel() {
        textureWidth = 16;
        textureHeight = 16;

        VoxelGroup = new ModelRenderer(this);
        VoxelGroup.setRotationPoint(0.0F, 24.0F, 0.0F);


        Head = new ModelRenderer(this);
        Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        VoxelGroup.addChild(Head);
        Head.setTextureOffset(0, 8).addBox(-2.0F, -12.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        Orbs = new ModelRenderer(this);
        Orbs.setRotationPoint(0.0F, 0.0F, 0.0F);
        VoxelGroup.addChild(Orbs);
        Orbs.setTextureOffset(12, 14).addBox(-1.0F, -14.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Orbs.setTextureOffset(12, 14).addBox(4.0F, -10.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Orbs.setTextureOffset(0, 0).addBox(-1.0F, -11.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Orbs.setTextureOffset(12, 14).addBox(-1.0F, -11.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Orbs.setTextureOffset(12, 14).addBox(-6.0F, -11.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        Orbs.setTextureOffset(12, 14).addBox(0.0F, -6.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        VoxelGroup.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}