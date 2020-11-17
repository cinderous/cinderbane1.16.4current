package net.cinderous.cinderbane.world.gen;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HyphinityOreFeatureConfig  extends OreFeatureConfig implements IFeatureConfig {
    public HyphinityOreFeatureConfig(RuleTest p_i241989_1_, BlockState state, int size) {
        super(p_i241989_1_, state, size);
    }
}