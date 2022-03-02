package tech.lq0.providencraft.item.madoka;

import net.minecraft.item.*;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tiers.ModItemTier;

public class RedAhogeSword extends SwordItem {
    public RedAhogeSword() {
        super(ModItemTier.RED_AHOGE, 4, -2.4f, new Item.Properties().group(ModGroup.itemgroup));
    }
}
