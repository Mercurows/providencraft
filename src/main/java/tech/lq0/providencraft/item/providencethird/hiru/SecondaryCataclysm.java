package tech.lq0.providencraft.item.providencethird.hiru;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.entity.projectile.HirenadeGGEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class SecondaryCataclysm extends Item {
    public SecondaryCataclysm(){
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1).rarity(Rarity.EPIC));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add((new TranslationTextComponent("des.providencraft.secondary_cataclysm")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.HIRU);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        if(entity instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entity;
            World world = player.world;
            if(!world.isRemote && !player.getCooldownTracker().hasCooldown(stack.getItem())){
                HirenadeGGEntity hirenadeGG = new HirenadeGGEntity(world, player);
                hirenadeGG.setShooter(player);
                hirenadeGG.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0f, 1.8f, 0.0f);

                world.addEntity(hirenadeGG);

                player.getCooldownTracker().setCooldown(stack.getItem(), 10);
            }
        }

        return true;
    }

    @Override
    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        return !player.isCreative();
    }
}
