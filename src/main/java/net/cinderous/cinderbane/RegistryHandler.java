package net.cinderous.cinderbane;

import net.cinderous.cinderbane.block.*;
import net.cinderous.cinderbane.effect.CinderousHelmetEffect;
import net.cinderous.cinderbane.effect.LavaWalkersEffect;
import net.cinderous.cinderbane.effect.WaterStridersEffect;
import net.cinderous.cinderbane.entity.CinderousZealot;
import net.cinderous.cinderbane.entity.HyphinityWisp;
import net.cinderous.cinderbane.entity.LavaSquid;
import net.cinderous.cinderbane.item.CinderousHelmet;
import net.cinderous.cinderbane.item.CinderousTesseractItem;
import net.cinderous.cinderbane.item.LavaWalkers;
import net.cinderous.cinderbane.item.WaterStriders;
import net.cinderous.cinderbane.material.CinderbaneArmorMaterial;
import net.cinderous.cinderbane.tileentity.CinderousTesseractTileEntity;
import net.cinderous.cinderbane.tileentity.CinderwoodTreeBuilderTileEntity;
import net.cinderous.cinderbane.util.CinderbaneItemTier;
import net.cinderous.cinderbane.world.feature.CinderkelpFeature;
import net.cinderous.cinderbane.world.feature.FeatureRegistry;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Cinderbane.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler
{

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
//        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
        STRUCTURES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cinderbane.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cinderbane.MODID);
    private static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Cinderbane.MODID);
    private static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Cinderbane.MODID);
    private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Cinderbane.MODID);
//    private static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Cinderbane.MODID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Cinderbane.MODID);
//    private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Cinderbane.MODID);
    private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Cinderbane.MODID);
    private static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Cinderbane.MODID);
    //


//testestetsttest

    //Blocks
    public static final RegistryObject<Block> CINDIRT = BLOCKS.register("cindirt", () -> new Block(Block.Properties.create(Material.EARTH)));
    public static final RegistryObject<Block> BASALT_SHEET = BLOCKS.register("basalt_sheet", () -> new BasaltSheet(Block.Properties.create(Material.EARTH)));
    public static final RegistryObject<Block> CINDERBANE_LOG = BLOCKS.register("cinderbane_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CINDERBANE_LEAVES = BLOCKS.register("cinderbane_leaves", () -> new Block(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).sound(SoundType.PLANT).notSolid()));
    //public static final RegistryObject<Block> CINDERBANE_TREE_POD = BLOCKS.register("cinderbane_tree_pod", () -> new CinderbaneTreePod(Block.Properties.create(Material.IRON)));
    public static final RegistryObject<Block> HYPERLANE_GEL_BLOCK = BLOCKS.register("hyperlane_gel_block", () -> new HyperlaneGelBlock(Block.Properties.create(Material.WATER)));
    public static final RegistryObject<Block> HYPERLANE_GEL_SHEET = BLOCKS.register("hyperlane_gel_sheet", () -> new HyperlaneGelSheet(Block.Properties.from(RegistryHandler.HYPERLANE_GEL_BLOCK.get())));
    public static final RegistryObject<Block> CINDERWOOD_TREE_POD = BLOCKS.register("cinderwood_tree_pod", () -> new CinderwoodTreePod(Block.Properties.create(Material.WOOD)));
    //Cinderbane Dimension Blocks
    public static final RegistryObject<Block> CINDERKELP = BLOCKS.register("cinderkelp", () -> new Cinderkelp(Block.Properties.create(Material.OCEAN_PLANT).doesNotBlockMovement().notSolid()));
    public static final RegistryObject<Block> CINDERKELP_TOP = BLOCKS.register("cinderkelp_top", () -> new CinderkelpTop(Block.Properties.create(Material.OCEAN_PLANT).doesNotBlockMovement().notSolid()));
    public static final RegistryObject<Block> CINDEROUS_TESSERACT = BLOCKS.register("cinderous_tesseract", () -> new CinderousTesseract());
    //Blocks Item
    public static final RegistryObject<Item> CINDIRT_ITEM = ITEMS.register("cindirt", () -> new BlockItem(CINDIRT.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    public static final RegistryObject<Item> BASALT_SHEET_ITEM = ITEMS.register("basalt_sheet", () -> new BlockItem(BASALT_SHEET.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    public static final RegistryObject<Item> CINDERBANE_LOG_ITEM = ITEMS.register("cinderbane_log", () -> new BlockItem(CINDERBANE_LOG.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    public static final RegistryObject<Item> CINDERBANE_LEAVES_ITEM = ITEMS.register("cinderbane_leaves", () -> new BlockItem(CINDERBANE_LEAVES.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    public static final RegistryObject<Item> CINDERWOOD_TREE_POD_ITEM = ITEMS.register("cinderwood_tree_pod", () -> new BlockItem(CINDERWOOD_TREE_POD.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));

    public static final RegistryObject<Item> CINDERKELP_ITEM = ITEMS.register("cinderkelp", () -> new BlockItem(CINDERKELP.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    public static final RegistryObject<Item> CINDERKELP_TOP_ITEM = ITEMS.register("cinderkelp_top", () -> new BlockItem(CINDERKELP_TOP.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    //TESSERACT ITEM BLOCK
    public static final RegistryObject<Item> CINDEROUS_TESSERACT_ITEM = ITEMS.register("cinderous_tesseract_item", () -> new CinderousTesseractItem(CINDEROUS_TESSERACT.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB).setNoRepair().maxDamage(8000)));


    //Items
    //public static final RegistryObject<Item> SPELLDEV = ITEMS.register("spelldev", () -> new SpellDev(new Item.Properties().group(GeomancyAndTerraforming.GEOMANCYANDTERRAFORMING_TAB)));

    //Equipment Armor
    public static final RegistryObject<ArmorItem> LAVA_WALKERS = ITEMS.register("lava_walkers",
            () -> new LavaWalkers(CinderbaneArmorMaterial.LAVAWALKERS, EquipmentSlotType.FEET, new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));

    public static final RegistryObject<ArmorItem> WATER_STRIDERS = ITEMS.register("water_striders",
            () -> new WaterStriders(CinderbaneArmorMaterial.WATERSTRIDERS, EquipmentSlotType.FEET, new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    //Cinderous Armor Set
    public static final RegistryObject<ArmorItem> CINDEROUS_HELMET = ITEMS.register("cinderous_helmet",
            () -> new CinderousHelmet(CinderbaneArmorMaterial.CINDEROUS, EquipmentSlotType.FEET, new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    //Hyphinity Armor Set
    public static final RegistryObject<ArmorItem> HYPHINITY_HELMET = ITEMS.register("hyphinity_helmet",
            () -> new ArmorItem(CinderbaneArmorMaterial.HYPHINITY, EquipmentSlotType.FEET, new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    public static final RegistryObject<ArmorItem> HYPHINITY_BOOTS = ITEMS.register("hyphinity_boots",
            () -> new ArmorItem(CinderbaneArmorMaterial.HYPHINITY, EquipmentSlotType.HEAD, new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    public static final RegistryObject<ArmorItem> HYPHINITY_LEGGINGS = ITEMS.register("hyphinity_leggings",
            () -> new ArmorItem(CinderbaneArmorMaterial.HYPHINITY, EquipmentSlotType.LEGS, new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    public static final RegistryObject<ArmorItem> HYPHINITY_CHESTPLATE = ITEMS.register("hyphinity_chestplate",
            () -> new ArmorItem(CinderbaneArmorMaterial.HYPHINITY, EquipmentSlotType.CHEST, new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    //Effects
    public static final RegistryObject<Effect> LAVA_WALKERS_EFFECT = EFFECTS.register("lava_walkers_effect",
            () -> new LavaWalkersEffect(EffectType.BENEFICIAL, 37848743));

    public static final RegistryObject<Effect> WATER_STRIDERS_EFFECT = EFFECTS.register("water_striders_effect",
            () -> new WaterStridersEffect(EffectType.BENEFICIAL, 37848743));

    public static final RegistryObject<Effect> CINDEROUS_HELMET_EFFECT = EFFECTS.register("cinderous_helmet_effect",
            () -> new CinderousHelmetEffect(EffectType.BENEFICIAL, 37848743));

    //Tile Entities
    public static final RegistryObject<TileEntityType<CinderwoodTreeBuilderTileEntity>> CINDERWOOD_TREE_BUILDER_TILE_ENTITY = TILE_ENTITIES.register("cinderwood_tree_builder_tile_entity", () -> TileEntityType.Builder
            .create(CinderwoodTreeBuilderTileEntity::new, RegistryHandler.CINDERWOOD_TREE_POD.get()).build(null));

    public static final RegistryObject<TileEntityType<CinderousTesseractTileEntity>> CINDEROUS_TESSERACT_TILE_ENTITY = TILE_ENTITIES.register("cinderous_tesseract_tile_entity", () -> TileEntityType.Builder
            .create(CinderousTesseractTileEntity::new, RegistryHandler.CINDEROUS_TESSERACT.get()).build(null));


    //Entities
    public static final RegistryObject<EntityType<LavaSquid>> LAVA_SQUID = ENTITIES
            .register("lava_squid",
                    () -> EntityType.Builder.<LavaSquid>create(LavaSquid::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Cinderbane.MODID, "lava_squid").toString()));
    public static final RegistryObject<EntityType<HyphinityWisp>> HYPHINITY_WISP = ENTITIES
            .register("hyphinity_wisp",
                    () -> EntityType.Builder.<HyphinityWisp>create(HyphinityWisp::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Cinderbane.MODID, "hyphinity_wisp").toString()));
    public static final RegistryObject<EntityType<CinderousZealot>> CINDEROUS_ZEALOT = ENTITIES
            .register("cinderous_zealot",
                    () -> EntityType.Builder.<CinderousZealot>create(CinderousZealot::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Cinderbane.MODID, "cinderous_zealot").toString()));
    //Entity Spawn and Attributes
    @SubscribeEvent
    public static void onRegisterEntityTypes(RegistryEvent.Register<EntityType<?>> event)
    {
        EntitySpawnPlacementRegistry.register(RegistryHandler.LAVA_SQUID.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canSpawnOn);
        GlobalEntityTypeAttributes.put(RegistryHandler.LAVA_SQUID.get(), LavaSquid.registerAttributeMap().create());

        EntitySpawnPlacementRegistry.register(RegistryHandler.HYPHINITY_WISP.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canSpawnOn);
        GlobalEntityTypeAttributes.put(RegistryHandler.HYPHINITY_WISP.get(), LavaSquid.registerAttributeMap().create());

        EntitySpawnPlacementRegistry.register(RegistryHandler.CINDEROUS_ZEALOT.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canSpawnOn);
        GlobalEntityTypeAttributes.put(RegistryHandler.CINDEROUS_ZEALOT.get(), LavaSquid.registerAttributeMap().create());
    }

//features
//    public static ConfiguredFeature<?, ?> TESTFEATURECONFIGURED = RegistryHandler.TESTFEATURE.get().withConfiguration(NoFeatureConfig.field_236559_b_).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).chance(30);
    public static final RegistryObject<Feature<NoFeatureConfig>> TESTFEATURE = createFeature("testfeature", () -> new CinderkelpFeature(NoFeatureConfig.field_236558_a_));

    private static <F extends Feature<?>> RegistryObject<F> createFeature(String name, Supplier<F> feature) {
        return FEATURES.register(name, feature);

        //Structures



//    //Biomes
//    //Biomes
//    public static final RegistryObject<Biome> CINDERBANE_ABYSS = BIOMES.register("cinderbane_abyss", () -> new CinderbaneAbyss());
//    //Biome World Generation
//    @SubscribeEvent
//    public static void onRegisterBiomes(RegistryEvent.Register<Biome> event)
//    {
//        IForgeRegistry<Biome> registry = event.getRegistry();
//        registerBiome(registry, CINDERBANE_ABYSS.get(), "cinderbane_abyss", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
//    }
//
//    private static void registerBiome(IForgeRegistry<Biome> registry, Biome biome, String name, boolean spawn, BiomeDictionary.Type... types) {
//        //registry.register(biome.setRegistryName(Cinderbane.MODID, name));
//        if (spawn) {
//            BiomeManager.addSpawnBiome(biome);
//        }
//        BiomeDictionary.addTypes(biome, types);
//    }


    }
}
