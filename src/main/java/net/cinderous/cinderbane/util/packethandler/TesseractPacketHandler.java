package net.cinderous.cinderbane.util.packethandler;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.RegistryHandler;
import net.cinderous.cinderbane.event.WaterStridersEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class TesseractPacketHandler {


    private int tankAmount;




    public TesseractPacketHandler(int tankAmount) {


        this.tankAmount = tankAmount;


    }



    public void serialize(PacketBuffer buffer) {

        buffer.writeInt(this.tankAmount);

    }



    public static TesseractPacketHandler deserialize(PacketBuffer buffer) {


        int tankAmount = buffer.readInt();

        return new TesseractPacketHandler(tankAmount);

    }



    public static boolean handle(TesseractPacketHandler tesseractPacketHandler, Supplier<NetworkEvent.Context> contextSupplier) {
        Cinderbane.LOGGER.info("THIS SHOULD BE GOING OFF!!!!!!");
        NetworkEvent.Context context = contextSupplier.get();
        System.out.println(context.getDirection());
        boolean fail = true;
        Minecraft client = Minecraft.getInstance();

        if (context.getDirection().getReceptionSide() == LogicalSide.SERVER) {
            context.enqueueWork(() -> {



                World world = context.getSender().world;
                PlayerEntity player = context.getSender();
                Cinderbane.LOGGER.info(world);
                int tankAmountPacket = tesseractPacketHandler.tankAmount;
                if(!world.isRemote) {

                    ItemStack tesseractItemStack = new ItemStack (RegistryHandler.CINDEROUS_TESSERACT_ITEM.get(), 1);
                    int damageCalculation = 8000 + tesseractPacketHandler.tankAmount;
                    tesseractItemStack.setDamage(8000 + -tesseractPacketHandler.tankAmount);

                    Cinderbane.LOGGER.info(tesseractPacketHandler.tankAmount);
                    //tesseractItemStack.damageItem(tesseractPacketHandler.tankAmount, player, null);

                    player.addItemStackToInventory(tesseractItemStack);

                    //LivingEntity livingEntity = world.getClosestPlayer(message.pos.getX(), message.pos.getY(), message.pos.getZ(), 5000,false);

                    //Cinderbane.LOGGER.info("ACHIEVED THE REQUIRED SPEED TICKS");


                }

            });
        }

        return fail;
    }



    /*@OnlyIn(Dist.CLIENT)

    private static <T> T getEntity(World world, int id, Class<T> type) {

        Entity entity = world.getEntityByID(id);

        if (entity != null && type.isAssignableFrom(entity.getClass())) {

            return type.cast(entity);

        }

        return null;

    }*/

}