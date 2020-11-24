package net.cinderous.cinderbane.block;

import net.cinderous.cinderbane.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class CinderwormBase extends Block {
    public CinderwormBase(Properties properties) {
        super(properties);

    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RegistryHandler.CINDERWORM_BASE_TILE_ENTITY.get().create();
    }

//    @Override
//    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
//        if(worldIn.getBlockState(pos.offset(Direction.DOWN)) == RegistryHandler.CINDIRT.get().getDefaultState() || worldIn.getBlockState(pos.offset(Direction.DOWN)) == CinderbaneRegistry.CINDIRT_GRASS_BLOCK.get().getDefaultState()) {
//            return true;
//        }
//        return false;
//    }


}