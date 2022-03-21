package tech.lq0.providencraft.item.providencefirst.usa;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.entity.PlungerEntity;
import tech.lq0.providencraft.group.ModGroup;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class Plunger extends SwordItem {
    public Plunger() {
        super(ItemTier.WOOD, 3, -1.5f, new Properties().defaultMaxDamage(503).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("plunger_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("plunger_des2")).mergeStyle(TextFormatting.GRAY));
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote()) {
            if (item.getDamage() < item.getMaxDamage() - 1) {
                PlungerEntity plungerEntity = new PlungerEntity(worldIn, playerIn);
                plungerEntity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 4.0f, 0.2f);
                worldIn.addEntity(plungerEntity);
                item.setDamage(item.getDamage() + 1);
                playerIn.getCooldownTracker().setCooldown(item.getItem(), 10);
            }
        }

        return new ActionResult<>(ActionResultType.SUCCESS, item);
    }
}
