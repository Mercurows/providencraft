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
    public static final RegistryObject<SoundEvent> YYKY_SCREAM = SOUNDS.register("yyky_scream", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "yyky_scream")));
    public static final RegistryObject<SoundEvent> HOW_HOLD_BLOOD = SOUNDS.register("how_hold_blood", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "how_hold_blood")));
    public static final RegistryObject<SoundEvent> WHY_NOT_DIE = SOUNDS.register("why_not_die", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "why_not_die")));
    public static final RegistryObject<SoundEvent> SORRY = SOUNDS.register("sorry", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "sorry")));
    public static final RegistryObject<SoundEvent> BABY_MEOW = SOUNDS.register("baby_meow", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "baby_meow")));
    public static final RegistryObject<SoundEvent> SHUTTER = SOUNDS.register("shutter", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "shutter")));
    public static final RegistryObject<SoundEvent> LECIA_HOWL = SOUNDS.register("lecia_howl", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "lecia_howl")));
    public static final RegistryObject<SoundEvent> LECIA_SCREAM = SOUNDS.register("lecia_scream", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "lecia_scream")));
    public static final RegistryObject<SoundEvent> LECIA_CAST_1 = SOUNDS.register("lecia_cast_1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "lecia_cast_1")));
    public static final RegistryObject<SoundEvent> LECIA_CAST_2 = SOUNDS.register("lecia_cast_2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "lecia_cast_2")));
    public static final RegistryObject<SoundEvent> BLOOD_CRYSTAL = SOUNDS.register("blood_crystal", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "blood_crystal")));

    //audios
    public static final RegistryObject<SoundEvent> CHIRAM_BOLSTER = SOUNDS.register("chiram_bolster", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/magicros/chiram_bolster")));
    public static final RegistryObject<SoundEvent> CHIRAM_INTRO = SOUNDS.register("chiram_intro", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/magicros/chiram_intro")));
    public static final RegistryObject<SoundEvent> CHIRAM_TALES = SOUNDS.register("chiram_tales", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/magicros/chiram_tales")));
    public static final RegistryObject<SoundEvent> HAINE_BROADCAST = SOUNDS.register("haine_broadcast", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/magicros/haine_broadcast")));
    public static final RegistryObject<SoundEvent> HAINE_TAUNT = SOUNDS.register("haine_taunt", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/magicros/haine_taunt")));
    public static final RegistryObject<SoundEvent> HAINE_HAIPLATE = SOUNDS.register("haine_haiplate", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/magicros/haine_haiplate")));
    public static final RegistryObject<SoundEvent> EKIRA_STAR = SOUNDS.register("ekira_star", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/magicros/ekira_star")));
    public static final RegistryObject<SoundEvent> EKIRA_TAUNT = SOUNDS.register("ekira_taunt", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/magicros/ekira_taunt")));
    public static final RegistryObject<SoundEvent> EKIRA_GOURMET = SOUNDS.register("ekira_gourmet", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/magicros/ekira_gourmet")));
    public static final RegistryObject<SoundEvent> KERORO_ELECTRIC_FROG = SOUNDS.register("keroro_electric_frog", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/magicros/keroro_electric_frog")));
    public static final RegistryObject<SoundEvent> KERORO_FROG_CROWN = SOUNDS.register("keroro_frog_crown", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/magicros/keroro_frog_crown")));
    public static final RegistryObject<SoundEvent> KERORO_WALKING = SOUNDS.register("keroro_walking", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/magicros/keroro_walking")));
    public static final RegistryObject<SoundEvent> FUKAMIZU_OCEAN_MONUMENT = SOUNDS.register("fukamizu_ocean_monument", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/poi/fukamizu_ocean_monument")));
    public static final RegistryObject<SoundEvent> FUKAMIZU_DIAMOND = SOUNDS.register("fukamizu_diamond", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/poi/fukamizu_diamond")));
    public static final RegistryObject<SoundEvent> FUKAMIZU_RING = SOUNDS.register("fukamizu_ring", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/poi/fukamizu_ring")));
    public static final RegistryObject<SoundEvent> LOUISE_SUMMON = SOUNDS.register("louise_summon", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/second/louise_summon")));
    public static final RegistryObject<SoundEvent> LOUISE_FARMING = SOUNDS.register("louise_farming", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/second/louise_farming")));
    public static final RegistryObject<SoundEvent> LOUISE_FOOD = SOUNDS.register("louise_food", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/second/louise_food")));
    public static final RegistryObject<SoundEvent> FUKAMIZU_CATS = SOUNDS.register("fukamizu_cats", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/poi/fukamizu_cats")));
    public static final RegistryObject<SoundEvent> FUKAMIZU_MATH = SOUNDS.register("fukamizu_math", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/poi/fukamizu_math")));
    public static final RegistryObject<SoundEvent> FUKAMIZU_SUN_BATH = SOUNDS.register("fukamizu_sun_bath", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/poi/fukamizu_sun_bath")));
    public static final RegistryObject<SoundEvent> MADOKA_EXCHANGE_STUDENT = SOUNDS.register("madoka_exchange_student", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/first/madoka_exchange_student")));
    public static final RegistryObject<SoundEvent> MADOKA_RED_AHOGE = SOUNDS.register("madoka_red_ahoge", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/first/madoka_red_ahoge")));
    public static final RegistryObject<SoundEvent> MADOKA_PARTY = SOUNDS.register("madoka_party", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/first/madoka_party")));
    public static final RegistryObject<SoundEvent> MUMU_AYELET = SOUNDS.register("mumu_ayelet", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/second/mumu_ayelet")));
    public static final RegistryObject<SoundEvent> MUMU_TRAVEL = SOUNDS.register("mumu_travel", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/second/mumu_travel")));
    public static final RegistryObject<SoundEvent> MUMU_BEEF = SOUNDS.register("mumu_beef", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/second/mumu_beef")));
    public static final RegistryObject<SoundEvent> QIANYUN_INTRO = SOUNDS.register("qianyun_intro", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/cnt/qianyun_intro")));
    public static final RegistryObject<SoundEvent> QIANYUN_EXPLORE = SOUNDS.register("qianyun_explore", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/cnt/qianyun_explore")));
    public static final RegistryObject<SoundEvent> QIANYUN_PROTECTION = SOUNDS.register("qianyun_protection", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/cnt/qianyun_protection")));
    public static final RegistryObject<SoundEvent> UNIA_LEGION = SOUNDS.register("unia_legion", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/first/unia_legion")));
    public static final RegistryObject<SoundEvent> UNIA_EXPLORE = SOUNDS.register("unia_explore", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/first/unia_explore")));
    public static final RegistryObject<SoundEvent> UNIA_UNIGIRI = SOUNDS.register("unia_unigiri", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/first/unia_unigiri")));

    public static final RegistryObject<SoundEvent> ELIFAUS = SOUNDS.register("elifaus", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "audio/other/elifaus")));

    //songs
    public static final RegistryObject<SoundEvent> DARAKUDATENSHI = SOUNDS.register("darakudatenshi", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "song/darakudatenshi")));
    public static final RegistryObject<SoundEvent> AROUND_THE_TRAVEL = SOUNDS.register("around_the_travel", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "song/around_the_travel")));
    public static final RegistryObject<SoundEvent> SONG_OF_AUTUMN = SOUNDS.register("song_of_autumn", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "song/song_of_autumn")));
}
