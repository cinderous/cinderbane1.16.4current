package net.cinderous.cinderbane.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.cinderous.cinderbane.entity.CinderousZealot;
import net.cinderous.cinderbane.entity.HyphinityWisp;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class CinderousZealotModel<T extends CinderousZealot> extends EntityModel<T> {
    private final ModelRenderer VoxelGroup;
    private final ModelRenderer Head;
    private final ModelRenderer Arms;

    public CinderousZealotModel() {
        textureWidth = 64;
        textureHeight = 128;

        VoxelGroup = new ModelRenderer(this);
        VoxelGroup.setRotationPoint(0.0F, 24.0F, 0.0F);


        Head = new ModelRenderer(this);
        Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        VoxelGroup.addChild(Head);
        Head.setTextureOffset(40, 11).addBox(-2.0F, -21.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
        Head.setTextureOffset(41, 7).addBox(2.0F, -20.0F, -2.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
        Head.setTextureOffset(35, 1).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 13.0F, 6.0F, 0.0F, false);
        Head.setTextureOffset(38, 14).addBox(-3.0F, -4.0F, -3.0F, 5.0F, 4.0F, 6.0F, 0.0F, false);
        Head.setTextureOffset(33, 4).addBox(-7.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
        Head.setTextureOffset(38, 8).addBox(-18.0F, -2.0F, -1.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);

        Arms = new ModelRenderer(this);
        Arms.setRotationPoint(0.0F, 24.0F, 0.0F);
        Arms.setTextureOffset(36, 3).addBox(-1.0F, -17.0F, 3.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);
        Arms.setTextureOffset(0, 0).addBox(0.0F, -8.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        Arms.setTextureOffset(37, 2).addBox(-1.0F, -17.0F, -6.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);
        Arms.setTextureOffset(0, 0).addBox(0.0F, -8.0F, -6.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        VoxelGroup.render(matrixStack, buffer, packedLight, packedOverlay);
        Arms.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}