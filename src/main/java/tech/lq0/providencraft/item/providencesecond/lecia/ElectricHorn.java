package tech.lq0.providencraft.item.providencesecond.lecia;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.models.ElectricHornModel;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ElectricHorn extends ArmorItem {
    public static final String TAG_ABLE = "able";

    public ElectricHorn() {
        super(ArmorMaterial.DIAMOND, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(1145).group(ModGroup.itemgroup).setNoRepair());
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new ElectricHornModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/electric_horn_model_texture.png";
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("electric_horn_func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("electric_horn_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("electric_horn_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("electric_horn_warn")).mergeStyle(TextFormatting.RED));
        TooltipTool.addLiverInfo(tooltip, Livers.LECIA);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote && playerIn.isSneaking()) {
            boolean flag = ItemNBTTool.getBoolean(stack, TAG_ABLE, false);
            ItemNBTTool.setBoolean(stack, TAG_ABLE, !flag);
            playerIn.sendStatusMessage(!flag ? new TranslationTextComponent("electric_horn_enable") :
                    new TranslationTextComponent("electric_horn_disable"), true);

        }
        return ActionResult.resultFail(stack);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();

        Entity entityP = event.getSource().getImmediateSource();
        if (entityP instanceof PlayerEntity && !entityP.world.isRemote()) {
            PlayerEntity player = (PlayerEntity) entityP;
            ItemStack item = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            if (item.getItem().equals(ItemRegistry.ELECTRIC_HORN.get()) && ItemNBTTool.getBoolean(item, TAG_ABLE, false)) {
                LightningBoltEntity lightningboltentity = EntityType.LIGHTNING_BOLT.create(player.world);
                assert lightningboltentity != null;
                lightningboltentity.moveForced(Vector3d.copyCenteredHorizontally(entity.getPosition()));
                lightningboltentity.setCaster(player instanceof ServerPlayerEntity ? (ServerPlayerEntity) player : null);
                player.world.addEntity(lightningboltentity);

                item.damageItem(10, player, (playerEntity) -> playerEntity.sendBreakAnimation(EquipmentSlotType.HEAD));
            }
        }
    }

    @SubscribeEvent
    public static void Effect(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();
        DamageSource damageSource = event.getSource();
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            ItemStack item = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            if (item.getItem().equals(ItemRegistry.ELECTRIC_HORN.get()) && damageSource.damageType.equals("lightningBolt")
                    && ItemNBTTool.getBoolean(item, TAG_ABLE, false)) {
                event.setCanceled(true);
                player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 100, 1));
            }
        }
    }
}
