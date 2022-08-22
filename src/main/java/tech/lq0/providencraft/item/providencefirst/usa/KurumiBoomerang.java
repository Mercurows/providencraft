package tech.lq0.providencraft.item.providencefirst.usa;

import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.entity.KurumiBoomerangEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.models.bakedModel.KurumiBoomerangBakedModel;
import tech.lq0.providencraft.render.tile.KurumiBoomerangTileEntityRenderer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KurumiBoomerang extends Item {
    public KurumiBoomerang(){
        super(new Properties().group(ModGroup.itemgroup).setISTER(() -> KurumiBoomerangTileEntityRenderer::new));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("kurumi_boomerang_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("description_zero")).mergeStyle(TextFormatting.LIGHT_PURPLE).mergeStyle(TextFormatting.BOLD));
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        int random = (int)(Math.random() * 10 + 1);
        if(random == 1){
            worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundRegistry.WHY_NOT_DIE.get(), SoundCategory.NEUTRAL, 0.5F, 1.0F);
        }else {
            worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundRegistry.HOW_HOLD_BLOOD.get(), SoundCategory.NEUTRAL, 0.5F, 1.0F);
        }

        if (!worldIn.isRemote()) {
            KurumiBoomerangEntity kurumiBoomerangEntity = new KurumiBoomerangEntity(worldIn, playerIn);
            kurumiBoomerangEntity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 3.0f, 0.2f);
            worldIn.addEntity(kurumiBoomerangEntity);
            item.shrink(1);
        }

        return new ActionResult<>(ActionResultType.SUCCESS, item);
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
        return armorType == EquipmentSlotType.HEAD;
    }

    @SubscribeEvent
    public static void onModelBaked(ModelBakeEvent event) {
        Map<ResourceLocation, IBakedModel> modelRegistry = event.getModelRegistry();
        ModelResourceLocation location = new ModelResourceLocation(ItemRegistry.KURUMI_BOOMERANG.get().getRegistryName(), "inventory");
        IBakedModel existingModel = modelRegistry.get(location);
        if (existingModel == null) {
            throw new RuntimeException("Did not find Obsidian Hidden in registry");
        } else if (existingModel instanceof KurumiBoomerangBakedModel) {
            throw new RuntimeException("Tried to replaceObsidian Hidden twice");
        } else {
            KurumiBoomerangBakedModel kurumiBoomerangBakedModel = new KurumiBoomerangBakedModel(existingModel);
            event.getModelRegistry().put(location, kurumiBoomerangBakedModel);
        }
    }
}
