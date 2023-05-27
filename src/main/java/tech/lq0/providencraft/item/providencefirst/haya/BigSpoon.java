package tech.lq0.providencraft.item.providencefirst.haya;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class BigSpoon extends SwordItem {
    public BigSpoon() {
        super(ItemTier.IRON, 8, -3.2f, new Item.Properties().defaultMaxDamage(1108).group(ModGroup.itemgroup));
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) attacker;
            int food = 1;
            float saturation = 1.0f;
            if (target instanceof MonsterEntity) {
                if (target.isEntityUndead()) {
                    food = 2;
                    saturation = 2.0f;
                } else {
                    food = 4;
                    saturation = 4.0f;
                }
            } else if (target instanceof AnimalEntity) {
                food = 6;
                saturation = 6.0f;
            }

            if (!target.isAlive()) {
                player.getFoodStats().addStats(food, saturation);
            }
        }
        return super.hitEntity(stack, target, attacker);
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.big_spoon")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.HAYA);
    }

}
