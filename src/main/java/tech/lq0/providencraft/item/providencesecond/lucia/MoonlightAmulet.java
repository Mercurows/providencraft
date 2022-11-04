package tech.lq0.providencraft.item.providencesecond.lucia;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

public class MoonlightAmulet extends Item {
    public static final String TAG_MOONLIGHT = "isnight";

    public MoonlightAmulet() {
        super(new Properties().group(ModGroup.itemgroup));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot, stack);
        UUID uuid = new UUID(ItemRegistry.MOONLIGHT_AMULET.hashCode() + slot.toString().hashCode(), 0);
        if (slot == EquipmentSlotType.OFFHAND) {
            map = HashMultimap.create(map);
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, "moonlight amulet modifier", 6.0, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "moonlight amulet modifier", 2.0, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ARMOR,
                    new AttributeModifier(uuid, "moonlight amulet modifier", 4.0, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityIn;
            if (!worldIn.isDaytime()) {
                ItemNBTTool.setBoolean(stack, TAG_MOONLIGHT, true);
                player.addPotionEffect(new EffectInstance(EffectRegistry.BIG_FIERCE_ONE.get(), 300, 0));
            } else {
                ItemNBTTool.setBoolean(stack, TAG_MOONLIGHT, false);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("moonlight_amulet_des")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.LUCIA);
    }
}
