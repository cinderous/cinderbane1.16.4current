package net.cinderous.cinderbane.block;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.RegistryHandler;
import net.cinderous.cinderbane.tileentity.CinderousTesseractTileEntity;
import net.cinderous.cinderbane.tileentity.CinderwormHeadTileEntity;
import net.cinderous.cinderbane.util.packethandler.TesseractPacketHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;

import javax.annotation.Nullable;

public class CinderwormHead extends Block {
    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static int tankAmount = 0;

    public CinderwormHead() {
        super(AbstractBlock.Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(2.0f, 3.0f)
                .harvestLevel(0)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE)
                .notSolid()

        );
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CinderwormHeadTileEntity();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {
        if (!world.isRemote) {
            ItemStack heldItem = player.getHeldItem(hand);
            TileEntity tileEntity = world.getTileEntity(pos);

            if (tileEntity != null) {
                LazyOptional<IFluidHandler> fluidHandlerCap = tileEntity.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY);

                if (fluidHandlerCap.isPresent()) {
                    IFluidHandler fluidHandler = fluidHandlerCap.orElseThrow(IllegalStateException::new);

                    if (heldItem.getItem() == Items.GLASS_BOTTLE) {
                        if (fluidHandler.drain(333, IFluidHandler.FluidAction.SIMULATE).getAmount() == 333) {
                            fluidHandler.drain(333, IFluidHandler.FluidAction.EXECUTE);

                            player.world.playSound(null, player.getPosition(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.PLAYERS, 1f, 1f);

                            heldItem.shrink(1);
                            ItemStack itemPotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER);

                            if (!player.addItemStackToInventory(itemPotion)) {
                                spawnAsEntity(world, player.getPosition(), itemPotion);
                            }

                            return ActionResultType.SUCCESS;
                        }
                    } else if (heldItem.getItem() == Items.POTION && heldItem.getTag() != null) {
                        if (heldItem.getTag().getString("Potion").equals("minecraft:water")) {
                            if (fluidHandler.fill(new FluidStack(Fluids.WATER, 333), IFluidHandler.FluidAction.SIMULATE) == 333) {
                                fluidHandler.fill(new FluidStack(Fluids.WATER, 333), IFluidHandler.FluidAction.EXECUTE);

                                player.world.playSound(null, player.getPosition(), SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.PLAYERS, 1f, 1f);

                                heldItem.shrink(1);
                                ItemStack itemBottle = new ItemStack(Items.GLASS_BOTTLE);

                                if (!player.addItemStackToInventory(itemBottle)) {
                                    spawnAsEntity(world, player.getPosition(), itemBottle);
                                }

                                return ActionResultType.SUCCESS;
                            }
                        }
                    } else {

                        return (FluidUtil.interactWithFluidHandler(player, hand, fluidHandler)) ? ActionResultType.SUCCESS : ActionResultType.FAIL;
                    }
                }
            }
        }

        return ActionResultType.SUCCESS;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {

        if (!worldIn.isRemote) {


            TileEntity te = worldIn.getTileEntity(pos);

            if (te instanceof CinderousTesseractTileEntity) {
                FluidStack tankFluidStack = ((CinderousTesseractTileEntity) te).getTank().getFluid();
                tankAmount = tankFluidStack.getAmount();

                Cinderbane.LOGGER.info(tankAmount);


            }

            TesseractPacketHandler tesseractPacket = (new TesseractPacketHandler(tankAmount));
            Cinderbane.LOGGER.info(tesseractPacket);
            Cinderbane.INSTANCE.sendToServer(tesseractPacket);


            super.onBlockHarvested(worldIn, pos, state, player);


        }


    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        int tankAmount = 8000 + -stack.getDamage();

        if (!worldIn.isRemote) {


            TileEntity te = worldIn.getTileEntity(pos);

            if (te instanceof CinderousTesseractTileEntity) {
                FluidTank tankFluidTank = ((CinderousTesseractTileEntity) te).getTank();
                tankFluidTank.fill(new FluidStack(Fluids.WATER.getFluid(), tankAmount), IFluidHandler.FluidAction.EXECUTE);

                Cinderbane.LOGGER.info(tankAmount);


            }

        }
    }
}