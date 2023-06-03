package tech.lq0.providencraft.compat.vrc;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.compat.vrc.ameki.RainyButterfly;

public class VirtuaRealCraftRegistry {
    public static final DeferredRegister<Item> VRC_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    public static final RegistryObject<Item> RAINY_BUTTERFLY = VRC_ITEMS.register("rainy_butterfly", RainyButterfly::new);
}
