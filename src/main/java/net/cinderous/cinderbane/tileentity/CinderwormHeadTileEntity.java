package net.cinderous.cinderbane.tileentity;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.rmi.registry.Registry;
import java.util.Random;

public class CinderwormHeadTileEntity extends TileEntity implements ITickableTileEntity {

    private int ticks;
    private boolean isHungry = false;
    private BlockState currentFood;
    public BlockPos down;
    public BlockPos up;
    public BlockPos north;
    public BlockPos south;
    public BlockPos west;
    public BlockPos east;

    public CinderwormHeadTileEntity() {
        super(RegistryHandler.CINDERWORM_HEAD_TILE_ENTITY.get());
    }

    @Override
    public void tick() {

        ticks++;
        if (!world.isRemote) {
            if (ticks == 4) {
                Cinderbane.LOGGER.info("Worm is Active");
            }
            if (ticks == 5) {


                isHungry = true;
                Cinderbane.LOGGER.info("Will eat");
                ticks = 0;
            }
            if (isHungry) {

                BlockPos blockPosDirections[] = {
                        down = this.pos.down(),
                        up = this.pos.up(),
                        north = this.pos.north(),
                        south = this.pos.south(),
                        west = this.pos.west(),
                        east = this.pos.east(),
                };
                Random rand = new Random();
                int randomDirectionInt = rand.nextInt(4);

                currentFood = world.getBlockState(blockPosDirections[randomDirectionInt]);
                if (currentFood != deniedFood()) {
                    world.setBlockState(blockPosDirections[randomDirectionInt], RegistryHandler.CINDERWORM_HEAD.get().getDefaultState());
                    world.setBlockState(this.pos, RegistryHandler.CINDERWORM_BASE.get().getDefaultState());
                };

            }


        }


    }

    private BlockState deniedFood() {
        if (currentFood == RegistryHandler.CINDERWORM_HEAD.get().getDefaultState()) {
            return RegistryHandler.CINDERWORM_HEAD.get().getDefaultState();
        }
        if (currentFood == RegistryHandler.CINDERWORM_BASE.get().getDefaultState()) {
            return RegistryHandler.CINDERWORM_BASE.get().getDefaultState();
        }
        if (currentFood == Blocks.BEDROCK.getDefaultState()) {
            return Blocks.BEDROCK.getDefaultState();
        }
        if (currentFood == Blocks.AIR.getDefaultState()) {
            return Blocks.AIR.getDefaultState();
        }
        if (currentFood == Blocks.VOID_AIR.getDefaultState()) {
            return Blocks.VOID_AIR.getDefaultState();
        }
        if (currentFood == Blocks.CAVE_AIR.getDefaultState()) {
            return Blocks.CAVE_AIR.getDefaultState();
        }
        if (currentFood == Blocks.WATER.getDefaultState()) {
            return Blocks.WATER.getDefaultState();
        }
        if (currentFood == Blocks.LAVA.getDefaultState()) {
            return Blocks.LAVA.getDefaultState();
        }
        return Blocks.BEDROCK.getDefaultState();
    }


//    private BlockState availableFood() {
//        return RegistryHandler.
//    }

}