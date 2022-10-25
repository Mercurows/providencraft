package tech.lq0.providencraft.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Utils.MOD_ID);

    public static final RegistryObject<SoundEvent> MYANNA = SOUNDS.register("myanna", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "myanna")));
    public static final RegistryObject<SoundEvent> HAIPLATE = SOUNDS.register("haiplate", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "haiplate")));
    public static final RegistryObject<SoundEvent> KERORO_SNEEZE = SOUNDS.register("keroro_sneeze", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "keroro_sneeze")));
    public static final RegistryObject<SoundEvent> BLADE = SOUNDS.register("blade", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "blade")));
    public static final RegistryObject<SoundEvent> YYKY_SCREAM_1 = SOUNDS.register("yyky_scream_1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "yyky_scream_1")));
    public static final RegistryObject<SoundEvent> YYKY_SCREAM_2 = SOUNDS.register("yyky_scream_2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "yyky_scream_2")));
    public static final RegistryObject<SoundEvent> YYKY_SCREAM_3 = SOUNDS.register("yyky_scream_3", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "yyky_scream_3")));
    public static final RegistryObject<SoundEvent> YYKY_SCREAM_4 = SOUNDS.register("yyky_scream_4", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "yyky_scream_4")));
    public static final RegistryObject<SoundEvent> YYKY_SCREAM_5 = SOUNDS.register("yyky_scream_5", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "yyky_scream_5")));
    public static final RegistryObject<SoundEvent> HOW_HOLD_BLOOD = SOUNDS.register("how_hold_blood", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "how_hold_blood")));
    public static final RegistryObject<SoundEvent> WHY_NOT_DIE = SOUNDS.register("why_not_die", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "why_not_die")));
    public static final RegistryObject<SoundEvent> SORRY = SOUNDS.register("sorry", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "sorry")));
    public static final RegistryObject<SoundEvent> BABY_MEOW = SOUNDS.register("baby_meow", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "baby_meow")));
    public static final RegistryObject<SoundEvent> SHUTTER = SOUNDS.register("shutter", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "shutter")));
    public static final RegistryObject<SoundEvent> LECIA_HOWL = SOUNDS.register("lecia_howl", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "lecia_howl")));
    public static final RegistryObject<SoundEvent> LECIA_SCREAM = SOUNDS.register("lecia_scream", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "lecia_scream")));
    public static final RegistryObject<SoundEvent> LECIA_CAST_1 = SOUNDS.register("lecia_cast_1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "lecia_cast_1")));
    public static final RegistryObject<SoundEvent> LECIA_CAST_2 = SOUNDS.register("lecia_cast_2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "lecia_cast_2")));

    // TODO 添加Liver定制语音
}
