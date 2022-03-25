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
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.RandomTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;

public class Lollipop extends Item {
    public static final Food food = (new Food.Builder()).saturation(6.0f).hunger(4).setAlwaysEdible().build();
    public Lollipop(){
        super(new Properties().food(food).isImmuneToFire().group(ModGroup.donategroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("lollipop_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("donate_item_des")).mergeStyle(TextFormatting.GOLD).mergeStyle(TextFormatting.BOLD));
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(!worldIn.isRemote && entityLiving instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityLiving;
            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE,340,9));
            player.addPotionEffect(new EffectInstance(Effects.GLOWING,340,0));
            player.addPotionEffect(new EffectInstance(Effects.SPEED,340,2));
            player.addPotionEffect(new EffectInstance(Effects.HASTE,340,2));
            player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST,340,2));

            Thread t = new Thread(() ->{
                try {
                    Thread.sleep(17000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int random = (int) (Math.random() * 99 + 1);
                if(random > 30){
                    player.sendStatusMessage(new TranslationTextComponent("lollipop_nothing").mergeStyle(TextFormatting.GRAY), false);
                }else if(random > 5) {
                    int[] num = RandomTool.getRandom(1, 5, 2);
                    for (int i = 0; i < 2; i++) {
                        switch (Objects.requireNonNull(num)[i]) {
                            case 0:
                                player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 100, 1));
                                break;
                            case 1:
                                player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 100, 1));
                                break;
                            case 2:
                                player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 1));
                                break;
                            case 3:
                                player.addPotionEffect(new EffectInstance(Effects.WITHER, 100, 1));
                                break;
                            case 4:
                                player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 100, 1));
                                break;
                        }
                    }
                }else{
                    player.setHealth(player.getHealth() - 30);
                }

                if(!player.isAlive()){
                    player.sendStatusMessage(new TranslationTextComponent("death.lollipop", entityLiving.getDisplayName()), false);
                }

            });
            t.start();


        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }


}
