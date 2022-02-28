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
import tech.lq0.providencraft.item.madoka.RedAhogeSword;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    public static final RegistryObject<Item> red_ahoge = ITEMS.register("red_ahoge", RedAhoge::new);
    public static final RegistryObject<Item> red_ahoge_sword = ITEMS.register("red_ahoge_sword", RedAhogeSword::new);
    public static final RegistryObject<Item> red_ahoge_boomerang = ITEMS.register("red_ahoge_boomerang", RedAhogeBoomerang::new);
    public static final RegistryObject<Item> lucia_rice_cake = ITEMS.register("lucia_rice_cake", LuciaRiceCake::new);
    public static final RegistryObject<Item> magic_page_myanna = ITEMS.register("magic_page_myanna", MagicPageMyanna::new);
    public static final RegistryObject<Item> flat_vegetable_chestplate = ITEMS.register("flat_vegetable_chestplate", FlatVegetableChestplate::new);
}
