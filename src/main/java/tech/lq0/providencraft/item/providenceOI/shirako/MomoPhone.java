package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
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
    public static final String NBT_BINDING = "binding";

    public MomoPhone() {
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

        if (!(Float.isNaN(posX) || Float.isNaN(posY) || Float.isNaN(posZ))) {
            pos = new BlockPos(posX, posY, posZ);
        }

        if (item.getDamage() < item.getMaxDamage()) {
            if (playerIn.isSneaking()) {
                pos = playerIn.getPosition();
                ItemNBTTool.setFloat(item, NBT_POS_X, pos.getX() + 0.5F);

                BlockState state = worldIn.getBlockState(pos);
                if (state.getMaterial().blocksMovement()) {
                    ItemNBTTool.setFloat(item, NBT_POS_Y, pos.getY() + 1);
                } else {
                    ItemNBTTool.setFloat(item, NBT_POS_Y, pos.getY());
                }

                ItemNBTTool.setFloat(item, NBT_POS_Z, pos.getZ() + 0.5F);

                ItemNBTTool.setBoolean(item, NBT_BINDING, true);

                playerIn.sendStatusMessage(new TranslationTextComponent("momo_phone_set_pos").mergeStyle(TextFormatting.LIGHT_PURPLE), true);

                playerIn.playSound(SoundEvents.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);

                return new ActionResult<>(ActionResultType.PASS, item);
            } else {
                if (worldIn.isThundering() && worldIn.canSeeSky(playerIn.getPosition())) {
                    LightningBoltEntity lightningBoltEntity = EntityType.LIGHTNING_BOLT.create(worldIn);
                    assert lightningBoltEntity != null;
                    lightningBoltEntity.moveForced(Vector3d.copyCenteredHorizontally(playerIn.getPosition()));
                    worldIn.addEntity(lightningBoltEntity);
                    playerIn.getCooldownTracker().setCooldown(item.getItem(), 200);
                } else {
                    if (pos == null) {
                        playerIn.sendStatusMessage(new TranslationTextComponent("momo_phone_not_set_pos").mergeStyle(TextFormatting.RED), true);
                    } else {
                        boolean isBlocked = false;
                        BlockState state1 = worldIn.getBlockState(pos.add(0, 1, 0));
                        BlockState state2 = worldIn.getBlockState(pos.add(0, 2, 0));
                        if (state1.getMaterial().blocksMovement() || state2.getMaterial().blocksMovement()) {
                            isBlocked = true;
                        }
                        if (!isBlocked) {
                            boolean temp = false;
                            for (int i = (int) posY; i >= 0; i--) {
                                BlockState state = worldIn.getBlockState(new BlockPos(posX, i, posZ));
                                if (state.getMaterial().blocksMovement()) {
                                    temp = true;
                                    posY = i + 1;
                                    break;
                                }
                            }
                            isBlocked = !temp;
                        }

                        if (!isBlocked) {
                            if (!worldIn.isRemote) {
                                playerIn.teleportKeepLoaded(posX, posY, posZ);
                            }
                            playerIn.getEntityWorld().playSound(playerIn, new BlockPos(posX, posY, posZ), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);

                            if (!playerIn.abilities.isCreativeMode) {
                                item.setDamage(item.getDamage() + 1);
                            }
                            playerIn.getCooldownTracker().setCooldown(item.getItem(), 200);
                            if (item.getDamage() == item.getMaxDamage()) {
                                ItemNBTTool.setBoolean(item, NBT_BINDING, false);
                            }
                        } else {
                            if (!worldIn.isRemote) {
                                playerIn.sendStatusMessage(new TranslationTextComponent("momo_phone_tp_fail").mergeStyle(TextFormatting.RED), true);
                            }
                        }
                    }
                }
                return new ActionResult<>(ActionResultType.SUCCESS, item);
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
