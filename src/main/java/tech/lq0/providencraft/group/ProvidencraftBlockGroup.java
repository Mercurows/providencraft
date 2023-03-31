package tech.lq0.providencraft.group;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;

public class ProvidencraftBlockGroup extends ItemGroup {
    public ProvidencraftBlockGroup() {
        super("Providencraft Blocks");
    }

    @Override
    @Nonnull
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.CHISELED_BLUE_SANDSTONE.get());
    }
}
