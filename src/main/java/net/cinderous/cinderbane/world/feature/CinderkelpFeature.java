package net.cinderous.cinderbane.world.feature;

import com.mojang.serialization.Codec;
import net.cinderous.cinderbane.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;
import java.util.function.Supplier;


public class CinderkelpFeature extends Feature<NoFeatureConfig> {
        private static final Supplier<BlockState> TEST_BLOCK = () -> RegistryHandler.CINDIRT.get().getDefaultState();

        public CinderkelpFeature(Codec<NoFeatureConfig> config) {
            super(config);
        }

    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
            if (func_230362_a_(reader, generator, rand, pos, config) == true) {
                return true;
            }
        return false;
    }

    public boolean func_230362_a_(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
            for (BlockState blockstate = worldIn.getBlockState(pos); (blockstate.isAir() || blockstate.isIn(BlockTags.LEAVES)) && pos.getY() > 0; blockstate = worldIn.getBlockState(pos)) {
                pos = pos.down();
            }

            int i = 0;
            for (int j = 0; j < 128; ++j) {
                BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

                    worldIn.setBlockState(blockpos.up(), TEST_BLOCK.get(), 2);
                    ++i;

            }

            return i > 0;
        }

//        protected boolean isNearBolloomBud(IWorld world, BlockPos pos) {
//            return world.getBlockState(pos.north()).getBlock() == EEBlocks.BOLLOOM_BUD.get() || world.getBlockState(pos.east()).getBlock() == EEBlocks.BOLLOOM_BUD.get() || world.getBlockState(pos.south()).getBlock() == EEBlocks.BOLLOOM_BUD.get() || world.getBlockState(pos.west()).getBlock() == EEBlocks.BOLLOOM_BUD.get();
//        }
    }
