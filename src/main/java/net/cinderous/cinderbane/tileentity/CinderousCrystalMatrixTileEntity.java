//package net.cinderous.cinderbane.tileentity;
//
//import net.cinderous.cinderbane.Cinderbane;
//import net.cinderous.cinderbane.RegistryHandler;
//import net.cinderous.cinderbane.container.CinderousCrystalMatrixContainer;
//import net.minecraft.block.BlockState;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.fluid.Fluids;
//import net.minecraft.inventory.container.Container;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.CompoundNBT;
//import net.minecraft.tileentity.ITickableTileEntity;
//import net.minecraft.tileentity.LockableLootTileEntity;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.tileentity.TileEntityType;
//import net.minecraft.util.Direction;
//import net.minecraft.util.NonNullList;
//import net.minecraft.util.text.ITextComponent;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.fluids.FluidAttributes;
//import net.minecraftforge.fluids.FluidStack;
//import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
//import net.minecraftforge.fluids.capability.IFluidHandler;
//import net.minecraftforge.fluids.capability.templates.FluidTank;
//
//import javax.annotation.Nonnull;
//import javax.annotation.Nullable;
//
//public class CinderousCrystalMatrixTileEntity  extends LockableLootTileEntity implements ITickableTileEntity {
//
//
//
//    public CinderousCrystalMatrixTileEntity() {
//        super(RegistryHandler.CINDEROUS_CRYSTAL_MATRIX_TILE_ENTITY.get());
//    }
//
//    public CinderousCrystalMatrixTileEntity(TileEntityType<?> typeIn) {
//        super(typeIn);
//
//    }
//
//    @Override
//    protected ITextComponent getDefaultName() {
//        return null;
//    }
//
//    @Override
//    protected Container createMenu(int id, PlayerInventory player) {
//        return new CinderousCrystalMatrixContainer(id, player, this);
//    }
//
//    @Override
//    protected NonNullList<ItemStack> getItems() {
//        return null;
//    }
//
//    @Override
//    protected void setItems(NonNullList<ItemStack> itemsIn) {
//
//    }
//
//
//    @Override
//    public void tick() {
//        Cinderbane.LOGGER.info("TEST");
//    }
//
//    @Override
//    public int getSizeInventory() {
//        return 0;
//    }
//}