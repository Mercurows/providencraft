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

    public static void setFloat(ItemStack stack, String tag, float f){
        stack.getOrCreateTag().putFloat(tag, f);
    }

    public static float getFloat(ItemStack stack, String tag, float f){
        return verifyExistence(stack, tag) ? stack.getOrCreateTag().getFloat(tag) : f;
    }

    public static void setInt(ItemStack stack, String tag, int num){
        stack.getOrCreateTag().putInt(tag, num);
    }

    public static int getInt(ItemStack stack, String tag, int num){
        return verifyExistence(stack, tag) ? stack.getOrCreateTag().getInt(tag) : num;
    }
}
