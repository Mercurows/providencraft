package tech.lq0.providencraft.potion;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import tech.lq0.providencraft.ModGroup;
import tech.lq0.providencraft.init.EffectInit;

public class DarkElfPotion extends Potion {
    public DarkElfPotion() {
        super(new EffectInstance(EffectInit.blessOfDarkElf.get(),3600));
    }

    
}
