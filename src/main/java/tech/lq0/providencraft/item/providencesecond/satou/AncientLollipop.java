package tech.lq0.providencraft.item.providencesecond.satou;

import com.google.common.collect.Streams;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AncientLollipop extends SwordItem {
    public AncientLollipop(){
        super(ItemTier.NETHERITE, 2, -0.5F, new Properties().maxDamage(642)
                .rarity(Rarity.create("PROVIDENCRAFT_LEGENDARY", TextFormatting.GOLD)));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);
        tooltip.add((new TranslationTextComponent("des.providencraft.ancient_lollipop_1")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add((new TranslationTextComponent("des.providencraft.ancient_lollipop_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.SATOU);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return ActionResult.resultConsume(stack);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 10;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(entityLiving instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityLiving;

            Vector3d start = player.getEyePosition(1);
            Vector3d end = start.add(player.getLookVec().scale(20));

            BlockRayTraceResult rayTrace = worldIn.rayTraceBlocks(new RayTraceContext(start, end, RayTraceContext.BlockMode.COLLIDER,
                    RayTraceContext.FluidMode.NONE, player));

            if(rayTrace.getType() == RayTraceResult.Type.BLOCK){
                BlockPos pos = rayTrace.getPos().offset(rayTrace.getFace());

                Vector3d vector3d = getTpPos(player, getFaceCenter(pos));
                if(vector3d != null){
                    if(!worldIn.isRemote) {
                        player.setPositionAndUpdate(vector3d.getX(), vector3d.getY(), vector3d.getZ());
                    }
                }
            }else {
                if(!worldIn.isRemote) {
                    Vector3d vector3d = start.add(player.getLookVec().scale(10));
                    player.setPositionAndUpdate(vector3d.getX(), vector3d.getY(), vector3d.getZ());
                }
            }

            player.getCooldownTracker().setCooldown(stack.getItem(), 10);
        }
        return stack;
    }

    //From Electroblob77's Wizardry
    public static Vector3d getTpPos(Entity entity, Vector3d vector3d){
        World world = entity.world;
        AxisAlignedBB box = entity.getBoundingBox();

        box = box.offset(vector3d.subtract(entity.getPosX(), entity.getPosY(), entity.getPosZ()));

        Iterable<BlockPos> cuboid = BlockPos.getAllInBoxMutable(MathHelper.floor(box.minX), MathHelper.floor(box.minY),
                MathHelper.floor(box.minZ), MathHelper.floor(box.maxX), MathHelper.floor(box.maxY), MathHelper.floor(box.maxZ));

        if(Streams.stream(cuboid).noneMatch(b -> world.hasNoCollisions(new AxisAlignedBB(b)))){
            return vector3d;
        }else{
            double dx = box.maxX - box.minX;
            double dy = box.maxY - box.minY;
            double dz = box.maxZ - box.minZ;

            int nx = MathHelper.ceil(dx) / 2;
            int px = MathHelper.ceil(dx) - nx;
            int ny = MathHelper.ceil(dy) / 2;
            int py = MathHelper.ceil(dy) - ny;
            int nz = MathHelper.ceil(dz) / 2;
            int pz = MathHelper.ceil(dz) - nz;

            List<BlockPos> nearby = Streams.stream(BlockPos.getAllInBoxMutable(MathHelper.floor(box.minX) - 1,
                    MathHelper.floor(box.minY) - 1, MathHelper.floor(box.minZ) - 1,
                    MathHelper.floor(box.maxX) + 1, MathHelper.floor(box.maxY) + 1,
                    MathHelper.floor(box.maxZ) + 1)).collect(Collectors.toList());

            List<BlockPos> possiblePositions = Streams.stream(cuboid).collect(Collectors.toList());

            while(!nearby.isEmpty()){
                BlockPos pos = nearby.remove(0);

                if(world.hasNoCollisions(new AxisAlignedBB(pos))){
                    Predicate<BlockPos> nearSolidBlock = b -> b.getX() >= pos.getX() - nx && b.getX() <= pos.getX() + px
                            && b.getY() >= pos.getY() - ny && b.getY() <= pos.getY() + py
                            && b.getZ() >= pos.getZ() - nz && b.getZ() <= pos.getZ() + pz;
                    nearby.removeIf(nearSolidBlock);
                    possiblePositions.removeIf(nearSolidBlock);
                }
            }

            if(possiblePositions.isEmpty()){
                return null;
            }

            BlockPos nearest = possiblePositions.stream().min(Comparator.comparingDouble(b -> vector3d.squareDistanceTo(
                    b.getX() + 0.5, b.getY() + 0.5, b.getZ() + 0.5))).get();

            return getFaceCenter(nearest);
        }
    }

    public static Vector3d getFaceCenter(BlockPos pos){
        return new Vector3d(pos.getX(), pos.getY(), pos.getZ()).add(0.5, 0, 0.5);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote && entityIn instanceof PlayerEntity && isSelected) {
            PlayerEntity player = (PlayerEntity) entityIn;
            if (player.isSneaking()) {
                player.addPotionEffect(new EffectInstance(Effects.SPEED, 50, 4, true, false));
                player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 50, 0, true, false));
                player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 50, 4, true, false));
                player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 50, 2, true, false));
            }
        }
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return false;
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker.isSneaking()){
            target.addPotionEffect(new EffectInstance(EffectRegistry.BLEEDING.get(), 100, 3));
        }
        return true;
    }
}
