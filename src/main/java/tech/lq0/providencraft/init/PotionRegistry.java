package tech.lq0.providencraft.init;

import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.potion.DarkElfPotion;

public class PotionRegistry {
    public static final DeferredRegister<Potion> POTION_TYPES = DeferredRegister.create(ForgeRegistries.POTION_TYPES, Utils.MOD_ID);

    public static final RegistryObject<Potion> DARK_ELF_POTION = POTION_TYPES.register("dark_elf_potion",DarkElfPotion::new);
}
