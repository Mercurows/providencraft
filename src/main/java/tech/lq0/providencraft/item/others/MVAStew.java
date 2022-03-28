package tech.lq0.providencraft.item.others;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import tech.lq0.providencraft.group.ModGroup;

public class MVAStew extends Item{
    //MVA means Madoka Vegetable Asui
    //真菜蛙
    private static final Food food = (new Food.Builder()).saturation(8).hunger(10).build();

    public MVAStew(){
        super(new Item.Properties().food(food).maxStackSize(1).group(ModGroup.itemgroup));
    }
}
