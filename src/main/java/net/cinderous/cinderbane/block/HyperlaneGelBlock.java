package net.cinderous.cinderbane.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class HyperlaneGelBlock  extends Block {

    public HyperlaneGelBlock(Properties properties) {
        super(Block.Properties.create(Material.WATER)
                .hardnessAndResistance(0.5f,0.5f)
                .sound(SoundType.SNOW)
                .doesNotBlockMovement()
                .slipperiness(5.0f)
                .speedFactor(10.0f)
                .jumpFactor(5.0f)
                .harvestTool(ToolType.SHOVEL)
        );
    }

    @Override
    public Vector3d getFogColor(BlockState state, IWorldReader world, BlockPos pos, Entity entity, Vector3d originalColor, float partialTicks) {
        return null;
    }

    //    @Override
//    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
//        return super.allowsMovement(state, worldIn, pos, type);
//    }
}