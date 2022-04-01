package tech.lq0.providencraft.item.providencemagicros.keroro;

import net.minecraft.client.renderer.entity.model.BipedModel;
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
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.models.RedNoseModel;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RedNose extends ArmorItem {
    public RedNose(){
        super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(302).setNoRepair().group(ModGroup.itemgroup));
    }

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
    public static void Event(LivingEvent.LivingJumpEvent event){
        LivingEntity livingEntity = event.getEntityLiving();
        if(livingEntity instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) livingEntity;
            if(!player.world.isRemote){
                ItemStack itemStack = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
                if(itemStack.getItem().equals(ItemRegistry.RED_NOSE.get())){
                    player.addPotionEffect(new EffectInstance(Effects.SPEED, 40, 1));
                    itemStack.damageItem(1,player, (playerEntity) -> playerEntity.sendBreakAnimation(EquipmentSlotType.HEAD));

                }
            }
            player.world.playSound(player, player.getPosition(),
                    SoundRegistry.KERORO_SNEEZE.get(), SoundCategory.AMBIENT, 0.5f, 1f);
        }
    }
}
