package net.cinderous.cinderbane.material;

import net.cinderous.cinderbane.Cinderbane;
import net.cinderous.cinderbane.RegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum CinderbaneArmorMaterial implements IArmorMaterial {
    // name, durability, protection, enchantability, toughness
    LAVAWALKERS("lavawalkers", 4, new int[]{1, 2, 3, 1}, 7, 0.0f, 0.0f, () -> Ingredient.fromItems(RegistryHandler.CINDIRT.get())),
    WATERSTRIDERS("waterstriders", 4, new int[]{1, 2, 3, 1}, 7, 0.0f, 0.0f, () -> Ingredient.fromItems(RegistryHandler.CINDIRT.get())),
    CINDEROUS("cinderous", 4, new int[]{1, 2, 3, 1}, 7, 0.0f, 0.0f, () -> Ingredient.fromItems(RegistryHandler.CINDIRT.get()));

    // borrowed from vanilla
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};

    // armor fields
    private final String name;
    private final int durabilityFactor;
    private final int[] protection;
    private final int enchantability;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairMaterial;

    CinderbaneArmorMaterial(String name, int durabilityFactor, int[] protection, int enchantability, float toughness, float knockbackResistance, Supplier<Ingredient> ingredient) {
        this.name = Cinderbane.MODID + ":" + name;
        this.durabilityFactor = durabilityFactor;
        this.protection = protection;
        this.enchantability = enchantability;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        repairMaterial = new LazyValue<>(ingredient);
    }

    @Override
    public int getDurability(EquipmentSlotType slot) {
        return MAX_DAMAGE_ARRAY[slot.getIndex()] * this.durabilityFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slot) {
        return this.protection[slot.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}