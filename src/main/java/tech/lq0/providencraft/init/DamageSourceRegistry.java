package tech.lq0.providencraft.init;

import net.minecraft.util.DamageSource;

public class DamageSourceRegistry {
    public static final DamageSource BENI_CAKE = (new DamageSource("beniCake")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource MARI_FOOD = (new DamageSource("mariFood")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource EMO = (new DamageSource("emotionalDamage")).setDamageBypassesArmor().setMagicDamage().setDamageIsAbsolute();
    public static final DamageSource LOTUS = (new DamageSource("lotusPotato")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource SORAYO = (new DamageSource("sorayo")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource OVERLOAD = (new DamageSource("overload")).setDamageBypassesArmor().setMagicDamage().setDamageIsAbsolute();
    public static final DamageSource BLEEDING = (new DamageSource("pdc_bleeding")).setDamageBypassesArmor().setMagicDamage().setDamageIsAbsolute();
    public static final DamageSource BLOOD_CRYSTAL = (new DamageSource("blood_crystal").setProjectile());
    public static final DamageSource LUNAR_ECLIPSE = (new DamageSource("lunar_eclipse").setDamageBypassesArmor().setMagicDamage().setDamageIsAbsolute());
}
