package tech.lq0.providencraft.group;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;

public class ProvidencraftCostumeGroup extends ItemGroup {
    public ProvidencraftCostumeGroup() {
        super("Providencraft Costumes");
    }

    @Override
    @Nonnull
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.STEEL_PLATE.get());
    }
}
