package tech.lq0.providencraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import tech.lq0.providencraft.init.EnchantRegistry;

public class UniHusk extends Enchantment {
    private static final EquipmentSlotType[] CHEST = new EquipmentSlotType[]{EquipmentSlotType.CHEST};

    public UniHusk() {
        super(Rarity.RARE, EnchantmentType.ARMOR_CHEST, CHEST);
    }

    public int getMinEnchantability(int level) {
        return 8 + 6 * level;
    }

    public int getMaxEnchantability(int level) {
        return super.getMinEnchantability(level) + 20;
    }

    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onUserHurt(LivingEntity user, Entity attacker, int level) {
        if (user instanceof PlayerEntity && !user.world.isRemote()) {
            if (attacker instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) attacker;

                if (level > 0) {
                    livingEntity.addPotionEffect(new EffectInstance(Effects.POISON, 100, level + 1));
                }
            }
        }
    }
}
