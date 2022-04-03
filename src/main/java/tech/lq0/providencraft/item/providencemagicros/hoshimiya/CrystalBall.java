package tech.lq0.providencraft.item.providencemagicros.hoshimiya;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

public class CrystalBall extends Item {
    public CrystalBall(){
        super(new Properties().maxStackSize(1).group(ModGroup.itemgroup));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        UUID uuid = new UUID(ItemRegistry.CRYSTAL_BALL.hashCode(), 0);
        if(!worldIn.isRemote){
            if(worldIn.isThundering()){
                playerIn.sendMessage(new TranslationTextComponent("crystal_ball_weather_thunder").mergeStyle(TextFormatting.YELLOW), uuid);
            }else if(worldIn.isRaining()){
                playerIn.sendMessage(new TranslationTextComponent("crystal_ball_weather_rain").mergeStyle(TextFormatting.AQUA), uuid);
            }else{
                playerIn.sendMessage(new TranslationTextComponent("crystal_ball_weather_clear").mergeStyle(TextFormatting.GREEN), uuid);
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("crystal_ball_func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("crystal_ball_des")).mergeStyle(TextFormatting.GRAY));
    }
}