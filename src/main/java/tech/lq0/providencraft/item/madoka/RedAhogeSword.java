package tech.lq0.providencraft.item.madoka;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import tech.lq0.providencraft.ModGroup;
import tech.lq0.providencraft.ModItemTier;
import tech.lq0.providencraft.init.EffectInit;

public class RedAhogeSword extends SwordItem {
    public RedAhogeSword() {
        super(ModItemTier.RED_AHOGE, 4, -2.4f, new Item.Properties().group(ModGroup.itemgroup));
    }
}
