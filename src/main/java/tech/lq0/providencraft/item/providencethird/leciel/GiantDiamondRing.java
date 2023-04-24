package tech.lq0.providencraft.item.providencethird.leciel;

import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import tech.lq0.providencraft.group.ModGroup;

public class GiantDiamondRing extends SwordItem {
    public GiantDiamondRing(){
        super(ItemTier.DIAMOND, 1, -1.0f, new Properties().maxDamage(794).rarity(Rarity.UNCOMMON).group(ModGroup.itemgroup));
    }
}
