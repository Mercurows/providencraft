package tech.lq0.providencraft.group;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import tech.lq0.providencraft.init.ItemInit;

public class ProvidencraftGroup extends ItemGroup {
    public ProvidencraftGroup(){
        super("Providencraft Items");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemInit.RED_AHOGE.get());
    }
}
