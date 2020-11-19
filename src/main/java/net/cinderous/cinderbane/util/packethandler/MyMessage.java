package net.cinderous.cinderbane.util.packethandler;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.event.WaterStridersEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class MyMessage{

    private int index;

    private BlockPos pos;

    private boolean speedAchieved;



//    public MyMessage(int index) {
//
//        this.index = index;
//
//    }



    public MyMessage(BlockPos pos, Boolean speedAchieved) {

        //this.index = index;

        this.pos = pos;

        this.speedAchieved = speedAchieved;



    }



    public void serialize(PacketBuffer buffer) {

        // buffer.writeInt(this.index);

        buffer.writeBlockPos(this.pos);

        buffer.writeBoolean(this.speedAchieved);




    }



    public static MyMessage deserialize(PacketBuffer buffer) {

        //int index = buffer.readInt();

        BlockPos pos = buffer.readBlockPos();

        Boolean speedAchieved = buffer.readBoolean();

        return new MyMessage(pos, speedAchieved);

    }



    public static boolean handle(MyMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        System.out.println(context.getDirection());
        boolean fail = true;
        Minecraft client = Minecraft.getInstance();
        //if (client.world.getWorld().isRemote()) fail = false;
        if (context.getDirection().getReceptionSide() == LogicalSide.SERVER) {
            context.enqueueWork(() -> {
                //do Stuff somewhere, anywhere at all


                World world = context.getSender().world;
                Cinderbane.LOGGER.info(world);
                if(!world.isRemote) {
                    LivingEntity livingEntity = world.getClosestPlayer(message.pos.getX(), message.pos.getY(), message.pos.getZ(), 5000,false);

                    Cinderbane.LOGGER.info("ACHIEVED THE REQUIRED SPEED TICKS");



                    WaterStridersEvent.teleportToHyphinity(livingEntity, message.speedAchieved);
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