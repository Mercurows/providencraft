package tech.lq0.providencraft.item.costume.first.usa;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.models.KRM96353Model;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KRM_963_53 extends ArmorItem {
    public static final String TAG_FLY_ENERGY = "fly_energy";
    private static final List<String> players = Collections.synchronizedList(new ArrayList<>());

    public KRM_963_53(){
        super(ArmorMaterial.NETHERITE, EquipmentSlotType.CHEST, new Properties().defaultMaxDamage(963).isImmuneToFire().rarity(Rarity.EPIC).setNoRepair().group(ModGroup.costumegroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new KRM96353Model<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/costume/krm_963_53_texture.png";
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("krm_963_53_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add(new StringTextComponent(""));
        tooltip.add((new TranslationTextComponent("krm_963_53_func")).mergeStyle(TextFormatting.WHITE));
        showFlyEnergy(stack, tooltip);
        TooltipTool.addLiverInfo(tooltip, Livers.USA);
    }

    private void showFlyEnergy(ItemStack stack, List<ITextComponent> tooltip){
        TextFormatting textFormatting;
        if(getFlyEnergy(stack) >= 800){
            textFormatting = TextFormatting.GREEN;
        }else if(getFlyEnergy(stack) >= 500){
            textFormatting = TextFormatting.YELLOW;
        }else if(getFlyEnergy(stack) >= 200){
            textFormatting = TextFormatting.GOLD;
        }else {
            textFormatting = TextFormatting.RED;
        }
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(1);
        numberFormat.setMinimumFractionDigits(1);
        double per = (double)getFlyEnergy(stack) / 1000;
        String percent = numberFormat.format(per);

        StringBuilder fuel = new StringBuilder(70);
        for(int i=0;i < getFlyEnergy(stack) / 20;i++){
            fuel.append("\u00a7").append(Integer.toHexString(textFormatting.getColorIndex())).append("|");
        }
        for(int i=0;i < 50 - getFlyEnergy(stack) / 20;i++){
            fuel.append("\u00a7").append(Integer.toHexString(TextFormatting.GRAY.getColorIndex())).append("|");
        }
        fuel.append(" ").append("\u00a7").append(Integer.toHexString(textFormatting.getColorIndex())).append(percent);

        tooltip.add(new StringTextComponent(fuel.toString()));
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    private static int getFlyEnergy(ItemStack stack){
        return ItemNBTTool.getInt(stack, TAG_FLY_ENERGY, 1000);
    }

    private static void setFlyEnergy(ItemStack stack, int num){
        ItemNBTTool.setInt(stack, TAG_FLY_ENERGY, Math.min(num, 1000));
    }

    private static boolean checkFly(PlayerEntity player){
        ItemStack itemStack = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
        if(itemStack.getItem().equals(ItemRegistry.KRM_963_53.get())){
            return getFlyEnergy(itemStack) > 0;
        }
        return false;
    }

    @SubscribeEvent
    public static void playerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        String username = event.getPlayer().getGameProfile().getName();
        players.remove(username + ":false");
        players.remove(username + ":true");
    }

    private static String playerToString(PlayerEntity player){
        return player.getGameProfile().getName() + ":" + player.world.isRemote;
    }

    @SubscribeEvent
    public static void effect(LivingEvent.LivingUpdateEvent event){
        LivingEntity livingEntity = event.getEntityLiving();
        if(livingEntity instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) livingEntity;
            ItemStack itemStack = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
            boolean flag = itemStack.getItem().equals(ItemRegistry.KRM_963_53.get());

            if(players.contains(playerToString(player))) {
                if(checkFly(player)) {
                //if (!player.isCreative() && !player.isSpectator() && !player.abilities.allowFlying) {
//                    player.abilities.allowFlying = flag;
                    player.abilities.allowFlying = true;

                    if (player.abilities.isFlying) {
                        if (getFlyEnergy(itemStack) > 0) {
                            if (player.ticksExisted % 20 == 0) {
                                setFlyEnergy(itemStack, Math.max(getFlyEnergy(itemStack) - 1, 0));
                            }
                        } else {
                            player.abilities.isFlying = false;
                        }
//                        if (!flag) {
//                            player.abilities.isFlying = false;
//                        }
                    }
                } else {
                    if (!player.isSpectator() && !player.abilities.isCreativeMode) {
                        player.abilities.allowFlying = false;
                        player.abilities.isFlying = false;
                        player.abilities.disableDamage = false;
                    }
                    players.remove(playerToString(player));
//                    player.abilities.allowFlying = true;
                }
            }else if(checkFly(player)) {
                players.add(playerToString(player));
                player.abilities.allowFlying = true;
            }

            if (!player.abilities.isFlying) {
                if (player.ticksExisted % 30 == 0) {
                    setFlyEnergy(itemStack, getFlyEnergy(itemStack) + 1);
                }
            }
        }
    }
}
