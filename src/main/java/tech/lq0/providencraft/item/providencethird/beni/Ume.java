package tech.lq0.providencraft.item.providencethird.beni;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Ume extends SwordItem {
    public static final String TAG_INVOKE = "invoke";

    public Ume() {
        super(ItemTier.IRON, -2, -1.0f, new Properties().group(ModGroup.itemgroup).
                setNoRepair().defaultMaxDamage(721).rarity(Rarity.UNCOMMON));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.UME.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            map = HashMultimap.create(map);
            boolean flag = ItemNBTTool.getBoolean(stack, TAG_INVOKE, false);
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "ume modifier", flag ? 5.0f : 0.0f, AttributeModifier.Operation.ADDITION));
        } else if (equipmentSlot == EquipmentSlotType.OFFHAND) {
            map = HashMultimap.create(map);
            boolean flag = ItemNBTTool.getBoolean(stack, TAG_INVOKE, false);
            map.put(Attributes.ARMOR,
                    new AttributeModifier(uuid, "ume modifier", flag ? 0.0f : 4.0f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
        event.enqueueWork(() ->
                ItemModelsProperties.registerProperty(ItemRegistry.UME.get(), new ResourceLocation(Utils.MOD_ID, "ume_invoke"),
                        (stack, world, entity) -> ItemNBTTool.getBoolean(stack, TAG_INVOKE, false) ? 1.0F : 0.0F)
        );
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if (handIn == Hand.MAIN_HAND) {
            if (!ItemNBTTool.getBoolean(stack, TAG_INVOKE, false)) {
                worldIn.playSound(playerIn, playerIn.getPosition(),
                        SoundRegistry.BLADE.get(), SoundCategory.AMBIENT, 0.5f, 1f);
            }
            if (!worldIn.isRemote) {
                boolean flag = ItemNBTTool.getBoolean(stack, TAG_INVOKE, false);
                ItemNBTTool.setBoolean(stack, TAG_INVOKE, !flag);
            }
        }
        return ActionResult.resultFail(stack);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("ume_func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("ume_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("ume_des2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
        TooltipTool.addLiverInfo(tooltip, Livers.BENI);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        return 20;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.type == EnchantmentType.WEAPON || enchantment.type == EnchantmentType.BREAKABLE;
    }
}
