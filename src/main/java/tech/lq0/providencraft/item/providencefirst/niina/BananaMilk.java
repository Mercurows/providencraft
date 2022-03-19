package tech.lq0.providencraft.item.providencefirst.niina;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import tech.lq0.providencraft.group.ModGroup;

public class BananaMilk extends Item {
    private static final Food food = (new Food.Builder()).saturation(5.0f).hunger(4).build();
    public BananaMilk() {
        super(new Properties().food(food).group(ModGroup.itemgroup));
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }



}
