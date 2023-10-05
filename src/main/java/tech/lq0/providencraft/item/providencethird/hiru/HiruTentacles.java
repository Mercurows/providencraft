package tech.lq0.providencraft.item.providencethird.hiru;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
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
import tech.lq0.providencraft.models.HiruTentaclesModel;
import tech.lq0.providencraft.particle.TentacleParticleData;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.awt.*;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HiruTentacles extends ArmorItem {
    public HiruTentacles() {
        super(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, new Properties().maxDamage(913).group(ModGroup.itemgroup));
    }

    @SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new HiruTentaclesModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/hiru_tentacles_model_texture.png";
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == ItemRegistry.GN_SOUL.get();
    }

    @SubscribeEvent
    public static void tentacleEffect(LivingHurtEvent event) {
        LivingEntity living = event.getEntityLiving();
        DamageSource source = event.getSource();

        if (source.getTrueSource() instanceof GuardianEntity) {
            return;
        }

        if (living instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            ItemStack chestplate = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
            int count = 0;

            if (!player.world.isRemote && !chestplate.isEmpty() && chestplate.getItem().equals(ItemRegistry.HIRU_TENTACLES.get())) {
                for (MobEntity mobEntity : player.getEntityWorld().getEntitiesWithinAABB(MobEntity.class, player.getBoundingBox().grow(20.0D, 20.0D, 20.0D))) {
                    if (player.getDistanceSq(mobEntity) < 400.0f && !player.isOnSameTeam(mobEntity) && !mobEntity.hasCustomName() &&
                            !(mobEntity instanceof AnimalEntity) && !(mobEntity instanceof VillagerEntity) &&
                            !(mobEntity instanceof IronGolemEntity) && !(mobEntity instanceof SnowGolemEntity)) {

                        double[] px = {player.getPosX() + 0.95f * MathHelper.cos(player.getHorizontalFacing().getHorizontalAngle()),
                                player.getPosX() - 0.95f * MathHelper.cos(player.getHorizontalFacing().getHorizontalAngle()),
                                player.getPosX() + 0.65f * MathHelper.cos(player.getHorizontalFacing().getHorizontalAngle()),
                                player.getPosX() - 0.65f * MathHelper.cos(player.getHorizontalFacing().getHorizontalAngle())};
                        double[] py = {player.getPosY() + 1.5f, player.getPosY() + 1.5f, player.getPosY() + 0.5f, player.getPosY() + 0.5f};
                        double[] pz = {player.getPosZ() + 0.95f * MathHelper.sin(player.getHorizontalFacing().getHorizontalAngle()),
                                player.getPosZ() + 0.95f * MathHelper.sin(player.getHorizontalFacing().getHorizontalAngle()),
                                player.getPosZ() + 0.95f * MathHelper.sin(player.getHorizontalFacing().getHorizontalAngle()),
                                player.getPosZ() + 0.95f * MathHelper.sin(player.getHorizontalFacing().getHorizontalAngle())};
                        double tx = mobEntity.getPosX();
                        double ty = mobEntity.getPosY() + 0.5f;
                        double tz = mobEntity.getPosZ();

                        int j = (int) (Math.random() * 4);

                        mobEntity.attackEntityFrom(DamageSource.causePlayerDamage(player), 4);
                        mobEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 4));

                        if (player.getEntityWorld() instanceof ServerWorld) {
                            IParticleData iParticleData = new TentacleParticleData(new Vector3d(0.0f, 0.0f, 0.0f), new Color(255, 255, 255, 50), 0.3f);
                            for (int i = 0; i < 20; i++) {
                                ((ServerWorld) player.getEntityWorld()).spawnParticle(iParticleData, px[j] + (tx - px[j]) * (i / 20.0),
                                        py[j] + (ty - py[j]) * (i / 20.0), pz[j] + (tz - pz[j]) * (i / 20.0), 0, 0.0, 0.0, 0.0, 0.0D);
                            }
                        }

                        count++;
                        if (count > 3) {
                            break;
                        }
                    }
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.hiru_tentacles.func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("des.providencraft.hiru_tentacles_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.hiru_tentacles_2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
        TooltipTool.addLiverInfo(tooltip, Livers.HIRU);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.HIRU_TENTACLES.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, "hiru tentacles modifier", 6.0f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }
}
