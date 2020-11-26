package net.cinderous.cinderbane.tileentity;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.RegistryHandler;
import net.cinderous.cinderbane.util.packethandler.TesseractPacketHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
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

public class CinderousTesseractTileEntity extends TileEntity implements ITickableTileEntity {
    protected FluidTank tank = new FluidTank(FluidAttributes.BUCKET_VOLUME * 8) {
        @Override
        public boolean isFluidValid(FluidStack stack) {
            return stack.getFluid() == Fluids.WATER;
        }

        @Override
        protected void onContentsChanged() {
            BlockState blockstate = world.getBlockState(pos);
            world.notifyBlockUpdate(pos,blockstate,blockstate,3);
            markDirty();
        }
    };



    public boolean tankConfigured = false;

    private final LazyOptional<IFluidHandler> holder = LazyOptional.of(() -> tank);

    private int ticks;

    public CinderousTesseractTileEntity() {
        super(RegistryHandler.CINDEROUS_TESSERACT_TILE_ENTITY.get());
    }

    @Override
    @Nonnull
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
            return holder.cast();
        return super.getCapability(capability, facing);
    }

    public FluidTank getTank() {


        return this.tank;
    }

    @Override
    public void tick() {
//        if(!tankConfigured) {
//            CompoundNBT teNBT = this.getTileData().getCompound("tankAmount");
//            this.read(this.getBlockState(), teNBT);
//            int tankAmount = teNBT.getInt("tankAmount");
//            //        this.read(this.getTileData());
//            //        ItemStack tesseractItem =
//            this.tank.fill(new FluidStack(Fluids.WATER.getFluid(), tankAmount), IFluidHandler.FluidAction.EXECUTE);
//            tankConfigured = true;
//        }

        ticks++;
        if (ticks == 20) {
            ticks = 0;

            this.tank.fill(new FluidStack(Fluids.WATER.getFluid(), 17), IFluidHandler.FluidAction.EXECUTE);
            this.markDirty();
        }
    }


    @Override
    public void read(BlockState state, CompoundNBT tag) {
        super.read(state, tag);
        getTank().readFromNBT(tag);
        Cinderbane.LOGGER.info(tag);
    }



    @Override
    public CompoundNBT write(CompoundNBT tag) {
        tag = super.write(tag);
        getTank().writeToNBT(tag);
        Cinderbane.LOGGER.info(tag + "tag");
        return tag;
    }

    @Nonnull
    @Override
    public CompoundNBT getUpdateTag() {
        return write(new CompoundNBT());
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(getPos(), 1, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        this.read(null,packet.getNbtCompound());
    }


}