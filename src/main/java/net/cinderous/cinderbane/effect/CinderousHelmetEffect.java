package net.cinderous.cinderbane.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class CinderousHelmetEffect extends Effect {

    public CinderousHelmetEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);

    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        //entityLivingBaseIn.addPotionEffect(new EffectInstance(Effects.SPEED, 500, 255));
        //entityLivingBaseIn.setGlowing(true);

    }


}