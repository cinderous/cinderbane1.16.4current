package net.cinderous.cinderbane.block;

import net.cinderous.cinderbane.RegistryHandler;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.property.Properties;

import javax.annotation.Nullable;


public class CinderwoodTreePod extends Block {
    public CinderwoodTreePod(Properties properties) {
        super(properties);

    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RegistryHandler.CINDERWOOD_TREE_BUILDER_TILE_ENTITY.get().create();
    }

//    @Override
//    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
//        if(worldIn.getBlockState(pos.offset(Direction.DOWN)) == RegistryHandler.CINDIRT.get().getDefaultState() || worldIn.getBlockState(pos.offset(Direction.DOWN)) == CinderbaneRegistry.CINDIRT_GRASS_BLOCK.get().getDefaultState()) {
//            return true;
//        }
//        return false;
//    }


}