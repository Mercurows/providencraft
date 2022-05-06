package tech.lq0.providencraft.item.providencemagicros.chiram;

import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import tech.lq0.providencraft.group.ModGroup;

public class Bolster extends SwordItem {
    public Bolster(){
        super(ItemTier.WOOD, 5, -3.0f, new Properties().setNoRepair().maxDamage(430).group(ModGroup.itemgroup));
    }
}
