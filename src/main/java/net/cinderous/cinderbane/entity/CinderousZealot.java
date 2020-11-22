package net.cinderous.cinderbane.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class CinderousZealot extends AnimalEntity {

    public CinderousZealot(EntityType<? extends CinderousZealot> type, World worldIn) {
        super(type, worldIn);
//        this.rand.setSeed((long)this.getEntityId());
//        this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
    }

//    protected void registerGoals() {
//        this.goalSelector.addGoal(0, new LavaSquid.MoveRandomGoal(this));
//        this.goalSelector.addGoal(1, new LavaSquid.FleeGoal());
//    }

    public static AttributeModifierMap.MutableAttribute registerAttributeMap() {
        return MobEntity.func_233666_p_()

                .createMutableAttribute(Attributes.MAX_HEALTH, 40.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D);

    }


    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }
}