package tech.lq0.providencraft.group;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;

public class ProvidencraftGroup extends ItemGroup {
    public ProvidencraftGroup() {
        super("Providencraft Items");
    }

    @Override
    @Nonnull
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.RED_AHOGE.get());
    }
}
