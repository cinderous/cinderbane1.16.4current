package net.cinderous.cinderbane;

import net.cinderous.cinderbane.block.BasaltSheet;
import net.cinderous.cinderbane.effect.LavaWalkersEffect;
import net.cinderous.cinderbane.item.LavaWalkers;
import net.cinderous.cinderbane.material.CinderbaneArmorMaterial;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Cinderbane.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler
{

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
//        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
//        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
//        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cinderbane.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cinderbane.MODID);
    private static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Cinderbane.MODID);
    private static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Cinderbane.MODID);

//    private static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Cinderbane.MODID);
//    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Cinderbane.MODID);
//    private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Cinderbane.MODID);
//    private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Cinderbane.MODID);
    //


//testestetsttest

    //Blocks
    public static final RegistryObject<Block> CINDIRT = BLOCKS.register("cindirt", () -> new Block(Block.Properties.create(Material.EARTH)));
    public static final RegistryObject<Block> BASALT_SHEET = BLOCKS.register("basalt_sheet", () -> new BasaltSheet(Block.Properties.create(Material.EARTH)));
    public static final RegistryObject<Block> CINDERBANE_LOG = BLOCKS.register("cinderbane_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CINDERBANE_LEAVES = BLOCKS.register("cinderbane_leaves", () -> new Block(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).sound(SoundType.PLANT).notSolid()));
    //public static final RegistryObject<Block> CINDERBANE_TREE_POD = BLOCKS.register("cinderbane_tree_pod", () -> new CinderbaneTreePod(Block.Properties.create(Material.IRON)));
    //Blocks Item
    public static final RegistryObject<Item> CINDIRT_ITEM = ITEMS.register("cindirt", () -> new BlockItem(CINDIRT.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    public static final RegistryObject<Item> BASALT_SHEET_ITEM = ITEMS.register("basalt_sheet", () -> new BlockItem(BASALT_SHEET.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    public static final RegistryObject<Item> CINDERBANE_LOG_ITEM = ITEMS.register("cinderbane_log", () -> new BlockItem(CINDERBANE_LOG.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    public static final RegistryObject<Item> CINDERBANE_LEAVES_ITEM = ITEMS.register("cinderbane_leaves", () -> new BlockItem(CINDERBANE_LEAVES.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    //Items
    //public static final RegistryObject<Item> SPELLDEV = ITEMS.register("spelldev", () -> new SpellDev(new Item.Properties().group(GeomancyAndTerraforming.GEOMANCYANDTERRAFORMING_TAB)));

    //Equipment Armor
    public static final RegistryObject<ArmorItem> LAVA_WALKERS = ITEMS.register("lava_walkers",
            () -> new LavaWalkers(CinderbaneArmorMaterial.CINDEROUS, EquipmentSlotType.FEET, new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));

    //Effects
    public static final RegistryObject<Effect> LAVA_WALKERS_EFFECT = EFFECTS.register("lava_walkers_effect",
            () -> new LavaWalkersEffect(EffectType.BENEFICIAL, 37848743));

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
