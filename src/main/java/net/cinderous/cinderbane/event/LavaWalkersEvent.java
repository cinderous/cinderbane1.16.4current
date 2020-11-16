package net.cinderous.cinderbane.event;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cinderbane.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LavaWalkersEvent {

    public static boolean speedAchieved = false;



    @SubscribeEvent
    public static void LavaWalkersEvent(LivingEvent event) {
        if (event.getEntityLiving() != null) {
            LivingEntity livingEntity = event.getEntityLiving();
            World world = livingEntity.getEntityWorld();
            if (livingEntity.getActivePotionEffect(RegistryHandler.LAVA_WALKERS_EFFECT.get()) != null) {

                BlockPos checkingPos = livingEntity.getPosition();
                int z;
                for (z = 0; z<= 7; ++z) {
                    int x;
                    for (x=0; x<= 7; ++x) {
                        if (world.getBlockState(checkingPos.east(x).south(z).down()) == Blocks.LAVA.getDefaultState()) {
                            world.setBlockState(checkingPos.east(x).south(z), RegistryHandler.BASALT_SHEET.get().getDefaultState());
                        }
                    }
                }

//                world.getBlockState(livingEntity.getPosition()) == Blocks.AIR.getDefaultState();
//
//                if (world.getBlockState(livingEntity.getPosition()) == Blocks.AIR.getDefaultState() || world.getBlockState(livingEntity.getPosition()) == Blocks.WATER.getDefaultState()) {
//                    //checking to ensure they are not submerged under water
//                    if (world.getBlockState(livingEntity.getPosition().up(2)) != Blocks.LAVA.getDefaultState()) {
//
//                        world.setBlockState(livingEntity.getPosition(), RegistryHandler.BASALT_SHEET.get().getDefaultState());
//                    }
//                }
            }
        }
    }
}
