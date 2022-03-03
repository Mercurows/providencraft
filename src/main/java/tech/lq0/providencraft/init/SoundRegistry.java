package tech.lq0.providencraft.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.ExampleMod;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ExampleMod.MOD_ID);

    public static final RegistryObject<SoundEvent> MYANNA = SOUNDS.register("myanna", () -> new SoundEvent(new ResourceLocation(ExampleMod.MOD_ID,"myanna")));
}
