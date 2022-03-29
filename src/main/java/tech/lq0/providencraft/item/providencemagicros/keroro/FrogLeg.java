package tech.lq0.providencraft.item.providencemagicros.keroro;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import tech.lq0.providencraft.group.ModGroup;

public class FrogLeg extends Item {
    //蛙腿——食物
    private static final Food food = (new Food.Builder()).saturation(4).hunger(5).build();

    public FrogLeg(){
        super(new Properties().food(food).group(ModGroup.itemgroup));
    }
}
