package tech.lq0.providencraft.init;

import net.minecraft.util.DamageSource;

public class DamageSourceRegistry {
    public static final DamageSource BENI_CAKE = (new DamageSource("beni_cake")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource MARI_FOOD = (new DamageSource("mari_food")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource EMO = (new DamageSource("emotional_damage")).setDamageBypassesArmor().setMagicDamage().setDamageIsAbsolute();
    public static final DamageSource LOTUS = (new DamageSource("lotus_potato")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource SORAYO = (new DamageSource("sorayo")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource OVERLOAD = (new DamageSource("overload")).setDamageBypassesArmor().setMagicDamage().setDamageIsAbsolute();
    public static final DamageSource BLEEDING = (new DamageSource("pdc_bleeding")).setDamageBypassesArmor().setMagicDamage().setDamageIsAbsolute();
    public static final DamageSource BLOOD_CRYSTAL = (new DamageSource("blood_crystal").setProjectile());
    public static final DamageSource LUNAR_ECLIPSE = (new DamageSource("lunar_eclipse").setDamageBypassesArmor().setMagicDamage().setDamageIsAbsolute());
    public static final DamageSource FUKAMIZU_BREAD = (new DamageSource("fukamizu_bread")).setDamageBypassesArmor().setMagicDamage();
    public static final DamageSource BROWNIE_UZZA = (new DamageSource("brownie_uzza")).setDamageBypassesArmor().setMagicDamage();
}
