package net.cinderous.cinderbane.block;

import net.cinderous.cinderbane.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class Cinderkelp  extends AbstractBodyPlantBlock implements ILiquidContainer {
    public Cinderkelp(AbstractBlock.Properties properties) {
        super(properties, Direction.UP, VoxelShapes.fullCube(), true);
    }

    protected AbstractTopPlantBlock getTopPlantBlock() {
        return (AbstractTopPlantBlock) RegistryHandler.CINDERKELP_TOP.get();
    }

    public FluidState getFluidState(BlockState state) {

        if(!state.isIn(Blocks.LAVA)) {
            return Fluids.EMPTY.getDefaultState();
        }
        return Fluids.LAVA.getStillFluidState(false);

//        if(state.isIn(Blocks.AIR)) {
//            return Fluids.EMPTY.getDefaultState();
//        }

        //return Fluids.WATER.getStillFluidState(false);
       // return Fluids.EMPTY.getDefaultState();

    }



    public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        return false;
    }

    public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
        return false;
    }
}