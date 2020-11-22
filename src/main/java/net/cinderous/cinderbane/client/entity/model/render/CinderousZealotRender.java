package net.cinderous.cinderbane.client.entity.model.render;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.client.entity.model.CinderousZealotModel;
import net.cinderous.cinderbane.client.entity.model.HyphinityWispModel;
import net.cinderous.cinderbane.entity.CinderousZealot;
import net.cinderous.cinderbane.entity.HyphinityWisp;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CinderousZealotRender  extends MobRenderer<CinderousZealot, CinderousZealotModel<CinderousZealot>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Cinderbane.MODID,
            "textures/entities/cinderous_zealot.png");

    public CinderousZealotRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CinderousZealotModel<CinderousZealot>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(CinderousZealot entity) {
        return TEXTURE;
    }


}