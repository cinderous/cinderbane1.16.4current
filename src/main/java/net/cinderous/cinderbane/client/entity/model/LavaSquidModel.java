package net.cinderous.cinderbane.client.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.cinderous.cinderbane.entity.LavaSquid;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import java.util.Arrays;

public class LavaSquidModel  <T extends LavaSquid> extends SegmentedModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer[] legs = new ModelRenderer[8];
    private final ImmutableList<ModelRenderer> field_228296_f_;

    public LavaSquidModel() {
        int i = -16;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-6.0F, -8.0F, -6.0F, 12.0F, 16.0F, 12.0F);
        this.body.rotationPointY += 8.0F;

        for(int j = 0; j < this.legs.length; ++j) {
            this.legs[j] = new ModelRenderer(this, 48, 0);
            double d0 = (double)j * Math.PI * 2.0D / (double)this.legs.length;
            float f = (float)Math.cos(d0) * 5.0F;
            float f1 = (float)Math.sin(d0) * 5.0F;
            this.legs[j].addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F);
            this.legs[j].rotationPointX = f;
            this.legs[j].rotationPointZ = f1;
            this.legs[j].rotationPointY = 15.0F;
            d0 = (double)j * Math.PI * -2.0D / (double)this.legs.length + (Math.PI / 2D);
            this.legs[j].rotateAngleY = (float)d0;
        }

        ImmutableList.Builder<ModelRenderer> builder = ImmutableList.builder();
        builder.add(this.body);
        builder.addAll(Arrays.asList(this.legs));
        this.field_228296_f_ = builder.build();
    }

    /**
     * Sets this entity's model rotation angles
     */
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        for(ModelRenderer modelrenderer : this.legs) {
            modelrenderer.rotateAngleX = ageInTicks;
        }

    }

    public Iterable<ModelRenderer> getParts() {
        return this.field_228296_f_;
    }
}