package net.cinderous.cinderbane.event;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cinderbane.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CinderousArmorLivingEquipmentChange {

    public static boolean walksOnLiquid = false;

    @SubscribeEvent

    public static void CinderousArmorLivingEquipmentChange(LivingEvent event) {

        if (event.getEntityLiving() != null) {

            LivingEntity livingEntity = event.getEntityLiving();
            World world = livingEntity.getEntityWorld();
            if (!world.isRemote & livingEntity instanceof ServerPlayerEntity) {


                //&& livingEntity.getActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get()) != null
                for (ItemStack armor : livingEntity.getArmorInventoryList()) {

                    if (livingEntity.hasItemInSlot(EquipmentSlotType.FEET)) {
                        if (armor.getItem() != RegistryHandler.LAVA_WALKERS.get()) {
                            //livingEntity.removePotionEffect((RegistryHandler.LAVA_WALKERS_EFFECT.get()));
                            walksOnLiquid = false;
                        }
                    }
                    if (armor.getItem() == RegistryHandler.LAVA_WALKERS.get()) {
                       // livingEntity.addPotionEffect(new EffectInstance(RegistryHandler.LAVA_WALKERS_EFFECT.get(), 1, 255));
                        walksOnLiquid = true;
                    }
                    if (livingEntity.hasItemInSlot(EquipmentSlotType.FEET)) {
                        if (armor.getItem() != RegistryHandler.WATER_STRIDERS.get() && walksOnLiquid) {
                           // livingEntity.removePotionEffect((RegistryHandler.LAVA_WALKERS_EFFECT.get()));
                            walksOnLiquid = false;
                        }
                    }
                    if (armor.getItem() == RegistryHandler.WATER_STRIDERS.get() && !walksOnLiquid) {
                        walksOnLiquid = true;
                       // livingEntity.addPotionEffect(new EffectInstance(RegistryHandler.LAVA_WALKERS_EFFECT.get(), 10000, 255));
                    }


                }
            }
        }
    }
}