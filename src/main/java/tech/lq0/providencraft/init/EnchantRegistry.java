package tech.lq0.providencraft.init;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.enchantment.AhogeParasitic;
import tech.lq0.providencraft.enchantment.UniHusk;

public class EnchantRegistry {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Utils.MOD_ID);

    public static final RegistryObject<Enchantment> AHOGE_PARASITIC = ENCHANTMENTS.register("ahoge_parasitic",AhogeParasitic::new);
    public static final RegistryObject<Enchantment> UNI_HUSK = ENCHANTMENTS.register("uni_husk", UniHusk::new);
}
