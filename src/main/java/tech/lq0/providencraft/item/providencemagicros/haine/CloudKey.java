package tech.lq0.providencraft.item.providencemagicros.haine;

import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import tech.lq0.providencraft.group.ModGroup;

public class CloudKey extends Item {
    public CloudKey(){
        super(new Properties().maxStackSize(1).rarity(Rarity.EPIC).group(ModGroup.itemgroup));
    }
}
