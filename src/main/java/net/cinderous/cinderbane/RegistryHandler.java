package net.cinderous.cinderbane;

import net.cinderous.cinderbane.block.BasaltSheet;
import net.cinderous.cinderbane.effect.LavaWalkersEffect;
import net.cinderous.cinderbane.item.LavaWalkers;
import net.cinderous.cinderbane.material.CinderbaneArmorMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Cinderbane.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler
{

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
//        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
//        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
//        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cinderbane.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cinderbane.MODID);

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
    //Blocks Item
    public static final RegistryObject<Item> CINDIRT_ITEM = ITEMS.register("cindirt", () -> new BlockItem(CINDIRT.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    public static final RegistryObject<Item> BASALT_SHEET_ITEM = ITEMS.register("basalt_sheet", () -> new BlockItem(BASALT_SHEET.get(), new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));
    //Items
    //public static final RegistryObject<Item> SPELLDEV = ITEMS.register("spelldev", () -> new SpellDev(new Item.Properties().group(GeomancyAndTerraforming.GEOMANCYANDTERRAFORMING_TAB)));

    //Equipment Armor
    public static final RegistryObject<ArmorItem> LAVA_WALKERS = ITEMS.register("lava_walkers",
            () -> new LavaWalkers(CinderbaneArmorMaterial.CINDEROUS, EquipmentSlotType.FEET, new Item.Properties().group(Cinderbane.CINDERBANE_TAB)));

    //Effects
    public static final RegistryObject<Effect> LAVA_WALKERS_EFFECT = EFFECTS.register("lava_walkers_effect",
            () -> new LavaWalkersEffect(EffectType.BENEFICIAL, 37848743));






}
