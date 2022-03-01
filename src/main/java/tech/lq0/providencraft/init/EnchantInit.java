package tech.lq0.providencraft.init;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.ExampleMod;
import tech.lq0.providencraft.enchantment.AhogeParasitic;

public class EnchantInit {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ExampleMod.MOD_ID);

    public static final RegistryObject<Enchantment> AHOGE_PARASITIC = ENCHANTMENTS.register("ahoge_parasitic",AhogeParasitic::new);
}
