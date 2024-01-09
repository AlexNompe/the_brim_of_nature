package net.thebrimofnature.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.thebrimofnature.The_Brim_Of_Nature;
import net.thebrimofnature.feature.Glimmer_Cluster_Feature;
import net.thebrimofnature.world.The_Brim_Of_Nature_OrePlacement;

import java.util.List;

import static net.thebrimofnature.registry.TheBrimOfNatureBlockRegistry.*;

public class TheBrimOfNatureFeatureRegistry {
    public static final RegistryKey<ConfiguredFeature<?, ?>> GLIMMER_CLUSTER_KEY = registerKey("glimmer_cluster");
    public static final RegistryKey<PlacedFeature> GLIMMER_CLUSTER_PLACED_KEY = registerPlacedKey("glimmer_cluster_placed");

    public static final Identifier GLIMMER_CLUSTER_FEATURE_ID = new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmer_cluster_feature");
    public static final Glimmer_Cluster_Feature GLIMMER_CLUSTER_FEATURE = new Glimmer_Cluster_Feature(Glimmer_Cluster_Feature.Glimmer_Cluster_FeatureConfig.CODEC);

    public static final ConfiguredFeature<Glimmer_Cluster_Feature.Glimmer_Cluster_FeatureConfig, Glimmer_Cluster_Feature> GLIMMER_CLUSTER_FEATURE_CONFIGURED = new ConfiguredFeature<>(
            GLIMMER_CLUSTER_FEATURE,
            new Glimmer_Cluster_Feature.Glimmer_Cluster_FeatureConfig(10, new Identifier(The_Brim_Of_Nature.MOD_ID, "glimmer_block"))
    );

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldRubyOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, GLIMMER_BLOCK.getDefaultState()));

        register(context, GLIMMER_CLUSTER_KEY, Feature.ORE, new OreFeatureConfig(overworldRubyOres, 12));
    }

    public static void boostrapPlaced(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, GLIMMER_CLUSTER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(GLIMMER_CLUSTER_KEY),
                The_Brim_Of_Nature_OrePlacement.modifiersWithCount(12, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
    }

    public static void registering() {
        The_Brim_Of_Nature.LOGGER.info("Feature registry...");
        Registry.register(Registries.FEATURE, GLIMMER_CLUSTER_FEATURE_ID, GLIMMER_CLUSTER_FEATURE);
        RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, GLIMMER_CLUSTER_FEATURE_ID);
        RegistryKey.of(RegistryKeys.PLACED_FEATURE, GLIMMER_CLUSTER_FEATURE_ID);

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                // the feature is to be added while flowers and trees are being generated
                GenerationStep.Feature.VEGETAL_DECORATION,
                GLIMMER_CLUSTER_PLACED_KEY);
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(The_Brim_Of_Nature.MOD_ID, name));
    }

    public static RegistryKey<PlacedFeature> registerPlacedKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(The_Brim_Of_Nature.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
