package tech.lq0.providencraft.item.material;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MagicrosCore extends Item {
    public static final String TAG_CHIRAM = "chiram";

    public MagicrosCore(){
        super(new Properties().maxStackSize(1).rarity(Rarity.EPIC).group(ModGroup.itemgroup).isImmuneToFire());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add(new TranslationTextComponent("des.providencraft.magicros_core_1").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("des.providencraft.magicros_core_2").mergeStyle(TextFormatting.GRAY));
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(!worldIn.isRemote && entityIn instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityIn;

            if(isSelected) {
                //倾澜核心判定
                if (player.isElytraFlying()) {
                    Vector3d vec = player.getMotion();
                    double speed = vec.x * vec.x + vec.y * vec.y + vec.z * vec.z;

//                    player.sendStatusMessage(new StringTextComponent("speed: "+speed + " num:" + ItemNBTTool.getInt(stack,TAG_CHIRAM, 0)), true);

                    if (speed > .15 && speed < .6 && player.isPotionActive(Effects.REGENERATION)) {
                        ItemNBTTool.setInt(stack, TAG_CHIRAM, Math.min(ItemNBTTool.getInt(stack, TAG_CHIRAM, 0) + 1, 600));
                    } else {
                        ItemNBTTool.setInt(stack, TAG_CHIRAM, 0);
                    }
                }else {
                    ItemNBTTool.setInt(stack, TAG_CHIRAM, 0);
                }
            }

            if(ItemNBTTool.getInt(stack, TAG_CHIRAM, 0) >= 600){
                player.replaceItemInInventory(itemSlot, new ItemStack(ItemRegistry.CHIRAM_CORE.get()));
            }

        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return oldStack != newStack && slotChanged;
    }
}
