package tech.lq0.providencraft.item.donate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import tech.lq0.providencraft.group.ModGroup;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Random;

public class Beast extends SwordItem {
    public Beast() {
        super(ItemTier.NETHERITE, 114509, 1919806, new Properties().group(ModGroup.donategroup).isImmuneToFire().rarity(Rarity.EPIC));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        StringBuilder temp = new StringBuilder();
        for (char c : " - \u300e B E A S T \u300f - ".toCharArray()) {
            if (Math.random() > 0.85) {
                temp.append("\u00a7").append(Integer.toHexString((int) (Math.random() * 16)));
            } else {
                temp.append("\u00a7b");
            }
            if (Math.random() > 0.05) {
                temp.append("\u00a7l");
            }
            if (Math.random() > 0.995) {
                temp.append("\u00a7ka");
            }
            if (Math.random() > 0.95) {
                temp.append("\u00a7o");
            }
            temp.append(c);
            temp.append("\u00a7r");
        }
        tooltip.add(new StringTextComponent(temp.toString()));
        tooltip.add((new TranslationTextComponent("beast_des")).mergeStyle(TextFormatting.GRAY));
        //tooltip.add((new TranslationTextComponent("donate_item_des")).mergeStyle(TextFormatting.GOLD).mergeStyle(TextFormatting.BOLD));

        if (Screen.hasShiftDown()) {
            tooltip.add(new StringTextComponent("逸一时，误一世"));
        }
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        forceKill(target);
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity target = ((LivingEntity) entity);
            forceKill(target);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    private static void forceKill(LivingEntity target) {
        target.setInvulnerable(false);
        target.setHealth(0.0f);
        target.onDeath(new DamageSource("BEAST").setDamageBypassesArmor().setDamageIsAbsolute().setDamageAllowedInCreativeMode());
        target.deathTime = 5;

        Random rand = new Random();
        for (int i = 0; i < 20; ++i) {
            double d0 = rand.nextGaussian() * 0.02D;
            double d1 = rand.nextGaussian() * 0.02D;
            double d2 = rand.nextGaussian() * 0.02D;
            target.world.addParticle(ParticleTypes.FLAME, target.getPosXRandom(1.0D), target.getPosYRandom(), target.getPosZRandom(1.0D), d0, d1, d2);
        }

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                target.remove();
                ObfuscationReflectionHelper.findMethod(ClientWorld.class, "removeEntity", Entity.class).invoke(
                        Minecraft.getInstance().world, target
                );
            } catch (Exception ignored) {
            }
        }).start();
    }
}
