package tech.lq0.providencraft.group;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import tech.lq0.providencraft.init.ItemRegistry;

public class ProvidencraftDonateGroup extends ItemGroup {
    public ProvidencraftDonateGroup() {
        super("Providencraft Donate Items");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.LAVA_CAKE.get());
    }
}
