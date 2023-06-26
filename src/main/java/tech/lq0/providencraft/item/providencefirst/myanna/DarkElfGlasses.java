package tech.lq0.providencraft.item.providencefirst.myanna;

import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tiers.ModArmorMaterial;

public class DarkElfGlasses extends ArmorItem {
    public DarkElfGlasses(){
        super(ModArmorMaterial.SATOU, EquipmentSlotType.HEAD, new Properties().group(ModGroup.itemgroup).setNoRepair());
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(!world.isRemote){
            player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 200, 0, false, false));
        }
    }

    @Override
    public boolean isEnderMask(ItemStack stack, PlayerEntity player, EndermanEntity endermanEntity) {
        return true;
    }
}
