package tech.lq0.providencraft.item.providencemagicros.keroro;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.models.RedNoseModel;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RedNose extends ArmorItem {
    public RedNose() {
        super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(302).setNoRepair().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new RedNoseModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/red_nose_model_texture.png";
    }

    @SubscribeEvent
    public static void Event(LivingHurtEvent event) {
        LivingEntity livingEntity = event.getEntityLiving();
        ItemStack itemStack = livingEntity.getItemStackFromSlot(EquipmentSlotType.HEAD);
        if (livingEntity instanceof PlayerEntity && !itemStack.isEmpty() && itemStack.getItem().equals(ItemRegistry.RED_NOSE.get())) {
            PlayerEntity player = (PlayerEntity) livingEntity;
            if(!player.world.isRemote) {
                player.playSound(SoundRegistry.KERORO_SNEEZE.get(), SoundCategory.AMBIENT, 0.5f, 1f);
            }
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 100, 1));
            itemStack.damageItem(1, player, (playerEntity) -> playerEntity.sendBreakAnimation(EquipmentSlotType.HEAD));
        }
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("red_nose_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("red_nose_des2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.KERORO);
    }
}
