package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
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
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MomoPhone extends Item {
    public static final String NBT_POS_X = "posX";
    public static final String NBT_POS_Y = "posY";
    public static final String NBT_POS_Z = "posZ";

    public MomoPhone(){
        super(new Properties().group(ModGroup.itemgroup).isImmuneToFire().maxStackSize(1).maxDamage(9));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == ItemRegistry.DAIFUKU_SYRUP.get();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        BlockPos pos = null;

        float posX = ItemNBTTool.getFloat(item, NBT_POS_X, Float.NaN);
        float posY = ItemNBTTool.getFloat(item, NBT_POS_Y, Float.NaN);
        float posZ = ItemNBTTool.getFloat(item, NBT_POS_Z, Float.NaN);

        if(!(Float.isNaN(posX) || Float.isNaN(posY) || Float.isNaN(posZ))){
            pos = new BlockPos(posX, posY, posZ);
        }

        if(!worldIn.isRemote) {
            if (playerIn.isSneaking()) {
                pos = playerIn.getPosition();
                ItemNBTTool.setFloat(item, NBT_POS_X, pos.getX());
                ItemNBTTool.setFloat(item, NBT_POS_Y, pos.getY());
                ItemNBTTool.setFloat(item, NBT_POS_Z, pos.getZ());
                playerIn.sendStatusMessage(new TranslationTextComponent("momo_phone_set_pos").mergeStyle(TextFormatting.LIGHT_PURPLE), true);
                return new ActionResult<>(ActionResultType.PASS, item);
            }else{
                if(item.getDamage() < item.getMaxDamage()){
                    if(worldIn.isThundering() && worldIn.canSeeSky(playerIn.getPosition())){
                        LightningBoltEntity lightningBoltEntity = EntityType.LIGHTNING_BOLT.create(worldIn);
                        assert lightningBoltEntity != null;
                        lightningBoltEntity.moveForced(Vector3d.copyCenteredHorizontally(playerIn.getPosition()));
                        worldIn.addEntity(lightningBoltEntity);
                        playerIn.getCooldownTracker().setCooldown(item.getItem(), 200);
                    }else {
                        if(pos == null){
                            playerIn.sendStatusMessage(new TranslationTextComponent("momo_phone_not_set_pos").mergeStyle(TextFormatting.RED), true);
                        }else {
                            playerIn.attemptTeleport(pos.getX(), pos.getY(), pos.getZ(), true);
                            if (!playerIn.abilities.isCreativeMode) {
                                item.setDamage(item.getDamage() + 1);
                            }
                            playerIn.getCooldownTracker().setCooldown(item.getItem(), 200);
                        }
                    }
                    return new ActionResult<>(ActionResultType.SUCCESS, item);
                }
            }
        }
        return new ActionResult<>(ActionResultType.FAIL, item);
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("momo_phone_func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("momo_phone_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("momo_phone_warn")).mergeStyle(TextFormatting.RED));
        TooltipTool.addLiverInfo(tooltip, Livers.SHIRAKO);
    }
}
