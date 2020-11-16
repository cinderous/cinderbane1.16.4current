package net.cinderous.cinderbane.event;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cinderbane.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CinderousArmorLivingEquipmentChange {

    public static boolean walksOnWater = false;

    @SubscribeEvent
    public static void CinderousArmorLivingEquipmentChange(LivingEvent event) {

        if (event.getEntityLiving() != null) {
            LivingEntity livingEntity = event.getEntityLiving();
            World world = livingEntity.getEntityWorld();

            //Iterable<ItemStack> stacks =

            for (ItemStack armor : livingEntity.getArmorInventoryList()) {
                //Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(armor);
                if (livingEntity.hasItemInSlot(EquipmentSlotType.FEET)) {
                    if (armor.getItem() != RegistryHandler.LAVA_WALKERS.get()) {
                        //livingEntity.removePotionEffect((RegistryHandler.LAVA_WALKERS_EFFECT.get()));
                        walksOnWater = false;
                    }
                }
                if (armor.getItem() == RegistryHandler.LAVA_WALKERS.get() && !walksOnWater) {
                    walksOnWater = true;
                   // livingEntity.addPotionEffect(new EffectInstance(RegistryHandler.LAVA_WALKERS_EFFECT.get(), 10000, 255));
                }


            }
        }


    }
}