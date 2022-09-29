package tech.lq0.providencraft.item.costume.first.usa;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.models.KRM96353Model;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KRM_963_53 extends ArmorItem {
    public KRM_963_53(){
        super(ArmorMaterial.NETHERITE, EquipmentSlotType.CHEST, new Properties().defaultMaxDamage(963).rarity(Rarity.EPIC).group(ModGroup.costumegroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new KRM96353Model<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/costume/krm_963_53_texture.png";
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("krm_963_53_des")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.USA);
    }

    @SubscribeEvent
    public static void effect(LivingEvent.LivingUpdateEvent event){
        LivingEntity livingEntity = event.getEntityLiving();
        if(livingEntity instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) livingEntity;
            ItemStack itemStack = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
            boolean flag = itemStack.getItem().equals(ItemRegistry.KRM_963_53.get());

            if(!player.isCreative() && !player.isSpectator()) {
                player.abilities.allowFlying = flag;

                if(player.abilities.isFlying){
                    if(itemStack.getDamage() < itemStack.getMaxDamage()){
                        if(player.ticksExisted % 20 == 0){
                            itemStack.setDamage(itemStack.getDamage() + 1);
                        }
                    }else{
                        player.abilities.isFlying = false;
                    }
                    if(!flag) {
                        player.abilities.isFlying = false;
                    }
                }
            }else{
                player.abilities.allowFlying = true;
            }

            if(!player.abilities.isFlying){
                if(player.ticksExisted % 30 == 0){
                    itemStack.setDamage(itemStack.getDamage() - 1);
                }
            }
        }
    }
}
