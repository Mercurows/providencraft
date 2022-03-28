package tech.lq0.providencraft.item.others;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import tech.lq0.providencraft.group.ModGroup;

public class MMAStew extends Item {
    //MMA means Madoka Mumu Asui
    //真牛蛙
    private static final Food food = (new Food.Builder()).saturation(10).hunger(12).build();

    public MMAStew(){
        super(new Properties().food(food).maxStackSize(1).group(ModGroup.itemgroup));
    }
}
