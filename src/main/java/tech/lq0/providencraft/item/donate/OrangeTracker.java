package tech.lq0.providencraft.item.donate;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.models.LunaticBowModel;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class OrangeTracker extends ArmorItem {
    public OrangeTracker(){
        super(ArmorMaterial.IRON, EquipmentSlotType.LEGS, new Properties().group(ModGroup.donategroup).defaultMaxDamage(520));
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new LunaticBowModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/lunatic_bow_model_texture.png";
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("orange_tracker_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("orange_tracker_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("donate_item_des")).mergeStyle(TextFormatting.GOLD).mergeStyle(TextFormatting.BOLD));
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        int r = 5;
        AxisAlignedBB area = new AxisAlignedBB(player.getPosition().add(-r, -r, -r), player.getPosition().add(r, r, r));

        List<ItemEntity> items = player.world.getEntitiesWithinAABB(EntityType.ITEM, area,
                item -> item.isAlive() && (player.world.isRemote || item.ticksExisted > 1) &&
                        (item.getThrowerId() == null || !item.getThrowerId().equals(player.getUniqueID()) || !item.cannotPickup()) &&
                        !item.getItem().isEmpty()
        );
        items.forEach(item -> item.setPosition(player.getPosX(), player.getPosY(), player.getPosZ()));
    }
}
