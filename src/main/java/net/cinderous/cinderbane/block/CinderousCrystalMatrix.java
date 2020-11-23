//package net.cinderous.cinderbane.block;
//
//import net.cinderous.cinderbane.Cinderbane;
//
//import net.cinderous.cinderbane.tileentity.CinderousTesseractTileEntity;
//import net.cinderous.cinderbane.util.packethandler.TesseractPacketHandler;
//import net.minecraft.block.*;
//import net.minecraft.block.material.Material;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.fluid.Fluids;
//import net.minecraft.item.BlockItemUseContext;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
//import net.minecraft.potion.PotionUtils;
//import net.minecraft.potion.Potions;
//import net.minecraft.state.DirectionProperty;
//import net.minecraft.state.StateContainer;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.util.*;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.BlockRayTraceResult;
//import net.minecraft.world.IBlockReader;
//import net.minecraft.world.World;
//import net.minecraftforge.common.ToolType;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.fluids.FluidStack;
//import net.minecraftforge.fluids.FluidUtil;
//import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
//import net.minecraftforge.fluids.capability.IFluidHandler;
//import net.minecraftforge.fluids.capability.templates.FluidTank;
//
//import javax.annotation.Nullable;
//
//public class CinderousCrystalMatrix extends Block {
//    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
//    public static int tankAmount = 0;
//
//    public CinderousCrystalMatrix() {
//        super(AbstractBlock.Properties.create(Material.ROCK)
//                .sound(SoundType.STONE)
//                .hardnessAndResistance(2.0f, 3.0f)
//                .harvestLevel(0)
//                .setRequiresTool()
//                .harvestTool(ToolType.PICKAXE)
//                .notSolid()
//        );
//    }
//
//    @Nullable
//    @Override
//    public BlockState getStateForPlacement(BlockItemUseContext context) {
//        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
//    }
//
//    @Override
//    public BlockState rotate(BlockState state, Rotation rot) {
//        return state.with(FACING, rot.rotate(state.get(FACING)));
//    }
//
//    @Override
//    public BlockState mirror(BlockState state, Mirror mirrorIn) {
//        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
//    }
//
//    @Override
//    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
//        builder.add(FACING);
//    }
//
//    @Override
//    public boolean hasTileEntity(BlockState state) {
//        return true;
//    }
//
//    @Nullable
//    @Override
//    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
//        return new CinderousCrystalMatrixTileEntity();
//    }
//
//
//}