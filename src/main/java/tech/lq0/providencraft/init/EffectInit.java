package tech.lq0.providencraft.init;

import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.ExampleMod;
import tech.lq0.providencraft.effect.BlessOfDarkElf;

public class EffectInit {
    public static final DeferredRegister<Effect> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, ExampleMod.MOD_ID);

    public static final RegistryObject<Effect> blessOfDarkElf = POTIONS.register("bless_of_dark_elf", BlessOfDarkElf::new);
}
