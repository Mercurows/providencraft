package tech.lq0.providencraft.item.providenceOI.sorayo;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.DamageSourceRegistry;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.models.LunaticBowModel;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LunaticBow extends ArmorItem {
    public LunaticBow() {
        super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(928).setNoRepair().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new LunaticBowModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/lunatic_bow_model_texture.png";
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.NAUTILUS_SHELL;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("lunatic_bow_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("lunatic_bow_des2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
        TooltipTool.addLiverInfo(tooltip, Livers.SORAYO);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.LUNATIC_BOW.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.ATTACK_SPEED,
                    new AttributeModifier(uuid, "lunatic bow modifier", 0.4, AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "lunatic bow modifier", 0.8, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @SubscribeEvent
    public static void BowEffect(AttackEntityEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            if (!helmet.isEmpty() && helmet.getItem().equals(ItemRegistry.LUNATIC_BOW.get())) {
                player.attackEntityFrom(DamageSourceRegistry.SORAYO, 2.0f);
                int random = (int) (Math.random() * 5 + 1);
                switch (random) {
                    case 1:
                        player.world.playSound(player, player.getPosition(),
                                SoundRegistry.YYKY_SCREAM_1.get(), SoundCategory.AMBIENT, 0.7f, 1f);
                        break;
                    case 2:
                        player.world.playSound(player, player.getPosition(),
                                SoundRegistry.YYKY_SCREAM_2.get(), SoundCategory.AMBIENT, 0.7f, 1f);
                        break;
                    case 3:
                        player.world.playSound(player, player.getPosition(),
                                SoundRegistry.YYKY_SCREAM_3.get(), SoundCategory.AMBIENT, 0.7f, 1f);
                        break;
                    case 4:
                        player.world.playSound(player, player.getPosition(),
                                SoundRegistry.YYKY_SCREAM_4.get(), SoundCategory.AMBIENT, 0.7f, 1f);
                        break;
                    case 5:
                        player.world.playSound(player, player.getPosition(),
                                SoundRegistry.YYKY_SCREAM_5.get(), SoundCategory.AMBIENT, 0.7f, 1f);
                        break;
                }
            }
        }
    }

    @SubscribeEvent
    public static void BowEffect2(LivingDeathEvent event) {
        Entity entity = event.getSource().getImmediateSource();
        if (entity instanceof PlayerEntity && !entity.world.isRemote) {
            PlayerEntity player = (PlayerEntity) entity;
            ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            if (!helmet.isEmpty() && helmet.getItem().equals(ItemRegistry.LUNATIC_BOW.get())) {
                player.heal(6.0f);
            }
        }
    }


}
