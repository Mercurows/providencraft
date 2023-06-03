package tech.lq0.providencraft.compat.vrc.ameki;

import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import tech.lq0.providencraft.group.ModGroup;

public class RainyButterfly extends SwordItem {
    public RainyButterfly(){
        super(ItemTier.IRON, 5, -2.1f, new Properties().group(ModGroup.integrationgroup));
    }
}
