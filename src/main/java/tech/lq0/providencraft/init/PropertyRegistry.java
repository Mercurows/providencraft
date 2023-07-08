package tech.lq0.providencraft.init;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.tools.ItemNBTTool;

import static tech.lq0.providencraft.item.providenceOI.shirako.MomoPhone.NBT_BINDING;
import static tech.lq0.providencraft.item.providencesecond.lecia.ElectricHorn.TAG_ABLE;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PropertyRegistry {
    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
        event.enqueueWork(() -> ItemModelsProperties.registerProperty(ItemRegistry.HAI_PLATE.get(), new ResourceLocation(Utils.MOD_ID, "blocking"), (itemStack, clientWorld, livingEntity) ->
                livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F));
        event.enqueueWork(() -> ItemModelsProperties.registerProperty(ItemRegistry.HAYAMEN.get(), new ResourceLocation(Utils.MOD_ID, "hayamen_blocking"), (itemStack, clientWorld, livingEntity) ->
                livingEntity != null && livingEntity.isHandActive() && livingEntity.getActiveItemStack() == itemStack ? 1.0F : 0.0F));
        event.enqueueWork(() ->
                ItemModelsProperties.registerProperty(ItemRegistry.ELECTRIC_HORN.get(), new ResourceLocation(Utils.MOD_ID, "electric_horn_able"),
                        (stack, world, entity) -> ItemNBTTool.getBoolean(stack, TAG_ABLE, false) ? 1.0F : 0.0F));
        event.enqueueWork(() ->
                ItemModelsProperties.registerProperty(ItemRegistry.MOMO_PHONE.get(), new ResourceLocation(Utils.MOD_ID, "momo_phone_binding"),
                        (itemStack, clientWorld, livingEntity) -> ItemNBTTool.getBoolean(itemStack, NBT_BINDING, false) ? 1.0F : 0.0F));
        event.enqueueWork(() ->
                ItemModelsProperties.registerProperty(ItemRegistry.TAIL_FISHING_ROD.get(), new ResourceLocation("cast"), (heldStack, world, livingEntity) -> {
                    if (livingEntity == null) {
                        return 0.0F;
                    } else {
                        boolean isMainhand = livingEntity.getHeldItemMainhand() == heldStack;
                        boolean isOffHand = livingEntity.getHeldItemOffhand() == heldStack;
                        if (livingEntity.getHeldItemMainhand().getItem() instanceof FishingRodItem) {
                            isOffHand = false;
                        }
                        return (isMainhand || isOffHand) && livingEntity instanceof PlayerEntity && ((PlayerEntity) livingEntity).fishingBobber != null ? 1.0F : 0.0F;
                    }
                })
        );
        event.enqueueWork(() ->
                ItemModelsProperties.registerProperty(ItemRegistry.SECONDARY_CATACLYSM.get(), new ResourceLocation("reload"), (heldStack, world, livingEntity) -> {
                    if (livingEntity == null) {
                        return 0.0F;
                    } else {
                        return livingEntity.getActiveItemStack() != heldStack ? 0.0F : (float) (heldStack.getUseDuration() - livingEntity.getItemInUseCount()) / 30.0f;
                    }
                })
        );
        event.enqueueWork(() ->
                ItemModelsProperties.registerProperty(ItemRegistry.SECONDARY_CATACLYSM.get(), new ResourceLocation("fire"),
                        (heldStack, world, livingEntity) -> ItemNBTTool.getBoolean(heldStack, "fire", false) ? 1.0F : 0.0F)
        );
    }
}
