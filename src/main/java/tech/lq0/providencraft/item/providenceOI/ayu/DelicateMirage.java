package tech.lq0.providencraft.item.providenceOI.ayu;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.capability.ChaosHelper;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class DelicateMirage extends Item {
    public static final String TAG_ATTACK = "attack";
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public DelicateMirage() {
        super(new Properties().rarity(Rarity.UNCOMMON).group(ModGroup.itemgroup).maxDamage(480));
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 1, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -1, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add((new TranslationTextComponent("des.providencraft.delicate_mirage")).mergeStyle(TextFormatting.GRAY));

        TooltipTool.addLiverInfo(tooltip, Livers.AYU);
    }

    private Multimap<Attribute, AttributeModifier> getModifiers(ItemStack stack){
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "delicate mirage modifier",
                        ItemNBTTool.getInt(stack, TAG_ATTACK, 0), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier",
                -1, AttributeModifier.Operation.ADDITION));
        return builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        return equipmentSlot == EquipmentSlotType.MAINHAND ? getModifiers(stack) : super.getAttributeModifiers(equipmentSlot);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(!worldIn.isRemote && entityIn instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityIn;
            int chaos = ChaosHelper.getChaos(player);

            ItemNBTTool.setInt(stack, TAG_ATTACK, Math.max(0,chaos / 20));
        }
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity && !attacker.world.isRemote){
            PlayerEntity player = (PlayerEntity) attacker;

            int chaos = ChaosHelper.getChaos(player);
            System.out.println("chaos= " + chaos);

            boolean flag = false;
            double prob = chaos * 0.01;
            double rand = Math.random();

            //混沌时，攻击生物有概率对自己造成伤害
            if(chaos > 0){
                if(rand < prob){
                    flag = true;

                    player.attackEntityFrom(DamageSource.causePlayerDamage(player), player.getHealth() * 0.1f);
                }
            }

//            new Object() {
//                private int ticks = 0;
//                private float waitTicks;
//
//                public void start(int waitTicks) {
//                    this.waitTicks = waitTicks;
//                    MinecraftForge.EVENT_BUS.register(this);
//                }
//
//                @SubscribeEvent
//                public void tick(TickEvent.ServerTickEvent event) {
//                    if (event.phase == TickEvent.Phase.END) {
//                        this.ticks++;
//                        if (this.ticks >= this.waitTicks) {
//                            run();
//                        }
//                    }
//                }
//
//                private void run() {
//                    target.attackEntityFrom(DamageSource.causePlayerDamage(player), 3.0f);
//
//                    MinecraftForge.EVENT_BUS.unregister(this);
//                }
//            }.start((int) 10);
        }


        return super.hitEntity(stack, target, attacker);
    }
}
