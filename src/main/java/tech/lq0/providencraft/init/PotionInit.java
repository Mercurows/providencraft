package tech.lq0.providencraft.init;

import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.ExampleMod;
import tech.lq0.providencraft.ModGroup;
import tech.lq0.providencraft.potion.DarkElfPotion;

import java.util.Properties;

public class PotionInit {
    public static final DeferredRegister<Potion> POTION_TYPES = DeferredRegister.create(ForgeRegistries.POTION_TYPES, ExampleMod.MOD_ID);

    public static final RegistryObject<Potion> dark_elf_potion = POTION_TYPES.register("dark_elf_potion", DarkElfPotion::new);
    //()->new Potion(new EffectInstance(EffectInit.blessOfDarkElf.get(),3600))
}
