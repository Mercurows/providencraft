package tech.lq0.providencraft.item.providencesecond.satou;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.integration.CompatHandler;
import tech.lq0.providencraft.integration.vrc.VirtuaRealCraftRegistry;
import tech.lq0.providencraft.tiers.ModArmorMaterial;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class SatouChestplate extends ArmorItem {
    public SatouChestplate() {
        super(ModArmorMaterial.SATOU, EquipmentSlotType.CHEST, new Properties().group(ModGroup.itemgroup).maxDamage(70));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.satou_chestplate")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.SATOU);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(!world.isRemote){
            if(player.getFoodStats().needFood()){
                if(player.ticksExisted % 20 == 0) {
                    player.getFoodStats().setFoodLevel(player.getFoodStats().getFoodLevel() + 1);
                    player.getFoodStats().setFoodSaturationLevel(player.getFoodStats().getSaturationLevel() + 0.5f);
                    stack.damageItem(1, player, (player1) -> player1.sendBreakAnimation(EquipmentSlotType.CHEST));
                }
            }

            if(player.isInWater() || (world.isRaining() && world.canSeeSky(player.getPosition()) && world.getBiome(player.getPosition()).getDownfall() != 0)){
                if(CompatHandler.virtuarealcraft){
                    boolean main = player.getHeldItemMainhand().getItem() == VirtuaRealCraftRegistry.RAINY_BUTTERFLY.get();
                    boolean off = player.getHeldItemOffhand().getItem() == VirtuaRealCraftRegistry.RAINY_BUTTERFLY.get();
                    ItemStack item;
                    if(main){
                        item = player.getHeldItemMainhand();
                    }else {
                        item = player.getHeldItemOffhand();
                    }

                    if(main || off){
                        if(ItemNBTTool.getBoolean(item, "rainy_butterfly_open", false)){
                            super.onArmorTick(stack, world, player);
                            if(!player.isInWater()) {
                                return;
                            }
                        }
                    }
                }


                if(player.ticksExisted % 2 == 0){
                    stack.damageItem(1, player, (player1) -> player1.sendBreakAnimation(EquipmentSlotType.CHEST));
                }
            }
        }
        super.onArmorTick(stack, world, player);
    }
}
