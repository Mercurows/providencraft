package tech.lq0.providencraft.item.providencesecond.lecia;

import net.minecraft.item.Item;
import tech.lq0.providencraft.group.ModGroup;

public class DuelWaterGun extends Item {
    public DuelWaterGun(){
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1).maxDamage(40));
    }
}
