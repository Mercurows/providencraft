package tech.lq0.providencraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import tech.lq0.providencraft.init.EffectRegistry;

public class PeaceWish extends Enchantment {
    private static final EquipmentSlotType[] CHEST = new EquipmentSlotType[]{EquipmentSlotType.CHEST};

    public PeaceWish() {
        super(Rarity.VERY_RARE, EnchantmentType.ARMOR_CHEST, CHEST);
    }

    public int getMinEnchantability(int level) {
        return 20 + 9 * level;
    }

    public int getMaxEnchantability(int level) {
        return super.getMinEnchantability(level) + 10;
    }

    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }

    @Override
    public void onUserHurt(LivingEntity user, Entity attacker, int level) {
        if (!user.world.isRemote()) {
            if (attacker instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) attacker;

                livingEntity.addPotionEffect(new EffectInstance(EffectRegistry.BLEEDING.get(), 100, level - 1));
            }
        }
    }
}
