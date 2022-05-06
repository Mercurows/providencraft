package tech.lq0.providencraft.item.providencemagicros.haine;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import tech.lq0.providencraft.group.ModGroup;

public class Marshaimallow extends Item {
    private static final Food food = (new Food.Builder()).saturation(4.0f).hunger(5).build();

    public Marshaimallow(){
        super(new Properties().food(food).group(ModGroup.itemgroup));
    }
}
