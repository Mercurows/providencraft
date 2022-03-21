package tech.lq0.providencraft.potion;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import tech.lq0.providencraft.init.EffectRegistry;

public class DarkElfPotion extends Potion {
    public DarkElfPotion() {
        super(new EffectInstance(EffectRegistry.BLESS_OF_DARK_ELF.get(), 3600));
    }
}
