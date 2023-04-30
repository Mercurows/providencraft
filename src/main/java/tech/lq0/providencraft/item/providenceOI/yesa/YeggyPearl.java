package tech.lq0.providencraft.item.providenceOI.yesa;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.models.YeggyPearlModel;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class YeggyPearl extends ArmorItem {
    public static final String TAG_YEGGY_PEARL = "yeggy_energy";

    public YeggyPearl(){
        super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(802).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new YeggyPearlModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/yeggy_pearl_texture.png";
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.yeggy_pearl_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.yeggy_pearl_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.YESA);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.YEGGY_PEARL.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "lunatic bow modifier", -0.2, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    public static void setEnergy(ItemStack stack, int num){
        ItemNBTTool.setInt(stack, TAG_YEGGY_PEARL, Math.min(80, num));
    }

    public static int getEnergy(ItemStack stack){
        return ItemNBTTool.getInt(stack, TAG_YEGGY_PEARL, 0);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        setEnergy(stack, getEnergy(stack) + 1);
        super.onArmorTick(stack, world, player);
    }

    public static float getDamageTimes(int x){
        float res = 0f;
        if(x > 80){
            return 1.25f;
        }

        if(x >= 60){
            res = 25.0f;
        }else if(x >= 40){
            res = -1.187f * x * x + 95f * x - 1400f;
        }else if(x >= 30){
            res = 3.25f * x * x - 195f * x + 3100f;
        }else if(x >= 10){
            res = -0.375f * x * x + 22.5f * x - 162.5f;
        }else if(x >= 0){
            res = 2.5f * x;
        }
        return 1.0f + res * 0.01f;
    }

    @SubscribeEvent
    public static void yeggyPearlEffect(LivingDamageEvent event) {
        Entity source = event.getSource().getImmediateSource();
        if (source instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) source;
            ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            if (!helmet.isEmpty() && helmet.getItem().equals(ItemRegistry.YEGGY_PEARL.get())) {
                event.setAmount(event.getAmount() * getDamageTimes(getEnergy(helmet)));
//                System.out.println("yesa: " + event.getAmount());
//                System.out.println("times: " + getDamageTimes(getEnergy(helmet)));
                setEnergy(helmet, 0);
            }
        }
    }
}
