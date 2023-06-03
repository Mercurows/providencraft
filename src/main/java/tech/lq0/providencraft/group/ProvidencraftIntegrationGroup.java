package tech.lq0.providencraft.group;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;

public class ProvidencraftIntegrationGroup extends ItemGroup {
    public ProvidencraftIntegrationGroup() {
        super("Providencraft Integration Items");
    }

    @Override
    @Nonnull
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.MAGIC_MIRROR.get());
    }
}
