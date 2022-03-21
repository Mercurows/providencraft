package tech.lq0.providencraft.item.providencesecond.satou;

import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import tech.lq0.providencraft.group.ModGroup;

public class SatouKnife extends SwordItem {
    public SatouKnife(){
        super(ItemTier.IRON, 3, -3.0f, new Properties().defaultMaxDamage(321).group(ModGroup.itemgroup));
    }
}
