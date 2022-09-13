package tech.lq0.providencraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;

public class Magicros extends Enchantment {
    private static final EquipmentSlotType[] SLOTS = new EquipmentSlotType[]{
            EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET};

    public Magicros() {
        super(Rarity.RARE, EnchantmentType.ARMOR, SLOTS);
    }

    public int getMinEnchantability(int level) {
        return 9 * level;
    }

    public int getMaxEnchantability(int level) {
        return super.getMinEnchantability(level) + 20;
    }

    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onUserHurt(LivingEntity user, Entity attacker, int level) {
        if(user instanceof PlayerEntity && !user.world.isRemote){
            PlayerEntity player = (PlayerEntity) user;
            int count = 0;
            for (LivingEntity livingentity : player.getEntityWorld().getEntitiesWithinAABB(LivingEntity.class, player.getBoundingBox().grow(10.0D, 10.0D, 10.0D))) {
                if(livingentity != player && !(livingentity instanceof MonsterEntity || livingentity instanceof ArmorStandEntity) && player.getDistanceSq(livingentity) < 100.0D){
                    count++;
                }
            }
            if(count >= 3){
                player.heal((float)(level + 1) * (count + 1) / 4);
                if(attacker instanceof LivingEntity){
                    LivingEntity attackerLiving = (LivingEntity) attacker;
                    attackerLiving.attackEntityFrom(DamageSource.MAGIC, level);
                    attackerLiving.applyKnockback(level + 1, player.getPosX() - attackerLiving.getPosX(), player.getPosZ() - attackerLiving.getPosZ());
                }
            }
        }
        super.onUserHurt(user, attacker, level);
    }
}
