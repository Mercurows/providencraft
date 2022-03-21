package tech.lq0.providencraft.item.providencefirst.usa;

import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import tech.lq0.providencraft.group.ModGroup;

public class Plunger extends SwordItem {
    public Plunger() {
        super(ItemTier.WOOD, 3, -1.5f, new Properties().defaultMaxDamage(503).group(ModGroup.itemgroup));
    }
}
