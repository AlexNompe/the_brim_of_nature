package net.thebrimofnature.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class Glimmer_Cluster_Feature extends Feature<Glimmer_Cluster_Feature.Glimmer_Cluster_FeatureConfig> {
    public Glimmer_Cluster_Feature(Codec<Glimmer_Cluster_FeatureConfig> configCodec) {
        super(configCodec);
    }

    // this method is what is called when the game tries to generate the feature. it is where the actual blocks get placed into the world.
    @Override
    public boolean generate(FeatureContext<Glimmer_Cluster_FeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        // the origin is the place where the game starts trying to place the feature
        BlockPos origin = context.getOrigin();
        // we won't use the random here, but we could if we wanted to
        Random random = context.getRandom();
        Glimmer_Cluster_FeatureConfig config = context.getConfig();

        // don't worry about where these come from-- we'll implement these methods soon
        int number = config.number();
        Identifier blockId = config.blockId();

        BlockState blockState = Registries.BLOCK.get(blockId).getDefaultState();
        // ensure the ID is okay
        if (blockState == null) throw new IllegalStateException(blockId + " could not be parsed to a valid block identifier!");

        // find the surface of the world
        BlockPos testPos = new BlockPos(origin);
        for (int y = 0; y < world.getHeight(); y++) {
            testPos = testPos.up();
            // the tag name is dirt, but includes grass, mud, podzol, etc.
            if (world.getBlockState(testPos).isIn(BlockTags.DIRT)) {
                if (world.getBlockState(testPos.up()).isOf(Blocks.AIR)) {
                    for (int i = 0; i < number; i++) {
                        // create a simple pillar of blocks
                        world.setBlockState(testPos, blockState, 0x10);
                        testPos = testPos.up();

                        // ensure we don't try to place blocks outside the world
                        if (testPos.getY() >= world.getTopY()) break;
                    }
                    return true;
                }
            }
        }
        // the game couldn't find a place to put the pillar
        return false;
    }

    public record Glimmer_Cluster_FeatureConfig(int number, Identifier blockId) implements FeatureConfig {
        public static final Codec<Glimmer_Cluster_FeatureConfig> CODEC = RecordCodecBuilder.create(
                instance -> instance.group(
                                // you can add as many of these as you want, one for each parameter
                                Codecs.POSITIVE_INT.fieldOf("number").forGetter(Glimmer_Cluster_FeatureConfig::number),
                                Identifier.CODEC.fieldOf("blockID").forGetter(Glimmer_Cluster_FeatureConfig::blockId))
                        .apply(instance, Glimmer_Cluster_FeatureConfig::new));
    }
}
