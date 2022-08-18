package tech.lq0.providencraft.item.providencefirst.usa;

import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import tech.lq0.providencraft.group.ModGroup;

public class KurumiBoomerang extends SwordItem {
    public KurumiBoomerang(){
        super(ItemTier.IRON, 5, -2.7f, new Properties().defaultMaxDamage(963).group(ModGroup.itemgroup));
    }
}
