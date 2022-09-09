package tech.lq0.providencraft.item.providencemagicros.haine;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CloudKey extends Item {
    public CloudKey(){
        super(new Properties().maxStackSize(1).rarity(Rarity.EPIC).defaultMaxDamage(4).group(ModGroup.itemgroup));
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(entityIn instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityIn;
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 300, 1, true, false));
            player.addPotionEffect(new EffectInstance(Effects.HASTE, 300,0,true,false));
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("cloud_key_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("cloud_key_des2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.HAINE);
    }

    @SubscribeEvent
    public static void event(LivingHurtEvent event){
        LivingEntity entity = event.getEntityLiving();
        float damage = event.getAmount();
        if(entity instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entity;
            ItemStack key_stack = ItemRegistry.CLOUD_KEY.get().getDefaultInstance();
            if(player.getHeldItemOffhand().getItem().equals(key_stack.getItem())){
                ItemStack key = player.getHeldItemOffhand();
                if(damage >= player.getHealth()) {
                    event.setAmount(player.getHealth() > 2.0f ? player.getHealth() - 2.0f : 0.0f);
                    player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 3));
                    key.damageItem(1, player, (playerEntity) -> playerEntity.sendBreakAnimation(EquipmentSlotType.OFFHAND));
                }
            }
        }
    }

}
