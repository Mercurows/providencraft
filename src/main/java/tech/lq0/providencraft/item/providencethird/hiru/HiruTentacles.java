package tech.lq0.providencraft.item.providencethird.hiru;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
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
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.models.HiruTentaclesModel;
import tech.lq0.providencraft.particle.TentacleParticleData;

import javax.annotation.Nullable;
import java.awt.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HiruTentacles extends ArmorItem {
    public HiruTentacles(){
        super(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, new Properties().maxDamage(913).setNoRepair().group(ModGroup.itemgroup));
    }

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

    @SubscribeEvent
    public static void tentacleEffect(LivingHurtEvent event){
        if(event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            ItemStack chestplate = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
            int count = 0;
            if (!chestplate.isEmpty() && chestplate.getItem().equals(ItemRegistry.HIRU_TENTACLES.get())) {
                for (LivingEntity livingentity : player.getEntityWorld().getEntitiesWithinAABB(LivingEntity.class, player.getBoundingBox().grow(20.0D, 20.0D, 20.0D))) {
                    if (livingentity instanceof MonsterEntity && !player.isOnSameTeam(livingentity) && !livingentity.hasCustomName() && player.getDistanceSq(livingentity) < 400.0f) {
                        double[] px = {player.getPosX() + 0.95f * MathHelper.cos(player.getHorizontalFacing().getHorizontalAngle()),
                                player.getPosX() - 0.95f * MathHelper.cos(player.getHorizontalFacing().getHorizontalAngle()),
                                player.getPosX() + 0.65f * MathHelper.cos(player.getHorizontalFacing().getHorizontalAngle()),
                                player.getPosX() - 0.65f * MathHelper.cos(player.getHorizontalFacing().getHorizontalAngle())};
                        double[] py = {player.getPosY() + 1.5f, player.getPosY() + 1.5f, player.getPosY() + 0.5f, player.getPosY() + 0.5f};
                        double[] pz = {player.getPosZ() + 0.95f * MathHelper.sin(player.getHorizontalFacing().getHorizontalAngle()),
                                player.getPosZ() + 0.95f * MathHelper.sin(player.getHorizontalFacing().getHorizontalAngle()),
                                player.getPosZ() + 0.95f * MathHelper.sin(player.getHorizontalFacing().getHorizontalAngle()),
                                player.getPosZ() + 0.95f * MathHelper.sin(player.getHorizontalFacing().getHorizontalAngle())};
                        double tx = livingentity.getPosX();
                        double ty = livingentity.getPosY() + 0.5f;
                        double tz = livingentity.getPosZ();

                        int j = (int) (Math.random() * 4);

                        livingentity.attackEntityFrom(DamageSource.causePlayerDamage(player), 4);
                        livingentity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 4));

                        if (livingentity.getEntityWorld() instanceof ServerWorld) {
                            IParticleData iParticleData = new TentacleParticleData(new Vector3d(0.0f, 0.0f, 0.0f), new Color(255, 255, 255, 50), 0.3f);
                            for (int i = 0; i < 20; i++) {
                                ((ServerWorld) livingentity.getEntityWorld()).spawnParticle(iParticleData, px[j] + (tx - px[j]) * (i / 20.0),
                                        py[j] + (ty - py[j]) * (i / 20.0), pz[j] + (tz - pz[j]) * (i / 20.0), 0, 0.0, 0.0, 0.0, 0.0D);
                            }
                        }

                        count++;
                        if(count > 3){
                            break;
                        }
                    }
                }
            }
        }
    }
}
