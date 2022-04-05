package tech.lq0.providencraft.item.providencefirst.haya;

import net.minecraft.block.DispenserBlock;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ShieldItem;
import tech.lq0.providencraft.group.ModGroup;

public class Hayamen extends ShieldItem {
    public Hayamen() {
        super(new Properties().maxDamage(554).group(ModGroup.itemgroup));
        DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
    }
}
