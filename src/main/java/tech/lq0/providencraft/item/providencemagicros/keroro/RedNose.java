package tech.lq0.providencraft.item.providencemagicros.keroro;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tech.lq0.providencraft.group.ModGroup;

public class RedNose extends ArmorItem {
    public RedNose(){
        super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(302).setNoRepair().group(ModGroup.itemgroup));
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        //这里写打喷嚏的功能
        super.onArmorTick(stack, world, player);
    }
}
