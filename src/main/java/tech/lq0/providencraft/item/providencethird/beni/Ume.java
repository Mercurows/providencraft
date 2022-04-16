package tech.lq0.providencraft.item.providencethird.beni;

import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import tech.lq0.providencraft.group.ModGroup;

public class Ume extends SwordItem {
    public Ume(){
        super(ItemTier.IRON, 3, -1.0f, new Properties().group(ModGroup.itemgroup).
                setNoRepair().defaultMaxDamage(721).rarity(Rarity.UNCOMMON));
    }
}
