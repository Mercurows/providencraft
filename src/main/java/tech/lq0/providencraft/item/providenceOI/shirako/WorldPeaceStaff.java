package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class WorldPeaceStaff extends SwordItem {
    public static final String TAG_DAMAGE = "damage";

    public WorldPeaceStaff(){
        super(ItemTier.NETHERITE, 18, -2.0f, new Properties().maxDamage(11451).isImmuneToFire()
                .rarity(Rarity.create("legendary", TextFormatting.GOLD)).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("world_peace_staff_des1")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        TooltipTool.addLiverInfo(tooltip, Livers.SHIRAKO);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int sharpLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.SHARPNESS, stack);
        float maxDamage = 23.0f;
        if(sharpLevel != 0){
            maxDamage = 23.0f + (0.5f * sharpLevel + 0.5f);
        }

        int random = (int)(Math.random() * (maxDamage * 10)) + 100;
        float allDamage = getAllDamage(stack);
        setAllDamage(stack, allDamage + random / 10.0f);


        target.addPotionEffect(new EffectInstance(EffectRegistry.BLEEDING.get(), 300, 6));
        target.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 300, 2));
        return true;
    }

    private static float getAllDamage(ItemStack stack) {
        return ItemNBTTool.getFloat(stack, TAG_DAMAGE, 0.0f);
    }

    private static void setAllDamage(ItemStack stack, float num) {
        ItemNBTTool.setFloat(stack, TAG_DAMAGE, Math.min(num, 500.0f));
    }
}
