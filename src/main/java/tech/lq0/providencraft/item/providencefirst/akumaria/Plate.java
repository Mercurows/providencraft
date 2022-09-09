package tech.lq0.providencraft.item.providencefirst.akumaria;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Plate extends Item {
    public Plate() {
        super(new Properties().maxStackSize(1).defaultMaxDamage(10).group(ModGroup.itemgroup));
    }

    @SubscribeEvent
    public static void Effect(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            ItemStack itemStack = ItemRegistry.PLATE.get().getDefaultInstance();
            if (player.getHeldItemOffhand().getItem().equals(itemStack.getItem())) {
                ItemStack plate = player.getHeldItemOffhand();
                if (event.getAmount() >= 10) {
                    event.setAmount(1);
                    plate.damageItem(1, player, (playerEntity) -> playerEntity.sendBreakAnimation(EquipmentSlotType.OFFHAND));
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("plate_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("plate_des2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.MARIA);
    }

}
