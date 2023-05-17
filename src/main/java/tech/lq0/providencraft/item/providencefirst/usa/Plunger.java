package tech.lq0.providencraft.item.providencefirst.usa;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.entity.projectile.PlungerEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

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
        TooltipTool.addLiverInfo(tooltip, Livers.USA);
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote()) {
            if (item.getDamage() < item.getMaxDamage() - 1) {
                if (playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(ItemRegistry.KRM_963_53.get())) {
                    PlungerEntity plungerEntity1 = new PlungerEntity(worldIn, playerIn);
                    PlungerEntity plungerEntity2 = new PlungerEntity(worldIn, playerIn);
                    PlungerEntity plungerEntity3 = new PlungerEntity(worldIn, playerIn);
                    PlungerEntity plungerEntity4 = new PlungerEntity(worldIn, playerIn);
                    PlungerEntity plungerEntity5 = new PlungerEntity(worldIn, playerIn);

                    plungerEntity1.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 12.0f, 0.0f, 5.0f, 0.0f);
                    plungerEntity2.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 6.0f, 0.0f, 5.0f, 0.0f);
                    plungerEntity3.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 5.0f, 0.0f);
                    plungerEntity4.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 6.0f, 0.0f, 5.0f, 0.0f);
                    plungerEntity5.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 12.0f, 0.0f, 5.0f, 0.0f);

                    worldIn.addEntity(plungerEntity1);
                    worldIn.addEntity(plungerEntity2);
                    worldIn.addEntity(plungerEntity3);
                    worldIn.addEntity(plungerEntity4);
                    worldIn.addEntity(plungerEntity5);
                } else {
                    PlungerEntity plungerEntity = new PlungerEntity(worldIn, playerIn);
                    plungerEntity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 4.0f, 0.2f);
                    worldIn.addEntity(plungerEntity);
                }
                item.damageItem(1, playerIn, (playerEntity) -> playerEntity.sendBreakAnimation(handIn));
                playerIn.getCooldownTracker().setCooldown(item.getItem(), 10);
            }
        }

        return new ActionResult<>(ActionResultType.SUCCESS, item);
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
        return armorType == EquipmentSlotType.HEAD;
    }
}
