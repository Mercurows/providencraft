package tech.lq0.providencraft.item.providenceOI.roky;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SExplosionPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class Xiaolongbao extends Item {
    private static final Food food = (new Food.Builder()).saturation(0.5f).hunger(7).setAlwaysEdible().build();

    public Xiaolongbao(){
        super(new Properties().group(ModGroup.itemgroup).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.xiaolongbao")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.xiaolongbao.warn")).mergeStyle(TextFormatting.RED));
        TooltipTool.addLiverInfo(tooltip, Livers.ROKY);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 50;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.onItemUseFinish(stack, worldIn, entityLiving);
        if (entityLiving instanceof PlayerEntity && !worldIn.isRemote) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            double random = Math.random();
            if (random < .05) {
                Explosion explosion = new Explosion(worldIn, player, DamageSource.causeExplosionDamage(player),
                        null, player.getPosX(), player.getPosY(), player.getPosZ(), 2, false, Explosion.Mode.NONE);
                explosion.doExplosionA();
                explosion.doExplosionB(true);

                explosion.clearAffectedBlockPositions();

                for(ServerPlayerEntity serverPlayer : ((ServerWorld) worldIn).getPlayers()) {
                    if(serverPlayer.getDistanceSq(player.getPosX(), player.getPosY(), player.getPosZ()) < 100) {
                        serverPlayer.connection.sendPacket(new SExplosionPacket(player.getPosX(), player.getPosY(), player.getPosZ(), 2, explosion.getAffectedBlockPositions(), explosion.getPlayerKnockbackMap().get(player)));
                    }
                }
            }

        }
        return itemStack;
    }
}
