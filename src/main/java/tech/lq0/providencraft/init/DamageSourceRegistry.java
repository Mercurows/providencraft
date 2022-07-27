package tech.lq0.providencraft.init;

import net.minecraft.util.DamageSource;

public class DamageSourceRegistry {
    public static final DamageSource BENI_CAKE = (new DamageSource("beniCake")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource MARI_FOOD = (new DamageSource("mariFood")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource EMO = (new DamageSource("emotionalDamage")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource LOTUS = (new DamageSource("lotusPotato")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource SORAYO = (new DamageSource("sorayo")).setDamageBypassesArmor().setMagicDamage();
}
