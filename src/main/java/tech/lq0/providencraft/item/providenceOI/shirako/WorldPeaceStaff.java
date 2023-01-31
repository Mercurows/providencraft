package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.entity.BloodCrystalEntity;
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
        target.applyKnockback(5.0f, attacker.getPosX() - target.getPosX(), attacker.getPosZ() - target.getPosZ());

        int sharpLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.SHARPNESS, stack);
        float maxDamage = 23.0f;
        if(sharpLevel != 0){
            maxDamage = 23.0f + (0.5f * sharpLevel + 0.5f);
        }

        int random = (int)(Math.random() * (maxDamage * 10)) + 100;
        float allDamage = getAllDamage(stack);
        setAllDamage(stack, allDamage + random / 10.0f);

        target.addPotionEffect(new EffectInstance(EffectRegistry.BLEEDING.get(), 300, 5));
        target.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 40, 2));
        return true;
    }

    public static float getAllDamage(ItemStack stack) {
        return ItemNBTTool.getFloat(stack, TAG_DAMAGE, 0.0f);
    }

    private static void setAllDamage(ItemStack stack, float num) {
        ItemNBTTool.setFloat(stack, TAG_DAMAGE, Math.min(num, 500.0f));
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 9999;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return ActionResult.resultConsume(stack);
    }

    @Override
    public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
        if(count % 2 == 0){
            if(getAllDamage(stack) >= 5.0f) {
                if (player.isSneaking()) {
                    player.heal(3.0f);
                }else {
                    World world = player.world;
                    BloodCrystalEntity bloodCrystal = new BloodCrystalEntity(world, player);
                    Vector3d vector3d = player.getLookVec();
                    bloodCrystal.shoot(vector3d.x, vector3d.y, vector3d.z, 4.0f, 0.6f);
                    world.addEntity(bloodCrystal);
                }

                setAllDamage(stack, Math.max(getAllDamage(stack) - 5.0f, 0.0f));
            }
        }
        super.onUsingTick(stack, player, count);
    }
}
