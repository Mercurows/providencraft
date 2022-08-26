package tech.lq0.providencraft.init;

import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.effect.*;

public class EffectRegistry {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Utils.MOD_ID);

    public static final RegistryObject<Effect> BLESS_OF_DARK_ELF = EFFECTS.register("bless_of_dark_elf", BlessOfDarkElf::new);
    public static final RegistryObject<Effect> CURSE_OF_SERPENT = EFFECTS.register("curse_of_serpent", CurseOfSerpent::new);
    public static final RegistryObject<Effect> BIG_FIERCE_ONE = EFFECTS.register("big_fierce_one", BigFierceOne::new);
    public static final RegistryObject<Effect> BIG_MOE_ONE = EFFECTS.register("big_moe_one", BigMoeOne::new);
    public static final RegistryObject<Effect> OVERLOAD = EFFECTS.register("overload", Overload::new);
    public static final RegistryObject<Effect> HOLINESS = EFFECTS.register("holiness", Holiness::new);
}
