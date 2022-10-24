package tech.lq0.providencraft.item.others;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AudioTape extends Item {
    private String liver = "null";
    private String content = "null";

    public AudioTape(){
        super(new Properties().maxStackSize(1));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }


}
