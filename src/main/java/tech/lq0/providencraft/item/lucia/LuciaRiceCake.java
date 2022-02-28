package tech.lq0.providencraft.item.lucia;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import tech.lq0.providencraft.ModGroup;

public class LuciaRiceCake extends Item {
    private static final Food food = (new Food.Builder()).saturation(6.4f).hunger(4).build();
    public LuciaRiceCake(){
        super(new Properties().food(food).group(ModGroup.itemgroup));
    }
}
