package tech.lq0.providencraft.item.providencesecond.mumu;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
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
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.AttributeRegistry;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.models.AyeletMaskModel;
import tech.lq0.providencraft.tiers.ModArmorMaterial;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AyeletMask extends ArmorItem {
    public AyeletMask(){
        super(ModArmorMaterial.CRYSTAL, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(515).setNoRepair().group(ModGroup.itemgroup));
    }

    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new AyeletMaskModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/ayelet_mask_model_texture.png";
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("ayelet_mask_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("ayelet_mask_des2")).mergeStyle(TextFormatting.GRAY));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.AYELET_MASK.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(AttributeRegistry.ATTACK_COPPER.get(),
                    new AttributeModifier(uuid, "ayelet mask modifier", 200.0D, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ATTACK_KNOCKBACK,
                    new AttributeModifier(uuid, "ayelet mask modifier", 0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(AttributeRegistry.ATTACK_COW.get(),
                    new AttributeModifier(uuid, "ayelet mask modifier", -1.0f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    //对幼年生物特攻
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();

        Entity entityP = event.getSource().getImmediateSource();
        if (entityP instanceof PlayerEntity && !entityP.world.isRemote()) {
            PlayerEntity player = (PlayerEntity) entityP;
            ItemStack item = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            if (item.getItem().equals(ItemRegistry.AYELET_MASK.get())) {
                if (entity instanceof CowEntity || entity.getUniqueID().toString().equals("1e10b6810052495bb7a93c0c5fc35552")){
                    event.setAmount(0);
                }else if (entity instanceof AnimalEntity && entity.isChild()) {
                    event.setAmount(event.getAmount() + 200);
                }
            }
        }
    }
}
