package tech.lq0.providencraft.item.shirako;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import tech.lq0.providencraft.group.ModGroup;

public class MomoDaifuku extends Item {
    private static final Food food = (new Food.Builder()).saturation(5).hunger(6).build();
    public MomoDaifuku(){
        super(new Properties().food(food).group(ModGroup.itemgroup));
    }
}
