package tech.lq0.providencraft.item.providencethird.beni;

import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import tech.lq0.providencraft.group.ModGroup;

public class ShuraChin extends SwordItem {
    public ShuraChin(){
        super(ItemTier.IRON, 7, -1.5f, new Properties().rarity(Rarity.UNCOMMON).group(ModGroup.itemgroup).
                setNoRepair().maxDamage(1442));
    }
}
