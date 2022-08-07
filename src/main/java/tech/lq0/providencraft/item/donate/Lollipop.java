package tech.lq0.providencraft.item.donate;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.DamageSourceRegistry;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.RandomTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Lollipop extends Item {
    public static final Food food = (new Food.Builder()).saturation(6.0f).hunger(4).setAlwaysEdible().build();

    public Lollipop() {
        super(new Properties().food(food).isImmuneToFire().group(ModGroup.donategroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("lollipop_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("lollipop_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("lollipop_des3")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
        tooltip.add((new TranslationTextComponent("donate_item_des")).mergeStyle(TextFormatting.GOLD).mergeStyle(TextFormatting.BOLD));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote && entityLiving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            int lvl = -1;
            if(player.isPotionActive(EffectRegistry.OVERLOAD.get())){
                lvl = Objects.requireNonNull(player.getActivePotionEffect(EffectRegistry.OVERLOAD.get())).getAmplifier();
            }

            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 340, 9));
            player.addPotionEffect(new EffectInstance(Effects.GLOWING, 340, 0));
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 340, 4));
            player.addPotionEffect(new EffectInstance(Effects.HASTE, 340, 2));
            player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 340, 2));

            player.addPotionEffect(new EffectInstance(EffectRegistry.OVERLOAD.get(), 340, lvl + 1));
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    private static void triggerSideEffect(PlayerEntity player, int num, int lvl) {
        switch (num) {
            case 0:
                player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 100, lvl));
                break;
            case 1:
                player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 100, lvl));
                break;
            case 2:
                player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, lvl));
                break;
            case 3:
                player.addPotionEffect(new EffectInstance(Effects.WITHER, 100, lvl));
                break;
            case 4:
                player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 100, lvl));
                break;
        }
    }

    @SubscribeEvent
    public static void SideEffect(PotionEvent.PotionExpiryEvent event){
        LivingEntity entity = event.getEntityLiving();
        if(EffectRegistry.OVERLOAD.get().getName().equals(Objects.requireNonNull(event.getPotionEffect()).getEffectName())){
            if(entity instanceof PlayerEntity){
                PlayerEntity player = (PlayerEntity) entity;
                int random = (int) (Math.random() * 99 + 1);
                int lvl = event.getPotionEffect().getAmplifier();

                if (random > 20) {
                    int[] num = RandomTool.getRandom(1, 5, 2);
                    assert num != null;
                    triggerSideEffect(player, num[0], lvl);
                    triggerSideEffect(player, num[1], lvl);
                } else {
                    player.attackEntityFrom(DamageSourceRegistry.EMO, 30.0f);
                }
            }
        }
    }

    @SubscribeEvent
    public static void SideEffect2(PotionEvent.PotionAddedEvent event){
        LivingEntity entity = event.getEntityLiving();
        if(EffectRegistry.OVERLOAD.get().getName().equals(Objects.requireNonNull(event.getPotionEffect()).getEffectName())){
            if(entity instanceof PlayerEntity){
                PlayerEntity player = (PlayerEntity) entity;
                int lvl = event.getPotionEffect().getAmplifier();
                if (lvl >= 10) {
                    player.attackEntityFrom(DamageSourceRegistry.OVERLOAD, 300.0f);
                }
            }
        }
    }
}
