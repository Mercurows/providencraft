package tech.lq0.providencraft.item.providencesecond.satou;

import com.google.common.collect.Streams;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.network.play.server.SExplosionPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AncientLollipop extends SwordItem {
    public static final String TAG_LOLLIPOP = "shouldExplode";

    public AncientLollipop(){
        super(ItemTier.NETHERITE, 2, -0.5F, new Properties().maxDamage(642)
                .rarity(Rarity.create("PROVIDENCRAFT_LEGENDARY", TextFormatting.GOLD)).isImmuneToFire().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.ancient_lollipop_1")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add((new TranslationTextComponent("des.providencraft.ancient_lollipop_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.SATOU);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        if(!worldIn.isRemote){
            playerIn.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 10, 0, true, false));
        }
        return ActionResult.resultConsume(stack);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 5;
    }

    @Override
    public SoundEvent getEatSound() {
        return null;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(entityLiving instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityLiving;
            if(player.getRidingEntity() != null){
                return stack;
            }

            Vector3d start = player.getEyePosition(1);
            Vector3d end = start.add(player.getLookVec().scale(20));

            Vector3d res;

            BlockRayTraceResult rayTrace = worldIn.rayTraceBlocks(new RayTraceContext(start, end, RayTraceContext.BlockMode.COLLIDER,
                    RayTraceContext.FluidMode.NONE, player));

            if(rayTrace.getType() == RayTraceResult.Type.BLOCK){
                BlockPos pos = rayTrace.getPos().offset(rayTrace.getFace());

                res = getTpPos(player, getFaceCenter(pos));
            }else {
                res = start.add(player.getLookVec().scale(10));
            }

            if(res != null) {
                if (!worldIn.isRemote) {
                    player.setPositionAndUpdate(res.x, res.y, res.z);
                }else {
                    for(int i=1; i<=10; i++){
                        worldIn.addParticle(ParticleTypes.PORTAL, true,
                                    player.getPosX(), player.getPosY(), player.getPosZ(),
                                    worldIn.rand.nextDouble() - 0.5, worldIn.rand.nextDouble(), worldIn.rand.nextDouble() - 0.5);
                    }
                }
            }

            player.getCooldownTracker().setCooldown(stack.getItem(), 30);
            player.playSound(SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, 1.0f, 1.0f);
            ItemNBTTool.setBoolean(stack, TAG_LOLLIPOP, true);
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

            if(player.ticksExisted % 160 == 0){
                player.getFoodStats().addStats(1, 0.5f);
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
        World worldIn = attacker.world;
        target.hurtResistantTime = 0;

        if(attacker instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) attacker;

            boolean flag = ItemNBTTool.getBoolean(stack, TAG_LOLLIPOP, false);
            if (flag) {
                ItemNBTTool.setBoolean(stack, TAG_LOLLIPOP, false);

                target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 80, 2));

                if(!worldIn.isRemote) {
                    new Object() {
                        private int ticks = 0;
                        private float waitTicks;

                        public void start(int waitTicks) {
                            ((ServerWorld) worldIn).spawnParticle(ParticleTypes.ENCHANT, target.getPosX(), target.getPosY() + 1, target.getPosZ(),
                                    150, 0.1, 0.2, 0.1, 2);

                            this.waitTicks = waitTicks;
                            MinecraftForge.EVENT_BUS.register(this);
                        }

                        @SubscribeEvent
                        public void tick(TickEvent.ServerTickEvent event) {
                            if (event.phase == TickEvent.Phase.END) {
                                this.ticks++;
                                if (this.ticks >= this.waitTicks) {
                                    run();
                                }
                            }
                        }

                        private void run() {
                            Explosion explosion = new Explosion(worldIn, player, DamageSource.causeExplosionDamage(player),
                                    null, target.getPosX(), target.getPosY(), target.getPosZ(), 3, false, Explosion.Mode.NONE);
                            explosion.doExplosionA();
                            explosion.doExplosionB(false);

                            ((ServerWorld) worldIn).spawnParticle(ParticleTypes.DRAGON_BREATH, target.getPosX(), target.getPosY() + 1, target.getPosZ(),
                                    200, worldIn.rand.nextDouble() - 0.5, worldIn.rand.nextDouble(), worldIn.rand.nextDouble() - 0.5, 0.5);

                            explosion.clearAffectedBlockPositions();

                            for (ServerPlayerEntity serverPlayer : ((ServerWorld) worldIn).getPlayers()) {
                                if (serverPlayer.getDistanceSq(target.getPosX(), target.getPosY(), target.getPosZ()) < 400) {
                                    serverPlayer.connection.sendPacket(new SExplosionPacket(target.getPosX(), target.getPosY(), target.getPosZ(), 3, explosion.getAffectedBlockPositions(), explosion.getPlayerKnockbackMap().get(player)));
                                }
                            }

                            MinecraftForge.EVENT_BUS.unregister(this);
                        }
                    }.start(30);
                }


            }
        }
        return true;
    }
}
