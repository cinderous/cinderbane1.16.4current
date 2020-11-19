package net.cinderous.cinderbane.client.entity.model.render;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.client.entity.model.LavaSquidModel;
import net.cinderous.cinderbane.entity.LavaSquid;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class LavaSquidRender   extends MobRenderer<LavaSquid, LavaSquidModel<LavaSquid>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Cinderbane.MODID,
            "textures/entities/cinderling.png");

    public LavaSquidRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new LavaSquidModel<LavaSquid>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(LavaSquid entity) {
        return TEXTURE;
    }
}

