package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.entity.DaifukuSyrupEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MomoGun extends Item {
    public MomoGun(){
        super(new Properties().maxDamage(1540).group(ModGroup.itemgroup));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!worldIn.isRemote) {
            boolean flag2 = playerIn.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, itemstack) > 0;
            ItemStack ammo = this.findAmmo(playerIn);

            if (!ammo.isEmpty() || flag2) {
                if (ammo.isEmpty()) {
                    ammo = new ItemStack(ItemRegistry.DAIFUKU_SYRUP.get());
                }

                boolean flag1 = playerIn.abilities.isCreativeMode || (ammo.getItem() instanceof DaifukuSyrup &&
                        ((DaifukuSyrup) ammo.getItem()).isInfinite(ammo, itemstack, playerIn));

                DaifukuSyrup syrup = (DaifukuSyrup) (ammo.getItem() instanceof DaifukuSyrup ? ammo.getItem() : ItemRegistry.DAIFUKU_SYRUP.get());

                DaifukuSyrupEntity syrupEntity = syrup.createArrow(worldIn, ammo, playerIn);
                syrupEntity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 4.0F, 0.2F);

                itemstack.damageItem(1, playerIn, (playerEntity) -> playerEntity.sendBreakAnimation(handIn));
                worldIn.addEntity(syrupEntity);

                if (!flag1 && !playerIn.abilities.isCreativeMode) {
                    ammo.shrink(1);

                    if (ammo.isEmpty()) {
                        playerIn.inventory.deleteStack(ammo);
                    }
                }

                playerIn.getCooldownTracker().setCooldown(itemstack.getItem(), 20);
                return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
            }else {
                return new ActionResult<>(ActionResultType.FAIL, itemstack);
            }
        }
        return new ActionResult<>(ActionResultType.FAIL, itemstack);
    }

    protected ItemStack findAmmo(PlayerEntity player){
        if (this.check(player.getHeldItem(Hand.OFF_HAND))) {
            return player.getHeldItem(Hand.OFF_HAND);
        }
        else if (this.check(player.getHeldItem(Hand.MAIN_HAND))) {
            return player.getHeldItem(Hand.MAIN_HAND);
        }
        else {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
                ItemStack itemstack = player.inventory.getStackInSlot(i);
                if (this.check(itemstack)) {
                    return itemstack;
                }
            }
            return ItemStack.EMPTY;
        }
    }

    protected boolean check(ItemStack stack){
        return stack.getItem() instanceof DaifukuSyrup;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("momo_gun_func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("momo_gun_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("description_poi")).mergeStyle(TextFormatting.DARK_RED).mergeStyle(TextFormatting.BOLD));
    }
}
