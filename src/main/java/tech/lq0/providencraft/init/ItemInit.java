package tech.lq0.providencraft.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.ExampleMod;
import tech.lq0.providencraft.item.chiram.FlatVegetableChestplate;
import tech.lq0.providencraft.item.louise.MagicPageMyanna;
import tech.lq0.providencraft.item.lucia.LuciaRiceCake;
import tech.lq0.providencraft.item.madoka.RedAhoge;
import tech.lq0.providencraft.item.madoka.RedAhogeBoomerang;
import tech.lq0.providencraft.item.madoka.RedAhogeHelmet;
import tech.lq0.providencraft.item.madoka.RedAhogeSword;
import tech.lq0.providencraft.item.shirako.Fetuozi;
import tech.lq0.providencraft.item.shirako.MomoDaifuku;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    public static final RegistryObject<Item> RED_AHOGE = ITEMS.register("red_ahoge", RedAhoge::new);
    public static final RegistryObject<Item> RED_AHOGE_SWORD = ITEMS.register("red_ahoge_sword", RedAhogeSword::new);
    public static final RegistryObject<Item> RED_AHOGE_BOOMERANG = ITEMS.register("red_ahoge_boomerang", RedAhogeBoomerang::new);
    public static final RegistryObject<Item> RED_AHOGE_HELMET = ITEMS.register("red_ahoge_helmet", RedAhogeHelmet::new);
    public static final RegistryObject<Item> LUCIA_RICE_CAKE = ITEMS.register("lucia_rice_cake", LuciaRiceCake::new);
    public static final RegistryObject<Item> MAGIC_PAGE_MYANNA = ITEMS.register("magic_page_myanna", MagicPageMyanna::new);
    public static final RegistryObject<Item> FLAT_VEGETABLE_CHESTPLATE = ITEMS.register("flat_vegetable_chestplate", FlatVegetableChestplate::new);
    public static final RegistryObject<Item> MOMO_DAIFUKU = ITEMS.register("momo_daifuku", MomoDaifuku::new);
    public static final RegistryObject<Item> FETUOZI = ITEMS.register("fetuozi", Fetuozi::new);
}
