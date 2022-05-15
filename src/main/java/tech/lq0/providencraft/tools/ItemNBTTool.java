package tech.lq0.providencraft.tools;

import net.minecraft.item.ItemStack;

//from Botania
public final class ItemNBTTool {
    public static void setBoolean(ItemStack stack, String tag, boolean b) {
        stack.getOrCreateTag().putBoolean(tag, b);
    }

    public static boolean verifyExistence(ItemStack stack, String tag) {
        return !stack.isEmpty() && stack.getOrCreateTag().contains(tag);
    }


    public static boolean getBoolean(ItemStack stack, String tag, boolean defaultExpected) {
        return verifyExistence(stack, tag) ? stack.getOrCreateTag().getBoolean(tag) : defaultExpected;
    }
}
