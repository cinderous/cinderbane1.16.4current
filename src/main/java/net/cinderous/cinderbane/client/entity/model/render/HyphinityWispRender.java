package net.cinderous.cinderbane.client.entity.model.render;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.client.entity.model.HyphinityWispModel;
import net.cinderous.cinderbane.client.entity.model.LavaSquidModel;
import net.cinderous.cinderbane.entity.HyphinityWisp;
import net.cinderous.cinderbane.entity.LavaSquid;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HyphinityWispRender extends MobRenderer<HyphinityWisp, HyphinityWispModel<HyphinityWisp>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Cinderbane.MODID,
            "textures/entities/hyphinity_wisp.png");

    public HyphinityWispRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HyphinityWispModel<HyphinityWisp>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(HyphinityWisp entity) {
        return TEXTURE;
    }


}
