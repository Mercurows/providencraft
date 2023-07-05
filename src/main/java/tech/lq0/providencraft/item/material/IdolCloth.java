package tech.lq0.providencraft.item.material;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class IdolCloth extends Item {
    public static final String TAG_TIME = "time";

    public IdolCloth() {
        super(new Properties().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.idol_cloth")).mergeStyle(TextFormatting.GRAY));
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        boolean flag = false;

        if(!worldIn.isRemote && entityIn instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityIn;

            if(isSelected){
                boolean flag1 = stack.getCount() == 1;
                boolean flag2 = player.experienceLevel >= 25;
                boolean flag3 = !worldIn.isDaytime();
                boolean flag4 = player.isSleeping();

                if(flag1 && flag2 && flag3 && flag4){
                    int count = 0;
                    for (EffectInstance effect : player.getActivePotionEffects()) {
                        if(effect.getPotion().isBeneficial()){
                            count++;
                        }
                    }

                    if(count >= 16){
                        flag = true;
                    }
                }
            }

            if(flag){
                ItemNBTTool.setInt(stack, TAG_TIME, Math.min(ItemNBTTool.getInt(stack, TAG_TIME, 0) + 1, 100));
            }else {
                ItemNBTTool.setInt(stack, TAG_TIME, 0);
            }
            if(ItemNBTTool.getInt(stack, TAG_TIME, 0) >= 100){
                player.replaceItemInInventory(itemSlot, new ItemStack(ItemRegistry.DREAM_WEAVING_YARN.get()));
                player.addExperienceLevel(-4);
                player.curePotionEffects(new ItemStack(Items.MILK_BUCKET));
            }
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }


}
