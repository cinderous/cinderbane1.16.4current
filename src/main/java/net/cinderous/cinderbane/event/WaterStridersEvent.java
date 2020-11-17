package net.cinderous.cinderbane.event;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.RegistryHandler;
import net.cinderous.cinderbane.util.packethandler.MyMessage;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cinderbane.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WaterStridersEvent {

    public static boolean speedAchieved = false;
    public static int tick;



    @SubscribeEvent
    public static void WaterStridersEvent (LivingEvent event) {
        if (event.getEntityLiving() != null) {
            LivingEntity livingEntity = event.getEntityLiving();
            World world = livingEntity.getEntityWorld();
            if (livingEntity.getActivePotionEffect(RegistryHandler.WATER_STRIDERS_EFFECT.get()) != null) {

                BlockPos checkingPos = livingEntity.getPosition();

                int z;
                for (z = 0; z<= 7; ++z) {
                    int x;
                    for (x=0; x<= 7; ++x) {
                        if (world.getBlockState(checkingPos.down()) == Blocks.WATER.getDefaultState() && world.getBlockState(checkingPos.down().north(1)) == Blocks.WATER.getDefaultState() && world.getBlockState(checkingPos.up()) == Blocks.AIR.getDefaultState() ) {
                            world.setBlockState(checkingPos.up(), RegistryHandler.HYPERLANE_GEL_SHEET.get().getDefaultState());
                            world.setBlockState(checkingPos, RegistryHandler.HYPERLANE_GEL_BLOCK.get().getDefaultState());
                            //livingEntity.addVelocity(0,.11,0);
                        }
                    }
                }
                if (Math.sqrt(Math.pow(livingEntity.getMotion().getX(), 2) + Math.pow(livingEntity.getMotion().getZ(), 2)) > 5 ) {

                        tick++;
                        Cinderbane.LOGGER.info(tick);
                        if (tick == 75) {
                            speedAchieved = true;
                            BlockPos playerPos = livingEntity.getPosition();
                            MyMessage message = (new MyMessage(playerPos ,speedAchieved));

                            Cinderbane.INSTANCE.sendToServer(message);
                            tick=0;

                        }

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

