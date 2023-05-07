package tech.lq0.providencraft.item.providenceOI.fukami;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.DamageSourceRegistry;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

public class FukamizuBread extends Item {
    private static final Food food = (new Food.Builder()).saturation(0.5f).hunger(8).build();

    public FukamizuBread(){
        super(new Properties().group(ModGroup.itemgroup).food(food).isImmuneToFire());
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(!worldIn.isRemote){
            entityLiving.attackEntityFrom(DamageSourceRegistry.FUKAMIZU_BREAD, 5.0f);
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.providencraft.fukamizu_bread_1").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("des.providencraft.fukamizu_bread_2").mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.FUKAMI);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 80;
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot, stack);
        UUID uuid = new UUID(ItemRegistry.FUKAMIZU_BREAD.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "fukamizu bread modifier", 2.0, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }
}
