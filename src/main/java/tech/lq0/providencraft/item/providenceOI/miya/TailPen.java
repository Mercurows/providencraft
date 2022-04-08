package tech.lq0.providencraft.item.providenceOI.miya;

import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import tech.lq0.providencraft.group.ModGroup;

public class TailPen extends SwordItem {
    public TailPen(){
        super(ItemTier.WOOD, 8, -2.5f, new Properties().setNoRepair().defaultMaxDamage(723).rarity(Rarity.EPIC).group(ModGroup.itemgroup));
    }
}
