package tech.lq0.providencraft.item.material;

import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import tech.lq0.providencraft.group.ModGroup;

public class MagicrosCore extends Item {
    public MagicrosCore(){
        super(new Properties().maxStackSize(1).rarity(Rarity.EPIC).group(ModGroup.itemgroup).isImmuneToFire());
    }
}
