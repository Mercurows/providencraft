package tech.lq0.providencraft.tiers;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {
    CHIRAM("chiram", 25, new int[]{2, 8, 10, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.5F, 0.3F, () -> Ingredient.fromItems(Items.IRON_INGOT)),
    CHIRAM_PLUS("chiram_plus", 35, new int[]{1, 1, 16, 1}, 25, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 6.0F, 0.4F, () -> Ingredient.fromItems(Items.IRON_BLOCK)),
    RED_AHOGE("red_ahoge", 18, new int[]{3, 5, 5, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.fromItems(ItemRegistry.RED_AHOGE.get())),
    CRYSTAL("crystal", 22, new int[]{4, 5, 4, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> Ingredient.fromItems(Items.EMERALD)),
    IDOL_COSTUME("idol_costume", 15, new int[]{2, 3, 5, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> Ingredient.fromItems(ItemRegistry.IDOL_CLOTH.get()));


    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairMaterial;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    @Nonnull
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Nonnull
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    @Nonnull
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
