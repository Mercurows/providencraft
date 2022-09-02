package tech.lq0.providencraft.item.providencefirst.haya;

import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import tech.lq0.providencraft.group.ModGroup;

public class HayaSword extends SwordItem {
    public HayaSword(){
        super(ItemTier.NETHERITE, 4, -2.0f, new Properties().group(ModGroup.itemgroup));
    }
}
