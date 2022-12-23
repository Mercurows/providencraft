package tech.lq0.providencraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import tech.lq0.providencraft.init.ItemRegistry;

public class AhogeParasitic extends Enchantment {
    private static final EquipmentSlotType[] MAINHAND = new EquipmentSlotType[]{EquipmentSlotType.MAINHAND};

    public AhogeParasitic() {
        super(Rarity.RARE, EnchantmentType.WEAPON, MAINHAND);
    }

    public int getMinEnchantability(int level) {
        return 1 + 8 * (level - 1);
    }

    public int getMaxEnchantability(int level) {
        return super.getMinEnchantability(level) + 20;
    }

    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean canApply(ItemStack stack) {
        if ((stack.getItem() == ItemRegistry.RED_AHOGE_BOOMERANG.get()) || stack.getItem() == ItemRegistry.RED_AHOGE_SWORD.get()
        || stack.getItem() == ItemRegistry.RED_AHOGE_MACHETE.get()) {
            return true;
        } else {
            return super.canApply(stack);
        }
    }

    @Override
    public void onEntityDamaged(LivingEntity user, Entity target, int level) {
        int times = 2;
        if (user instanceof PlayerEntity && !user.world.isRemote() && !target.isAlive()) {
            PlayerEntity player = (PlayerEntity) user;
            ItemStack heldItem = player.getHeldItemMainhand();

            ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            if (!helmet.isEmpty() && helmet.getItem().equals(ItemRegistry.RED_AHOGE_HELMET.get())) {
                times++;
            }
            if (heldItem.getItem().equals(ItemRegistry.RED_AHOGE_SWORD.get()) ||
                    heldItem.getItem().equals(ItemRegistry.RED_AHOGE_BOOMERANG.get()) ||
            heldItem.getItem().equals(ItemRegistry.RED_AHOGE_MACHETE.get())) {
                times++;
            }

            player.heal(level * times / 2.0f);
        }
    }
}
