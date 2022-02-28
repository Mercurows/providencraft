package tech.lq0.providencraft.item.madoka;

import net.minecraft.item.*;
import tech.lq0.providencraft.ModGroup;
import tech.lq0.providencraft.ModItemTier;

public class RedAhogeBoomerang extends SwordItem {
    public RedAhogeBoomerang() {
        super(ModItemTier.RED_AHOGE, 3, -2, new Item.Properties().group(ModGroup.itemgroup));
    }
}
