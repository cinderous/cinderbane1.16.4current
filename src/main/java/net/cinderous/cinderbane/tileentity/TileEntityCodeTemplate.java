package net.cinderous.cinderbane.tileentity;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.RegistryHandler;
import net.minecraft.block.BlockState;
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

public class TileEntityCodeTemplate extends TileEntity implements ITickableTileEntity {

    private int ticks;

    public TileEntityCodeTemplate() {
        super(RegistryHandler.CINDERWORM_HEAD_TILE_ENTITY.get());
    }


    @Override
    public void tick() {
        ticks++;
        if (ticks == 20) {
            ticks = 0;
            Cinderbane.LOGGER.info("Template is Active");
        }
    }

}