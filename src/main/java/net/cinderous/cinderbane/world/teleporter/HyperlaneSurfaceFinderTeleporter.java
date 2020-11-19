package net.cinderous.cinderbane.world.teleporter;

import net.cinderous.cinderbane.Cinderbane;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class HyperlaneSurfaceFinderTeleporter implements ITeleporter {

//this teleporter handlers a teleport back into the Overworld at 100 times the distance traveled, allowing for quick setups for interdimensional travel between two points.


    //Block safeblock;
    BlockPos pos;
    public static BlockPos finalizedPos;

    public HyperlaneSurfaceFinderTeleporter(BlockPos pos) {

        this.pos = pos;
        //this.safeblock = safeblock;


    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        groundFinder(destWorld, pos, entity);

        return repositionEntity.apply(false);

    }

    public static boolean groundFinder(World world, BlockPos pos, Entity entity) {
        if (!world.isRemote) {
            BlockPos startpos = new BlockPos(pos.getX(), world.getHeight(), pos.getZ());
            int yOffset;
            int air = 0;
            boolean isGround = false;


            int x;
            int startx = pos.getX();
            int sizex = 1000;
            for (x = startx; x < sizex; x++) {
                //Hyperlane.LOGGER.info("STARTING X " + x);

                int z;
                int startz = pos.getZ();
                int sizez = 1000;
                for (z = startz; z < sizez; z++) {
                    //Hyperlane.LOGGER.info("STARTING Z " + z);
                    int y;
                    int starty = 256;
                    int sizey = 0;
                    for (y = starty; y > sizey; y--) {
                        //Hyperlane.LOGGER.info("STARTING Y " + y);
                        BlockPos checkPos = new BlockPos(x, y, z);
                        if (world.getBlockState(checkPos) != Blocks.AIR.getDefaultState() && world.getBlockState(checkPos) != Blocks.VOID_AIR.getDefaultState()) {

                            finalizedPos =  checkPos;

                            Cinderbane.LOGGER.info(world.getBlockState(finalizedPos));
                            isGround = true;

                        }

                        if (isGround) {
                            Cinderbane.LOGGER.info(finalizedPos.getY() + " THIS SHOULD BE WHERE YOU TELEPORT TO?");
                            entity.setPosition(finalizedPos.getX(), finalizedPos.getY() + 2, finalizedPos.getZ());
                            return true;
                        }


                    }
                }
            }

        } return false;
    }
}


