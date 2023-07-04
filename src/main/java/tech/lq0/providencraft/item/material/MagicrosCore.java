package tech.lq0.providencraft.item.material;

import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.BeaconTileEntity;
import net.minecraft.tileentity.TileEntity;
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

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MagicrosCore extends Item {
    public static final String TAG_CHIRAM = "chiram";
    public static final String TAG_HAINE = "haine";
    public static final String TAG_KERORO = "keroro";
    public static final String TAG_EKIRA = "ekira";

    public MagicrosCore(){
        super(new Properties().maxStackSize(1).rarity(Rarity.EPIC).group(ModGroup.itemgroup).isImmuneToFire());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.providencraft.magicros_core_1").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("des.providencraft.magicros_core_2").mergeStyle(TextFormatting.GRAY));
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        boolean flagChiram = false;
        boolean flagHaine = false;
        boolean flagKeroro = false;
        boolean flagEkira = false;

        if(!worldIn.isRemote && entityIn instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityIn;

            if(isSelected) {
                //倾澜核心判定
                if (player.isElytraFlying()) {
                    Vector3d vec = player.getMotion();
                    double speed = vec.x * vec.x + vec.y * vec.y + vec.z * vec.z;

//                    player.sendStatusMessage(new StringTextComponent("speed: "+speed + " num:" + ItemNBTTool.getInt(stack,TAG_CHIRAM, 0)), true);

                    if (speed > .15 && speed < .6 && player.isPotionActive(Effects.REGENERATION)) {
                        flagChiram = true;
                    }
                }

                //灰音核心判定
                if (!player.abilities.isFlying) {
                    double posY = player.getPosY();

                    if (posY >= 192 && player.isPotionActive(Effects.LEVITATION)) {
                        long time = worldIn.getDayTime() % 24000;
                        if (time >= 0 && time <= 450) {
                            flagHaine = true;
                        }
                    }
                }

                //蛙吹核心判定
                if (worldIn.isRaining() && player.isInWater()) {
                    int count = 0;
                    for (EffectInstance effect : player.getActivePotionEffects()) {
                        if(!effect.getPotion().isBeneficial() && effect.getDuration() <= 400){
                            count++;
                        }
                    }

                    if(count >= 8){
                        flagKeroro = true;
                    }
                }

                //星宫颜核心判定
                if (!worldIn.isDaytime() && !worldIn.isRaining()){
                    BlockPos pos = player.getPosition();
                    int count = 0;

                    boolean flag1 = worldIn.canSeeSky(pos);
                    boolean flag2 = player.isPotionActive(Effects.GLOWING);

                    for (int i = -5; i <= 5; i++) {
                        for (int q = -5; q <= 5; q++) {
                            if (worldIn.getBlockState(pos.add(i, 0, q)).isIn(Blocks.BEACON)) {
                                TileEntity tileEntity = worldIn.getTileEntity(pos.add(i, 0, q));
                                if(tileEntity instanceof BeaconTileEntity){
                                    if(((BeaconTileEntity) tileEntity).getLevels() == 4){
                                        count++;
                                    }
                                }
                            }
                        }
                    }

                    if(count >= 4 && flag1 && flag2){
                        flagEkira = true;
                    }
                }
            }

            if(flagChiram){
                ItemNBTTool.setInt(stack, TAG_CHIRAM, Math.min(ItemNBTTool.getInt(stack, TAG_CHIRAM, 0) + 1, 600));
            }else {
                ItemNBTTool.setInt(stack, TAG_CHIRAM, 0);
            }
            if(ItemNBTTool.getInt(stack, TAG_CHIRAM, 0) >= 600){
                player.replaceItemInInventory(itemSlot, new ItemStack(ItemRegistry.CHIRAM_CORE.get()));
            }

            if(flagHaine){
                ItemNBTTool.setInt(stack, TAG_HAINE, Math.min(ItemNBTTool.getInt(stack, TAG_HAINE, 0) + 1, 400));
            }else {
                ItemNBTTool.setInt(stack, TAG_HAINE, 0);
            }
            if(ItemNBTTool.getInt(stack, TAG_HAINE, 0) >= 400){
                player.replaceItemInInventory(itemSlot, new ItemStack(ItemRegistry.HAINE_CORE.get()));
            }

            if(flagKeroro){
                ItemNBTTool.setInt(stack, TAG_KERORO, Math.min(ItemNBTTool.getInt(stack, TAG_KERORO, 0) + 1, 300));
            }else {
                ItemNBTTool.setInt(stack, TAG_KERORO, 0);
            }
            if(ItemNBTTool.getInt(stack, TAG_KERORO, 0) >= 300){
                player.replaceItemInInventory(itemSlot, new ItemStack(ItemRegistry.KERORO_CORE.get()));
            }

            if(flagEkira){
                ItemNBTTool.setInt(stack, TAG_EKIRA, Math.min(ItemNBTTool.getInt(stack, TAG_EKIRA, 0) + 1, 1200));
            }else {
                ItemNBTTool.setInt(stack, TAG_EKIRA, 0);
            }
            if(ItemNBTTool.getInt(stack, TAG_EKIRA, 0) >= 1200){
                player.replaceItemInInventory(itemSlot, new ItemStack(ItemRegistry.EKIRA_CORE.get()));
            }

        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return oldStack != newStack && slotChanged;
    }
}
