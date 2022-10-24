package tech.lq0.providencraft.group;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import tech.lq0.providencraft.init.ItemRegistry;

public class ProvidencraftTapeGroup extends ItemGroup {
    public ProvidencraftTapeGroup(){
        super("Providencraft Audio Tapes");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.AUDIO_TAPE.get());
    }
}
