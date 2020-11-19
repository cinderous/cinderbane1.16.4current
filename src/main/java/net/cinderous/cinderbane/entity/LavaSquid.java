package net.cinderous.cinderbane.entity;

import net.cinderous.cinderbane.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class LavaSquid extends AnimalEntity {

    public LavaSquid(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);

    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.fromItems(Items.WHEAT), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

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
        return RegistryHandler.LAVA_SQUID.get().create(this.world);
    }

//    @Nullable
//    @Override
//    public AgeableEntity createChild(AgeableEntity ageable) {
//
//    }
//
//    public static AttributeModifierMap.MutableAttribute registerAttributeMap()
//    {
//        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.ARMOR, 16.0D).createMutableAttribute(Attributes.MAX_HEALTH, 35.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.24F);
//    }

    public static boolean canAnimalSpawn(EntityType<? extends AnimalEntity> animal, IWorld worldIn, SpawnReason reason, BlockPos pos, Random random) {
        return worldIn.getBlockState(pos.down()).isIn(Blocks.LAVA) && worldIn.getLightSubtracted(pos, 0) > 8;
    }



}